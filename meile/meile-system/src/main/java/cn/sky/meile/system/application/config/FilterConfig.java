package cn.sky.meile.system.application.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.sky.meile.system.application.filter.CommonFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CommonFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

}
