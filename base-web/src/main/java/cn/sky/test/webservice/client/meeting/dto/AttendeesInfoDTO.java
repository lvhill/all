
package cn.sky.test.webservice.client.meeting.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttendeesInfoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttendeesInfoDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdaNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Female" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LevelPosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LevelPositionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShopName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShopCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalPerson" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttendeesInfoDTO", propOrder = {
    "adaNum",
    "adaName",
    "female",
    "levelPosition",
    "levelPositionCode",
    "areaName",
    "areaCode",
    "province",
    "provinceCode",
    "city",
    "cityCode",
    "shopName",
    "shopCode",
    "telphone",
    "legalPerson"
})
public class AttendeesInfoDTO {

    @XmlElement(name = "AdaNum")
    protected String adaNum;
    @XmlElement(name = "AdaName")
    protected String adaName;
    @XmlElement(name = "Female")
    protected String female;
    @XmlElement(name = "LevelPosition")
    protected String levelPosition;
    @XmlElement(name = "LevelPositionCode")
    protected String levelPositionCode;
    @XmlElement(name = "AreaName")
    protected String areaName;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "Province")
    protected String province;
    @XmlElement(name = "ProvinceCode")
    protected String provinceCode;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "CityCode")
    protected String cityCode;
    @XmlElement(name = "ShopName")
    protected String shopName;
    @XmlElement(name = "ShopCode")
    protected String shopCode;
    @XmlElement(name = "Telphone")
    protected String telphone;
    @XmlElement(name = "LegalPerson")
    protected int legalPerson;

    /**
     * Gets the value of the adaNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdaNum() {
        return adaNum;
    }

    /**
     * Sets the value of the adaNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdaNum(String value) {
        this.adaNum = value;
    }

    /**
     * Gets the value of the adaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdaName() {
        return adaName;
    }

    /**
     * Sets the value of the adaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdaName(String value) {
        this.adaName = value;
    }

    /**
     * Gets the value of the female property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFemale() {
        return female;
    }

    /**
     * Sets the value of the female property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFemale(String value) {
        this.female = value;
    }

    /**
     * Gets the value of the levelPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelPosition() {
        return levelPosition;
    }

    /**
     * Sets the value of the levelPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelPosition(String value) {
        this.levelPosition = value;
    }

    /**
     * Gets the value of the levelPositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelPositionCode() {
        return levelPositionCode;
    }

    /**
     * Sets the value of the levelPositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelPositionCode(String value) {
        this.levelPositionCode = value;
    }

    /**
     * Gets the value of the areaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets the value of the areaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

    /**
     * Gets the value of the areaCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the value of the areaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCode(String value) {
        this.areaCode = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * Gets the value of the provinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * Sets the value of the provinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceCode(String value) {
        this.provinceCode = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the cityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Sets the value of the cityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityCode(String value) {
        this.cityCode = value;
    }

    /**
     * Gets the value of the shopName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Sets the value of the shopName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopName(String value) {
        this.shopName = value;
    }

    /**
     * Gets the value of the shopCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * Sets the value of the shopCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopCode(String value) {
        this.shopCode = value;
    }

    /**
     * Gets the value of the telphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * Sets the value of the telphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelphone(String value) {
        this.telphone = value;
    }

    /**
     * Gets the value of the legalPerson property.
     * 
     */
    public int getLegalPerson() {
        return legalPerson;
    }

    /**
     * Sets the value of the legalPerson property.
     * 
     */
    public void setLegalPerson(int value) {
        this.legalPerson = value;
    }

}
