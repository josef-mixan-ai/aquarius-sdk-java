/* Options:
Instant: 2020-07-10 13:55:25
Version: 4.512
Tip: To override a DTO option, remove "//" prefix before updating
BaseUrl: http://autoserver1/AQUARIUS/Acquisition/v2

Package: com.aquaticinformatics.aquarius.sdk.timeseries.servicemodels
GlobalNamespace: Acquisition
//AddPropertyAccessors: True
//SettersReturnThis: True
AddServiceStackTypes: False
//AddResponseStatus: False
//AddDescriptionAsComments: True
//AddImplicitVersion: 
//IncludeTypes: 
//ExcludeTypes: 
TreatTypesAsStrings: Guid
DefaultImports: java.time.*,java.util.*,net.servicestack.client.*,com.aquaticinformatics.aquarius.sdk.AquariusServerVersion
*/

package com.aquaticinformatics.aquarius.sdk.timeseries.servicemodels;

import java.time.*;
import java.util.*;
import net.servicestack.client.*;
import com.aquaticinformatics.aquarius.sdk.AquariusServerVersion;

public class Acquisition
{

    @Route(Path="/locations/{LocationUniqueId}/visits/upload/plugins", Verbs="POST")
    public static class PostVisitFileToLocation extends PostVisitFileBase implements IReturn<PostVisitFileResponse>
    {
        /**
        * Unique ID of the location of visits in the file
        */
        @ApiMember(DataType="string", Description="Unique ID of the location of visits in the file", IsRequired=true, ParameterType="path")
        public String LocationUniqueId = null;
        
        public String getLocationUniqueId() { return LocationUniqueId; }
        public PostVisitFileToLocation setLocationUniqueId(String value) { this.LocationUniqueId = value; return this; }
        private static Object responseType = PostVisitFileResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/visits/{VisitIdentifier}/upload/plugins", Verbs="POST")
    public static class PostVisitFileToVisit extends PostVisitFileBase implements IReturn<PostVisitFileResponse>
    {
        /**
        * Identifier of the existing visit to add the file's content to
        */
        @ApiMember(Description="Identifier of the existing visit to add the file's content to", IsRequired=true, ParameterType="path")
        public String VisitIdentifier = null;
        
        public String getVisitIdentifier() { return VisitIdentifier; }
        public PostVisitFileToVisit setVisitIdentifier(String value) { this.VisitIdentifier = value; return this; }
        private static Object responseType = PostVisitFileResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/visits/upload/plugins", Verbs="POST")
    public static class PostVisitFile extends PostVisitFileBase implements IReturn<PostVisitFileResponse>
    {
        
        private static Object responseType = PostVisitFileResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/visits/{VisitIdentifier}", Verbs="DELETE")
    public static class DeleteVisit implements IReturnVoid
    {
        /**
        * Identifier of the existing visit to delete
        */
        @ApiMember(Description="Identifier of the existing visit to delete", IsRequired=true, ParameterType="path")
        public String VisitIdentifier = null;
        
        public String getVisitIdentifier() { return VisitIdentifier; }
        public DeleteVisit setVisitIdentifier(String value) { this.VisitIdentifier = value; return this; }
    }

    @Route(Path="/locations/{LocationUniqueId}/attachments/reports", Verbs="POST")
    public static class PostReportAttachment implements IReturn<PostReportResponse>
    {
        /**
        * Title of the report
        */
        @ApiMember(Description="Title of the report", IsRequired=true)
        public String Title = null;

        /**
        * Description of the report
        */
        @ApiMember(Description="Description of the report")
        public String Description = null;

        /**
        * Comments about the report
        */
        @ApiMember(Description="Comments about the report")
        public String Comments = null;

        /**
        * Unique ID of the location to add the report to
        */
        @ApiMember(DataType="string", Description="Unique ID of the location to add the report to", IsRequired=true, ParameterType="path")
        public String LocationUniqueId = null;

        /**
        * Unique IDs of source time-series displayed in report
        */
        @ApiMember(DataType="Array<string>", Description="Unique IDs of source time-series displayed in report")
        public ArrayList<String> SourceTimeSeriesUniqueIds = null;

        /**
        * Time range of source data displayed in report
        */
        @ApiMember(DataType="Interval", Description="Time range of source data displayed in report")
        public Interval SourceTimeRange = null;

        /**
        * Time report was created
        */
        @ApiMember(DataType="Instant", Description="Time report was created")
        public Instant CreatedTime = null;

