
package cn.sky.test.webservice.client.order.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelMiscOrderFacadeResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelMiscOrderFacadeResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractFacadeResp">
 *       &lt;sequence>
 *         &lt;element name="resp" type="{http://ejb.facade.pos5g.amway.com/}cancelMiscOrderResp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelMiscOrderFacadeResp", propOrder = {
    "resp"
})
public class CancelMiscOrderFacadeResp
    extends AbstractFacadeResp
{

    protected CancelMiscOrderResp resp;

    /**
     * 获取resp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancelMiscOrderResp }
     *     
     */
    public CancelMiscOrderResp getResp() {
        return resp;
    }

    /**
     * 设置resp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancelMiscOrderResp }
     *     
     */
    public void setResp(CancelMiscOrderResp value) {
        this.resp = value;
    }

}
