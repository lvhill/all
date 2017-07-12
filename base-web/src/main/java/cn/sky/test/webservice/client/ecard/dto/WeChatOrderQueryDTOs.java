
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WeChatOrderQueryDTOs complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatOrderQueryDTOs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outtradenum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatOrderQueryDTOs", propOrder = {
    "outtradenum",
    "transid"
})
public class WeChatOrderQueryDTOs {

    protected String outtradenum;
    protected String transid;

    /**
     * 获取outtradenum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOuttradenum() {
        return outtradenum;
    }

    /**
     * 设置outtradenum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOuttradenum(String value) {
        this.outtradenum = value;
    }

    /**
     * 获取transid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransid() {
        return transid;
    }

    /**
     * 设置transid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransid(String value) {
        this.transid = value;
    }

}
