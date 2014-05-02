package br.com.eleicoestransparentes.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EProperties {

	public static Properties getProp() throws IOException {
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(findTopLevelDirectory()+"/eleicao.properties");
		props.load(file);
		file.close();
		return props;
	}

	public static String findTopLevelDirectory() {
		String dir = findAppDirectory();
		if (dir.contains("/")) {
			int lastBar = dir.lastIndexOf("/");
			StringBuffer buffer = new StringBuffer(dir);
			buffer = buffer.replace(lastBar, buffer.length(), "");
			return buffer.toString();
		}
		return dir;
	}
	
	public static String findAppDirectory(){
		String dir = System.getProperty("user.dir");
		return dir;
	}

	public static String getPathRoot() {
		try {
			return getProp().getProperty("path_root_repo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
