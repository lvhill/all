
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.sky.test.webservice.client.ecard.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Args_QNAME = new QName("http://impl.ws.com", "args");
    private final static QName _MeetingTicketUpdatedResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketUpdatedResponse");
    private final static QName _VerifyAdaCardAuthorization_QNAME = new QName("http://service.ws.ecard.amway.com/", "verifyAdaCardAuthorization");
    private final static QName _VerifyAdaCardAuthorizationResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "verifyAdaCardAuthorizationResponse");
    private final static QName _UpdateWeChatCard_QNAME = new QName("http://service.ws.ecard.amway.com/", "updateWeChatCard");
    private final static QName _ClientProtocolException_QNAME = new QName("http://service.ws.ecard.amway.com/", "ClientProtocolException");
    private final static QName _MeetingTicketDeleteResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketDeleteResponse");
    private final static QName _MeetingTicketCreated_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketCreated");
    private final static QName _WechatOrderPublicQuery_QNAME = new QName("http://service.ws.ecard.amway.com/", "wechatOrderPublicQuery");
    private final static QName _WeChatOrderQueryDTOs_QNAME = new QName("http://impl.ws.com", "weChatOrderQueryDTOs");
    private final static QName _MeetingTicketUpdated_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketUpdated");
    private final static QName _WeChatCardDTO_QNAME = new QName("http://impl.ws.com", "weChatCardDTO");
    private final static QName _WechatOrderPublicCloser_QNAME = new QName("http://service.ws.ecard.amway.com/", "wechatOrderPublicCloser");
    private final static QName _TicketNoDTO_QNAME = new QName("http://impl.ws.com", "ticketNoDTO");
    private final static QName _CreateWeChatCardResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "createWeChatCardResponse");
    private final static QName _List_QNAME = new QName("http://impl.ws.com", "list");
    private final static QName _WechatOrderPublicCloserResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "wechatOrderPublicCloserResponse");
    private final static QName _WechatOrderPublicQueryResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "wechatOrderPublicQueryResponse");
    private final static QName _MeetingCreatedOrUpdated_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingCreatedOrUpdated");
    private final static QName _UpdateWeChatMeetingFlagResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "updateWeChatMeetingFlagResponse");
    private final static QName _MeetingTicketCreatedResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketCreatedResponse");
    private final static QName _UpdateWeChatCardResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "updateWeChatCardResponse");
    private final static QName _WeChatOrderCloserDTOs_QNAME = new QName("http://impl.ws.com", "weChatOrderCloserDTOs");
    private final static QName _CreateWeChatCard_QNAME = new QName("http://service.ws.ecard.amway.com/", "createWeChatCard");
    private final static QName _SimpleList_QNAME = new QName("http://impl.ws.com", "simpleList");
    private final static QName _Exception_QNAME = new QName("http://service.ws.ecard.amway.com/", "Exception");
    private final static QName _IOException_QNAME = new QName("http://service.ws.ecard.amway.com/", "IOException");
    private final static QName _UpdateWeChatMeetingFlag_QNAME = new QName("http://service.ws.ecard.amway.com/", "updateWeChatMeetingFlag");
    private final static QName _MeetingTicketDelete_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingTicketDelete");
    private final static QName _ActivityMeetingDTOs_QNAME = new QName("http://impl.ws.com", "ActivityMeetingDTOs");
    private final static QName _MeetingCreatedOrUpdatedResponse_QNAME = new QName("http://service.ws.ecard.amway.com/", "meetingCreatedOrUpdatedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.sky.test.webservice.client.ecard.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QRCodeDTO }
     * 
     */
    public QRCodeDTO createQRCodeDTO() {
        return new QRCodeDTO();
    }

    /**
     * Create an instance of {@link ActivityMeetingDTO }
     * 
     */
    public ActivityMeetingDTO createActivityMeetingDTO() {
        return new ActivityMeetingDTO();
    }

    /**
     * Create an instance of {@link WeChatOrderCloserDTOs }
     * 
     */
    public WeChatOrderCloserDTOs createWeChatOrderCloserDTOs() {
        return new WeChatOrderCloserDTOs();
    }

    /**
     * Create an instance of {@link ActivityTicketSimpleDTO }
     * 
     */
    public ActivityTicketSimpleDTO createActivityTicketSimpleDTO() {
        return new ActivityTicketSimpleDTO();
    }

    /**
     * Create an instance of {@link WeChatDTO }
     * 
     */
    public WeChatDTO createWeChatDTO() {
        return new WeChatDTO();
    }

    /**
     * Create an instance of {@link ActivityTicketDTO }
     * 
     */
    public ActivityTicketDTO createActivityTicketDTO() {
        return new ActivityTicketDTO();
    }

    /**
     * Create an instance of {@link WeChatOrderQueryDTOs }
     * 
     */
    public WeChatOrderQueryDTOs createWeChatOrderQueryDTOs() {
        return new WeChatOrderQueryDTOs();
    }

    /**
     * Create an instance of {@link CreateWeChatCard }
     * 
     */
    public CreateWeChatCard createCreateWeChatCard() {
        return new CreateWeChatCard();
    }

    /**
     * Create an instance of {@link UpdateWeChatCard }
     * 
     */
    public UpdateWeChatCard createUpdateWeChatCard() {
        return new UpdateWeChatCard();
    }

    /**
     * Create an instance of {@link MeetingTicketCreatedResponse }
     * 
     */
    public MeetingTicketCreatedResponse createMeetingTicketCreatedResponse() {
        return new MeetingTicketCreatedResponse();
    }

    /**
     * Create an instance of {@link UpdateWeChatCardResponse }
     * 
     */
    public UpdateWeChatCardResponse createUpdateWeChatCardResponse() {
        return new UpdateWeChatCardResponse();
    }

    /**
     * Create an instance of {@link UpdateWeChatMeetingFlagResponse }
     * 
     */
    public UpdateWeChatMeetingFlagResponse createUpdateWeChatMeetingFlagResponse() {
        return new UpdateWeChatMeetingFlagResponse();
    }

    /**
     * Create an instance of {@link VerifyAdaCardAuthorization }
     * 
     */
    public VerifyAdaCardAuthorization createVerifyAdaCardAuthorization() {
        return new VerifyAdaCardAuthorization();
    }

    /**
     * Create an instance of {@link VerifyAdaCardAuthorizationResponse }
     * 
     */
    public VerifyAdaCardAuthorizationResponse createVerifyAdaCardAuthorizationResponse() {
        return new VerifyAdaCardAuthorizationResponse();
    }

    /**
     * Create an instance of {@link MeetingCreatedOrUpdated }
     * 
     */
    public MeetingCreatedOrUpdated createMeetingCreatedOrUpdated() {
        return new MeetingCreatedOrUpdated();
    }

    /**
     * Create an instance of {@link MeetingTicketUpdatedResponse }
     * 
     */
    public MeetingTicketUpdatedResponse createMeetingTicketUpdatedResponse() {
        return new MeetingTicketUpdatedResponse();
    }

    /**
     * Create an instance of {@link WechatOrderPublicCloserResponse }
     * 
     */
    public WechatOrderPublicCloserResponse createWechatOrderPublicCloserResponse() {
        return new WechatOrderPublicCloserResponse();
    }

    /**
     * Create an instance of {@link WechatOrderPublicQueryResponse }
     * 
     */
    public WechatOrderPublicQueryResponse createWechatOrderPublicQueryResponse() {
        return new WechatOrderPublicQueryResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link WechatOrderPublicQuery }
     * 
     */
    public WechatOrderPublicQuery createWechatOrderPublicQuery() {
        return new WechatOrderPublicQuery();
    }

    /**
     * Create an instance of {@link MeetingTicketCreated }
     * 
     */
    public MeetingTicketCreated createMeetingTicketCreated() {
        return new MeetingTicketCreated();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link MeetingTicketDeleteResponse }
     * 
     */
    public MeetingTicketDeleteResponse createMeetingTicketDeleteResponse() {
        return new MeetingTicketDeleteResponse();
    }

    /**
     * Create an instance of {@link ClientProtocolException }
     * 
     */
    public ClientProtocolException createClientProtocolException() {
        return new ClientProtocolException();
    }

    /**
     * Create an instance of {@link MeetingTicketUpdated }
     * 
     */
    public MeetingTicketUpdated createMeetingTicketUpdated() {
        return new MeetingTicketUpdated();
    }

    /**
     * Create an instance of {@link MeetingTicketDelete }
     * 
     */
    public MeetingTicketDelete createMeetingTicketDelete() {
        return new MeetingTicketDelete();
    }

    /**
     * Create an instance of {@link UpdateWeChatMeetingFlag }
     * 
     */
    public UpdateWeChatMeetingFlag createUpdateWeChatMeetingFlag() {
        return new UpdateWeChatMeetingFlag();
    }

    /**
     * Create an instance of {@link CreateWeChatCardResponse }
     * 
     */
    public CreateWeChatCardResponse createCreateWeChatCardResponse() {
        return new CreateWeChatCardResponse();
    }

    /**
     * Create an instance of {@link MeetingCreatedOrUpdatedResponse }
     * 
     */
    public MeetingCreatedOrUpdatedResponse createMeetingCreatedOrUpdatedResponse() {
        return new MeetingCreatedOrUpdatedResponse();
    }

    /**
     * Create an instance of {@link WechatOrderPublicCloser }
     * 
     */
    public WechatOrderPublicCloser createWechatOrderPublicCloser() {
        return new WechatOrderPublicCloser();
    }

    /**
     * Create an instance of {@link WechatOrderQueryResultDTO }
     * 
     */
    public WechatOrderQueryResultDTO createWechatOrderQueryResultDTO() {
        return new WechatOrderQueryResultDTO();
    }

    /**
     * Create an instance of {@link ResultDTO }
     * 
     */
    public ResultDTO createResultDTO() {
        return new ResultDTO();
    }

    /**
     * Create an instance of {@link AuthVerificationResultDTO }
     * 
     */
    public AuthVerificationResultDTO createAuthVerificationResultDTO() {
        return new AuthVerificationResultDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QRCodeDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "args")
    public JAXBElement<QRCodeDTO> createArgs(QRCodeDTO value) {
        return new JAXBElement<QRCodeDTO>(_Args_QNAME, QRCodeDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketUpdatedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketUpdatedResponse")
    public JAXBElement<MeetingTicketUpdatedResponse> createMeetingTicketUpdatedResponse(MeetingTicketUpdatedResponse value) {
        return new JAXBElement<MeetingTicketUpdatedResponse>(_MeetingTicketUpdatedResponse_QNAME, MeetingTicketUpdatedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyAdaCardAuthorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "verifyAdaCardAuthorization")
    public JAXBElement<VerifyAdaCardAuthorization> createVerifyAdaCardAuthorization(VerifyAdaCardAuthorization value) {
        return new JAXBElement<VerifyAdaCardAuthorization>(_VerifyAdaCardAuthorization_QNAME, VerifyAdaCardAuthorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyAdaCardAuthorizationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "verifyAdaCardAuthorizationResponse")
    public JAXBElement<VerifyAdaCardAuthorizationResponse> createVerifyAdaCardAuthorizationResponse(VerifyAdaCardAuthorizationResponse value) {
        return new JAXBElement<VerifyAdaCardAuthorizationResponse>(_VerifyAdaCardAuthorizationResponse_QNAME, VerifyAdaCardAuthorizationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWeChatCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "updateWeChatCard")
    public JAXBElement<UpdateWeChatCard> createUpdateWeChatCard(UpdateWeChatCard value) {
        return new JAXBElement<UpdateWeChatCard>(_UpdateWeChatCard_QNAME, UpdateWeChatCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientProtocolException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "ClientProtocolException")
    public JAXBElement<ClientProtocolException> createClientProtocolException(ClientProtocolException value) {
        return new JAXBElement<ClientProtocolException>(_ClientProtocolException_QNAME, ClientProtocolException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketDeleteResponse")
    public JAXBElement<MeetingTicketDeleteResponse> createMeetingTicketDeleteResponse(MeetingTicketDeleteResponse value) {
        return new JAXBElement<MeetingTicketDeleteResponse>(_MeetingTicketDeleteResponse_QNAME, MeetingTicketDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketCreated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketCreated")
    public JAXBElement<MeetingTicketCreated> createMeetingTicketCreated(MeetingTicketCreated value) {
        return new JAXBElement<MeetingTicketCreated>(_MeetingTicketCreated_QNAME, MeetingTicketCreated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatOrderPublicQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "wechatOrderPublicQuery")
    public JAXBElement<WechatOrderPublicQuery> createWechatOrderPublicQuery(WechatOrderPublicQuery value) {
        return new JAXBElement<WechatOrderPublicQuery>(_WechatOrderPublicQuery_QNAME, WechatOrderPublicQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatOrderQueryDTOs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "weChatOrderQueryDTOs")
    public JAXBElement<WeChatOrderQueryDTOs> createWeChatOrderQueryDTOs(WeChatOrderQueryDTOs value) {
        return new JAXBElement<WeChatOrderQueryDTOs>(_WeChatOrderQueryDTOs_QNAME, WeChatOrderQueryDTOs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketUpdated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketUpdated")
    public JAXBElement<MeetingTicketUpdated> createMeetingTicketUpdated(MeetingTicketUpdated value) {
        return new JAXBElement<MeetingTicketUpdated>(_MeetingTicketUpdated_QNAME, MeetingTicketUpdated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "weChatCardDTO")
    public JAXBElement<WeChatDTO> createWeChatCardDTO(WeChatDTO value) {
        return new JAXBElement<WeChatDTO>(_WeChatCardDTO_QNAME, WeChatDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatOrderPublicCloser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "wechatOrderPublicCloser")
    public JAXBElement<WechatOrderPublicCloser> createWechatOrderPublicCloser(WechatOrderPublicCloser value) {
        return new JAXBElement<WechatOrderPublicCloser>(_WechatOrderPublicCloser_QNAME, WechatOrderPublicCloser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "ticketNoDTO")
    public JAXBElement<String> createTicketNoDTO(String value) {
        return new JAXBElement<String>(_TicketNoDTO_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWeChatCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "createWeChatCardResponse")
    public JAXBElement<CreateWeChatCardResponse> createCreateWeChatCardResponse(CreateWeChatCardResponse value) {
        return new JAXBElement<CreateWeChatCardResponse>(_CreateWeChatCardResponse_QNAME, CreateWeChatCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityTicketDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "list")
    public JAXBElement<ActivityTicketDTO> createList(ActivityTicketDTO value) {
        return new JAXBElement<ActivityTicketDTO>(_List_QNAME, ActivityTicketDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatOrderPublicCloserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "wechatOrderPublicCloserResponse")
    public JAXBElement<WechatOrderPublicCloserResponse> createWechatOrderPublicCloserResponse(WechatOrderPublicCloserResponse value) {
        return new JAXBElement<WechatOrderPublicCloserResponse>(_WechatOrderPublicCloserResponse_QNAME, WechatOrderPublicCloserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatOrderPublicQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "wechatOrderPublicQueryResponse")
    public JAXBElement<WechatOrderPublicQueryResponse> createWechatOrderPublicQueryResponse(WechatOrderPublicQueryResponse value) {
        return new JAXBElement<WechatOrderPublicQueryResponse>(_WechatOrderPublicQueryResponse_QNAME, WechatOrderPublicQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingCreatedOrUpdated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingCreatedOrUpdated")
    public JAXBElement<MeetingCreatedOrUpdated> createMeetingCreatedOrUpdated(MeetingCreatedOrUpdated value) {
        return new JAXBElement<MeetingCreatedOrUpdated>(_MeetingCreatedOrUpdated_QNAME, MeetingCreatedOrUpdated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWeChatMeetingFlagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "updateWeChatMeetingFlagResponse")
    public JAXBElement<UpdateWeChatMeetingFlagResponse> createUpdateWeChatMeetingFlagResponse(UpdateWeChatMeetingFlagResponse value) {
        return new JAXBElement<UpdateWeChatMeetingFlagResponse>(_UpdateWeChatMeetingFlagResponse_QNAME, UpdateWeChatMeetingFlagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketCreatedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketCreatedResponse")
    public JAXBElement<MeetingTicketCreatedResponse> createMeetingTicketCreatedResponse(MeetingTicketCreatedResponse value) {
        return new JAXBElement<MeetingTicketCreatedResponse>(_MeetingTicketCreatedResponse_QNAME, MeetingTicketCreatedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWeChatCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "updateWeChatCardResponse")
    public JAXBElement<UpdateWeChatCardResponse> createUpdateWeChatCardResponse(UpdateWeChatCardResponse value) {
        return new JAXBElement<UpdateWeChatCardResponse>(_UpdateWeChatCardResponse_QNAME, UpdateWeChatCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatOrderCloserDTOs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "weChatOrderCloserDTOs")
    public JAXBElement<WeChatOrderCloserDTOs> createWeChatOrderCloserDTOs(WeChatOrderCloserDTOs value) {
        return new JAXBElement<WeChatOrderCloserDTOs>(_WeChatOrderCloserDTOs_QNAME, WeChatOrderCloserDTOs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWeChatCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "createWeChatCard")
    public JAXBElement<CreateWeChatCard> createCreateWeChatCard(CreateWeChatCard value) {
        return new JAXBElement<CreateWeChatCard>(_CreateWeChatCard_QNAME, CreateWeChatCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityTicketSimpleDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "simpleList")
    public JAXBElement<ActivityTicketSimpleDTO> createSimpleList(ActivityTicketSimpleDTO value) {
        return new JAXBElement<ActivityTicketSimpleDTO>(_SimpleList_QNAME, ActivityTicketSimpleDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWeChatMeetingFlag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "updateWeChatMeetingFlag")
    public JAXBElement<UpdateWeChatMeetingFlag> createUpdateWeChatMeetingFlag(UpdateWeChatMeetingFlag value) {
        return new JAXBElement<UpdateWeChatMeetingFlag>(_UpdateWeChatMeetingFlag_QNAME, UpdateWeChatMeetingFlag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingTicketDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingTicketDelete")
    public JAXBElement<MeetingTicketDelete> createMeetingTicketDelete(MeetingTicketDelete value) {
        return new JAXBElement<MeetingTicketDelete>(_MeetingTicketDelete_QNAME, MeetingTicketDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityMeetingDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.com", name = "ActivityMeetingDTOs")
    public JAXBElement<ActivityMeetingDTO> createActivityMeetingDTOs(ActivityMeetingDTO value) {
        return new JAXBElement<ActivityMeetingDTO>(_ActivityMeetingDTOs_QNAME, ActivityMeetingDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeetingCreatedOrUpdatedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecard.amway.com/", name = "meetingCreatedOrUpdatedResponse")
    public JAXBElement<MeetingCreatedOrUpdatedResponse> createMeetingCreatedOrUpdatedResponse(MeetingCreatedOrUpdatedResponse value) {
        return new JAXBElement<MeetingCreatedOrUpdatedResponse>(_MeetingCreatedOrUpdatedResponse_QNAME, MeetingCreatedOrUpdatedResponse.class, null, value);
    }

}
