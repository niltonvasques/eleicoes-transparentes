package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMBem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMCandidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMComite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMEleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPartido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMSetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMTransacao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Seed {

	public static void createTables(){
		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			String databaseUrl = "jdbc:mysql://192.241.169.62/eleicao?"+ "user=mata62&password=mata62";
//			String databaseUrl = "jdbc:mysql://localhost/eleicao?"+ "user=root&password=mata62";
			String databaseUrl = "jdbc:mysql://localhost/eleicao?"+ "user=root&password=batman";//Máquina Tiago
			// create a connection source to our database
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);		
			
//			Dao<Bem, String> accountDao = DaoManager.createDao(connectionSource, Bem.class);
			
			// if you need to create the 'Bem' table make this call
			TableUtils.dropTable(connectionSource, ORMBem.class, true);
	        TableUtils.createTable(connectionSource, ORMBem.class);
	        
	        TableUtils.dropTable(connectionSource, ORMSetorEconomico.class, true);
	        TableUtils.createTable(connectionSource, ORMSetorEconomico.class);
	        
	        TableUtils.dropTable(connectionSource, ORMPessoa.class, true);
	        TableUtils.createTable(connectionSource, ORMPessoa.class);
	        
	        TableUtils.dropTable(connectionSource, ORMPessoaFisica.class, true);
	        TableUtils.createTable(connectionSource, ORMPessoaFisica.class);
	        
	        TableUtils.dropTable(connectionSource, ORMPessoaJuridica.class, true);
	        TableUtils.createTable(connectionSource, ORMPessoaJuridica.class);
	        
	        TableUtils.dropTable(connectionSource, ORMPartido.class, true);
	        TableUtils.createTable(connectionSource, ORMPartido.class);
	        
	        TableUtils.dropTable(connectionSource, ORMCandidato.class, true);
	        TableUtils.createTable(connectionSource, ORMCandidato.class);
	        
	        TableUtils.dropTable(connectionSource, ORMComite.class, true);
	        TableUtils.createTable(connectionSource, ORMComite.class);
	        
	        TableUtils.dropTable(connectionSource, ORMEleicao.class, true);
	        TableUtils.createTable(connectionSource, ORMEleicao.class);
	        
	        TableUtils.dropTable(connectionSource, ORMTransacao.class, true);
	        TableUtils.createTable(connectionSource, ORMTransacao.class);
	        
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
