package br.ufba.mata62.eleicoestransparentes;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EProperties {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/eleicao.properties");
		props.load(file);
		file.close();
		return props;
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