        public String getTitle() { return Title; }
        public PostReportAttachment setTitle(String value) { this.Title = value; return this; }
        public String getDescription() { return Description; }
        public PostReportAttachment setDescription(String value) { this.Description = value; return this; }
        public String getComments() { return Comments; }
        public PostReportAttachment setComments(String value) { this.Comments = value; return this; }
        public String getLocationUniqueId() { return LocationUniqueId; }
        public PostReportAttachment setLocationUniqueId(String value) { this.LocationUniqueId = value; return this; }
        public ArrayList<String> getSourceTimeSeriesUniqueIds() { return SourceTimeSeriesUniqueIds; }
        public PostReportAttachment setSourceTimeSeriesUniqueIds(ArrayList<String> value) { this.SourceTimeSeriesUniqueIds = value; return this; }
        public Interval getSourceTimeRange() { return SourceTimeRange; }
        public PostReportAttachment setSourceTimeRange(Interval value) { this.SourceTimeRange = value; return this; }
        public Instant getCreatedTime() { return CreatedTime; }
        public PostReportAttachment setCreatedTime(Instant value) { this.CreatedTime = value; return this; }
        private static Object responseType = PostReportResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/attachments/reports/{ReportUniqueId}", Verbs="DELETE")
    public static class DeleteReportAttachment implements IReturnVoid
    {
        /**
        * Unique ID of report
        */
        @ApiMember(DataType="string", Description="Unique ID of report", IsRequired=true, ParameterType="path")
        public String ReportUniqueId = null;
        
        public String getReportUniqueId() { return ReportUniqueId; }
        public DeleteReportAttachment setReportUniqueId(String value) { this.ReportUniqueId = value; return this; }
    }

    @Route(Path="/locations/{LocationUniqueId}/attachments", Verbs="POST")
    public static class PostLocationAttachment implements IReturn<PostLocationAttachmentResponse>
    {
        /**
        * Unique ID of the location to add the attachment to
        */
        @ApiMember(DataType="string", Description="Unique ID of the location to add the attachment to", IsRequired=true, ParameterType="path")
        public String LocationUniqueId = null;

        /**
        * If not specified, defaults to None
        */
        @ApiMember(DataType="AttachmentCategory", Description="If not specified, defaults to None")
        public AttachmentCategory AttachmentCategory = null;

        /**
        * Comment
        */
        @ApiMember(Description="Comment")
        public String Comments = null;

        public String getLocationUniqueId() { return LocationUniqueId; }
        public PostLocationAttachment setLocationUniqueId(String value) { this.LocationUniqueId = value; return this; }
        public AttachmentCategory getAttachmentCategory() { return AttachmentCategory; }
        public PostLocationAttachment setAttachmentCategory(AttachmentCategory value) { this.AttachmentCategory = value; return this; }
        public String getComments() { return Comments; }
        public PostLocationAttachment setComments(String value) { this.Comments = value; return this; }
        private static Object responseType = PostLocationAttachmentResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/session/keepalive", Verbs="GET")
    public static class GetKeepAlive implements IReturnVoid
    {
        
    }

    @Route(Path="/session", Verbs="POST")
    public static class PostSession implements IReturn<String>
    {
        /**
        * Username
        */
        @ApiMember(Description="Username")
        public String Username = null;

        /**
        * Encrypted password
        */
        @ApiMember(Description="Encrypted password")
        public String EncryptedPassword = null;

        /**
        * Optional locale. Defaults to English
        */
        @ApiMember(Description="Optional locale. Defaults to English")
        public String Locale = null;
        
        public String getUsername() { return Username; }
        public PostSession setUsername(String value) { this.Username = value; return this; }
        public String getEncryptedPassword() { return EncryptedPassword; }
        public PostSession setEncryptedPassword(String value) { this.EncryptedPassword = value; return this; }
        public String getLocale() { return Locale; }
        public PostSession setLocale(String value) { this.Locale = value; return this; }
        private static Object responseType = String.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/session", Verbs="DELETE")
    public static class DeleteSession implements IReturnVoid
    {
        
    }

    @Route(Path="/session/publickey", Verbs="GET")
    public static class GetPublicKey implements IReturn<PublicKey>
    {
        
        private static Object responseType = PublicKey.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/appendstatus/{AppendRequestIdentifier}", Verbs="GET")
    public static class GetTimeSeriesAppendStatus implements IReturn<TimeSeriesAppendStatus>
    {
        /**
        * Identifier returned from a previous append request
        */
        @ApiMember(Description="Identifier returned from a previous append request", IsRequired=true, ParameterType="path")
        public String AppendRequestIdentifier = null;
        
