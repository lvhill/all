
package cn.sky.test.webservice.client.bizprocess.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getNewestApplicationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getNewestApplicationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="renewalApply" type="{http://bizprocess.facade.service.ebiz.amway.com/}iRenewalApply" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNewestApplicationResponse", propOrder = {
    "renewalApply"
})
public class GetNewestApplicationResponse {

    protected IRenewalApply renewalApply;

    /**
     * Gets the value of the renewalApply property.
     * 
     * @return
     *     possible object is
     *     {@link IRenewalApply }
     *     
     */
    public IRenewalApply getRenewalApply() {
        return renewalApply;
    }

    /**
     * Sets the value of the renewalApply property.
     * 
     * @param value
     *     allowed object is
     *     {@link IRenewalApply }
     *     
     */
    public void setRenewalApply(IRenewalApply value) {
        this.renewalApply = value;
    }

}
