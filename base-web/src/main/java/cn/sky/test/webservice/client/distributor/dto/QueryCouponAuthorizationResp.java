
package cn.sky.test.webservice.client.distributor.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queryCouponAuthorizationResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryCouponAuthorizationResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractResp">
 *       &lt;sequence>
 *         &lt;element name="authDP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="couponType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distributorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distributorNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distributorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remainDP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="shopCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryCouponAuthorizationResp", propOrder = {
    "authDP",
    "couponType",
    "distributorName",
    "distributorNumber",
    "distributorType",
    "endDate",
    "remainDP",
    "shopCode",
    "startDate"
})
public class QueryCouponAuthorizationResp
    extends AbstractResp
{

    protected BigDecimal authDP;
    @XmlElement(nillable = true)
    protected List<String> couponType;
    protected String distributorName;
    protected Long distributorNumber;
    protected String distributorType;
    protected String endDate;
    protected BigDecimal remainDP;
    protected String shopCode;
    protected String startDate;

    /**
     * Gets the value of the authDP property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAuthDP() {
        return authDP;
    }

    /**
     * Sets the value of the authDP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAuthDP(BigDecimal value) {
        this.authDP = value;
    }

    /**
     * Gets the value of the couponType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the couponType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCouponType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCouponType() {
        if (couponType == null) {
            couponType = new ArrayList<String>();
        }
        return this.couponType;
    }

    /**
     * Gets the value of the distributorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributorName() {
        return distributorName;
    }

    /**
     * Sets the value of the distributorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributorName(String value) {
        this.distributorName = value;
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

    /**
     * Gets the value of the distributorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributorType() {
        return distributorType;
    }

    /**
     * Sets the value of the distributorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributorType(String value) {
        this.distributorType = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the remainDP property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRemainDP() {
        return remainDP;
    }

    /**
     * Sets the value of the remainDP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRemainDP(BigDecimal value) {
        this.remainDP = value;
    }

    /**
     * Gets the value of the shopCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * Sets the value of the shopCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopCode(String value) {
        this.shopCode = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

}
