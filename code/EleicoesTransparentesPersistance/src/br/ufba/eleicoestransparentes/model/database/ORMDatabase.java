package br.ufba.eleicoestransparentes.model.database;

import java.sql.SQLException;

import br.ufba.eleicoestransparentes.util.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
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
		
		if(connection == null){
			connection = new JdbcConnectionSource(databaseUrl);
		}		
				
		return connection;
	}
	
	public void close() throws SQLException{
		if(connection != null)	connection.close();
	}
}

