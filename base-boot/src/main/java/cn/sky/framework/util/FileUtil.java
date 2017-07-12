package cn.sky.framework.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具
 * 
 * @author gaofu
 *
 */
public class FileUtil {

	/**
	 * 获得所有子文件夹的名称
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getSubfoldersName(String path) {
		File file = new File(path);
		file.mkdir();
		List<String> fileNames = new ArrayList<String>();
		File[] filelist = file.listFiles(new MyFileFilter(true));
		for (File fl : filelist) {
			String fname = fl.getAbsolutePath();
			int i = fname.lastIndexOf("/");
			if (i == -1) {
				i = fname.lastIndexOf("\\");
			}
			fname = fname.substring(i + 1);
			fileNames.add(fname);
		}
		return fileNames;
	}
}

/**
 * 过滤
 * 
 * @author gaofu
 *
 */
class MyFileFilter implements FileFilter {
	private boolean isDirectory;

	public MyFileFilter(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public boolean accept(File pathname) {
		if (pathname.isDirectory() == isDirectory) {
			return true;
		} else
			return false;
	}
}
