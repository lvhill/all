
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
 *         &lt;element name="AdaCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "adaCard"
})
@XmlRootElement(name = "GetAttendinfo")
public class GetAttendinfo {

    @XmlElement(name = "AdaCard")
    protected String adaCard;

    /**
     * Gets the value of the adaCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdaCard() {
        return adaCard;
    }

    /**
     * Sets the value of the adaCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdaCard(String value) {
        this.adaCard = value;
    }

}
