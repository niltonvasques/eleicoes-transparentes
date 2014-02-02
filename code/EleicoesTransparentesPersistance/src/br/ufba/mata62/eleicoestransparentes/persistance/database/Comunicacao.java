package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class Comunicacao {
	
	private ORMDatabase database;
	
	public Comunicacao() {
		database = new ORMDatabase();
	}
	
	public List<Transacao> consultaTransacao() throws SQLException{
		List<Transacao> transacaoes = new ArrayList<Transacao>();
		
		Dao<Transacao, String> accountDao = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		return transacaoes;
	}

}
