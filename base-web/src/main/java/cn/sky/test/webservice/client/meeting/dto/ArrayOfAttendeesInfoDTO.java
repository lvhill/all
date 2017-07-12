
package cn.sky.test.webservice.client.meeting.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAttendeesInfoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAttendeesInfoDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AttendeesInfoDTO" type="{http://oa.amway.com/}AttendeesInfoDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAttendeesInfoDTO", propOrder = {
    "attendeesInfoDTO"
})
public class ArrayOfAttendeesInfoDTO {

    @XmlElement(name = "AttendeesInfoDTO", nillable = true)
    protected List<AttendeesInfoDTO> attendeesInfoDTO;

    /**
     * Gets the value of the attendeesInfoDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attendeesInfoDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttendeesInfoDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttendeesInfoDTO }
     * 
     * 
     */
    public List<AttendeesInfoDTO> getAttendeesInfoDTO() {
        if (attendeesInfoDTO == null) {
            attendeesInfoDTO = new ArrayList<AttendeesInfoDTO>();
        }
        return this.attendeesInfoDTO;
    }

}
