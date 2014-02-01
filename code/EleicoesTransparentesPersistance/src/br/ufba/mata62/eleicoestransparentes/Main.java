package br.ufba.mata62.eleicoestransparentes;

import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;


public class Main {
	
	public static void main(String[] args) {
		
		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String databaseUrl = "jdbc:mysql://192.241.169.62/eleicao?"+ "user=mata62&password=mata62";
			// create a connection source to our database
			ConnectionSource connectionSource;
			connectionSource = new JdbcConnectionSource(databaseUrl);
			
			Dao<Bem, String> accountDao = DaoManager.createDao(connectionSource, Bem.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
