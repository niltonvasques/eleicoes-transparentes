package br.ufba.eleicoestransparentes.business.parser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Eleicao;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.eleicoestransparentes.util.EProperties;
import br.ufba.mata62.eleicoestransparentes.util.Path;

public abstract class ComportamentoParser {

	public ParserFile parserPrestacaoContasPartidoReceita;

	public ParserFile parserPrestacaoContasPartidoDespesa;

	public OnProgressListener listener;

	public void setListener(OnProgressListener listener) {
		this.listener = listener;
	}

	public interface OnProgressListener{
		public void onProgressChange(String job, String message, float progress, float taskProgress);
	}


	public void seguirModelo() throws IOException, SQLException {
		float totalUFs = Path.UFS.length;
		float ufIndex = 0;
		float fatia = 1/totalUFs;
		
		String inicialUF = EProperties.getStartUF();
		Comunicacao comm = new Comunicacao();
		
		Eleicao eleicao = comm.insereEleicao(readEleicao());
		
		for (String uf : Path.UFS) {
			
			
			float progressStart = ufIndex / totalUFs;
			float jobsFatia = 1.0f/8.0f;
			
			if(inicialUF != null && uf.compareTo(inicialUF) < 0){
				ufIndex++;
				continue;
			}
			if(!containsUF(uf)){
				ufIndex++;
				continue;
			}
			

			List<Candidato> candidatos = readCandidatos(uf);
			float totalItems = candidatos.size();
			float indexItem = 0;
			for (Candidato t : candidatos) {
				t.setEleicao(eleicao);
				comm.insereCandidato(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readCandidatos", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;

			List<Transacao> transacoes = readPrestacaoContasComiteDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				t.setEleicao(eleicao);
				comm.insereTransacao(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasComiteDespesa", progressStart, jobsFatia, totalItems,	indexItem);				
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasComiteReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				t.setEleicao(eleicao);
				comm.insereTransacao(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasComiteReceita", progressStart, jobsFatia, totalItems,	indexItem);	
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasPartidoReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				comm.insereTransacao(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasPartidoReceita", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasPartidoDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				t.setEleicao(eleicao);
				comm.insereTransacao(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasPartidoDespesa", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasCandidatoDespesa(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				t.setEleicao(eleicao);
				comm.insereTransacao(t);

				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasCandidatoDespesa", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;

			transacoes = readPrestacaoContasCandidatoReceita(uf);
			totalItems = transacoes.size();
			indexItem = 0;
			for (Transacao t : transacoes) {
				t.setEleicao(eleicao);
				comm.insereTransacao(t);
				
				indexItem++;
				updateProgress(fatia, uf, "readPrestacaoContasCandidatoReceita", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;

			List<Bem> bens = readBens(uf);
			totalItems = bens.size();
			indexItem = 0;
			for (Bem b : bens) {
				comm.insereBem(b);
				
				indexItem++;
				updateProgress(fatia, uf, "readBens", progressStart, jobsFatia, totalItems,	indexItem);
			}
			progressStart += jobsFatia*fatia;
			
			ufIndex++;
		}
		comm.close();

	}

	private void updateProgress(float fatia, String uf, String message, float progressStart, float jobsFatia, float totalItems, float indexItem) {
		float itemsProgress;
		if(listener != null){			
			itemsProgress = indexItem / totalItems;
			listener.onProgressChange("Parser: "+uf, message+"("+indexItem+"/"+totalItems+")", (progressStart+(itemsProgress*jobsFatia)*fatia)*100, itemsProgress*100);
		}
	}
	
	public abstract boolean containsUF(String uf);
	
	public abstract Eleicao readEleicao() throws IOException;

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
