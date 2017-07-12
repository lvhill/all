package cn.sky.framework.cxf.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

import cn.sky.framework.util.ServletUtil;

/**
 * WebService 请求日志拦截器
 * 
 * @see org.apache.cxf.interceptor.LoggingOutInterceptor
 * @author ligaofu
 *
 */
@Component
public class LogOutInterceptor extends LoggingOutInterceptor {
	protected StringBuilder soapXml;

	public LogOutInterceptor() {
		this(Phase.PRE_STREAM);
	}

	public LogOutInterceptor(String phase) {
		super(phase);
		limit = Integer.MAX_VALUE;
	}

	public void handleMessage(Message message) throws Fault {
		super.handleMessage(message);
		message.put(Item.OUT_SOAPXML, soapXml);
	}

	@Override
	protected String formatLoggingMessage(LoggingMessage loggingMessage) {
		soapXml = loggingMessage.getPayload();
		HttpServletRequest request = ServletUtil.getRequest();
		String logid = (String) request.getAttribute(Item.LOG_ID);
		StringBuilder buffer = new StringBuilder();
		buffer.append("logid: ").append(logid).append(", ");
		buffer.append("WebService end: ").append(request.getRequestURI()).append(", ");
		buffer.append("response saop: ").append(soapXml);
		return buffer.toString();
	}

}
