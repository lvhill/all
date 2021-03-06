
package cn.sky.test.webservice.client.scws.dto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ScWs", targetNamespace = "http://webservice.test.sky.cn/")
@XmlSeeAlso({ ObjectFactory.class })
public interface ScWs {

	/**
	 * 
	 * @param usrId
	 * @return returns java.lang.String
	 * @throws Exception_Exception
	 */
	@WebMethod
	@WebResult(name = "info", targetNamespace = "")
	@RequestWrapper(localName = "info", targetNamespace = "http://webservice.test.sky.cn/", className = "cn.sky.test.webservice.client.scws.dto.Info")
	@ResponseWrapper(localName = "infoResponse", targetNamespace = "http://webservice.test.sky.cn/", className = "cn.sky.test.webservice.client.scws.dto.InfoResponse")
	public String info(@WebParam(name = "usrId", targetNamespace = "") String usrId) throws Exception_Exception;

	/**
	 * 
	 * @param schoole
	 * @return returns cn.sky.test.webservice.client.scws.dto.City
	 */
	@WebMethod
	@WebResult(name = "space", targetNamespace = "")
	@RequestWrapper(localName = "space", targetNamespace = "http://webservice.test.sky.cn/", className = "cn.sky.test.webservice.client.scws.dto.Space")
	@ResponseWrapper(localName = "spaceResponse", targetNamespace = "http://webservice.test.sky.cn/", className = "cn.sky.test.webservice.client.scws.dto.SpaceResponse")
	public City space(@WebParam(name = "schoole", targetNamespace = "") Schoole schoole);

}
