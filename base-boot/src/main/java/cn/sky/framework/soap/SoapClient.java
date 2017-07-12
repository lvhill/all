package cn.sky.framework.soap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * soap 客户端
 * 
 * @author gaofu
 *
 */
public class SoapClient {
	private static Logger logger = LoggerFactory.getLogger(SoapClient.class);

	/**
	 * 发送soap请求, 并封装响应内容
	 * 
	 * @param wsdlUrl
	 *            请求Webservice地址(?wsdl)
	 * @param request
	 *            请求内容
	 * @param response
	 *            响应内容
	 * @throws Exception
	 */
	public static <QH, QB, PH, PB> void execute(String wsdlUrl, SoapEntity<QH, QB> request, SoapEntity<PH, PB> response)
			throws Exception {
		logger.info("发送地址: " + wsdlUrl);
		String xml = request.soapXml();
		logger.info("发送内容: " + xml);
		String responseXml = httpExecute(wsdlUrl, xml);
		responseXml = responseXml.replaceAll("[\\t\\n\\r]", "");
		logger.info("接收内容: " + responseXml);
		//
		try {
			response.init(responseXml);
			// 判断是否有错误消息
			if (response.getFault() == null) {
				logger.info("接口正常! ");
			} else {
				SoapFault fault = response.getFault();
				StringBuffer err = new StringBuffer();
				err.append("接口错误: ");
				err.append(fault.getFaultcodeInfo());
				err.append(": {'faultcode' : '");
				err.append(fault.getFaultcode());
				err.append("', 'faultstring' : '");
				err.append(fault.getFaultstring());
				err.append("'}");
				logger.info(err.toString());
			}
		} catch (Exception e) {
			logger.error("接口异常! ", e);
		}
	}

	/**
	 * 发送webservice请求
	 * 
	 * @param url
	 *            请求Webservice地址(?wsdl)
	 * @param xml
	 *            请求 Webservice内容(soap xml)
	 * @return
	 */
	public static String httpExecute(String url, String xml) {
		String responseXml = "";
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			StringEntity requestEntity = new StringEntity(xml, "UTF-8");
			httpPost.setEntity(requestEntity);
			httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
			// 配置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000)
					.build();
			httpPost.setConfig(requestConfig);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();
			responseXml = EntityUtils.toString(responseEntity);
		} catch (Exception e) {
			httpPost.abort();
			logger.error("HttpClients request error", e);
		} finally {
			try {
				httpPost.releaseConnection();
			} catch (Exception e) {
				logger.error("httpPost releaseConnection fail", e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				logger.error("httpClient close error", e);
			}
		}
		return responseXml;
	}

}
