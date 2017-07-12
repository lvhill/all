
package cn.sky.test.webservice.client.distributor.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paginationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paginationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemNumberCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pageNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageRowNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paginationInfo", propOrder = {
    "itemNumberCount",
    "pageNo",
    "pageRowNum",
    "recordCount"
})
public class PaginationInfo {

    protected long itemNumberCount;
    protected int pageNo;
    protected int pageRowNum;
    protected int recordCount;

    /**
     * Gets the value of the itemNumberCount property.
     * 
     */
    public long getItemNumberCount() {
        return itemNumberCount;
    }

    /**
     * Sets the value of the itemNumberCount property.
     * 
     */
    public void setItemNumberCount(long value) {
        this.itemNumberCount = value;
    }

    /**
     * Gets the value of the pageNo property.
     * 
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * Sets the value of the pageNo property.
     * 
     */
    public void setPageNo(int value) {
        this.pageNo = value;
    }

    /**
     * Gets the value of the pageRowNum property.
     * 
     */
    public int getPageRowNum() {
        return pageRowNum;
    }

    /**
     * Sets the value of the pageRowNum property.
     * 
     */
    public void setPageRowNum(int value) {
        this.pageRowNum = value;
    }

    /**
     * Gets the value of the recordCount property.
     * 
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     */
    public void setRecordCount(int value) {
        this.recordCount = value;
    }

}
