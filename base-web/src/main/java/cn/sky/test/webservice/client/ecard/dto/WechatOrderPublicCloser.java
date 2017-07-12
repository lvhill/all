
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>wechatOrderPublicCloser complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="wechatOrderPublicCloser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}weChatOrderCloserDTOs" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wechatOrderPublicCloser", propOrder = {
    "weChatOrderCloserDTOs"
})
public class WechatOrderPublicCloser {

    @XmlElement(namespace = "http://impl.ws.com")
    protected WeChatOrderCloserDTOs weChatOrderCloserDTOs;

    /**
     * 获取weChatOrderCloserDTOs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WeChatOrderCloserDTOs }
     *     
     */
    public WeChatOrderCloserDTOs getWeChatOrderCloserDTOs() {
        return weChatOrderCloserDTOs;
    }

    /**
     * 设置weChatOrderCloserDTOs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WeChatOrderCloserDTOs }
     *     
     */
    public void setWeChatOrderCloserDTOs(WeChatOrderCloserDTOs value) {
        this.weChatOrderCloserDTOs = value;
    }

}
