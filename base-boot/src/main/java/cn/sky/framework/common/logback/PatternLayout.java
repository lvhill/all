package cn.sky.framework.common.logback;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ch.qos.logback.classic.spi.ILoggingEvent;
import cn.sky.framework.util.ServletUtil;

/**
 * @see ch.qos.logback.classic.PatternLayout
 * @author ligaofu
 *
 */
public class PatternLayout extends ch.qos.logback.classic.PatternLayout {
	private static SimpleDateFormat dateFormat;

	static {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ");
	}

	protected String writeLoopOnConverters(ILoggingEvent event) {
		String message = super.writeLoopOnConverters(event);
		StringBuilder msg = new StringBuilder();
		msg.append(dateFormat.format(new Date()));
		try {
			HttpServletRequest request = ServletUtil.getRequest();
			Thread current = Thread.currentThread();
			msg.append("[threadId: ").append(current.getId()).append("] ");
			msg.append("[URL: ").append(request.getRequestURL()).append("] ");
			msg.append("[RIP: ").append(request.getRemoteAddr()).append("] ");
			msg.append("[XFF: ").append(request.getHeader("x-forwarded-for")).append("] ");
			msg.append("[PCIP: ").append(request.getHeader("Proxy-Client-IP")).append("] ");
			msg.append("[WPCIP: ").append(request.getHeader("WL-Proxy-Client-IP")).append("] ");
			msg.append("[UA: ").append(request.getHeader("User-Agent")).append("] ");
		} catch (Exception e) {
		}
		msg.append(message);
		return msg.toString();
	}
}
