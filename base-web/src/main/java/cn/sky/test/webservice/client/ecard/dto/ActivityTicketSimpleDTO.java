
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ActivityTicketSimpleDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ActivityTicketSimpleDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adaNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meetingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDelete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityTicketSimpleDTO", propOrder = {
    "adaNo",
    "meetingId",
    "ticketNo",
    "isDelete"
})
public class ActivityTicketSimpleDTO {

    protected String adaNo;
    protected String meetingId;
    protected String ticketNo;
    protected String isDelete;

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
     * 获取isDelete属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置isDelete属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDelete(String value) {
        this.isDelete = value;
    }

}
