
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>wechatOrderPublicQuery complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="wechatOrderPublicQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}weChatOrderQueryDTOs" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wechatOrderPublicQuery", propOrder = {
    "weChatOrderQueryDTOs"
})
public class WechatOrderPublicQuery {

    @XmlElement(namespace = "http://impl.ws.com")
    protected WeChatOrderQueryDTOs weChatOrderQueryDTOs;

    /**
     * 获取weChatOrderQueryDTOs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WeChatOrderQueryDTOs }
     *     
     */
    public WeChatOrderQueryDTOs getWeChatOrderQueryDTOs() {
        return weChatOrderQueryDTOs;
    }

    /**
     * 设置weChatOrderQueryDTOs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WeChatOrderQueryDTOs }
     *     
     */
    public void setWeChatOrderQueryDTOs(WeChatOrderQueryDTOs value) {
        this.weChatOrderQueryDTOs = value;
    }

}