        public String getAppendRequestIdentifier() { return AppendRequestIdentifier; }
        public GetTimeSeriesAppendStatus setAppendRequestIdentifier(String value) { this.AppendRequestIdentifier = value; return this; }
        private static Object responseType = TimeSeriesAppendStatus.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/{UniqueId}/append", Verbs="POST")
    public static class PostTimeSeriesAppend implements IReturn<AppendResponse>
    {
        /**
        * The unique ID (from Publish API) of the time-series to receive points
        */
        @ApiMember(DataType="string", Description="The unique ID (from Publish API) of the time-series to receive points", IsRequired=true, ParameterType="path")
        public String UniqueId = null;

        /**
        * Points to append (can be empty)
        */
        @ApiMember(DataType="Array<TimeSeriesPoint>", Description="Points to append (can be empty)")
        public ArrayList<TimeSeriesPoint> Points = null;
        
        public String getUniqueId() { return UniqueId; }
        public PostTimeSeriesAppend setUniqueId(String value) { this.UniqueId = value; return this; }
        public ArrayList<TimeSeriesPoint> getPoints() { return Points; }
        public PostTimeSeriesAppend setPoints(ArrayList<TimeSeriesPoint> value) { this.Points = value; return this; }
        private static Object responseType = AppendResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/{UniqueId}/overwriteappend", Verbs="POST")
    public static class PostTimeSeriesOverwriteAppend implements IReturn<AppendResponse>
    {
        /**
        * The unique ID (from Publish API) of the time-series to receive points
        */
        @ApiMember(DataType="string", Description="The unique ID (from Publish API) of the time-series to receive points", IsRequired=true, ParameterType="path")
        public String UniqueId = null;

        /**
        * Points to append (can be empty). All points must lie within the time range
        */
        @ApiMember(DataType="Array<TimeSeriesPoint>", Description="Points to append (can be empty). All points must lie within the time range")
        public ArrayList<TimeSeriesPoint> Points = null;

        /**
        * Time range to delete before appending points
        */
        @ApiMember(DataType="Interval", Description="Time range to delete before appending points", IsRequired=true)
        public Interval TimeRange = null;
        
        public String getUniqueId() { return UniqueId; }
        public PostTimeSeriesOverwriteAppend setUniqueId(String value) { this.UniqueId = value; return this; }
        public ArrayList<TimeSeriesPoint> getPoints() { return Points; }
        public PostTimeSeriesOverwriteAppend setPoints(ArrayList<TimeSeriesPoint> value) { this.Points = value; return this; }
        public Interval getTimeRange() { return TimeRange; }
        public PostTimeSeriesOverwriteAppend setTimeRange(Interval value) { this.TimeRange = value; return this; }
        private static Object responseType = AppendResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/{UniqueId}/reflected", Verbs="POST")
    public static class PostReflectedTimeSeries implements IReturn<AppendResponse>
    {
        /**
        * The unique ID (from Publish API) of the reflected time-series to receive points
        */
        @ApiMember(DataType="string", Description="The unique ID (from Publish API) of the reflected time-series to receive points", IsRequired=true, ParameterType="path")
        public String UniqueId = null;

        /**
        * Points to append (can be empty). All points must lie within the time range
        */
        @ApiMember(DataType="Array<TimeSeriesPoint>", Description="Points to append (can be empty). All points must lie within the time range")
        public ArrayList<TimeSeriesPoint> Points = null;

        /**
        * Time range to update. Any existing points in the time range will be overwritten
        */
        @ApiMember(DataType="Interval", Description="Time range to update. Any existing points in the time range will be overwritten", IsRequired=true)
        public Interval TimeRange = null;
        
        public String getUniqueId() { return UniqueId; }
        public PostReflectedTimeSeries setUniqueId(String value) { this.UniqueId = value; return this; }
        public ArrayList<TimeSeriesPoint> getPoints() { return Points; }
        public PostReflectedTimeSeries setPoints(ArrayList<TimeSeriesPoint> value) { this.Points = value; return this; }
        public Interval getTimeRange() { return TimeRange; }
        public PostReflectedTimeSeries setTimeRange(Interval value) { this.TimeRange = value; return this; }
        private static Object responseType = AppendResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/{UniqueId}/metadata", Verbs="POST")
    public static class PostTimeSeriesMetadata implements IReturn<PostTimeSeriesMetadataResponse>
    {
        /**
        * The unique ID (from Publish API) of the time-series
        */
        @ApiMember(DataType="string", Description="The unique ID (from Publish API) of the time-series", IsRequired=true, ParameterType="path")
        public String UniqueId = null;

