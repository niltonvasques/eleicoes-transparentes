package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ORMDatabase {
	
//	public static final String LOCAL_DATABASE_URL = "jdbc:mysql://localhost/eleicao?"+ "user=root&password=mata62";
	public static final String LOCAL_DATABASE_URL = "jdbc:mysql://localhost/eleicao?"+ "user=root&password=batman";//Máquina Tiago
	public static final String REMOTE_DATABASE_URL = "jdbc:mysql://192.241.169.62/eleicao?"+ "user=mata62&password=mata62";
	
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
		
		connection = new JdbcConnectionSource(LOCAL_DATABASE_URL);		
		
		return connection;
	}
}

