
package cn.sky.test.webservice.client.scws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * spaceResponse complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="spaceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="space" type="{http://webservice.test.sky.cn/}city" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spaceResponse", propOrder = { "space" })
public class SpaceResponse {

	protected City space;

	/**
	 * 获取space属性的值。
	 * 
	 * @return possible object is {@link City }
	 * 
	 */
	public City getSpace() {
		return space;
	}

	/**
	 * 设置space属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link City }
	 * 
	 */
	public void setSpace(City value) {
		this.space = value;
	}

}
