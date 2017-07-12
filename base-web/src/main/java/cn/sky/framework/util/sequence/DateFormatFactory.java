package cn.sky.framework.util.sequence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * 日期格式工具
 * 
 * @author ligaofu
 *
 */
public class DateFormatFactory {

	static Map<String, SimpleDateFormat> dateFormatCache = new HashMap<String, SimpleDateFormat>();

	public static final String defaultDateFormatPattern = "yyyy-MM-dd HH:mm:ss";

	public static SimpleDateFormat getInstance(String pattern) {
		if (pattern != null && !pattern.isEmpty()) {
			if (dateFormatCache.containsKey(pattern)) {
				return dateFormatCache.get(pattern);
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			dateFormatCache.put(pattern, dateFormat);
			return dateFormat;
		}
		return getDefaultDateFormat();
	}

	public static SimpleDateFormat getDefaultDateFormat() {
		return DateFormatFactory.getInstance(defaultDateFormatPattern);
	}

	/**
	 * 获取日期的yyyy-MM-dd格式
	 */
	public static String getYyyyMMdd(Date date) {
		return getInstance("yyyy-MM-dd").format(date);
	}

	/**
	 * 获取日期的yyyy-MM-dd HH:mm:ss格式
	 */
	public static String getYyyyMMddHHmmss(Date date) {
		return getInstance("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 获取日期的yyyy-MM-dd HH:mm格式
	 */
	public static String getYyyyMMddHHmm(Date date) {
		return getInstance("yyyy-MM-dd HH:mm").format(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM-dd HH:mm)为Date对象
	 */
	public static Date getYyyyMMddHHmm(String date) throws ParseException {
		return getInstance("yyyy-MM-dd HH:mm").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM-dd)为Date对象
	 */
	public static Date getYyyyMMdd(String date) throws ParseException {
		return getInstance("yyyy-MM-dd").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM)为Date对象
	 */
	public static Date getYyyyMM(String date) throws ParseException {
		return getInstance("yyyy-MM").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM-dd)为Date对象
	 */
	public static Date getYyyyMMddCH(String date) throws ParseException {
		return getInstance("yyyy年MM月dd日").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM)为Date对象
	 */
	public static Date getYyyyMMCH(String date) throws ParseException {
		return getInstance("yyyy年MM月").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM-dd)为Date对象
	 */
	public static Date getYyyyMMddHHmmss(String date) throws ParseException {
		return getInstance("yyyy-MM-dd HH:mm:ss").parse(date);
	}

	/**
	 * 转换日期字符串(日期格式yyyy-MM-dd 00:00:01)为Calendar对象
	 */
	public static Calendar strToCalendar(String date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getInstance("yyyy-MM-dd HH:mm:ss").parse(date));
		return cal;
	}

	/**
	 * 转换日期Date(日期格式yyyy-MM-dd 00:00:01)为Calendar对象
	 */
	public static Calendar dateToCalendar(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 转换日期Calender(日期格式yyyy-MM-dd 00:00:01)为String对象
	 */
	public static String calendarToStr(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String dateStr = sdf.format(calendar.getTime());
		return dateStr;
	}
}
