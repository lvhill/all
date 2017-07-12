package cn.sky.test.webservice.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import cn.sky.test.webservice.HubService;


@WebService(endpointInterface = "cn.sky.test.webservice.HubService", serviceName = "Hub")
@Component
public class HubServiceImpl implements HubService {

	@Override
	public String msg(String msg) {
		return "Hub msg is " + msg;
	}

	@Override
	public String token(String token) {
		return "Hub token is " + token;
	}

	@Override
	public String Lest(String adaNo) {
		return "Hub adaNo is " + adaNo;
	}

}