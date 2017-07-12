package cn.sky.framework.util.property;

import java.util.HashMap;

/**
 * <pre>
 * 智能配置文件读取类管理池，通过该管理池获得的配置文件的属性值
 * 可以自动随着配置文件的更改而刷新，不需要重启应用服务。
 * 使用实例：
 * [1]:比如配置文件application.properties在目录src下使用如下方式。
 * <p>
 * 	ConfigFile cfg = ConfigFileFactory.getInstance().get("application");
 * 	String value = cfg.getValue("value");
 * </p>
 * [2]:配置文件boss.properties和类com.maywide.common.SessionUtil在同一目录下，可以使用如下方式
 * <p>
 * 	ConfigFile cfg = ConfigFileFactory.getInstance().get("boss", SessionUtil.class);
 * 	String value = cfg.getValue("value");
 * </p>
 * [3]:配置文件smp.properties在包com.maywide.common.config,则可使用如下方式。
 * <p>
 * ConfigFile cfg = ConfigFileFactory.getInstance().get("smp", "/com/maywide/common/config/");
 * 	String value = cfg.getValue("value");
 * </p>
 * </pre>
 * 
 * @author luoxian
 * @since Jul 10, 2008 8:49:55 AM
 * @version 1.0
 */
public class ConfigFileFactory {
	private static ConfigFileFactory instance = null;
	private final String extendName = ".properties"; // 默认配置文件格式
	private HashMap<String, ConfigFile> hashMap = new HashMap<String, ConfigFile>();

	private ConfigFileFactory() {
	}

	public static synchronized ConfigFileFactory getInstance() {
		if (instance == null) {
			instance = new ConfigFileFactory();
		}
		return instance;
	}

	/**
	 * 该函数表示配置文件在根目录，及在classes目录下
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public ConfigFile get(String fileName) throws Exception {
		ConfigFile file = (ConfigFile) hashMap.get(fileName);
		if (file == null) {
			ConfigFile newFile;
			newFile = new ConfigFile(fileName + extendName);
			hashMap.put(fileName, newFile);
			return newFile;
		}
		return file;
	}

	/**
	 * 该函数表示配置文件和resendClass这个类具有相同的目录
	 * 
	 * @param fileName
	 * @param presentClass
	 * @return
	 * @throws Exception
	 */
	public ConfigFile get(String fileName, Class<?> presentClass)
			throws Exception {
		ConfigFile file = (ConfigFile) hashMap.get(fileName);
		if (file == null) {
			ConfigFile newFile = new ConfigFile(fileName + extendName,
					presentClass);
			hashMap.put(fileName, newFile);
			return newFile;
		}
		return file;
	}

	/**
	 * 该函数读取配置文件，文件目录由参数path指定<br>
	 * 
	 * <pre>
	 * 例如：配置文件config.properties在包com.maywide.common.test包下
	 * 则传入的path参数为  &quot;/com/maywide/common/test/&quot;
	 * </pre>
	 * 
	 * @param fileName
	 * @param packageName
	 * @return
	 * @throws Exception
	 */
	public ConfigFile get(String fileName, String packageName) throws Exception {
		ConfigFile file = (ConfigFile) hashMap.get(fileName);
		if (file == null) {
			ConfigFile newFile = new ConfigFile(fileName + extendName,
					packageName);
			hashMap.put(fileName, newFile);
			return newFile;
		}
		return file;
	}

	public int size() {
		return hashMap.size();

	}
}
