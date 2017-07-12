package cn.sky.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Servlet工具类.
 * 
 * @author gaofu
 *
 */
public class ServletUtil {

	/**
	 * 取得HttpSession的简化函数.
	 */
	public static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}

	/**
	 * 取得HttpRequest的简化函数.
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 取得HttpResponse的简化函数.
	 */
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * 取得ServletContext的简化函数.
	 */
	public static ServletContext getServletContext() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession()
				.getServletContext();
	}

	/**
	 * 获得web根目录的物理路径
	 * 
	 * @return rootPath
	 */
	public static String getRootPath() {
		return ClassLoader.getSystemResource("").getPath() + "public";
	}

	/**
	 * 获取 HTTP header
	 * 
	 * @return
	 */
	public static Map<String, String> getHeader() {
		HttpServletRequest request = getRequest();
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * 获取请求报文
	 * 
	 * @return
	 */
	public static String getRequestBody() {
		StringBuilder requestBody = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getRequest().getInputStream(), "utf-8"));
			String line = null;
			while ((line = in.readLine()) != null) {
				requestBody.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestBody.toString();
	}

}
