
package cn.sky.test.webservice.client.order.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>paginationInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取itemNumberCount属性的值。
     * 
     */
    public long getItemNumberCount() {
        return itemNumberCount;
    }

    /**
     * 设置itemNumberCount属性的值。
     * 
     */
    public void setItemNumberCount(long value) {
        this.itemNumberCount = value;
    }

    /**
     * 获取pageNo属性的值。
     * 
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置pageNo属性的值。
     * 
     */
    public void setPageNo(int value) {
        this.pageNo = value;
    }

    /**
     * 获取pageRowNum属性的值。
     * 
     */
    public int getPageRowNum() {
        return pageRowNum;
    }

    /**
     * 设置pageRowNum属性的值。
     * 
     */
    public void setPageRowNum(int value) {
        this.pageRowNum = value;
    }

    /**
     * 获取recordCount属性的值。
     * 
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * 设置recordCount属性的值。
     * 
     */
    public void setRecordCount(int value) {
        this.recordCount = value;
    }

}
