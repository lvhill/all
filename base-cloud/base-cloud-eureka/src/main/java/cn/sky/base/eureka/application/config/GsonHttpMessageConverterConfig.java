package cn.sky.base.eureka.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import springfox.documentation.spring.web.json.Json;

/**
 * Gson消息转换器
 * 
 * @author gaofu
 *
 */
@Configuration
public class GsonHttpMessageConverterConfig {

	@Bean
	public GsonHttpMessageConverter gsonHttpMessageConverter() {
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		converter.setGson(gson());
		return converter;
	}

	private Gson gson() {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter());
		return builder.create();
	}
}