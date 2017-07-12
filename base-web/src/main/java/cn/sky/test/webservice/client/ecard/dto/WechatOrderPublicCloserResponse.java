
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>wechatOrderPublicCloserResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="wechatOrderPublicCloserResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WechatOrderQueryResultDTO" type="{http://service.ws.ecard.amway.com/}WechatOrderQueryResultDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wechatOrderPublicCloserResponse", propOrder = {
    "wechatOrderQueryResultDTO"
})
public class WechatOrderPublicCloserResponse {

    @XmlElement(name = "WechatOrderQueryResultDTO")
    protected WechatOrderQueryResultDTO wechatOrderQueryResultDTO;

    /**
     * 获取wechatOrderQueryResultDTO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WechatOrderQueryResultDTO }
     *     
     */
    public WechatOrderQueryResultDTO getWechatOrderQueryResultDTO() {
        return wechatOrderQueryResultDTO;
    }

    /**
     * 设置wechatOrderQueryResultDTO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WechatOrderQueryResultDTO }
     *     
     */
    public void setWechatOrderQueryResultDTO(WechatOrderQueryResultDTO value) {
        this.wechatOrderQueryResultDTO = value;
    }

}
