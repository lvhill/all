package cn.sky.base.shop.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户")
public class User {

	@ApiModelProperty(value = "名字")
	private String name;

	@ApiModelProperty(value = "年龄")
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
