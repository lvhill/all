package cn.sky.framework.util.excel;

import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {

	private FileWriter fileWriter;

	public void open(String fileName) {
		try {
			fileWriter = new FileWriter(fileName, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String line) {
		try {
			fileWriter.write(line + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
