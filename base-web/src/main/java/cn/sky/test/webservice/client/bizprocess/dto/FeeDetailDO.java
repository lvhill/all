
package cn.sky.test.webservice.client.bizprocess.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for feeDetailDO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="feeDetailDO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bizId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="feeCde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeTyp" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feeDetailDO", propOrder = {
    "bizId",
    "fee",
    "feeCde",
    "feeClass",
    "feeName",
    "feeTyp",
    "quantity"
})
public class FeeDetailDO {

    protected Long bizId;
    protected Double fee;
    protected String feeCde;
    protected String feeClass;
    protected String feeName;
    protected Long feeTyp;
    protected Long quantity;

    /**
     * Gets the value of the bizId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * Sets the value of the bizId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBizId(Long value) {
        this.bizId = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFee(Double value) {
        this.fee = value;
    }

    /**
     * Gets the value of the feeCde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeCde() {
        return feeCde;
    }

    /**
     * Sets the value of the feeCde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCde(String value) {
        this.feeCde = value;
    }

    /**
     * Gets the value of the feeClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeClass() {
        return feeClass;
    }

    /**
     * Sets the value of the feeClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeClass(String value) {
        this.feeClass = value;
    }

    /**
     * Gets the value of the feeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeName() {
        return feeName;
    }

    /**
     * Sets the value of the feeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeName(String value) {
        this.feeName = value;
    }

    /**
     * Gets the value of the feeTyp property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeeTyp() {
        return feeTyp;
    }

    /**
     * Sets the value of the feeTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeeTyp(Long value) {
        this.feeTyp = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQuantity(Long value) {
        this.quantity = value;
    }

}
