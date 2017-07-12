package cn.sky.test.webservice;

import org.springframework.stereotype.Component;

import cn.sky.framework.cxf.WebServiceAuthorize;

@Component
public class WebServiceAccessAuthorize implements WebServiceAuthorize {

	@Override
	public boolean authorize(String soapXml) {
		return true;
	}

}
