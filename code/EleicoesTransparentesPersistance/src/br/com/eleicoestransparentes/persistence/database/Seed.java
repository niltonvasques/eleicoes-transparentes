package br.com.eleicoestransparentes.persistence.database;

import java.sql.SQLException;

import br.com.eleicoestransparentes.persistence.beans.Bem;
import br.com.eleicoestransparentes.persistence.beans.Candidato;
import br.com.eleicoestransparentes.persistence.beans.Comite;
import br.com.eleicoestransparentes.persistence.beans.Eleicao;
import br.com.eleicoestransparentes.persistence.beans.Partido;
import br.com.eleicoestransparentes.persistence.beans.Pessoa;
import br.com.eleicoestransparentes.persistence.beans.PessoaFisica;
import br.com.eleicoestransparentes.persistence.beans.PessoaJuridica;
import br.com.eleicoestransparentes.persistence.beans.SetorEconomico;
import br.com.eleicoestransparentes.persistence.beans.Transacao;
import br.com.eleicoestransparentes.persistence.util.EProperties;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
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
