package cn.sky.test.webservice.client.entity;

import java.util.Map;

public class District {

	private String dname;
	private Long dacreage;
	private Integer postcodes;
	private Map<String, Double> longitudeLatitude;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Long getDacreage() {
		return dacreage;
	}

	public void setDacreage(Long dacreage) {
		this.dacreage = dacreage;
	}

	public Integer getPostcodes() {
		return postcodes;
	}

	public void setPostcodes(Integer postcodes) {
		this.postcodes = postcodes;
	}

	public Map<String, Double> getLongitudeLatitude() {
		return longitudeLatitude;
	}

	public void setLongitudeLatitude(Map<String, Double> longitudeLatitude) {
		this.longitudeLatitude = longitudeLatitude;
	}
}
