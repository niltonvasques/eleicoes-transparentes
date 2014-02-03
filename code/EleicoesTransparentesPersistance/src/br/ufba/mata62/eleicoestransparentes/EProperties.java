package br.ufba.mata62.eleicoestransparentes;
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
		int lastBar = dir.lastIndexOf("/");
		StringBuffer buffer = new StringBuffer(dir);
		buffer = buffer.replace(lastBar, buffer.length(), "");
		
		return buffer.toString();
	}
	
	public static String findAppDirectory(){
		String dir = System.getProperty("user.dir");
		return dir;
	}

	public static String getDatabaseUrl() {
		try {
			return getProp().getProperty("database_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getLocalDatabaseUrl() {
		try {
			return getProp().getProperty("local_database_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getRemoteDatabaseUrl() {
		try {
			return getProp().getProperty("remote_database_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
