
package cn.sky.test.webservice.client.distributor.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for abstractFacadeResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="abstractFacadeResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ejb.facade.pos5g.amway.com/}abstractResp">
 *       &lt;sequence>
 *         &lt;element name="errorParams" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paginationInfo" type="{http://ejb.facade.pos5g.amway.com/}paginationInfo" minOccurs="0"/>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractFacadeResp", propOrder = {
    "errorParams",
    "paginationInfo",
    "resultCode"
})
public abstract class AbstractFacadeResp
    extends AbstractResp
{

    @XmlElement(nillable = true)
    protected List<String> errorParams;
    protected PaginationInfo paginationInfo;
    protected String resultCode;

    /**
     * Gets the value of the errorParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getErrorParams() {
        if (errorParams == null) {
            errorParams = new ArrayList<String>();
        }
        return this.errorParams;
    }

    /**
     * Gets the value of the paginationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationInfo }
     *     
     */
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    /**
     * Sets the value of the paginationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationInfo }
     *     
     */
    public void setPaginationInfo(PaginationInfo value) {
        this.paginationInfo = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

}
