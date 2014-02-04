package br.ufba.mata62.eleicoestransparentes.persistance.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Pessoa;
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
	
	public Bem insereBem(final Bem bem) throws SQLException{
		Dao<Bem, String> bemDao = DaoManager.createDao(database.getConnection(), Bem.class);
		
		Candidato ormCand = getCandidato(bem.getCandidato().getSequencialCandidato());
		
		if (ormCand != null) {//Só nos interessa se houver candidato.
			bem.setCandidato(ormCand);
			return bemDao.createIfNotExists(bem);
		}
		return null;
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
	
	public SetorEconomico insereSetorEconomico(SetorEconomico setor) throws SQLException{
		
		Dao<SetorEconomico, String> setorDao = DaoManager.createDao(database.getConnection(), SetorEconomico.class);
		
		SetorEconomico c = (SetorEconomico) checkIfExists(setorDao, "codSetorEco",setor.getCodSetorEco());
		
		if(c != null) return c;
		
		return setorDao.createIfNotExists(setor);
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
		
		Candidato c = (Candidato) checkIfExists(candidatoDao, "sequencialCandidato",cand.getSequencialCandidato());
		
		if(c != null){
			return c;
		}
		
		if(cand.getPartido() != null && cand.getPartido().getId() <= 0){
			cand.setPartido(inserePartido(cand.getPartido()));
		}
		
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
	
	public Comite insereComite(Comite cand) throws SQLException{
		
		Dao<Comite, String> comiteDAO = DaoManager.createDao(database.getConnection(), Comite.class);
		
		
		Comite c = (Comite) checkIfExists(comiteDAO, "sequencialComite",cand.getSequencialComite());
		
		if(c != null) return c;
		
		return comiteDAO.createIfNotExists(cand);
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
	
	public Eleicao insereEleicao(Eleicao eleicao) throws SQLException{
		Dao<Eleicao, String> eleicaoDAO = DaoManager.createDao(database.getConnection(), Eleicao.class);
		
		Eleicao c = (Eleicao) checkIfExists(eleicaoDAO, "ano",eleicao.getAno());
		
		if(c != null) return c;
		
		return eleicaoDAO.createIfNotExists(eleicao);
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
	
	public Partido inserePartido(Partido partido) throws SQLException{
		Dao<Partido, String> partidoDAO = DaoManager.createDao(database.getConnection(), Partido.class);
		
		Partido c = (Partido) checkIfExists(partidoDAO, "sigla",partido.getSigla());
		
		if(c != null) return c;
		
		return partidoDAO.createIfNotExists(partido);
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
	
	
	public PessoaFisica inserePessoaFisica(PessoaFisica pessoa) throws SQLException{
		Dao<PessoaFisica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), PessoaFisica.class);
		
		PessoaFisica c = (PessoaFisica) checkIfExists(pessoaDAO, "cpf",pessoa.getCpf());
		
		if(c != null) return c;
		
		return pessoaDAO.createIfNotExists(pessoa);
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
	
	public PessoaJuridica inserePessoaJuridica(PessoaJuridica pessoa) throws SQLException{
		Dao<PessoaJuridica, String> pessoaDAO = DaoManager.createDao(database.getConnection(), PessoaJuridica.class);
		
		PessoaJuridica c = (PessoaJuridica) checkIfExists(pessoaDAO, "cnpj",pessoa.getCnpj());
		
		if(c != null) return c;

		return pessoaDAO.createIfNotExists(pessoa);
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
	
	public Transacao insereTransacao(Transacao transacao) throws SQLException{
		
		Dao<Transacao, String> pessoaDAO = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		if(transacao.getDebitado() != null && transacao.getDebitado().getId() <= 0){
			int id  = 0;
			Pessoa debitado = transacao.getDebitado();
			if(debitado instanceof Partido){
				transacao.setDebitado(inserePartido((Partido)debitado));
			}else if(debitado instanceof Candidato){
				transacao.setDebitado(insereCandidato((Candidato)debitado));
			}else if(debitado instanceof PessoaJuridica){
				transacao.setDebitado(inserePessoaJuridica((PessoaJuridica)debitado));
			}else if(debitado instanceof PessoaFisica){
				transacao.setDebitado(inserePessoaFisica((PessoaFisica)debitado));
			}
		}
		if(transacao.getCreditado().getId() <= 0){
			int id  = 0;
			Pessoa creditado = transacao.getCreditado();
			if(creditado instanceof Partido){
				transacao.setCreditado(inserePartido((Partido)creditado));
			}else if(creditado instanceof Candidato){
				transacao.setCreditado(insereCandidato((Candidato)creditado));
			}else if(creditado instanceof PessoaJuridica){
				transacao.setCreditado(inserePessoaJuridica((PessoaJuridica)creditado));
			}else if(creditado instanceof PessoaFisica){
				transacao.setCreditado(inserePessoaFisica((PessoaFisica)creditado));
			}
		}
		
		if(transacao.getCreditado() != null && transacao.getCreditado().getId() <= 0){
			int id  = 0;
			Pessoa creditado = transacao.getCreditado();
			if(creditado instanceof Partido){
				transacao.setCreditado(inserePartido((Partido)creditado));
			}else if(creditado instanceof Candidato){
				transacao.setCreditado(insereCandidato((Candidato)creditado));
			}else if(creditado instanceof PessoaJuridica){
				transacao.setCreditado(inserePessoaJuridica((PessoaJuridica)creditado));
			}else if(creditado instanceof PessoaFisica){
				transacao.setCreditado(inserePessoaFisica((PessoaFisica)creditado));
			}
		}
		
		return pessoaDAO.createIfNotExists(transacao);
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
	
	/**
	 * @param numeroPartido
	 * @param UF
	 * @param tipo "R" para receita e "D" para despesa.
	 * @throws SQLException
	 */
	public float consultaTransacaoPartido(int numeroPartido, String UF, String tipo) throws SQLException{
		
		MySqlDatabase db = new MySqlDatabase();
		
		ResultSet result = db.query("select p.nome, sum(valor), t.tipo from Transacao t inner join Partido p on p.id = t.debitado_id  where t.tipo = '"+tipo+"' and p.numero = "+numeroPartido+" group by p.id order by sum(valor) desc;");
		float valor = 0;
		if(result.next()){
			System.out.println("Partido: "+result.getString(1)+" Valor: "+result.getString(2));
			valor = result.getFloat(2);
		}
		db.close();
		return valor;
	}
	
	public float consultaTransacaoCandidato(int numero,String UF,String tipoTransacao) throws SQLException {
		MySqlDatabase db = new MySqlDatabase();
		
		String query = "select p.nome, sum(valor), t.tipo from Transacao t inner join Candidato p" +
			" on p.id = t.debitado_id  where t.tipo = '"+tipoTransacao+"' and p.numero = "+numero+" group by p.id order by sum(valor) desc;";
		if(tipoTransacao.equals("R")){
			query = "select p.nome, sum(valor), t.tipo from Transacao t inner join Candidato p" +
				" on p.id = t.creditado_id  where t.tipo = '"+tipoTransacao+"' and p.numero = "+numero+" group by p.id order by sum(valor) desc;";
		}
		ResultSet result = db.query(query);
		float valor = 0;
		if(result.next()){
			System.out.println("Candidato: "+result.getString(1)+" Valor: "+result.getString(2));
			valor = result.getFloat(2);
		}
		db.close();
		return valor;
	}
	
	public List<Transacao> consultaTransacao() throws SQLException{
		
		Dao<Transacao, String> transacaoDao = DaoManager.createDao(database.getConnection(), Transacao.class);
		
		return transacaoDao.queryForAll();
	}
	
	private Object checkIfExists(Dao dao, String field, String value){
		try {
			List listORM = dao.queryForEq(field,value);
			if(!listORM.isEmpty()){
				return listORM.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
