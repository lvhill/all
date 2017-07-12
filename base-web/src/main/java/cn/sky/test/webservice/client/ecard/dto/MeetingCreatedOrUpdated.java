
package cn.sky.test.webservice.client.ecard.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>meetingCreatedOrUpdated complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="meetingCreatedOrUpdated">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}ActivityMeetingDTOs" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meetingCreatedOrUpdated", propOrder = {
    "activityMeetingDTOs"
})
public class MeetingCreatedOrUpdated {

    @XmlElement(name = "ActivityMeetingDTOs", namespace = "http://impl.ws.com")
    protected List<ActivityMeetingDTO> activityMeetingDTOs;

    /**
     * Gets the value of the activityMeetingDTOs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityMeetingDTOs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityMeetingDTOs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityMeetingDTO }
     * 
     * 
     */
    public List<ActivityMeetingDTO> getActivityMeetingDTOs() {
        if (activityMeetingDTOs == null) {
            activityMeetingDTOs = new ArrayList<ActivityMeetingDTO>();
        }
        return this.activityMeetingDTOs;
    }

}
