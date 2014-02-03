package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.PersistanceFactory;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.BeanFactory;
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
	
	public boolean insereBem(Bem bem) throws SQLException{
		
		ORMBem orm = BeanFactory.createORMBem(bem);
		
		Dao<ORMBem, String> bemDao = DaoManager.createDao(database.getConnection(), ORMBem.class);
		
		return bemDao.create(orm) > 0;
	}
	
	public List<Bem> consultaBens() throws SQLException{
		
		List<Bem> bens = new ArrayList<Bem>();
		
		Dao<ORMBem, String> dao = DaoManager.createDao(database.getConnection(), ORMBem.class);
		
		List<ORMBem> ormBens = dao.queryForAll();
		for (ORMBem ormBem : ormBens) {
			bens.add(PersistanceFactory.createBem(ormBem));
		}
		
		return bens;
	}
	
	public boolean insereSetorEconomico(SetorEconomico setor) throws SQLException{
		
		ORMSetorEconomico orm = BeanFactory.createORMSetorEconomico(setor);
		
		Dao<ORMSetorEconomico, String> setorDao = DaoManager.createDao(database.getConnection(), ORMSetorEconomico.class);
		
		return setorDao.create(orm) > 0;
	}
	
	
	public List<SetorEconomico> consultaSetoresEconomico() throws SQLException{
		
		List<SetorEconomico> itens = new ArrayList<SetorEconomico>();
		
		Dao<ORMSetorEconomico, String> dao = DaoManager.createDao(database.getConnection(), ORMSetorEconomico.class);
		
		List<ORMSetorEconomico> ormItens = dao.queryForAll();
		for (ORMSetorEconomico ormBem : ormItens) {
			itens.add(PersistanceFactory.createSetorEconomico(ormBem));
		}
		
		return itens;
	}
	
	public boolean insereCandidato(Candidato cand) throws SQLException{
		
		ORMCandidato orm = BeanFactory.createORMCandidato(cand);
		
		Dao<ORMCandidato, String> candidatoDao = DaoManager.createDao(database.getConnection(), ORMCandidato.class);
		
		return candidatoDao.create(orm) > 0;
	}
	
	public List<Candidato> consultaCandidatos() throws SQLException{
		
		List<Candidato> itens = new ArrayList<Candidato>();
		
		Dao<ORMCandidato, String> dao = DaoManager.createDao(database.getConnection(), ORMCandidato.class);
		
		List<ORMCandidato> ormItens = dao.queryForAll();
		for (ORMCandidato orm : ormItens) {
			itens.add(PersistanceFactory.createCandidato(orm));
		}
		
		return itens;
	}
	
	public boolean insereComite(Comite cand) throws SQLException{
		
		ORMComite orm = BeanFactory.createORMComite(cand);
		
		Dao<ORMComite, String> comiteDAO = DaoManager.createDao(database.getConnection(), ORMComite.class);
		
		return comiteDAO.create(orm) > 0;
	}
	
	public List<Comite> consultaComites() throws SQLException{
		
		List<Comite> itens = new ArrayList<Comite>();
		
		Dao<ORMComite, String> dao = DaoManager.createDao(database.getConnection(), ORMComite.class);
		
		List<ORMComite> ormItens = dao.queryForAll();
		for (ORMComite orm : ormItens) {
			itens.add(PersistanceFactory.createComite(orm));
		}
		
		return itens;
	}
	
	public boolean insereEleicao(Eleicao eleicao) throws SQLException{
		ORMEleicao orm = BeanFactory.createORMEleicao(eleicao);
		
		Dao<ORMEleicao, String> eleicaoDAO = DaoManager.createDao(database.getConnection(), ORMEleicao.class);
		
		return eleicaoDAO.create(orm) > 0;
	}
	
	public List<Eleicao> consultaEleicoes() throws SQLException{
		
		List<Eleicao> itens = new ArrayList<Eleicao>();
		
		Dao<ORMEleicao, String> dao = DaoManager.createDao(database.getConnection(), ORMEleicao.class);
		
		List<ORMEleicao> ormItens = dao.queryForAll();
		for (ORMEleicao orm : ormItens) {
			itens.add(PersistanceFactory.createEleicao(orm));
		}
		
		return itens;
	}
	
	public boolean inserePartido(Partido partido) throws SQLException{
		ORMPartido orm =  BeanFactory.createORMPartido(partido);
		
		Dao<ORMPartido, String> partidoDAO = DaoManager.createDao(database.getConnection(), ORMPartido.class);
		
		return partidoDAO.create(orm) > 0;
	}
	
	public List<Partido> consultaPartidos() throws SQLException{
		
		List<Partido> itens = new ArrayList<Partido>();
		
		Dao<ORMPartido, String> dao = DaoManager.createDao(database.getConnection(), ORMPartido.class);
		
		List<ORMPartido> ormItens = dao.queryForAll();
		for (ORMPartido orm : ormItens) {
			itens.add(PersistanceFactory.createPartido(orm));
		}
		
		return itens;
	}
	
	public boolean inserePessoa(Pessoa pessoa) throws SQLException{
		ORMPessoa orm =  BeanFactory.createORMPessoa(pessoa);
		
		Dao<ORMPessoa, String> pessoaDAO = DaoManager.createDao(database.getConnection(), ORMPessoa.class);
		
		return pessoaDAO.create(orm) > 0;
	}
	
	public List<Pessoa> consultaPessoas() throws SQLException{
		
		List<Pessoa> itens = new ArrayList<Pessoa>();
		
		Dao<ORMPessoa, String> dao = DaoManager.createDao(database.getConnection(), ORMPessoa.class);
		
		List<ORMPessoa> ormItens = dao.queryForAll();
		for (ORMPessoa orm : ormItens) {
			itens.add(PersistanceFactory.createPessoa(orm));
		}
		
		return itens;
	}
	
	public boolean inserePessoaFisica(PessoaFisica pessoa) throws SQLException{
		ORMPessoaFisica orm =  BeanFactory.createORMPessoaFisica(pessoa);
		
		Dao<ORMPessoaFisica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), ORMPessoaFisica.class);
		
		return pessoaDAO.create(orm) > 0;
	}
	
	public List<PessoaFisica> consultaPessoasFisica() throws SQLException{
		
		List<PessoaFisica> itens = new ArrayList<PessoaFisica>();
		
		Dao<ORMPessoaFisica, String> dao = DaoManager.createDao(database.getConnection(), ORMPessoaFisica.class);
		
		List<ORMPessoaFisica> ormItens = dao.queryForAll();
		for (ORMPessoaFisica orm : ormItens) {
			itens.add(PersistanceFactory.createPessoaFisica(orm));
		}
		
		return itens;
	}
	
	public boolean inserePessoaJuridica(PessoaJuridica pessoa) throws SQLException{
		ORMPessoaJuridica orm =  BeanFactory.createORMPessoaJuridica(pessoa);
		
		Dao<ORMPessoaJuridica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), ORMPessoaJuridica.class);
		
		if(orm.getPessoa().getId() <= 0){
			inserePessoa(pessoa);
		}
		
		return pessoaDAO.create(orm) > 0;
	}
	
	public List<PessoaJuridica> consultaPessoasJuridica() throws SQLException{
		
		List<PessoaJuridica> itens = new ArrayList<PessoaJuridica>();
		
		Dao<ORMPessoaJuridica, String> dao = DaoManager.createDao(database.getConnection(), ORMPessoaJuridica.class);
		
		List<ORMPessoaJuridica> ormItens = dao.queryForAll();
		for (ORMPessoaJuridica orm : ormItens) {
			itens.add(PersistanceFactory.createPessoaJuridica(orm));
		}
		
		return itens;
	}
	
	public boolean insereTransacao(Transacao transacao) throws SQLException{
		ORMTransacao orm =  BeanFactory.createORMTransacao(transacao);
		
		Dao<ORMTransacao, String> pessoaDAO = DaoManager.createDao(database.getConnection(), ORMTransacao.class);
		
		return pessoaDAO.create(orm) > 0;
	}
	
	public List<Transacao> consultaTransacoes() throws SQLException{
		
		List<Transacao> itens = new ArrayList<Transacao>();
		
		Dao<ORMTransacao, String> dao = DaoManager.createDao(database.getConnection(), ORMTransacao.class);
		
		List<ORMTransacao> ormItens = dao.queryForAll();
		for (ORMTransacao orm : ormItens) {
			itens.add(PersistanceFactory.createTransacao(orm));
		}
		
		return itens;
	}
	
	public List<ORMTransacao> consultaTransacao() throws SQLException{
		
		Dao<ORMTransacao, String> transacaoDao = DaoManager.createDao(database.getConnection(), ORMTransacao.class);
		
		return transacaoDao.queryForAll();
	}

}
