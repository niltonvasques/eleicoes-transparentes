package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class Comunicacao {
	
	private ORMDatabase database;
	
	public Comunicacao() {
		database = new ORMDatabase();
	}
	
	public void close(){
		try {
			database.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insereBem(final Bem bem) throws SQLException{
		Dao<Bem, String> bemDao = DaoManager.createDao(database.getConnection(), Bem.class);

		Candidato ormCand = getCandidato(bem.getCandidato().getSequencialCandidato());
		
		if (ormCand != null) {//Só nos interessa se houver candidato.
			bem.setCandidato(ormCand);
			return bemDao.create(bem) > 0;
		}
		return false;
	}
	
	public Candidato getCandidato(String sequencialCandidato){
		Candidato orm = null;
		List<Candidato> listORM;
		Dao<Candidato, String> candidatoDao;
		try {
			candidatoDao = DaoManager.createDao(database.getConnection(), Candidato.class);
			listORM = candidatoDao.queryForEq("sequencialCandidato",sequencialCandidato);
			if(!listORM.isEmpty())
				orm = listORM.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orm;
	}
	
	public List<Bem> consultaBens() throws SQLException{
		
		List<Bem> bens = new ArrayList<Bem>();
		
		Dao<Bem, String> dao = DaoManager.createDao(database.getConnection(), Bem.class);
		
		List<Bem> ormBens = dao.queryForAll();
		for (Bem ormBem : ormBens) {
			bens.add(ormBem);
		}
		
		return bens;
	}
	
	public boolean insereSetorEconomico(SetorEconomico setor) throws SQLException{
		
		Dao<SetorEconomico, String> setorDao = DaoManager.createDao(database.getConnection(), SetorEconomico.class);
		
		return setorDao.create(setor) > 0;
	}
	
	
	public List<SetorEconomico> consultaSetoresEconomico() throws SQLException{
		
		List<SetorEconomico> itens = new ArrayList<SetorEconomico>();
		
		Dao<SetorEconomico, String> dao = DaoManager.createDao(database.getConnection(), SetorEconomico.class);
		
		List<SetorEconomico> ormItens = dao.queryForAll();
		for (SetorEconomico ormBem : ormItens) {
			itens.add(ormBem);
		}
		
		return itens;
	}
	
	public Candidato insereCandidato(Candidato cand) throws SQLException{
		
		Dao<Candidato, String> candidatoDao = DaoManager.createDao(database.getConnection(), Candidato.class);
		
		return candidatoDao.createIfNotExists(cand);
	}
	
	public List<Candidato> consultaCandidatos() throws SQLException{
		
		List<Candidato> itens = new ArrayList<Candidato>();
		
		Dao<Candidato, String> dao = DaoManager.createDao(database.getConnection(), Candidato.class);
		
		List<Candidato> ormItens = dao.queryForAll();
		for (Candidato orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public boolean insereComite(Comite cand) throws SQLException{
		
		Dao<Comite, String> comiteDAO = DaoManager.createDao(database.getConnection(), Comite.class);
		
		return comiteDAO.create(cand) > 0;
	}
	
	public List<Comite> consultaComites() throws SQLException{
		
		List<Comite> itens = new ArrayList<Comite>();
		
		Dao<Comite, String> dao = DaoManager.createDao(database.getConnection(), Comite.class);
		
		List<Comite> ormItens = dao.queryForAll();
		for (Comite orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public boolean insereEleicao(Eleicao eleicao) throws SQLException{
		Dao<Eleicao, String> eleicaoDAO = DaoManager.createDao(database.getConnection(), Eleicao.class);
		
		return eleicaoDAO.create(eleicao) > 0;
	}
	
	public List<Eleicao> consultaEleicoes() throws SQLException{
		
		List<Eleicao> itens = new ArrayList<Eleicao>();
		
		Dao<Eleicao, String> dao = DaoManager.createDao(database.getConnection(), Eleicao.class);
		
		List<Eleicao> ormItens = dao.queryForAll();
		for (Eleicao orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public boolean inserePartido(Partido partido) throws SQLException{
		Dao<Partido, String> partidoDAO = DaoManager.createDao(database.getConnection(), Partido.class);
		
		return partidoDAO.create(partido) > 0;
	}
	
	public List<Partido> consultaPartidos() throws SQLException{
		
		List<Partido> itens = new ArrayList<Partido>();
		
		Dao<Partido, String> dao = DaoManager.createDao(database.getConnection(), Partido.class);
		
		List<Partido> ormItens = dao.queryForAll();
		for (Partido orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	
	public boolean inserePessoaFisica(PessoaFisica pessoa) throws SQLException{
		Dao<PessoaFisica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), PessoaFisica.class);
		
		return pessoaDAO.create(pessoa) > 0;
	}
	
	public List<PessoaFisica> consultaPessoasFisica() throws SQLException{
		
		List<PessoaFisica> itens = new ArrayList<PessoaFisica>();
		
		Dao<PessoaFisica, String> dao = DaoManager.createDao(database.getConnection(), PessoaFisica.class);
		
		List<PessoaFisica> ormItens = dao.queryForAll();
		for (PessoaFisica orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public boolean inserePessoaJuridica(PessoaJuridica pessoa) throws SQLException{
		Dao<PessoaJuridica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), PessoaJuridica.class);

		return pessoaDAO.create(pessoa) > 0;
	}
	
	public List<PessoaJuridica> consultaPessoasJuridica() throws SQLException{
		
		List<PessoaJuridica> itens = new ArrayList<PessoaJuridica>();
		
		Dao<PessoaJuridica, String> dao = DaoManager.createDao(database.getConnection(), PessoaJuridica.class);
		
		List<PessoaJuridica> ormItens = dao.queryForAll();
		for (PessoaJuridica orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public boolean insereTransacao(Transacao transacao) throws SQLException{
		
		Dao<Transacao, String> pessoaDAO = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		return pessoaDAO.create(transacao) > 0;
	}
	
	public List<Transacao> consultaTransacoes() throws SQLException{
		
		List<Transacao> itens = new ArrayList<Transacao>();
		
		Dao<Transacao, String> dao = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		List<Transacao> ormItens = dao.queryForAll();
		for (Transacao orm : ormItens) {
			itens.add(orm);
		}
		
		return itens;
	}
	
	public List<Transacao> consultaTransacao() throws SQLException{
		
		Dao<Transacao, String> transacaoDao = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		return transacaoDao.queryForAll();
	}

}
