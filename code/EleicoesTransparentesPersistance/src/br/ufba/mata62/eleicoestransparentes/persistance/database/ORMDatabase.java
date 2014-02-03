package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ORMDatabase {
	
	private String databaseUrl;
	private ConnectionSource connection;
	
	public ORMDatabase() {
		databaseUrl = EProperties.getDatabaseUrl();
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
		
		connection = new JdbcConnectionSource(databaseUrl);		
		
		return connection;
	}
	
	public void close() throws SQLException{
		connection.close();
	}
}

