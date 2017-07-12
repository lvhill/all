package cn.sky.framework.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * <p>
 * <b>classPath下的XML文件操作工具类</b>
 * </p>
 * <p>
 * 说明:<br>
 * 要求XML文件的DTD类型必须为:<br>
 * http://java.sun.com/dtd/properties.dtd<br>
 * </p>
 * 提示:<br>
 * 这里的classPath的含义是:<br>
 * 1)当整个网站在运行时,这里的classPath指定的是网站的"/WEB-INF/classes"目录<br>
 * 2)当整个网站并没有启动,而其子模块在单独运行时,这里的classPath指定的是子模块自身的classPath目录
 */
public class XmlProperty {

	/**
	 * 读取XML文件
	 * 
	 * @param fileName
	 *            此文件在classPath下
	 * @return properties
	 */
	public static Properties readPropertiesFromXML(String fileName) {

		Properties properties = new Properties();
		try {
			// classPath
			String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			fileName = classPath + fileName;
			InputStream inputStream = new FileInputStream(fileName);
			properties.loadFromXML(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 将Properties写到XML文件中
	 * 
	 * @param fileName
	 *            此文件在classPath下
	 * @param properties
	 * @param comment
	 *            xml文件说明
	 * @return boolean
	 */
	public static boolean writePropertiesToXML(String fileName, Properties properties, String comment) {

		if (null == properties)
			return false;
		try {
			// classPath
			String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			fileName = classPath + fileName;
			OutputStream outputStream = new FileOutputStream(fileName);
			properties.storeToXML(outputStream, comment);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}
