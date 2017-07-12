
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WechatOrderQueryResultDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WechatOrderQueryResultDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="messageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalfee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attach" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tradestate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="banktype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="issubscribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="succ" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="timeend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WechatOrderQueryResultDTO", propOrder = {
    "result",
    "messageCode",
    "messageContent",
    "totalfee",
    "attach",
    "tradestate",
    "banktype",
    "issubscribe",
    "transid",
    "succ",
    "timeend"
})
public class WechatOrderQueryResultDTO {

    protected int result;
    protected String messageCode;
    protected String messageContent;
    protected String totalfee;
    protected String attach;
    protected String tradestate;
    protected String banktype;
    protected String issubscribe;
    protected String transid;
    protected boolean succ;
    protected String timeend;

    /**
     * 获取result属性的值。
     * 
     */
    public int getResult() {
        return result;
    }

    /**
     * 设置result属性的值。
     * 
     */
    public void setResult(int value) {
        this.result = value;
    }

    /**
     * 获取messageCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * 设置messageCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCode(String value) {
        this.messageCode = value;
    }

    /**
     * 获取messageContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 设置messageContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageContent(String value) {
        this.messageContent = value;
    }

    /**
     * 获取totalfee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalfee() {
        return totalfee;
    }

    /**
     * 设置totalfee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalfee(String value) {
        this.totalfee = value;
    }

    /**
     * 获取attach属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttach() {
        return attach;
    }

    /**
     * 设置attach属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttach(String value) {
        this.attach = value;
    }

    /**
     * 获取tradestate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradestate() {
        return tradestate;
    }

    /**
     * 设置tradestate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradestate(String value) {
        this.tradestate = value;
    }

    /**
     * 获取banktype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanktype() {
        return banktype;
    }

    /**
     * 设置banktype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanktype(String value) {
        this.banktype = value;
    }

    /**
     * 获取issubscribe属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssubscribe() {
        return issubscribe;
    }

    /**
     * 设置issubscribe属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssubscribe(String value) {
        this.issubscribe = value;
    }

    /**
     * 获取transid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransid() {
        return transid;
    }

    /**
     * 设置transid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransid(String value) {
        this.transid = value;
    }

    /**
     * 获取succ属性的值。
     * 
     */
    public boolean isSucc() {
        return succ;
    }

    /**
     * 设置succ属性的值。
     * 
     */
    public void setSucc(boolean value) {
        this.succ = value;
    }

    /**
     * 获取timeend属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeend() {
        return timeend;
    }

    /**
     * 设置timeend属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeend(String value) {
        this.timeend = value;
    }

}
