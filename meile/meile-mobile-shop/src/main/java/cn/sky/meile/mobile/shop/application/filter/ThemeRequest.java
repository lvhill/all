package cn.sky.meile.mobile.shop.application.filter;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import cn.sky.framework.util.SpringUtil;
import cn.sky.framework.util.property.BaseProperties;
import cn.sky.meile.mobile.shop.config.service.ConfigService;

/**
 * web请求重新封装
 * 
 * @author gaofu
 *
 */
public class ThemeRequest extends HttpServletRequestWrapper {
	private final static Logger logger = LoggerFactory.getLogger(ThemeRequest.class);

	private static String staticDir;
	private static String themesDir;

	private boolean isResource = false;
	private String servletPath;

	static {
		Properties config = BaseProperties.load("static.properties");
		staticDir = config.getProperty("web.static.dir");
		staticDir = StringUtils.isEmpty(staticDir) ? "/static/" : staticDir;
		themesDir = config.getProperty("web.theme.dir");
		themesDir = StringUtils.isEmpty(themesDir) ? "/themes/" : themesDir;
	}

	public ThemeRequest(HttpServletRequest request) {
		super(request);

		String uri = super.getRequestURI();
		StringBuilder regex = new StringBuilder();
		regex.append("([/]$)|([\\.])");// endsWith("/")||contains(".")
		isResource = Pattern.compile(regex.toString()).matcher(uri).find();
		if (isResource) {
			servletPath = replaceResourcePath(new StringBuilder(super.getServletPath()));
		}
	}

	@Override
	public String getServletPath() {
		if (isResource) {
			return servletPath;
		} else {
			return super.getServletPath();
		}
	}

	/**
	 * 静态资源文件主题路径替换
	 * 
	 * @param superServletPath
	 * @return
	 */
	private String replaceResourcePath(StringBuilder superServletPath) {
		if ('/' == superServletPath.charAt(superServletPath.length() - 1)) {// endsWith("/")
			superServletPath.append("index.html");
		}
		StringBuilder result = new StringBuilder();
		if (!isIngoreResource(superServletPath.toString())) {
			String theme;
			try {
				ConfigService configService = SpringUtil.getBean(ConfigService.class);
				theme = configService.queryTheme();
			} catch (Exception e) {
				logger.error("设置主题默认值default", e);
				theme = "default";
			}
			result.append(themesDir).append(theme);
		}
		result.append(superServletPath);
		return result.toString();
	}

	/**
	 * 是否忽略的静态资源文件
	 * 
	 * @param superServletPath
	 * @return
	 */
	private boolean isIngoreResource(String superServletPath) {
		StringBuilder regex = new StringBuilder();
		regex.append("(^(").append(staticDir).append("|/webjars/).*)|(.*swagger.*)");// "|"表示或
		return Pattern.compile(regex.toString()).matcher(superServletPath).find();
	}

}