        /**
        * Notes to append
        */
        @ApiMember(DataType="Array<TimeSeriesNote>", Description="Notes to append", IsRequired=true)
        public ArrayList<TimeSeriesNote> Notes = null;
        
        public String getUniqueId() { return UniqueId; }
        public PostTimeSeriesMetadata setUniqueId(String value) { this.UniqueId = value; return this; }
        public ArrayList<TimeSeriesNote> getNotes() { return Notes; }
        public PostTimeSeriesMetadata setNotes(ArrayList<TimeSeriesNote> value) { this.Notes = value; return this; }
        private static Object responseType = PostTimeSeriesMetadataResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/timeseries/{UniqueId}/metadata/notes", Verbs="DELETE")
    public static class DeleteTimeSeriesNotes implements IReturn<DeleteTimeSeriesNotesResponse>
    {
        /**
        * The unique ID (from Publish API) of the time-series
        */
        @ApiMember(DataType="string", Description="The unique ID (from Publish API) of the time-series", IsRequired=true, ParameterType="path")
        public String UniqueId = null;

        /**
        * Time range. Only appended notes that are fully contained within the time range will be deleted.
        */
        @ApiMember(DataType="Interval", Description="Time range. Only appended notes that are fully contained within the time range will be deleted.", IsRequired=true)
        public Interval TimeRange = null;
        
        public String getUniqueId() { return UniqueId; }
        public DeleteTimeSeriesNotes setUniqueId(String value) { this.UniqueId = value; return this; }
        public Interval getTimeRange() { return TimeRange; }
        public DeleteTimeSeriesNotes setTimeRange(Interval value) { this.TimeRange = value; return this; }
        private static Object responseType = DeleteTimeSeriesNotesResponse.class;
        public Object getResponseType() { return responseType; }
    }

    public static class PostVisitFileResponse
    {
        /**
        * Relative URIs of created or modified visits
        */
        @ApiMember(DataType="Array<string>", Description="Relative URIs of created or modified visits")
        public ArrayList<String> VisitUris = null;

        /**
        * Identifiers of created or modified visits
        */
        @ApiMember(DataType="Array<string>", Description="Identifiers of created or modified visits")
        public ArrayList<String> VisitIdentifiers = null;

        /**
        * Registered field data plug-in that processed the file
        */
        @ApiMember(DataType="FieldDataPlugin", Description="Registered field data plug-in that processed the file")
        public FieldDataPlugin HandledByPlugin = null;
        
        public ArrayList<String> getVisitUris() { return VisitUris; }
        public PostVisitFileResponse setVisitUris(ArrayList<String> value) { this.VisitUris = value; return this; }
        public ArrayList<String> getVisitIdentifiers() { return VisitIdentifiers; }
        public PostVisitFileResponse setVisitIdentifiers(ArrayList<String> value) { this.VisitIdentifiers = value; return this; }
        public FieldDataPlugin getHandledByPlugin() { return HandledByPlugin; }
        public PostVisitFileResponse setHandledByPlugin(FieldDataPlugin value) { this.HandledByPlugin = value; return this; }
    }

    public static class PostReportResponse
    {
        /**
        * Unique ID of the created report
        */
        @ApiMember(DataType="string", Description="Unique ID of the created report")
        public String ReportUniqueId = null;
        
        public String getReportUniqueId() { return ReportUniqueId; }
        public PostReportResponse setReportUniqueId(String value) { this.ReportUniqueId = value; return this; }
    }

    public static class PostLocationAttachmentResponse
    {
        /**
        * Attachment URL
        */
        @ApiMember(Description="Attachment URL")
        public String Url = null;

        /**
        * Unique ID of the location
        */
        @ApiMember(DataType="string", Description="Unique ID of the location")
        public String LocationUniqueId = null;

        /**
        * File name
        */
        @ApiMember(Description="File name")
        public String FileName = null;

        /**
        * Attachment category
        */
        @ApiMember(DataType="AttachmentCategory", Description="Attachment category")
        public AttachmentCategory AttachmentCategory = null;

        /**
        * Comment
        */
        @ApiMember(Description="Comment")
        public String Comments = null;

        public AttachmentType AttachmentType = null;
        
