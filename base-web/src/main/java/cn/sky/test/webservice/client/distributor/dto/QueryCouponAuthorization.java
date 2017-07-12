
package cn.sky.test.webservice.client.distributor.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queryCouponAuthorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryCouponAuthorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ejb.facade.pos5g.amway.com/}queryCouponAuthorizationReq" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryCouponAuthorization", propOrder = {
    "arg0"
})
public class QueryCouponAuthorization {

    protected QueryCouponAuthorizationReq arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link QueryCouponAuthorizationReq }
     *     
     */
    public QueryCouponAuthorizationReq getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryCouponAuthorizationReq }
     *     
     */
    public void setArg0(QueryCouponAuthorizationReq value) {
        this.arg0 = value;
    }

}
