package cn.sky.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sky.framework.util.property.BaseProperties;

/**
 * 主题工具类
 * 
 * @author gaofu
 *
 */
public class ThemeUtil {
	private static final Logger logger = LoggerFactory.getLogger(ThemeUtil.class);
	private static String themePath = BaseProperties.load("static.properties").getProperty("web.theme.dir");

	/***
	 * 获取当前主题文件夹列表名称
	 * 
	 * @return
	 */
	public static List<String> getThemefoldersName() {
		URL url = ThemeUtil.class.getClassLoader().getResource("");
		List<String> themeNames = null;
		URLConnection urlConnection = null;
		try {
			urlConnection = url.openConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if (urlConnection instanceof JarURLConnection) {
			themeNames = jarSubfoldersName((JarURLConnection) urlConnection);
		} else {
			themeNames = fileSubfoldersName();
		}
		return themeNames;
	}

	private static List<String> fileSubfoldersName() {
		List<String> fileNames = new ArrayList<String>();
		try {
			InputStream inputStream = ThemeUtil.class.getResourceAsStream("/public" + themePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				fileNames.add(line);
			}
			reader.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return fileNames;
	}

	private static List<String> jarSubfoldersName(JarURLConnection jarURLConnection) {
		String folder = "public" + themePath;
		logger.info(folder);
		List<String> fileNames = new ArrayList<String>();
		try {
			logger.info(jarURLConnection.getJarFile().getName());
			JarFile jarFile = jarURLConnection.getJarFile();
			Enumeration<JarEntry> entrys = jarFile.entries();
			while (entrys.hasMoreElements()) {
				JarEntry entry = entrys.nextElement();
				String name = entry.getName();
				if (name.startsWith(folder)) {
					name = name.substring(folder.length());
					int i = name.indexOf("/");
					if (i != -1) {
						name = name.substring(0, name.indexOf("/"));
						if (!fileNames.contains(name)) {
							fileNames.add(name);
						}
					}
				}
			}
			jarFile.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return fileNames;
	}

}
