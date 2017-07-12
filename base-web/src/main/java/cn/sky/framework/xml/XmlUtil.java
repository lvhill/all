package cn.sky.framework.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlUtil {

	private static Map<String, JAXBContext> jaxbContextMap = new HashMap<String, JAXBContext>();

	/**
	 * xml转换为bean
	 * 
	 * @param xml
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	public static <T> T xmlToBean(String xml, Class<T> clazz) throws JAXBException, XMLStreamException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new StringReader(xml));
		JAXBContext jaxbContext = getJAXBContext(clazz);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<T> jaxbElement = unmarshaller.unmarshal(reader, clazz);
		return jaxbElement.getValue();
	}

	/**
	 * bean转换为xml
	 * 
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static String beanToXml(Object obj) throws JAXBException {
		String className = obj.getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
		className = Character.toLowerCase(className.charAt(0)) + className.substring(1);
		QName qname = new QName(className);
		return beanToXml(qname, obj);
	}

	/**
	 * bean转换为xml
	 * 
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static String beanToXml(QName qname, Object obj) throws JAXBException {
		StringWriter stringWriter = new StringWriter();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JAXBElement jaxbElement = new JAXBElement(qname, obj.getClass(), obj);
		JAXBContext jaxbContext = getJAXBContext(obj.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(jaxbElement, stringWriter);
		return stringWriter.toString();
	}

	private static JAXBContext getJAXBContext(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = null;
		if (!jaxbContextMap.containsKey(clazz.getName())) {
			jaxbContext = JAXBContext.newInstance(clazz);
			jaxbContextMap.put(clazz.getName(), jaxbContext);
		} else {
			jaxbContext = jaxbContextMap.get(clazz.getName());
		}
		return jaxbContext;
	}

}
