package cn.sky.meile.system.authority.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "登录信息")
public class LoginDto {

	@ApiModelProperty(value = "验证码")
	private String verifyCode;

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
