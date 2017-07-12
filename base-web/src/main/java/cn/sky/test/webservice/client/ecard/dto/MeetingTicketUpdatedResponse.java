
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>meetingTicketUpdatedResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="meetingTicketUpdatedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultDTO" type="{http://service.ws.ecard.amway.com/}ResultDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meetingTicketUpdatedResponse", propOrder = {
    "resultDTO"
})
public class MeetingTicketUpdatedResponse {

    @XmlElement(name = "ResultDTO")
    protected ResultDTO resultDTO;

    /**
     * 获取resultDTO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResultDTO }
     *     
     */
    public ResultDTO getResultDTO() {
        return resultDTO;
    }

    /**
     * 设置resultDTO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDTO }
     *     
     */
    public void setResultDTO(ResultDTO value) {
        this.resultDTO = value;
    }

}
