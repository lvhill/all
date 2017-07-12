
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateWeChatMeetingFlag complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateWeChatMeetingFlag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}ticketNoDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateWeChatMeetingFlag", propOrder = {
    "ticketNoDTO"
})
public class UpdateWeChatMeetingFlag {

    @XmlElement(namespace = "http://impl.ws.com")
    protected String ticketNoDTO;

    /**
     * 获取ticketNoDTO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNoDTO() {
        return ticketNoDTO;
    }

    /**
     * 设置ticketNoDTO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNoDTO(String value) {
        this.ticketNoDTO = value;
    }

}
