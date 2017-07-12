
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>verifyAdaCardAuthorizationResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="verifyAdaCardAuthorizationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthVerificationResultDTO" type="{http://service.ws.ecard.amway.com/}AuthVerificationResultDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyAdaCardAuthorizationResponse", propOrder = {
    "authVerificationResultDTO"
})
public class VerifyAdaCardAuthorizationResponse {

    @XmlElement(name = "AuthVerificationResultDTO")
    protected AuthVerificationResultDTO authVerificationResultDTO;

    /**
     * 获取authVerificationResultDTO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AuthVerificationResultDTO }
     *     
     */
    public AuthVerificationResultDTO getAuthVerificationResultDTO() {
        return authVerificationResultDTO;
    }

    /**
     * 设置authVerificationResultDTO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AuthVerificationResultDTO }
     *     
     */
    public void setAuthVerificationResultDTO(AuthVerificationResultDTO value) {
        this.authVerificationResultDTO = value;
    }

}
