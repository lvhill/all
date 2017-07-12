package cn.sky.framework.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.sky.framework.util.ServletUtil;
import cn.sky.framework.util.sequence.Sequence;

@Aspect
@Component
public class AopLogs {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private long logId;

	/**
	 * 对spring mvc 的 controller 设置切点, 每次请求 controller 时触发切面
	 */
	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerPointcut() {
	}

	@Before("controllerPointcut()")
	public void controllerBefore() {
		logId = Sequence.getSequence();
		HttpServletRequest request = ServletUtil.getRequest();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("logid: ").append(logId).append(", Controller start: ").append(request.getRequestURI());
		logger.info(stringBuffer.toString());
	}

	@After("controllerPointcut()")
	public void controllerAfter() {
		HttpServletRequest request = ServletUtil.getRequest();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("logid: ").append(logId).append(", Controller end: ").append(request.getRequestURI());
		logger.info(stringBuffer.toString());
	}

}
