
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ActivityTicketDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ActivityTicketDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adaRegionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adaNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingTimeFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingTimeTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketTimeOfUse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketTimeOfExpiry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seatNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pointsPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isRealName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityTicketDTO", propOrder = {
    "adaRegionNo",
    "adaNo",
    "meetingNo",
    "meetingId",
    "meetingTimeFrom",
    "meetingTimeTo",
    "meetingName",
    "meetingLocation",
    "ticketNo",
    "ticketTimeOfUse",
    "ticketTimeOfExpiry",
    "seatNo",
    "ticketType",
    "ticketPrice",
    "instructions",
    "payType",
    "pointsPrice",
    "isRealName"
})
public class ActivityTicketDTO {

    protected String adaRegionNo;
    protected String adaNo;
    protected String meetingNo;
    protected String meetingId;
    protected String meetingTimeFrom;
    protected String meetingTimeTo;
    protected String meetingName;
    protected String meetingLocation;
    protected String ticketNo;
    protected String ticketTimeOfUse;
    protected String ticketTimeOfExpiry;
    protected String seatNo;
    protected String ticketType;
    protected double ticketPrice;
    protected String instructions;
    protected String payType;
    protected double pointsPrice;
    protected String isRealName;

    /**
     * 获取adaRegionNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdaRegionNo() {
        return adaRegionNo;
    }

    /**
     * 设置adaRegionNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdaRegionNo(String value) {
        this.adaRegionNo = value;
    }

    /**
     * 获取adaNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdaNo() {
        return adaNo;
    }

    /**
     * 设置adaNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdaNo(String value) {
        this.adaNo = value;
    }

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
     * 获取ticketNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNo() {
        return ticketNo;
    }

    /**
     * 设置ticketNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNo(String value) {
        this.ticketNo = value;
    }

    /**
     * 获取ticketTimeOfUse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketTimeOfUse() {
        return ticketTimeOfUse;
    }

    /**
     * 设置ticketTimeOfUse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketTimeOfUse(String value) {
        this.ticketTimeOfUse = value;
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

    /**
     * 获取seatNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatNo() {
        return seatNo;
    }

    /**
     * 设置seatNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatNo(String value) {
        this.seatNo = value;
    }

    /**
     * 获取ticketType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * 设置ticketType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketType(String value) {
        this.ticketType = value;
    }

    /**
     * 获取ticketPrice属性的值。
     * 
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * 设置ticketPrice属性的值。
     * 
     */
    public void setTicketPrice(double value) {
        this.ticketPrice = value;
    }

    /**
     * 获取instructions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * 设置instructions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructions(String value) {
        this.instructions = value;
    }

    /**
     * 获取payType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置payType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayType(String value) {
        this.payType = value;
    }

    /**
     * 获取pointsPrice属性的值。
     * 
     */
    public double getPointsPrice() {
        return pointsPrice;
    }

    /**
     * 设置pointsPrice属性的值。
     * 
     */
    public void setPointsPrice(double value) {
        this.pointsPrice = value;
    }

    /**
     * 获取isRealName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRealName() {
        return isRealName;
    }

    /**
     * 设置isRealName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRealName(String value) {
        this.isRealName = value;
    }

}
