
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateWeChatCard complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateWeChatCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}weChatCardDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateWeChatCard", propOrder = {
    "weChatCardDTO"
})
public class UpdateWeChatCard {

    @XmlElement(namespace = "http://impl.ws.com")
    protected WeChatDTO weChatCardDTO;

    /**
     * 获取weChatCardDTO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WeChatDTO }
     *     
     */
    public WeChatDTO getWeChatCardDTO() {
        return weChatCardDTO;
    }

    /**
     * 设置weChatCardDTO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WeChatDTO }
     *     
     */
    public void setWeChatCardDTO(WeChatDTO value) {
        this.weChatCardDTO = value;
    }

}
