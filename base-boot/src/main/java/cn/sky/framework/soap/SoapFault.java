package cn.sky.framework.soap;

public class SoapFault {

	private String faultcode;
	private String faultstring;
	private String faultactor;
	private String detail;

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

	public String getFaultactor() {
		return faultactor;
	}

	public void setFaultactor(String faultactor) {
		this.faultactor = faultactor;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFaultcodeInfo() {
		return getFaultcodeInfo(faultcode);
	}

	public String getFaultcodeInfo(String faultcode) {
		if (faultcode == null) {
			return null;
		}
		if (faultcode.contains("Client")) {
			return "客户端错误";
		}
		if (faultcode.contains("Server")) {
			return "服务端错误";
		}
		if (faultcode.contains("VersionMismatch")) {
			return "SOAP Envelope 元素命名空间无效";
		}
		if (faultcode.contains("MustUnderstand")) {
			return "Header 元素的一个直接子元素（带有设置为 \"1\" 的 mustUnderstand 属性）无法被理解";
		}
		return null;
	}

}