        public String getUrl() { return Url; }
        public PostLocationAttachmentResponse setUrl(String value) { this.Url = value; return this; }
        public String getLocationUniqueId() { return LocationUniqueId; }
        public PostLocationAttachmentResponse setLocationUniqueId(String value) { this.LocationUniqueId = value; return this; }
        public String getFileName() { return FileName; }
        public PostLocationAttachmentResponse setFileName(String value) { this.FileName = value; return this; }
        public AttachmentCategory getAttachmentCategory() { return AttachmentCategory; }
        public PostLocationAttachmentResponse setAttachmentCategory(AttachmentCategory value) { this.AttachmentCategory = value; return this; }
        public String getComments() { return Comments; }
        public PostLocationAttachmentResponse setComments(String value) { this.Comments = value; return this; }
        public AttachmentType getAttachmentType() { return AttachmentType; }
        public PostLocationAttachmentResponse setAttachmentType(AttachmentType value) { this.AttachmentType = value; return this; }
    }

    public static class PublicKey
    {
        /**
        * RSA key size in bits
        */
        @ApiMember(DataType="integer", Description="RSA key size in bits")
        public Integer KeySize = null;

        /**
        * XML blob containing the RSA public key components
        */
        @ApiMember(Description="XML blob containing the RSA public key components")
        public String Xml = null;
        
        public Integer getKeySize() { return KeySize; }
        public PublicKey setKeySize(Integer value) { this.KeySize = value; return this; }
        public String getXml() { return Xml; }
        public PublicKey setXml(String value) { this.Xml = value; return this; }
    }

    public static class TimeSeriesAppendStatus
    {
        /**
        * Unique ID of the time series
        */
        @ApiMember(DataType="string", Description="Unique ID of the time series")
        public String TimeSeriesUniqueId = null;

        public AppendStatusCode AppendStatus = null;
        /**
        * When AppendStatus=Completed: Version of the time series containing the appended points
        */
        @ApiMember(DataType="Int64", Description="When AppendStatus=Completed: Version of the time series containing the appended points")
        public Long AppendedVersion = null;

        /**
        * When AppendStatus=Completed: Number of points successfully appended
        */
        @ApiMember(DataType="integer", Description="When AppendStatus=Completed: Number of points successfully appended")
        public Integer NumberOfPointsAppended = null;

        /**
        * When AppendStatus=Completed: Number of points successfully deleted
        */
        @ApiMember(DataType="integer", Description="When AppendStatus=Completed: Number of points successfully deleted")
        public Integer NumberOfPointsDeleted = null;
        
        public String getTimeSeriesUniqueId() { return TimeSeriesUniqueId; }
        public TimeSeriesAppendStatus setTimeSeriesUniqueId(String value) { this.TimeSeriesUniqueId = value; return this; }
        public AppendStatusCode getAppendStatus() { return AppendStatus; }
        public TimeSeriesAppendStatus setAppendStatus(AppendStatusCode value) { this.AppendStatus = value; return this; }
        public Long getAppendedVersion() { return AppendedVersion; }
        public TimeSeriesAppendStatus setAppendedVersion(Long value) { this.AppendedVersion = value; return this; }
        public Integer getNumberOfPointsAppended() { return NumberOfPointsAppended; }
        public TimeSeriesAppendStatus setNumberOfPointsAppended(Integer value) { this.NumberOfPointsAppended = value; return this; }
        public Integer getNumberOfPointsDeleted() { return NumberOfPointsDeleted; }
        public TimeSeriesAppendStatus setNumberOfPointsDeleted(Integer value) { this.NumberOfPointsDeleted = value; return this; }
    }

    public static class AppendResponse
    {
        /**
        * A token to use in subsequent GetTimeSeriesAppendStatus calls
        */
        @ApiMember(Description="A token to use in subsequent GetTimeSeriesAppendStatus calls")
        public String AppendRequestIdentifier = null;
        
        public String getAppendRequestIdentifier() { return AppendRequestIdentifier; }
        public AppendResponse setAppendRequestIdentifier(String value) { this.AppendRequestIdentifier = value; return this; }
    }

    public static class PostTimeSeriesMetadataResponse
    {
        /**
        * Notes created
        */
        @ApiMember(DataType="integer", Description="Notes created")
        public Integer NotesCreated = null;
        
        public Integer getNotesCreated() { return NotesCreated; }
        public PostTimeSeriesMetadataResponse setNotesCreated(Integer value) { this.NotesCreated = value; return this; }
    }

