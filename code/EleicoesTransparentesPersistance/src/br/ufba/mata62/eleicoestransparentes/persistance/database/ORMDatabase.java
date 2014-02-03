package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ORMDatabase {
	
	public static final String LOCAL_DATABASE_URL = EProperties.getLocalDatabaseUrl();
	public static final String REMOTE_DATABASE_URL = EProperties.getRemoteDatabaseUrl();
	
	private ConnectionSource connection;
	
	public ORMDatabase() {
		init();
	}

	private void init(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

	public ConnectionSource getConnection() throws SQLException{
		
		connection = new JdbcConnectionSource(REMOTE_DATABASE_URL);		
		
		return connection;
	}
	
	public void close() throws SQLException{
		connection.close();
	}
}

