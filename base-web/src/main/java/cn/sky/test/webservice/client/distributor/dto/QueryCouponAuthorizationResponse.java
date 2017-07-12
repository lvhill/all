
package cn.sky.test.webservice.client.distributor.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queryCouponAuthorizationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryCouponAuthorizationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ejb.facade.pos5g.amway.com/}queryCouponAuthorizationFacadeResp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryCouponAuthorizationResponse", propOrder = {
    "_return"
})
public class QueryCouponAuthorizationResponse {

    @XmlElement(name = "return")
    protected QueryCouponAuthorizationFacadeResp _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link QueryCouponAuthorizationFacadeResp }
     *     
     */
    public QueryCouponAuthorizationFacadeResp getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryCouponAuthorizationFacadeResp }
     *     
     */
    public void setReturn(QueryCouponAuthorizationFacadeResp value) {
        this._return = value;
    }

}
