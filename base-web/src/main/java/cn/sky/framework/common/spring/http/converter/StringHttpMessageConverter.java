package cn.sky.framework.common.spring.http.converter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.StreamUtils;

/**
 * spring mvc @ResponseBody utf-8
 * 
 * @see org.springframework.http.converter.StringHttpMessageConverter
 * @author gaofu
 *
 */
public class StringHttpMessageConverter extends
		AbstractHttpMessageConverter<String> {
	public static final Charset DEFAULT_CHARSET = Charset.forName("utf-8");

	private final List<Charset> availableCharsets;

	private boolean writeAcceptCharset = true;

	public StringHttpMessageConverter() {
		this(DEFAULT_CHARSET);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StringHttpMessageConverter(Charset defaultCharset) {
		super(defaultCharset, new MediaType[] { MediaType.TEXT_PLAIN,
				MediaType.ALL });
		availableCharsets = new ArrayList(Charset.availableCharsets().values());
	}

	public void setWriteAcceptCharset(boolean writeAcceptCharset) {
		this.writeAcceptCharset = writeAcceptCharset;
	}

	public boolean supports(Class<?> clazz) {
		return String.class == clazz;
	}

	protected String readInternal(Class<? extends String> clazz,
			HttpInputMessage inputMessage) throws IOException {
		Charset charset = getContentTypeCharset(inputMessage.getHeaders()
				.getContentType());
		return StreamUtils.copyToString(inputMessage.getBody(), charset);
	}

	protected Long getContentLength(String str, MediaType contentType) {
		Charset charset = getContentTypeCharset(contentType);
		try {
			return Long.valueOf(str.getBytes(charset.name()).length);
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException(ex);
		}
	}

	protected void writeInternal(String str, HttpOutputMessage outputMessage)
			throws IOException {
		if (writeAcceptCharset) {
			outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		}
		Charset charset = getContentTypeCharset(outputMessage.getHeaders()
				.getContentType());
		StreamUtils.copy(str, charset, outputMessage.getBody());
	}

	protected List<Charset> getAcceptedCharsets() {
		return availableCharsets;
	}

	private Charset getContentTypeCharset(MediaType contentType) {
		if ((contentType != null) && (contentType.getCharset() != null)) {
			return contentType.getCharset();
		}
		return getDefaultCharset();
	}
}
