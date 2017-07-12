
package cn.sky.test.webservice.client.ecard.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AuthVerificationResultDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AuthVerificationResultDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authVerificationResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="authorizationFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amplusPointFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizerAdaRegionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizerAdaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizedPersonAdaRegionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizedPersonAdaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiryTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthVerificationResultDTO", propOrder = {
    "authVerificationResult",
    "authorizationFlag",
    "amplusPointFlag",
    "authorizerAdaRegionNo",
    "authorizerAdaNumber",
    "authorizedPersonAdaRegionNo",
    "authorizedPersonAdaNumber",
    "recordId",
    "expiryTime",
    "errorCode",
    "errorMessage"
})
public class AuthVerificationResultDTO {

    protected int authVerificationResult;
    protected String authorizationFlag;
    protected String amplusPointFlag;
    protected String authorizerAdaRegionNo;
    protected String authorizerAdaNumber;
    protected String authorizedPersonAdaRegionNo;
    protected String authorizedPersonAdaNumber;
    protected String recordId;
    protected String expiryTime;
    protected String errorCode;
    protected String errorMessage;

    /**
     * 获取authVerificationResult属性的值。
     * 
     */
    public int getAuthVerificationResult() {
        return authVerificationResult;
    }

    /**
     * 设置authVerificationResult属性的值。
     * 
     */
    public void setAuthVerificationResult(int value) {
        this.authVerificationResult = value;
    }

    /**
     * 获取authorizationFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationFlag() {
        return authorizationFlag;
    }

    /**
     * 设置authorizationFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationFlag(String value) {
        this.authorizationFlag = value;
    }

    /**
     * 获取amplusPointFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmplusPointFlag() {
        return amplusPointFlag;
    }

    /**
     * 设置amplusPointFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmplusPointFlag(String value) {
        this.amplusPointFlag = value;
    }

    /**
     * 获取authorizerAdaRegionNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizerAdaRegionNo() {
        return authorizerAdaRegionNo;
    }

    /**
     * 设置authorizerAdaRegionNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizerAdaRegionNo(String value) {
        this.authorizerAdaRegionNo = value;
    }

    /**
     * 获取authorizerAdaNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizerAdaNumber() {
        return authorizerAdaNumber;
    }

    /**
     * 设置authorizerAdaNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizerAdaNumber(String value) {
        this.authorizerAdaNumber = value;
    }

    /**
     * 获取authorizedPersonAdaRegionNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedPersonAdaRegionNo() {
        return authorizedPersonAdaRegionNo;
    }

    /**
     * 设置authorizedPersonAdaRegionNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedPersonAdaRegionNo(String value) {
        this.authorizedPersonAdaRegionNo = value;
    }

    /**
     * 获取authorizedPersonAdaNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedPersonAdaNumber() {
        return authorizedPersonAdaNumber;
    }

    /**
     * 设置authorizedPersonAdaNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedPersonAdaNumber(String value) {
        this.authorizedPersonAdaNumber = value;
    }

    /**
     * 获取recordId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * 设置recordId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordId(String value) {
        this.recordId = value;
    }

    /**
     * 获取expiryTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryTime() {
        return expiryTime;
    }

    /**
     * 设置expiryTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryTime(String value) {
        this.expiryTime = value;
    }

    /**
     * 获取errorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置errorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * 获取errorMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 设置errorMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
