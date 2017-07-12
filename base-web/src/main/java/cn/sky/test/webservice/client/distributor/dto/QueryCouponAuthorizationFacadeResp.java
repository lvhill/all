
package cn.sky.test.webservice.client.distributor.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queryCouponAuthorizationFacadeResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryCouponAuthorizationFacadeResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractFacadeResp">
 *       &lt;sequence>
 *         &lt;element name="resps" type="{http://ejb.facade.pos5g.amway.com/}queryCouponAuthorizationResp" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryCouponAuthorizationFacadeResp", propOrder = {
    "resps"
})
public class QueryCouponAuthorizationFacadeResp
    extends AbstractFacadeResp
{

    @XmlElement(nillable = true)
    protected List<QueryCouponAuthorizationResp> resps;

    /**
     * Gets the value of the resps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryCouponAuthorizationResp }
     * 
     * 
     */
    public List<QueryCouponAuthorizationResp> getResps() {
        if (resps == null) {
            resps = new ArrayList<QueryCouponAuthorizationResp>();
        }
        return this.resps;
    }

}
