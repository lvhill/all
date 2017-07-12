package cn.sky.base.shop.test.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "District", description = "区县")
public class District {

	@ApiModelProperty(value = "区县名称")
	private String dname;

	@ApiModelProperty(value = "区县编码")
	private Long dacreage;

	@ApiModelProperty(value = "区县邮编")
	private Integer postcodes;

	@ApiModelProperty(value = "经纬度")
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
