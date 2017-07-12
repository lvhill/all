package cn.sky.framework.common.logback;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * logback.xml自定义变量
 * 
 * @author gaofu
 *
 */
public class ClassPath extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
		return this.getClass().getResource("/").getPath();
	}

}
