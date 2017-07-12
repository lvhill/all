
package cn.sky.test.webservice.client.hub.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.sky.test.webservice.client.hub.dto package. 
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

    private final static QName _LestResponse_QNAME = new QName("http://webservice.test.sky.cn/", "LestResponse");
    private final static QName _Msg_QNAME = new QName("http://webservice.test.sky.cn/", "msg");
    private final static QName _TokenResponse_QNAME = new QName("http://webservice.test.sky.cn/", "tokenResponse");
    private final static QName _MsgResponse_QNAME = new QName("http://webservice.test.sky.cn/", "msgResponse");
    private final static QName _Token_QNAME = new QName("http://webservice.test.sky.cn/", "token");
    private final static QName _Lest_QNAME = new QName("http://webservice.test.sky.cn/", "Lest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.sky.test.webservice.client.hub.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Msg }
     * 
     */
    public Msg createMsg() {
        return new Msg();
    }

    /**
     * Create an instance of {@link LestResponse }
     * 
     */
    public LestResponse createLestResponse() {
        return new LestResponse();
    }

    /**
     * Create an instance of {@link TokenResponse }
     * 
     */
    public TokenResponse createTokenResponse() {
        return new TokenResponse();
    }

    /**
     * Create an instance of {@link MsgResponse }
     * 
     */
    public MsgResponse createMsgResponse() {
        return new MsgResponse();
    }

    /**
     * Create an instance of {@link Lest }
     * 
     */
    public Lest createLest() {
        return new Lest();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "LestResponse")
    public JAXBElement<LestResponse> createLestResponse(LestResponse value) {
        return new JAXBElement<LestResponse>(_LestResponse_QNAME, LestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Msg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "msg")
    public JAXBElement<Msg> createMsg(Msg value) {
        return new JAXBElement<Msg>(_Msg_QNAME, Msg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "tokenResponse")
    public JAXBElement<TokenResponse> createTokenResponse(TokenResponse value) {
        return new JAXBElement<TokenResponse>(_TokenResponse_QNAME, TokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MsgResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "msgResponse")
    public JAXBElement<MsgResponse> createMsgResponse(MsgResponse value) {
        return new JAXBElement<MsgResponse>(_MsgResponse_QNAME, MsgResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Token }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "token")
    public JAXBElement<Token> createToken(Token value) {
        return new JAXBElement<Token>(_Token_QNAME, Token.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "Lest")
    public JAXBElement<Lest> createLest(Lest value) {
        return new JAXBElement<Lest>(_Lest_QNAME, Lest.class, null, value);
    }

}
