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

	public OnProgressListener listener;

	public void setListener(OnProgressListener listener) {
		this.listener = listener;
	}

	public interface OnProgressListener{
		public void onProgressChange(String job, String message, float progress);
	}


	public void seguirModelo() throws IOException, SQLException {
		float totalUFs = Path.UFS.length;
		float ufIndex = 0;
		float fatia = 1/totalUFs;
		
		for (String uf : Path.UFS) {
			
			float progressStart = ufIndex / totalUFs;
			float jobsFatia = 1.0f/8.0f;
			
			Comunicacao comm = new Comunicacao();

			List<Candidato> candidatos = readCandidatos(uf);
			float totalItems = candidatos.size();
			float indexItem = 0;
			float itemsProgress = 0;
			for (Candidato t : candidatos) {
				comm.insereCandidato(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readCandidatos("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			List<Transacao> transacoes = readPrestacaoContasComiteDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasComiteDespesa("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasComiteReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasComiteReceita("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasPartidoReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasPartidoReceita("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasPartidoDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasPartidoDespesa("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasCandidatoDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasCandidatoDespesa("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasCandidatoReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readPrestacaoContasCandidatoReceita("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;

			List<Bem> bens = readBens(uf);
			totalItems = bens.size();
			indexItem = 0;
			for (Bem b : bens) {
				comm.insereBem(b);
				
				if(listener != null){
					indexItem++;
					itemsProgress = indexItem / totalItems;
					listener.onProgressChange("Parser: "+uf, "readBens("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100);
				}
			}
			progressStart += jobsFatia*fatia;
			comm.close();
			
			ufIndex++;

//			break;
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
