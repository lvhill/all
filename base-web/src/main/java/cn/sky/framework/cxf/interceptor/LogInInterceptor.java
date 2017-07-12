package cn.sky.framework.cxf.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

import cn.sky.framework.util.ServletUtil;
import cn.sky.framework.util.sequence.Sequence;

/**
 * WebService 请求日志拦截器
 * 
 * @see org.apache.cxf.interceptor.LoggingInInterceptor
 * @author ligaofu
 *
 */
@Component
public class LogInInterceptor extends LoggingInInterceptor {
	protected StringBuilder soapXml;

	public LogInInterceptor() {
		this(Phase.RECEIVE);
	}

	public LogInInterceptor(String phase) {
		super(phase);
		limit = Integer.MAX_VALUE;
	}

	public void handleMessage(Message message) throws Fault {
		super.handleMessage(message);
		message.put(Item.IN_SOAPXML, soapXml);
	}

	@Override
	protected String formatLoggingMessage(LoggingMessage loggingMessage) {
		soapXml = loggingMessage.getPayload();
		String logid = String.valueOf(Sequence.getSequence());
		HttpServletRequest request = ServletUtil.getRequest();
		request.setAttribute(Item.LOG_ID, logid);
		StringBuilder buffer = new StringBuilder();
		buffer.append("logid: ").append(logid).append(", ");
		buffer.append("WebService start: ").append(request.getRequestURI()).append(", ");
		buffer.append("request saop: ").append(soapXml);
		return buffer.toString();
	}

}
