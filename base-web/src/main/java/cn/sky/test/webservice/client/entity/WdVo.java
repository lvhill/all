package cn.sky.test.webservice.client.entity;

import java.util.List;
import java.util.Map;

public class WdVo {
	private Long acreage;
	private List<District> districts;
	private Map<String, TwVo> tws;

	public Long getAcreage() {
		return acreage;
	}

	public void setAcreage(Long acreage) {
		this.acreage = acreage;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public Map<String, TwVo> getTws() {
		return tws;
	}

	public void setTws(Map<String, TwVo> tws) {
		this.tws = tws;
	}
}
