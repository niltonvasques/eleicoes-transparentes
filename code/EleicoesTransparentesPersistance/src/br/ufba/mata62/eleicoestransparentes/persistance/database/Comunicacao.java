package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMTransacao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class Comunicacao {
	
	private ORMDatabase database;
	
	public Comunicacao() {
		database = new ORMDatabase();
	}
	
	public List<ORMTransacao> consultaTransacao() throws SQLException{
		List<ORMTransacao> transacaoes = new ArrayList<ORMTransacao>();
		
		Dao<ORMTransacao, String> accountDao = DaoManager.createDao(database.getConnection(), ORMTransacao.class);
		
		return transacaoes;
	}

}
