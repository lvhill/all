package cn.sky.framework.soap;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.xml.bind.annotation.XmlNsForm;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import cn.sky.framework.xml.XmlUtil;

/**
 * soap 实体类
 * 
 * @author gaofu
 *
 * @param <HeadClass>
 * @param <BodyClass>
 */
public class SoapEntity<HeadClass, BodyClass> {
	private static Logger logger = LoggerFactory.getLogger(SoapEntity.class);

	/** soap头部类 */
	private Class<HeadClass> headClass;
	/** soap头部bean */
	private HeadClass head;
	/** soap主体类 */
	private Class<BodyClass> bodyClass;
	/** soap主体bean */
	private BodyClass body;
	/** soap错误消息 */
	private SoapFault fault;

	public SoapEntity(Class<HeadClass> headClass, Class<BodyClass> bodyClass) {
		this.headClass = headClass;
		this.bodyClass = bodyClass;
	}

	/**
	 * 通过 soap Xml 初始化
	 * 
	 * @param soapXml
	 * @throws Exception
	 */
	public void init(String soapXml) throws Exception {
		Document document = DocumentHelper.parseText(soapXml);
		Element root = document.getRootElement();
		//
		Element headEle = root.element("Header");
		if (headEle != null) {
			this.head = XmlUtil.xmlToBean(headEle.asXML(), headClass);
		}
		//
		Element body = root.element("Body");
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) body.elements();
		for (Element bodyChild : elements) {
			if (bodyChild != null) {
				if ("Fault".equals(bodyChild.getName())) {
					this.fault = XmlUtil.xmlToBean(bodyChild.asXML(), SoapFault.class);
				} else {
					this.body = XmlUtil.xmlToBean(bodyChild.asXML(), bodyClass);
				}
			}
		}
	}

	/**
	 * 获得 soap xml
	 * 
	 * @return
	 * @throws Exception
	 */
	public String soapXml() throws Exception {
		javax.xml.bind.annotation.XmlSchema xmlSchema = packageInfo();
		if (xmlSchema == null) {
			StringBuffer error = new StringBuffer();
			error.append(bodyClass.getPackage().getName());
			error.append(".package-info.class not found! ");
			logger.error(error.toString());
			throw new Exception(error.toString());
		}
		String nameSpaceUrl = xmlSchema.namespace();
		Namespace soapNs = new Namespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
		Namespace tns = new Namespace("tns", nameSpaceUrl);
		//
		Element root = DocumentHelper.createElement("Envelope");
		root.setQName(new QName("Envelope", soapNs));
		root.add(tns);
		//
		if (this.head != null) {
			javax.xml.namespace.QName qname = new javax.xml.namespace.QName("Header");
			String headXml = XmlUtil.beanToXml(qname, this.head);
			Document headDoc = DocumentHelper.parseText(headXml);
			Element headRoot = headDoc.getRootElement();
			headRoot.setQName(new QName("Header", soapNs));
			//
			if (XmlNsForm.QUALIFIED.equals(xmlSchema.elementFormDefault())) {
				@SuppressWarnings("unchecked")
				List<Element> elements = (List<Element>) headRoot.elements();
				for (Element ele : elements) {
					ele.setQName(new QName(ele.getName(), tns));
				}
			}
			//
			root.add(headRoot);
		}
		//
		Element bodyEle = DocumentHelper.createElement("Body");
		bodyEle.setQName(new QName("Body", soapNs));
		if (this.body != null) {
			String operateName = xmlNodeName(bodyClass);
			javax.xml.namespace.QName qname = new javax.xml.namespace.QName(operateName);
			String bodyXml = XmlUtil.beanToXml(qname, this.body);
			Document bodyDoc = DocumentHelper.parseText(bodyXml);
			Element bodyRoot = bodyDoc.getRootElement();
			bodyRoot.setQName(new QName(operateName, tns));
			bodyEle.add(bodyRoot);
		}
		if (this.fault != null) {
			javax.xml.namespace.QName qname = new javax.xml.namespace.QName("Fault");
			String faultXml = XmlUtil.beanToXml(qname, this.fault);
			Document faultDoc = DocumentHelper.parseText(faultXml);
			Element faultRoot = faultDoc.getRootElement();
			faultRoot.setQName(new QName("Fault", soapNs));
			bodyEle.add(faultRoot);
		}
		root.add(bodyEle);
		Document doucment = DocumentHelper.createDocument(root);
		return doucment.asXML().replaceAll("[\\t\\n\\r]", "");
	}

	/**
	 * 读取 package-info 信息
	 */
	private javax.xml.bind.annotation.XmlSchema packageInfo() {
		javax.xml.bind.annotation.XmlSchema xmlSchema = null;
		Package pkg = bodyClass.getPackage();
		for (Annotation annotation : pkg.getAnnotations()) {
			if (annotation instanceof javax.xml.bind.annotation.XmlSchema) {
				xmlSchema = (javax.xml.bind.annotation.XmlSchema) annotation;
				break;
			}
		}
		return xmlSchema;
	}

	/**
	 * 获取xml节点的名称
	 * 
	 * @param clazz
	 * @return
	 */
	private String xmlNodeName(Class<?> clazz) {
		String xmlNodeName = null;
		for (Annotation annotation : clazz.getAnnotations()) {
			if (annotation instanceof javax.xml.bind.annotation.XmlRootElement) {
				javax.xml.bind.annotation.XmlRootElement xmlRoot = (javax.xml.bind.annotation.XmlRootElement) annotation;
				if (!StringUtils.isEmpty(xmlRoot.name())) {
					xmlNodeName = xmlRoot.name();
					break;
				}
			}
			if (annotation instanceof javax.xml.bind.annotation.XmlType) {
				javax.xml.bind.annotation.XmlType xmlType = (javax.xml.bind.annotation.XmlType) annotation;
				if (!StringUtils.isEmpty(xmlType.name())) {
					xmlNodeName = xmlType.name();
					break;
				}
			}
		}
		return xmlNodeName;
	}

	public Class<HeadClass> getHeadClass() {
		return headClass;
	}

	public void setHeadClass(Class<HeadClass> headClass) {
		this.headClass = headClass;
	}

	public HeadClass getHead() {
		return head;
	}

	public void setHead(HeadClass head) {
		this.head = head;
	}

	public Class<BodyClass> getBodyClass() {
		return bodyClass;
	}

	public void setBodyClass(Class<BodyClass> bodyClass) {
		this.bodyClass = bodyClass;
	}

	public BodyClass getBody() {
		return body;
	}

	public void setBody(BodyClass body) {
		this.body = body;
	}

	public SoapFault getFault() {
		return fault;
	}

	public void setFault(SoapFault fault) {
		this.fault = fault;
	}

}
