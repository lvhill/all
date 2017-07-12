package cn.sky.meile.system.application.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 * 
 * @author gaofu
 *
 */
public class CommonFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		ThemeRequest themeRequest = new ThemeRequest(httpRequest);
		chain.doFilter(themeRequest, response);
	}

	@Override
	public void destroy() {
	}

}
