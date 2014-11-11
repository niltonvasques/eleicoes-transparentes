package br.ufba.mata62.eleicoestransparentes.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufba.mata62.eleicoestransparentes.util.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class MySqlDatabase {
	
	private String databaseUrl;
	private Connection connect = null;
	
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public MySqlDatabase() {
		databaseUrl = EProperties.getDatabaseUrl();
		init();
	}

	private void init() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	public Connection getConnection() throws SQLException{
		
		if(connect == null){
			connect = DriverManager.getConnection(databaseUrl);
		}
		
		return connect;
	}
	
	public ResultSet query(String query) throws SQLException{
		
		statement = getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		return resultSet;
	}
	
	private void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://192.241.169.62/eleicao?"+ "user=mata62&password=mata62");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from eleicao.Pessoa");
			writeResultSet(resultSet);

//			// PreparedStatements can use variables and are more efficient
//			preparedStatement = connect
//			.prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
//			// "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
//			// Parameters start with 1
//			preparedStatement.setString(1, "Test");
//			preparedStatement.setString(2, "TestEmail");
//			preparedStatement.setString(3, "TestWebpage");
//			preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//			preparedStatement.setString(5, "TestSummary");
//			preparedStatement.setString(6, "TestComment");
//			preparedStatement.executeUpdate();
//
//			preparedStatement = connect
//			.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
//			resultSet = preparedStatement.executeQuery();
//			writeResultSet(resultSet);
//
//			// Remove again the insert comment
//			preparedStatement = connect
//			.prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
//			preparedStatement.setString(1, "Test");
//			preparedStatement.executeUpdate();
//
//			resultSet = statement
//			.executeQuery("select * from FEEDBACK.COMMENTS");
//			writeMetaData(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
//			close();
		}

	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
	    // ResultSet is initially before the first data set
	    while (resultSet.next()) {
	      // It is possible to get the columns via name
	      // also possible to get the columns via the column number
	      // which starts at 1
	      // e.g. resultSet.getSTring(2);
	      String id = resultSet.getString("id");
	      String nome = resultSet.getString("nome");
	      System.out.println("Id: " + id);
	      System.out.println("Nome: " + nome);
	    }
	  }
	
	// You need to close the resultSet
	  public void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	
	public static void main(String[] args) {
		
//		System.out.println(new Hello().getSetoresEconomico());
//		MySqlAcess acess = new MySqlAcess();
//		
//		try {
//			acess.readDataBase();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
