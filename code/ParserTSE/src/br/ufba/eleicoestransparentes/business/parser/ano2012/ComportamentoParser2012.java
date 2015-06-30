package br.ufba.eleicoestransparentes.business.parser.ano2012;

import java.io.IOException;
import java.util.List;

import br.ufba.eleicoestransparentes.business.parser.ComportamentoParser;
import br.ufba.eleicoestransparentes.business.parser.ParserFile.OnReadDataListener;
import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Eleicao;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.util.Path;

public class ComportamentoParser2012 extends ComportamentoParser{
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public Eleicao readEleicao() throws IOException {
		Eleicao eleicao = new Eleicao();
		eleicao.setAno("2012");
		eleicao.setTipo("municipal");
		return eleicao;
	}
	
	/**
	 * @return true se a uf existe na eleição.
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS 
	 * */
	@Override
	public  boolean containsUF(String uf){
		if(uf.equals("DF")) return false;
		return true;
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasCandidatoReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_RECEITA_CANDIDATO;
		new ParserPrestacaoContasCandidatoReceita2012(path).parsing(listener);
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasComiteReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+  Path.FILE_RECEITA_COMITE;
		new ParserPrestacaoContasComiteReceita2012(path).parsing(listener);
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasPartidoReceita(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+   Path.FILE_RECEITA_PARTIDO;
		new ParserPrestacaoContasPartidoReceita2012(path).parsing(listener);
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasCandidatoDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+ Path.SEPARATOR+uf+Path.SEPARATOR+Path.FILE_DESPESA_CANDIDATO;
		new ParserPrestacaoContasCandidatoDespesa2012(path).parsing(listener);
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasComiteDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_COMITE;
		new ParserPrestacaoContasComiteDespesa2012(path).parsing(listener);
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readPrestacaoContasPartidoDespesa(String uf, OnReadDataListener<Transacao> listener) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_PARTIDO;
		new ParserPrestacaoContasPartidoDespesa2012(path).parsing(listener);
	}
	

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readBens(String uf, OnReadDataListener<Bem> listener) throws IOException {
		String path = Path.pathRoot +Path.FLD_BEM+Path.SEPARATOR+Path.FLD_BEM+(Path.UF_EXT.replace("$UF$", uf));
		new ParserBemCandidato2012(path).parsing(listener);
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public void readCandidatos(String uf, OnReadDataListener<Candidato> listener) throws IOException {
		String path = Path.pathRoot +Path.FLD_CONSULTA_CANDIDATO+Path.SEPARATOR+Path.FLD_CONSULTA_CANDIDATO+(Path.UF_EXT.replace("$UF$", uf));
		new ParserConsultaCandidato2012(path).parsing(listener);
		
	}
	
	public static void main(String[] args) {
		ComportamentoParser2012 cp = new ComportamentoParser2012();
//		for (String uf : Path.UFS) {
//			try {
//				List<Bem> bens = cp.readBens(uf);
//				for (Bem bem : bens) {
//					System.out.println(bem);
//				}
//			} catch (IOException e) {
//				System.err.println(uf);
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Done");
	}

}
