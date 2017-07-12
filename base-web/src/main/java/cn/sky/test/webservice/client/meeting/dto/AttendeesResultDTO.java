
package cn.sky.test.webservice.client.meeting.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttendeesResultDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttendeesResultDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListData" type="{http://oa.amway.com/}ArrayOfAttendeesInfoDTO" minOccurs="0"/>
 *         &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MessageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttendeesResultDTO", propOrder = {
    "listData",
    "result",
    "messageCode",
    "messageContent"
})
public class AttendeesResultDTO {

    @XmlElement(name = "ListData")
    protected ArrayOfAttendeesInfoDTO listData;
    @XmlElement(name = "Result")
    protected int result;
    @XmlElement(name = "MessageCode")
    protected String messageCode;
    @XmlElement(name = "MessageContent")
    protected String messageContent;

    /**
     * Gets the value of the listData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAttendeesInfoDTO }
     *     
     */
    public ArrayOfAttendeesInfoDTO getListData() {
        return listData;
    }

    /**
     * Sets the value of the listData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAttendeesInfoDTO }
     *     
     */
    public void setListData(ArrayOfAttendeesInfoDTO value) {
        this.listData = value;
    }

    /**
     * Gets the value of the result property.
     * 
     */
    public int getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     */
    public void setResult(int value) {
        this.result = value;
    }

    /**
     * Gets the value of the messageCode property.
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
     * Sets the value of the messageCode property.
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
     * Gets the value of the messageContent property.
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
     * Sets the value of the messageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageContent(String value) {
        this.messageContent = value;
    }

}
