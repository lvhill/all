
package cn.sky.test.webservice.client.order.dto;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelMiscOrderResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelMiscOrderResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractResp">
 *       &lt;sequence>
 *         &lt;element name="cancelFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="miscCreatedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="miscOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMiscOrderResp", propOrder = {
    "cancelFlag",
    "miscCreatedDate",
    "miscOrderNumber",
    "refundAmount",
    "status"
})
public class CancelMiscOrderResp
    extends AbstractResp
{

    protected String cancelFlag;
    protected String miscCreatedDate;
    protected String miscOrderNumber;
    protected BigDecimal refundAmount;
    protected String status;

    /**
     * 获取cancelFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelFlag() {
        return cancelFlag;
    }

    /**
     * 设置cancelFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelFlag(String value) {
        this.cancelFlag = value;
    }

    /**
     * 获取miscCreatedDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiscCreatedDate() {
        return miscCreatedDate;
    }

    /**
     * 设置miscCreatedDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiscCreatedDate(String value) {
        this.miscCreatedDate = value;
    }

    /**
     * 获取miscOrderNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiscOrderNumber() {
        return miscOrderNumber;
    }

    /**
     * 设置miscOrderNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiscOrderNumber(String value) {
        this.miscOrderNumber = value;
    }

    /**
     * 获取refundAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置refundAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

    /**
     * 获取status属性的值。
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
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
