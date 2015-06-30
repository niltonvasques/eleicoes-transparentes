package br.ufba.eleicoestransparentes.business.parser;

import java.io.IOException;
import java.sql.SQLException;

import br.ufba.eleicoestransparentes.business.parser.ParserFile.OnReadDataListener;
import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Eleicao;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.eleicoestransparentes.util.EProperties;
import br.ufba.mata62.eleicoestransparentes.util.Path;

public abstract class ComportamentoParser {

	protected OnProgressListener listener;
	
	public interface OnProgressListener{
		public void onProgressChange(String job, String message, float progress, float taskProgress);
	}
	
	private float progressStart, jobsFatia;
	
	
	public void seguirModelo() throws IOException, SQLException {
		float totalUFs = Path.UFS.length;
		float ufIndex = 0;
		final float fatia = 1/totalUFs;
		
		String inicialUF = EProperties.getStartUF();
		final Comunicacao comm = new Comunicacao();
		
		final Eleicao eleicao = comm.insereEleicao(readEleicao());
		
		for (final String uf : Path.UFS) {
			
			
			progressStart = ufIndex / totalUFs;
			jobsFatia = 1.0f / 8.0f;
			
			if(inicialUF != null && uf.compareTo(inicialUF) < 0){
				ufIndex++;
				continue;
			}
			
			if(!containsUF(uf)){
				ufIndex++;
				continue;
			}

			readCandidatos(uf, new OnReadDataListener<Candidato>() {
				@Override
				public void onRead(Candidato data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereCandidato(data);
						
						updateProgress(fatia, uf, "readCandidatos", progressStart, jobsFatia, numberOfLines, line);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			
			progressStart += jobsFatia*fatia;

			readPrestacaoContasComiteDespesa(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasComiteDespesa", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
			progressStart += jobsFatia*fatia;
//
			readPrestacaoContasComiteReceita(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasComiteReceita", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
			progressStart += jobsFatia*fatia;
//
			readPrestacaoContasPartidoReceita(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasPartidoReceita", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
			});
			progressStart += jobsFatia*fatia;
//
			readPrestacaoContasPartidoDespesa(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasPartidoDespesa", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
			progressStart += jobsFatia*fatia;
//
			readPrestacaoContasCandidatoDespesa(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasCandidatoDespesa", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
			progressStart += jobsFatia*fatia;
//
			readPrestacaoContasCandidatoReceita(uf, new OnReadDataListener<Transacao>() {
				@Override
				public void onRead(Transacao data, int line, int numberOfLines) {
					try {
						data.setEleicao(eleicao);
						comm.insereTransacao(data);
						
						updateProgress(fatia, uf, "readPrestacaoContasCandidatoReceita", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
			progressStart += jobsFatia*fatia;
//
			readBens(uf, new OnReadDataListener<Bem>() {
				@Override
				public void onRead(Bem data, int line, int numberOfLines) {
					try {
						comm.insereBem(data);
						
						updateProgress(fatia, uf, "readBens", progressStart, jobsFatia, numberOfLines,	line);
					} catch (SQLException e) {
						e.printStackTrace();
					}					
				}
			});
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

	public abstract void readPrestacaoContasCandidatoReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readPrestacaoContasComiteReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readPrestacaoContasPartidoReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */

	public abstract void readPrestacaoContasCandidatoDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readPrestacaoContasComiteDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readPrestacaoContasPartidoDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException;


	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readBens(String uf, OnReadDataListener<Bem> listener) throws IOException;

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	public abstract void readCandidatos(String uf, OnReadDataListener<Candidato> listener) throws IOException;

	public void setListener(OnProgressListener listener) {
		this.listener = listener;
	}	
	
}
