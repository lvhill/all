package cn.sky.test.webservice;

import cn.sky.test.webservice.client.entity.WdVo;

public class Authorize {
	private String appId;
	private String appkey;
	private WdVo wdvo;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public WdVo getWdvo() {
		return wdvo;
	}

	public void setWdvo(WdVo wdvo) {
		this.wdvo = wdvo;
	}

}
