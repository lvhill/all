
package cn.sky.test.webservice.client.distributor.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queryCouponAuthorizationReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryCouponAuthorizationReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractReq">
 *       &lt;sequence>
 *         &lt;element name="authorizeDp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizeToAda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distributorNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryCouponAuthorizationReq", propOrder = {
    "authorizeDp",
    "authorizeToAda",
    "distributorNumber"
})
public class QueryCouponAuthorizationReq
    extends AbstractReq
{

    protected String authorizeDp;
    protected Long authorizeToAda;
    protected Long distributorNumber;

    /**
     * Gets the value of the authorizeDp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizeDp() {
        return authorizeDp;
    }

    /**
     * Sets the value of the authorizeDp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizeDp(String value) {
        this.authorizeDp = value;
    }

    /**
     * Gets the value of the authorizeToAda property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAuthorizeToAda() {
        return authorizeToAda;
    }

    /**
     * Sets the value of the authorizeToAda property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAuthorizeToAda(Long value) {
        this.authorizeToAda = value;
    }

    /**
     * Gets the value of the distributorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDistributorNumber() {
        return distributorNumber;
    }

    /**
     * Sets the value of the distributorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDistributorNumber(Long value) {
        this.distributorNumber = value;
    }

}
