package cn.sky.framework.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Rest消息")
public class RestMessage<T> {

	@ApiModelProperty(value = "渠道")
	protected String channel;

	@ApiModelProperty(value = "令牌")
	protected String token;

	@ApiModelProperty(value = "消息主体")
	protected T entity;

	@ApiModelProperty(value = "是否成功响应")
	protected boolean success = false;

	@ApiModelProperty(value = "异常编码")
	protected String faultcode;

	@ApiModelProperty(value = "异常消息")
	protected String faultstring;

	public RestMessage() {
	}

	public RestMessage(T entity) {
		this.entity = entity;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFaultcode() {
		return faultcode;
	}

	public void setFaultcode(String faultcode) {
		this.faultcode = faultcode;
	}

	public String getFaultstring() {
		return faultstring;
	}

	public void setFaultstring(String faultstring) {
		this.faultstring = faultstring;
	}

}
