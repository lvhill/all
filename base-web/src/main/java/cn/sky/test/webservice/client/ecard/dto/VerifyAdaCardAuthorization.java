
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>verifyAdaCardAuthorization complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="verifyAdaCardAuthorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://impl.ws.com}args" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyAdaCardAuthorization", propOrder = {
    "args"
})
public class VerifyAdaCardAuthorization {

    @XmlElement(namespace = "http://impl.ws.com")
    protected QRCodeDTO args;

    /**
     * 获取args属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QRCodeDTO }
     *     
     */
    public QRCodeDTO getArgs() {
        return args;
    }

    /**
     * 设置args属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QRCodeDTO }
     *     
     */
    public void setArgs(QRCodeDTO value) {
        this.args = value;
    }

}
