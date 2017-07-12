
package cn.sky.test.webservice.client.order.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelMiscOrderResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelMiscOrderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ejb.facade.pos5g.amway.com/}cancelMiscOrderFacadeResp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMiscOrderResponse", propOrder = {
    "_return"
})
public class CancelMiscOrderResponse {

    @XmlElement(name = "return")
    protected CancelMiscOrderFacadeResp _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancelMiscOrderFacadeResp }
     *     
     */
    public CancelMiscOrderFacadeResp getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancelMiscOrderFacadeResp }
     *     
     */
    public void setReturn(CancelMiscOrderFacadeResp value) {
        this._return = value;
    }

}
