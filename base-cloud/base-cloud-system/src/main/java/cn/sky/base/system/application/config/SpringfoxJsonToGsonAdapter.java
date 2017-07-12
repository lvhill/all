package cn.sky.base.system.application.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import springfox.documentation.spring.web.json.Json;

/**
 * Gson适配器
 * 
 * @author gaofu
 *
 */
public class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {

	@Override
	public JsonElement serialize(Json json, Type type, JsonSerializationContext context) {
		final JsonParser parser = new JsonParser();
		return parser.parse(json.value());
	}
}