    public static class DeleteTimeSeriesNotesResponse
    {
        /**
        * Notes deleted
        */
        @ApiMember(DataType="integer", Description="Notes deleted")
        public Integer NotesDeleted = null;
        
        public Integer getNotesDeleted() { return NotesDeleted; }
        public DeleteTimeSeriesNotesResponse setNotesDeleted(Integer value) { this.NotesDeleted = value; return this; }
    }

    public static class PostVisitFileBase
    {
    }

    public static class FieldDataPlugin
    {
        /**
        * Name
        */
        @ApiMember(Description="Name")
        public String Name = null;

        /**
        * Unique id
        */
        @ApiMember(DataType="string", Description="Unique id")
        public String UniqueId = null;
        
        public String getName() { return Name; }
        public FieldDataPlugin setName(String value) { this.Name = value; return this; }
        public String getUniqueId() { return UniqueId; }
        public FieldDataPlugin setUniqueId(String value) { this.UniqueId = value; return this; }
    }

    public static enum AttachmentCategory
    {
        None,
        LocationPhoto,
        Notes,
        Site,
        Channel,
        Measurement,
        CrossSection,
        Inspection,
        InventoryControl,
        LevelSurvey;
    }

    public static enum AttachmentType
    {
        Binary,
        Swami,
        Image,
        Video,
        Audio,
        Pdf,
        Xml,
        Text,
        Zip,
        HistoricalSwami,
        AquaCalc,
        FlowTracker,
        Hfc,
        ScotLogger,
        SonTek,
        WinRiver,
        LoggerFile,
        GeneratedReport,
        Csv,
        FieldDataPlugin;
    }

    public static enum AppendStatusCode
    {
        Pending,
        Completed,
        Failed;
    }

    public static class TimeSeriesPoint
    {
        /**
        * ISO 8601 timestamp. Must not be specified if Type is 'Gap'.
        */
        @ApiMember(DataType="Instant", Description="ISO 8601 timestamp. Must not be specified if Type is 'Gap'.")
        public Instant Time = null;

        /**
        * The value of the point. Null or empty to represent a NaN. Must not be specified if Type is 'Gap'.
        */
        @ApiMember(DataType="double", Description="The value of the point. Null or empty to represent a NaN. Must not be specified if Type is 'Gap'.")
        public Double Value = null;

        /**
        * The type of the point: 'Point' or 'Gap'. Defaults to 'Point' if null or empty.
        */
        @ApiMember(DataType="PointType", Description="The type of the point: 'Point' or 'Gap'. Defaults to 'Point' if null or empty.")
        public PointType Type = null;

        /**
        * Grade code
        */
        @ApiMember(DataType="integer", Description="Grade code")
        public Integer GradeCode = null;

        /**
        * Qualifier codes
        */
        @ApiMember(DataType="Array<string>", Description="Qualifier codes")
        public ArrayList<String> Qualifiers = null;
        
        public Instant getTime() { return Time; }
        public TimeSeriesPoint setTime(Instant value) { this.Time = value; return this; }
        public Double getValue() { return Value; }
        public TimeSeriesPoint setValue(Double value) { this.Value = value; return this; }
        public PointType getType() { return Type; }
        public TimeSeriesPoint setType(PointType value) { this.Type = value; return this; }
        public Integer getGradeCode() { return GradeCode; }
        public TimeSeriesPoint setGradeCode(Integer value) { this.GradeCode = value; return this; }
        public ArrayList<String> getQualifiers() { return Qualifiers; }
        public TimeSeriesPoint setQualifiers(ArrayList<String> value) { this.Qualifiers = value; return this; }
    }

    public static class TimeSeriesNote
    {
        /**
        * Time range of the note
        */
        @ApiMember(DataType="Interval", Description="Time range of the note", IsRequired=true)
        public Interval TimeRange = null;

        /**
        * Content of the note
        */
        @ApiMember(Description="Content of the note", IsRequired=true)
        public String NoteText = null;
        
        public Interval getTimeRange() { return TimeRange; }
        public TimeSeriesNote setTimeRange(Interval value) { this.TimeRange = value; return this; }
        public String getNoteText() { return NoteText; }
        public TimeSeriesNote setNoteText(String value) { this.NoteText = value; return this; }
    }

    public static enum PointType
    {
        Unknown,
        Point,
        Gap;
    }

    public static class Current
    {
        public static final AquariusServerVersion Version = AquariusServerVersion.Create("20.2.85.0");
    }
}
