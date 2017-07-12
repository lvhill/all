
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResultDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ResultDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="messageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultDTO", propOrder = {
    "result",
    "messageCode",
    "messageContent",
    "objectID"
})
public class ResultDTO {

    protected int result;
    protected String messageCode;
    protected String messageContent;
    protected String objectID;

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
     * 获取objectID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectID() {
        return objectID;
    }

    /**
     * 设置objectID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectID(String value) {
        this.objectID = value;
    }

}
