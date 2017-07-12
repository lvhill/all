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
public class LogFileName extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
		String logFileName = null;
		try {
			ConfigFile configFile = ConfigFileFactory.getInstance().get(
					"common");
			if (configFile != null) {
				logFileName = configFile.getValue("logFileName");
				if (logFileName == null || logFileName.length() == 0
						|| logFileName.equalsIgnoreCase("default")) {
					logFileName = getNameByClassPath();
				}
			} else {
				logFileName = getNameByClassPath();
			}
		} catch (Exception e) {
			logFileName = getNameByClassPath();
		}
		return logFileName;
	}

	private String getNameByClassPath() {
		String logFileName = this.getClass().getResource("/").getPath();
		int index = logFileName.indexOf("/WEB-INF");
		int last = 0;
		if (index != -1) {
			logFileName = logFileName.substring(0, index);
			last = logFileName.lastIndexOf("/") + 1;
			logFileName = logFileName.substring(last);
		} else {
			index = logFileName.indexOf("/target");
			if (index != -1) {
				logFileName = logFileName.substring(0, index);
				last = logFileName.lastIndexOf("/") + 1;
				logFileName = logFileName.substring(last);
			} else {
				index = logFileName.indexOf("/classes");
				if (index != -1) {
					logFileName = logFileName.substring(0, index);
					last = logFileName.lastIndexOf("/") + 1;
					logFileName = logFileName.substring(last);
				}
			}
		}
		return logFileName;
	}

}
