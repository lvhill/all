
package cn.sky.test.webservice.client.bizprocess.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for iRenewalApply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iRenewalApply">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bizprocess.facade.service.ebiz.amway.com/}inquiryObject">
 *       &lt;sequence>
 *         &lt;element name="ada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="applyChannel" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="applySuccTs" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="applyTs" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="eformNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeDetails" type="{http://bizprocess.facade.service.ebiz.amway.com/}feeDetailDO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isFreePc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isOverdue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matRecvMeth" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="miscOrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newExpDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newVipExpDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldExpDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldVipExpDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentMeth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posDstTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preMiscOrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rnApplyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="rsv1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rsv2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rsv3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rsv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rsv5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalApplyFee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="updtTs" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iRenewalApply", propOrder = {
    "ada",
    "applyChannel",
    "applySuccTs",
    "applyTs",
    "eformNo",
    "feeDetails",
    "isFreePc",
    "isOverdue",
    "matRecvMeth",
    "miscOrderNo",
    "newExpDt",
    "newVipExpDt",
    "oldExpDt",
    "oldVipExpDt",
    "paymentMeth",
    "posDstTyp",
    "preMiscOrderNo",
    "remark",
    "rnApplyId",
    "rsv1",
    "rsv2",
    "rsv3",
    "rsv4",
    "rsv5",
    "status",
    "totalApplyFee",
    "updtTs"
})
public class IRenewalApply
    extends InquiryObject
{

    protected Long ada;
    protected Long applyChannel;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applySuccTs;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applyTs;
    protected String eformNo;
    @XmlElement(nillable = true)
    protected List<FeeDetailDO> feeDetails;
    protected String isFreePc;
    protected String isOverdue;
    protected Long matRecvMeth;
    protected String miscOrderNo;
    protected String newExpDt;
    protected String newVipExpDt;
    protected String oldExpDt;
    protected String oldVipExpDt;
    protected String paymentMeth;
    protected String posDstTyp;
    protected String preMiscOrderNo;
    protected String remark;
    protected Long rnApplyId;
    protected String rsv1;
    protected String rsv2;
    protected String rsv3;
    protected String rsv4;
    protected String rsv5;
    protected String status;
    protected Double totalApplyFee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updtTs;

    /**
     * Gets the value of the ada property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAda() {
        return ada;
    }

    /**
     * Sets the value of the ada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAda(Long value) {
        this.ada = value;
    }

    /**
     * Gets the value of the applyChannel property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApplyChannel() {
        return applyChannel;
    }

    /**
     * Sets the value of the applyChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApplyChannel(Long value) {
        this.applyChannel = value;
    }

    /**
     * Gets the value of the applySuccTs property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplySuccTs() {
        return applySuccTs;
    }

    /**
     * Sets the value of the applySuccTs property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplySuccTs(XMLGregorianCalendar value) {
        this.applySuccTs = value;
    }

    /**
     * Gets the value of the applyTs property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyTs() {
        return applyTs;
    }

    /**
     * Sets the value of the applyTs property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyTs(XMLGregorianCalendar value) {
        this.applyTs = value;
    }

    /**
     * Gets the value of the eformNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEformNo() {
        return eformNo;
    }

    /**
     * Sets the value of the eformNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEformNo(String value) {
        this.eformNo = value;
    }

    /**
     * Gets the value of the feeDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeDetailDO }
     * 
     * 
     */
    public List<FeeDetailDO> getFeeDetails() {
        if (feeDetails == null) {
            feeDetails = new ArrayList<FeeDetailDO>();
        }
        return this.feeDetails;
    }

    /**
     * Gets the value of the isFreePc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsFreePc() {
        return isFreePc;
    }

    /**
     * Sets the value of the isFreePc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsFreePc(String value) {
        this.isFreePc = value;
    }

    /**
     * Gets the value of the isOverdue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOverdue() {
        return isOverdue;
    }

    /**
     * Sets the value of the isOverdue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOverdue(String value) {
        this.isOverdue = value;
    }

    /**
     * Gets the value of the matRecvMeth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMatRecvMeth() {
        return matRecvMeth;
    }

    /**
     * Sets the value of the matRecvMeth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMatRecvMeth(Long value) {
        this.matRecvMeth = value;
    }

    /**
     * Gets the value of the miscOrderNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiscOrderNo() {
        return miscOrderNo;
    }

    /**
     * Sets the value of the miscOrderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiscOrderNo(String value) {
        this.miscOrderNo = value;
    }

    /**
     * Gets the value of the newExpDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewExpDt() {
        return newExpDt;
    }

    /**
     * Sets the value of the newExpDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewExpDt(String value) {
        this.newExpDt = value;
    }

    /**
     * Gets the value of the newVipExpDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewVipExpDt() {
        return newVipExpDt;
    }

    /**
     * Sets the value of the newVipExpDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewVipExpDt(String value) {
        this.newVipExpDt = value;
    }

    /**
     * Gets the value of the oldExpDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldExpDt() {
        return oldExpDt;
    }

    /**
     * Sets the value of the oldExpDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldExpDt(String value) {
        this.oldExpDt = value;
    }

    /**
     * Gets the value of the oldVipExpDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldVipExpDt() {
        return oldVipExpDt;
    }

    /**
     * Sets the value of the oldVipExpDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldVipExpDt(String value) {
        this.oldVipExpDt = value;
    }

    /**
     * Gets the value of the paymentMeth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMeth() {
        return paymentMeth;
    }

    /**
     * Sets the value of the paymentMeth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMeth(String value) {
        this.paymentMeth = value;
    }

    /**
     * Gets the value of the posDstTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosDstTyp() {
        return posDstTyp;
    }

    /**
     * Sets the value of the posDstTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosDstTyp(String value) {
        this.posDstTyp = value;
    }

    /**
     * Gets the value of the preMiscOrderNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreMiscOrderNo() {
        return preMiscOrderNo;
    }

    /**
     * Sets the value of the preMiscOrderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreMiscOrderNo(String value) {
        this.preMiscOrderNo = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the rnApplyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRnApplyId() {
        return rnApplyId;
    }

    /**
     * Sets the value of the rnApplyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRnApplyId(Long value) {
        this.rnApplyId = value;
    }

    /**
     * Gets the value of the rsv1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsv1() {
        return rsv1;
    }

    /**
     * Sets the value of the rsv1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsv1(String value) {
        this.rsv1 = value;
    }

    /**
     * Gets the value of the rsv2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsv2() {
        return rsv2;
    }

    /**
     * Sets the value of the rsv2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsv2(String value) {
        this.rsv2 = value;
    }

    /**
     * Gets the value of the rsv3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsv3() {
        return rsv3;
    }

    /**
     * Sets the value of the rsv3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsv3(String value) {
        this.rsv3 = value;
    }

    /**
     * Gets the value of the rsv4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsv4() {
        return rsv4;
    }

    /**
     * Sets the value of the rsv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsv4(String value) {
        this.rsv4 = value;
    }

    /**
     * Gets the value of the rsv5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsv5() {
        return rsv5;
    }

    /**
     * Sets the value of the rsv5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsv5(String value) {
        this.rsv5 = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the totalApplyFee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalApplyFee() {
        return totalApplyFee;
    }

    /**
     * Sets the value of the totalApplyFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalApplyFee(Double value) {
        this.totalApplyFee = value;
    }

    /**
     * Gets the value of the updtTs property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdtTs() {
        return updtTs;
    }

    /**
     * Sets the value of the updtTs property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdtTs(XMLGregorianCalendar value) {
        this.updtTs = value;
    }

}
