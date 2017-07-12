
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WeChatDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amwayCardNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weChatCardNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatDTO", propOrder = {
    "amwayCardNum",
    "weChatCardNum",
    "verify"
})
public class WeChatDTO {

    protected String amwayCardNum;
    protected String weChatCardNum;
    protected String verify;

    /**
     * 获取amwayCardNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmwayCardNum() {
        return amwayCardNum;
    }

    /**
     * 设置amwayCardNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmwayCardNum(String value) {
        this.amwayCardNum = value;
    }

    /**
     * 获取weChatCardNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeChatCardNum() {
        return weChatCardNum;
    }

    /**
     * 设置weChatCardNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeChatCardNum(String value) {
        this.weChatCardNum = value;
    }

    /**
     * 获取verify属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerify() {
        return verify;
    }

    /**
     * 设置verify属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerify(String value) {
        this.verify = value;
    }

}
