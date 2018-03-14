package com.aquaticinformatics.aquarius.sdk.samples;

import com.aquaticinformatics.aquarius.sdk.AquariusServerVersion;
import com.aquaticinformatics.aquarius.sdk.helpers.IFieldNamer;
import com.aquaticinformatics.aquarius.sdk.helpers.SdkServiceClient;
import com.aquaticinformatics.aquarius.sdk.samples.serializers.InstantDeserializer;
import com.aquaticinformatics.aquarius.sdk.samples.serializers.InstantSerializer;
import net.servicestack.client.IReturn;
import net.servicestack.client.Route;

import java.io.*;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SamplesClient implements AutoCloseable {

    public final SdkServiceClient Api;
    public final SdkServiceClient SparseApi;
    public final AquariusServerVersion ServerVersion;

    public static SamplesClient createConnectedClient(String hostname, String apiToken) {

        SamplesClient client = new SamplesClient(hostname);

        client.connect(apiToken);

        return client;
    }

    private final Map<Object,Type> _typeAdapters;
    private final IFieldNamer _fieldNamer;

    private SamplesClient(String hostname) {
        _typeAdapters = new HashMap<Object,Type>();
        _typeAdapters.put(new InstantDeserializer(), Instant.class);
        _typeAdapters.put(new InstantSerializer(), Instant.class);

        _fieldNamer = new FieldNamer();

        Api = SdkServiceClient.Create(SdkServiceClient.resolveServerWithDefaultScheme(hostname, SdkServiceClient.HttpsScheme), EndPoints.ROOT, _typeAdapters, _fieldNamer);
        SparseApi = SdkServiceClient.Create(SdkServiceClient.resolveServerWithDefaultScheme(hostname, SdkServiceClient.HttpsScheme), EndPoints.ROOT, _typeAdapters, _fieldNamer, true);

        ServerVersion = getServerVersion();
    }

    private void connect(String apiToken) {
        Api.setApiToken(apiToken);
        SparseApi.setApiToken(apiToken);
    }

    private AquariusServerVersion getServerVersion() {
        ServiceModel.Status response = Api.get(new ServiceModel.GetStatus());

        return AquariusServerVersion.Create(response.ReleaseName);
    }

    private void disconnect() {
    }

    @Override
    public void close() throws Exception {
        disconnect();
    }

    public <TResponse> TResponse postFileWithRequest(File fileToUpload, IReturn<TResponse> requestDto)
    {
        try (FileInputStream contentToUpload = new FileInputStream(fileToUpload.getPath())) {
            return postFileWithRequest(contentToUpload, fileToUpload.getName(), requestDto);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <TResponse> TResponse postFileWithRequest(InputStream contentToUpload, String fileName, IReturn<TResponse> requestDto) {

        return isImportServiceUpload(requestDto)
                ? postImportServiceRequest(contentToUpload, fileName, requestDto)
                : postFineuploaderRequest(contentToUpload, fileName, requestDto);
    }

    private <TResponse> boolean isImportServiceUpload(IReturn<TResponse> requestDto) {
        Route route = Api.getRoute(requestDto);

        if (route == null)
            throw new RuntimeException("No REST route found for " + requestDto.getClass().getName());

        return  (route.Path().toLowerCase().contains("/services/import"));
    }

    private <TResponse> TResponse postImportServiceRequest(InputStream contentToUpload, String fileName, IReturn<TResponse> requestDto) {
        return Api.postFileWithRequest(contentToUpload, fileName, requestDto, "file");
    }

    private <TResponse> TResponse postFineuploaderRequest(InputStream contentToUpload, String fileName, IReturn<TResponse> requestDto) {
        // These uploads need to emulate all the special FineUploader emulation cruft:
        // qqfile for the content field,
        // plus, qquuid, qqfilename, and qqtotalfilesize string fields
        byte[] bytes = ConvertToByteArray(contentToUpload);

        Map<String,String> extraProperties = new HashMap<String, String>();
        extraProperties.put("qqfilename", fileName);
        extraProperties.put("qqtotalfilesize", Integer.toString(bytes.length));
        extraProperties.put("qquuid", UUID.randomUUID().toString());

        return Api.postFileWithRequest(new ByteArrayInputStream(bytes), fileName, requestDto, "qqfile", extraProperties);
    }

    private byte[] ConvertToByteArray(InputStream content) {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = content.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            return buffer.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <TDomainObject> LazyResult<TDomainObject> lazyGet(Consumer<String> setCursorAction, Supplier<IPaginatedResponse<TDomainObject>> getNextPageFunc) {
        return new LazyResult<>(setCursorAction, getNextPageFunc);
    }

    public <TDomainObject> Stream<TDomainObject> lazyGetStream(Consumer<String> setCursorAction, Supplier<IPaginatedResponse<TDomainObject>> getNextPageFunc) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(lazyGet(setCursorAction, getNextPageFunc), Spliterator.ORDERED),
                false);
    }
}
