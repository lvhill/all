
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ActivityMeetingDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ActivityMeetingDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meetingNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingTimeFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingTimeTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketTimeOfExpiry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityMeetingDTO", propOrder = {
    "meetingNo",
    "meetingId",
    "meetingTimeFrom",
    "meetingTimeTo",
    "meetingName",
    "meetingLocation",
    "ticketTimeOfExpiry"
})
public class ActivityMeetingDTO {

    protected String meetingNo;
    protected String meetingId;
    protected String meetingTimeFrom;
    protected String meetingTimeTo;
    protected String meetingName;
    protected String meetingLocation;
    protected String ticketTimeOfExpiry;

    /**
     * 获取meetingNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingNo() {
        return meetingNo;
    }

    /**
     * 设置meetingNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingNo(String value) {
        this.meetingNo = value;
    }

    /**
     * 获取meetingId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingId() {
        return meetingId;
    }

    /**
     * 设置meetingId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingId(String value) {
        this.meetingId = value;
    }

    /**
     * 获取meetingTimeFrom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingTimeFrom() {
        return meetingTimeFrom;
    }

    /**
     * 设置meetingTimeFrom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingTimeFrom(String value) {
        this.meetingTimeFrom = value;
    }

    /**
     * 获取meetingTimeTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingTimeTo() {
        return meetingTimeTo;
    }

    /**
     * 设置meetingTimeTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingTimeTo(String value) {
        this.meetingTimeTo = value;
    }

    /**
     * 获取meetingName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingName() {
        return meetingName;
    }

    /**
     * 设置meetingName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingName(String value) {
        this.meetingName = value;
    }

    /**
     * 获取meetingLocation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingLocation() {
        return meetingLocation;
    }

    /**
     * 设置meetingLocation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingLocation(String value) {
        this.meetingLocation = value;
    }

    /**
     * 获取ticketTimeOfExpiry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketTimeOfExpiry() {
        return ticketTimeOfExpiry;
    }

    /**
     * 设置ticketTimeOfExpiry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketTimeOfExpiry(String value) {
        this.ticketTimeOfExpiry = value;
    }

}
