package cn.sky.base.shop.test.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "City", description = "城市")
public class City {

	@ApiModelProperty(value = "城市名称")
	private String name;

	@ApiModelProperty(value = "编码")
	private Long acreage;

	@ApiModelProperty(value = "区县")
	private List<District> districts;

	@ApiModelProperty(value = "经纬度")
	private Map<String, Double> longitudeLatitude;

	public static City getCity() {
		City gz = new City();
		gz.setName("广州市");
		gz.setAcreage((long) 87650);
		Map<String, Double> longitudeLatitude = new HashMap<String, Double>();
		longitudeLatitude.put("longitude", (double) 18.5);
		longitudeLatitude.put("latitude", (double) 64.1);
		gz.setLongitudeLatitude(longitudeLatitude);

		List<District> districts = new ArrayList<District>();
		District hz = new District();
		hz.setDname("海珠区");
		hz.setPostcodes(510000);
		hz.setDacreage((long) 18765);
		Map<String, Double> hzl = new HashMap<String, Double>();
		hzl.put("longitude", (double) 17.5);
		hzl.put("latitude", (double) 63.4);
		hz.setLongitudeLatitude(hzl);
		districts.add(hz);

		District py = new District();
		py.setDname("海珠区");
		py.setPostcodes(510000);
		py.setDacreage((long) 18765);
		Map<String, Double> pyl = new HashMap<String, Double>();
		pyl.put("longitude", (double) 18.1);
		pyl.put("latitude", (double) 65.1);
		py.setLongitudeLatitude(pyl);
		districts.add(py);
		gz.setDistricts(districts);
		return gz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Map<String, Double> getLongitudeLatitude() {
		return longitudeLatitude;
	}

	public void setLongitudeLatitude(Map<String, Double> longitudeLatitude) {
		this.longitudeLatitude = longitudeLatitude;
	}

}
