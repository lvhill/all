
package cn.sky.test.webservice.client.scws.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * district complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="district">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dacreage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longitudeLatitude">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="postcodes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "district", propOrder = { "dacreage", "dname", "longitudeLatitude", "postcodes" })
public class District {

	protected Long dacreage;
	protected String dname;
	@XmlElement(required = true)
	protected District.LongitudeLatitude longitudeLatitude;
	protected Integer postcodes;

	/**
	 * 获取dacreage属性的值。
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getDacreage() {
		return dacreage;
	}

	/**
	 * 设置dacreage属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setDacreage(Long value) {
		this.dacreage = value;
	}

	/**
	 * 获取dname属性的值。
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * 设置dname属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDname(String value) {
		this.dname = value;
	}

	/**
	 * 获取longitudeLatitude属性的值。
	 * 
	 * @return possible object is {@link District.LongitudeLatitude }
	 * 
	 */
	public District.LongitudeLatitude getLongitudeLatitude() {
		return longitudeLatitude;
	}

	/**
	 * 设置longitudeLatitude属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link District.LongitudeLatitude }
	 * 
	 */
	public void setLongitudeLatitude(District.LongitudeLatitude value) {
		this.longitudeLatitude = value;
	}

	/**
	 * 获取postcodes属性的值。
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPostcodes() {
		return postcodes;
	}

	/**
	 * 设置postcodes属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPostcodes(Integer value) {
		this.postcodes = value;
	}

	/**
	 * <p>
	 * anonymous complex type的 Java 类。
	 * 
	 * <p>
	 * 以下模式片段指定包含在此类中的预期内容。
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "entry" })
	public static class LongitudeLatitude {

		protected List<District.LongitudeLatitude.Entry> entry;

		/**
		 * Gets the value of the entry property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the entry property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getEntry().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link District.LongitudeLatitude.Entry }
		 * 
		 * 
		 */
		public List<District.LongitudeLatitude.Entry> getEntry() {
			if (entry == null) {
				entry = new ArrayList<District.LongitudeLatitude.Entry>();
			}
			return this.entry;
		}

		/**
		 * <p>
		 * anonymous complex type的 Java 类。
		 * 
		 * <p>
		 * 以下模式片段指定包含在此类中的预期内容。
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "key", "value" })
		public static class Entry {

			protected String key;
			protected Double value;

			/**
			 * 获取key属性的值。
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getKey() {
				return key;
			}

			/**
			 * 设置key属性的值。
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setKey(String value) {
				this.key = value;
			}

			/**
			 * 获取value属性的值。
			 * 
			 * @return possible object is {@link Double }
			 * 
			 */
			public Double getValue() {
				return value;
			}

			/**
			 * 设置value属性的值。
			 * 
			 * @param value
			 *            allowed object is {@link Double }
			 * 
			 */
			public void setValue(Double value) {
				this.value = value;
			}

		}

	}

}
