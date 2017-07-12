package cn.sky.test.webservice.client.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import cn.sky.test.webservice.client.meeting.dto.WsSecurityHeader;

@XmlAccessorType(XmlAccessType.FIELD)
public class HeadOA {

	@XmlElement(name = "WsSecurityHeader")
	private WsSecurityHeader wsSecurityHeader;

	public WsSecurityHeader getWsSecurityHeader() {
		return wsSecurityHeader;
	}

	public void setWsSecurityHeader(WsSecurityHeader wsSecurityHeader) {
		this.wsSecurityHeader = wsSecurityHeader;
	}

}
