package cn.sky.framework.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.sky.framework.util.sequence.Sequence;

public class LogHandlerInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class);
	private ThreadLocal<Long> logId = new ThreadLocal<Long>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logId.set(Sequence.getSequence());
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("logid: ").append(logId.get()).append(", Controller start: ")
				.append(request.getRequestURI());
		logger.info(stringBuffer.toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("logid: ").append(logId.get()).append(", Controller end: ").append(request.getRequestURI());
		logger.info(stringBuffer.toString());
	}

}
