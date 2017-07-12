package cn.sky.meile.mobile.shop.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.sky.framework.log.LogHandlerInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogHandlerInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
