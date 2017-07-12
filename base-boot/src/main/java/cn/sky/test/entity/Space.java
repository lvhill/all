
package cn.sky.test.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * space complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="space">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="schoole" type="{http://webservice.test.sky.cn/}schoole" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "space", propOrder = { "schoole" })
public class Space {

	protected Schoole schoole;

	/**
	 * 获取schoole属性的值。
	 * 
	 * @return possible object is {@link Schoole }
	 * 
	 */
	public Schoole getSchoole() {
		return schoole;
	}

	/**
	 * 设置schoole属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link Schoole }
	 * 
	 */
	public void setSchoole(Schoole value) {
		this.schoole = value;
	}

}
