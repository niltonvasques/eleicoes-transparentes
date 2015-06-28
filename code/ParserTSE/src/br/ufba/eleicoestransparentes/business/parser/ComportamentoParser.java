package br.ufba.eleicoestransparentes.business.parser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.util.Path;

public abstract class ComportamentoParser {
	
	public ParserFile parserPrestacaoContasPartidoReceita;
	
	public ParserFile parserPrestacaoContasPartidoDespesa;
	
	
	public void seguirModelo() throws IOException, SQLException {
		for (String uf : Path.UFS) {
				Comunicacao comm = new Comunicacao();
				
				for (Candidato t : readCandidatos(uf)) {
					comm.insereCandidato(t);
				}
				
				for (Transacao t : readPrestacaoContasComiteDespesa(uf)) {
					comm.insereTransacao(t);
				}
				
				for (Transacao t : readPrestacaoContasComiteReceita(uf)) {
					comm.insereTransacao(t);
				}
			
				for (Transacao t : readPrestacaoContasPartidoReceita(uf)) {
					comm.insereTransacao(t);
				}
				
				for (Transacao t : readPrestacaoContasPartidoDespesa(uf)) {
					comm.insereTransacao(t);
				}
				
				for (Transacao t : readPrestacaoContasCandidatoDespesa(uf)) {
					comm.insereTransacao(t);
				}
				
				for (Transacao t : readPrestacaoContasCandidatoReceita(uf)) {
					comm.insereTransacao(t);
				}
				
				for (Bem b : readBens(uf)) {
					comm.insereBem(b);
				}
				
				comm.close();
				
				
				break;
		}
		
	}
	
	public abstract List<Transacao> readPrestacaoContasCandidatoReceita(String uf) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Transacao> readPrestacaoContasComiteReceita(String uf) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Transacao> readPrestacaoContasPartidoReceita(String uf) throws IOException;
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	
	public abstract List<Transacao> readPrestacaoContasCandidatoDespesa(String uf) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Transacao> readPrestacaoContasComiteDespesa(String uf) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Transacao> readPrestacaoContasPartidoDespesa(String uf) throws IOException;
	

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Bem> readBens(String uf) throws IOException;
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract List<Candidato> readCandidatos(String uf) throws IOException;
}
