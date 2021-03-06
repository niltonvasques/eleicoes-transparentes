package br.ufba.eleicoestransparentes.model.database;

import java.sql.SQLException;

import br.ufba.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Comite;
import br.ufba.eleicoestransparentes.model.Eleicao;
import br.ufba.eleicoestransparentes.model.Partido;
import br.ufba.eleicoestransparentes.model.Pessoa;
import br.ufba.eleicoestransparentes.model.PessoaFisica;
import br.ufba.eleicoestransparentes.model.PessoaJuridica;
import br.ufba.eleicoestransparentes.model.SetorEconomico;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.eleicoestransparentes.util.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Seed {

	public static void createTables(){
		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String databaseUrl = EProperties.getDatabaseUrl();
			
			// create a connection source to our database
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
			
//			Dao<Bem, String> accountDao = DaoManager.createDao(connectionSource, Bem.class);
			
			// if you need to create the 'Bem' table make this call
	        TableUtils.createTable(connectionSource, Bem.class);
	        
	        TableUtils.createTable(connectionSource, SetorEconomico.class);
	        
	        TableUtils.createTable(connectionSource, Pessoa.class);
	        
	        TableUtils.createTable(connectionSource, PessoaFisica.class);
	        
	        TableUtils.createTable(connectionSource, PessoaJuridica.class);
	        
	        TableUtils.createTable(connectionSource, Partido.class);
	        
	        TableUtils.createTable(connectionSource, Candidato.class);
	        
	        TableUtils.createTable(connectionSource, Comite.class);
	        
	        TableUtils.createTable(connectionSource, AgenteEleitoral.class);
	        
	        TableUtils.createTable(connectionSource, Eleicao.class);
	        
	        TableUtils.createTable(connectionSource, Transacao.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropTables(){
		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			String databaseUrl = EProperties.getDatabaseUrl();
			
			// create a connection source to our database
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);		
			
//			Dao<Bem, String> accountDao = DaoManager.createDao(connectionSource, Bem.class);
			
			// if you need to create the 'Bem' table make this call
			TableUtils.dropTable(connectionSource, Bem.class, true);
	        
	        TableUtils.dropTable(connectionSource, SetorEconomico.class, true);
	        
	        TableUtils.dropTable(connectionSource, Pessoa.class, true);
	        
	        TableUtils.dropTable(connectionSource, PessoaFisica.class, true);
	        
	        TableUtils.dropTable(connectionSource, PessoaJuridica.class, true);
	        
	        TableUtils.dropTable(connectionSource, Partido.class, true);
	        
	        TableUtils.dropTable(connectionSource, Candidato.class, true);
	        
	        TableUtils.dropTable(connectionSource, Comite.class, true);
	        
	        TableUtils.dropTable(connectionSource, AgenteEleitoral.class, true);
	        
	        TableUtils.dropTable(connectionSource, Eleicao.class, true);
	        
	        TableUtils.dropTable(connectionSource, Transacao.class, true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
