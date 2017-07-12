
package cn.sky.test.webservice.client.order.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelMiscOrder complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelMiscOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ejb.facade.pos5g.amway.com/}cancelMiscOrderReq" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMiscOrder", propOrder = {
    "arg0"
})
public class CancelMiscOrder {

    protected CancelMiscOrderReq arg0;

    /**
     * 获取arg0属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancelMiscOrderReq }
     *     
     */
    public CancelMiscOrderReq getArg0() {
        return arg0;
    }

    /**
     * 设置arg0属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancelMiscOrderReq }
     *     
     */
    public void setArg0(CancelMiscOrderReq value) {
        this.arg0 = value;
    }

}
