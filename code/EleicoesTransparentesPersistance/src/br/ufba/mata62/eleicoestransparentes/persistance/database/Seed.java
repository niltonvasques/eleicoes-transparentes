package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Seed {

	public static void createTables(){
		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			String databaseUrl = "jdbc:mysql://192.241.169.62/eleicao?"+ "user=mata62&password=mata62";
			String databaseUrl = "jdbc:mysql://localhost/eleicao?"+ "user=root&password=mata62";
			// create a connection source to our database
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);		
			
//			Dao<Bem, String> accountDao = DaoManager.createDao(connectionSource, Bem.class);
			
			// if you need to create the 'Bem' table make this call
			TableUtils.dropTable(connectionSource, Bem.class, true);
	        TableUtils.createTable(connectionSource, Bem.class);
	        
	        TableUtils.dropTable(connectionSource, SetorEconomico.class, true);
	        TableUtils.createTable(connectionSource, SetorEconomico.class);
	        
	        TableUtils.dropTable(connectionSource, Pessoa.class, true);
	        TableUtils.createTable(connectionSource, Pessoa.class);
	        
	        TableUtils.dropTable(connectionSource, PessoaFisica.class, true);
	        TableUtils.createTable(connectionSource, PessoaFisica.class);
	        
	        TableUtils.dropTable(connectionSource, PessoaJuridica.class, true);
	        TableUtils.createTable(connectionSource, PessoaJuridica.class);
	        
	        TableUtils.dropTable(connectionSource, Partido.class, true);
	        TableUtils.createTable(connectionSource, Partido.class);
	        
	        TableUtils.dropTable(connectionSource, Candidato.class, true);
	        TableUtils.createTable(connectionSource, Candidato.class);
	        
	        TableUtils.dropTable(connectionSource, Comite.class, true);
	        TableUtils.createTable(connectionSource, Comite.class);
	        
	        TableUtils.dropTable(connectionSource, Eleicao.class, true);
	        TableUtils.createTable(connectionSource, Eleicao.class);
	        
	        TableUtils.dropTable(connectionSource, Transacao.class, true);
	        TableUtils.createTable(connectionSource, Transacao.class);
	        
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
