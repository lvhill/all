
package cn.sky.test.webservice.client.order.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelMiscOrderReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelMiscOrderReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractReq">
 *       &lt;sequence>
 *         &lt;element name="miscOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMiscOrderReq", propOrder = {
    "miscOrderNumber",
    "payDate"
})
public class CancelMiscOrderReq
    extends AbstractReq
{

    protected String miscOrderNumber;
    protected String payDate;

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
     * 获取payDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayDate() {
        return payDate;
    }

    /**
     * 设置payDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayDate(String value) {
        this.payDate = value;
    }

}
