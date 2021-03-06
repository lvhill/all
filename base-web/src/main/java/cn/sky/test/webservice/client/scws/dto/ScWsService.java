
package cn.sky.test.webservice.client.scws.dto;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ScWsService", targetNamespace = "http://webservice.test.sky.cn/", wsdlLocation = "http://localhost:9090/base-web/ws/ScWs?wsdl")
public class ScWsService extends Service {

	private final static URL SCWSSERVICE_WSDL_LOCATION;
	private final static WebServiceException SCWSSERVICE_EXCEPTION;
	private final static QName SCWSSERVICE_QNAME = new QName("http://webservice.test.sky.cn/", "ScWsService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL("http://localhost:9090/base-web/ws/ScWs?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		SCWSSERVICE_WSDL_LOCATION = url;
		SCWSSERVICE_EXCEPTION = e;
	}

	public ScWsService() {
		super(__getWsdlLocation(), SCWSSERVICE_QNAME);
	}

	public ScWsService(WebServiceFeature... features) {
		super(__getWsdlLocation(), SCWSSERVICE_QNAME, features);
	}

	public ScWsService(URL wsdlLocation) {
		super(wsdlLocation, SCWSSERVICE_QNAME);
	}

	public ScWsService(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, SCWSSERVICE_QNAME, features);
	}

	public ScWsService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public ScWsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns ScWs
	 */
	@WebEndpoint(name = "ScWsPort")
	public ScWs getScWsPort() {
		return super.getPort(new QName("http://webservice.test.sky.cn/", "ScWsPort"), ScWs.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns ScWs
	 */
	@WebEndpoint(name = "ScWsPort")
	public ScWs getScWsPort(WebServiceFeature... features) {
		return super.getPort(new QName("http://webservice.test.sky.cn/", "ScWsPort"), ScWs.class, features);
	}

	private static URL __getWsdlLocation() {
		if (SCWSSERVICE_EXCEPTION != null) {
			throw SCWSSERVICE_EXCEPTION;
		}
		return SCWSSERVICE_WSDL_LOCATION;
	}

}
