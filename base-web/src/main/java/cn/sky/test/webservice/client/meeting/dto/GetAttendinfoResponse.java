
package cn.sky.test.webservice.client.meeting.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAttendinfoResult" type="{http://oa.amway.com/}AttendeesResultDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getAttendinfoResult"
})
@XmlRootElement(name = "GetAttendinfoResponse")
public class GetAttendinfoResponse {

    @XmlElement(name = "GetAttendinfoResult")
    protected AttendeesResultDTO getAttendinfoResult;

    /**
     * Gets the value of the getAttendinfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link AttendeesResultDTO }
     *     
     */
    public AttendeesResultDTO getGetAttendinfoResult() {
        return getAttendinfoResult;
    }

    /**
     * Sets the value of the getAttendinfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttendeesResultDTO }
     *     
     */
    public void setGetAttendinfoResult(AttendeesResultDTO value) {
        this.getAttendinfoResult = value;
    }

}
