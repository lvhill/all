package cn.sky.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.soap.SoapEntity;
import cn.sky.test.entity.Head;
import cn.sky.test.entity.Space;

@RestController
@RequestMapping("/thread")
public class ThreadSafeController {
	private static final Logger logger = LoggerFactory.getLogger(ThreadSafeController.class);

	private int varthread = 0;

	private static Map<String, StringBuilder> configMap = new HashMap<String, StringBuilder>();

	@RequestMapping(value = "/safe", method = { RequestMethod.POST, RequestMethod.GET })
	public String safe() {
		Thread t = Thread.currentThread();
		++varthread;
		for (int i = 0; i < 50; ++i) {
			try {
				soapXmlToEntity();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("threadid: " + t.getId() + " , varthread: " + varthread);
		return "sucess";
	}

	@RequestMapping(value = "/safemap", method = { RequestMethod.POST, RequestMethod.GET })
	public int safemap(String key) {
		Thread t = Thread.currentThread();
		if (configMap.containsKey(key)) {
			logger.info("threadid: " + t.getId() + " , hashCode: " + configMap.get(key).hashCode());
			return configMap.get(key).hashCode();
		}

		for (int i = 0; i < 50; ++i) {
			try {
				soapXmlToEntity();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		StringBuilder obj = new StringBuilder(key + "_name");
		configMap.put(key, obj);
		logger.info("threadid: " + t.getId() + " , hashCode: " + configMap.get(key).hashCode());
		return configMap.get(key).hashCode();
	}

	private void soapXmlToEntity() throws Exception {
		String soapxml = "<?xml version='1.0' encoding='UTF-8' ?><soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:tns='http://webservice.test.sky.cn/'><soapenv:Header><osbappid>ebiz</osbappid><osbappkey>ebizkey</osbappkey></soapenv:Header><soapenv:Body><soapenv:Fault><faultcode>soap:Client</faultcode><faultstring>Error reading XMLStreamReader: Undeclared namespace prefix 'nyxt' at [row,col {unknown-source}]: [9,14]</faultstring></soapenv:Fault><tns:space><schoole><name>广东金融大学</name><students><achievement><entry><key>计算机原理</key><value>良</value></entry><entry><key>C语言编程基础</key><value>优</value></entry><entry><key>java Web开发</key><value>优</value></entry></achievement><grades>大四</grades><name>高甫</name><teacher>董燕玲</teacher><teacher>吴匡威</teacher></students><students><achievement><entry><key>市场原理</key><value>良</value></entry><entry><key>商场基础</key><value>优</value></entry></achievement><grades>大六</grades><name>王孔</name><teacher>王珂</teacher><teacher>洛克</teacher></students></schoole></tns:space></soapenv:Body></soapenv:Envelope>";
		SoapEntity<Head, Space> soapEntity = new SoapEntity<Head, Space>(Head.class, Space.class);
		soapEntity.init(soapxml);
		soapEntity.init(soapEntity.soapXml());
		soapEntity.soapXml();

	}

}
