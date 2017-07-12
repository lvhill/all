package cn.sky.framework.common.logback;

import cn.sky.framework.util.property.ConfigFile;
import cn.sky.framework.util.property.ConfigFileFactory;
import ch.qos.logback.core.PropertyDefinerBase;

/**
 * logback.xml自定义变量
 * 
 * @author gaofu
 *
 */
public class LogFilePath extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
		String logFilePath = null;
		try {
			ConfigFile configFile = ConfigFileFactory.getInstance().get(
					"common");
			if (configFile != null) {
				logFilePath = configFile.getValue("logFilePath");
				if (logFilePath == null || logFilePath.length() == 0
						|| logFilePath.equalsIgnoreCase("default")) {
					logFilePath = getClassLoadPath();
				}
			} else {
				logFilePath = getClassLoadPath();
			}
		} catch (Exception e) {
			logFilePath = getClassLoadPath();
		}
		return logFilePath;
	}

	private String getClassLoadPath() {
		String classLoadPath = this.getClass().getResource("/").getPath();
		int index = classLoadPath.indexOf("/WEB-INF");
		if (index != -1) {
			classLoadPath = classLoadPath.substring(0, index);
		} else {
			String target = "/target";
			index = classLoadPath.indexOf(target) + target.length();
			if (index != -1) {
				classLoadPath = classLoadPath.substring(0, index);
			} else {
				index = classLoadPath.indexOf("/classes");
				if (index != -1) {
					classLoadPath = classLoadPath.substring(0, index);
				}
			}
		}
		return classLoadPath.replace("file:/", "");
	}

}
