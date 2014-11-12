package br.ufba.mata62.eleicoestransparentes.business.parser.ano2012;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.business.parser.ComportamentoParser;
import br.ufba.mata62.eleicoestransparentes.model.Bem;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.utils.Path;

public class ComportamentoParser2012 extends ComportamentoParser{

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasCandidatoReceita(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_RECEITA_CANDIDATO;
		return new ParserPrestacaoContasCandidatoReceita2012(path).parsing();
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasComiteReceita(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+  Path.FILE_RECEITA_COMITE;
		return new ParserPrestacaoContasComiteReceita2012(path).parsing();
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasPartidoReceita(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+   Path.FILE_RECEITA_PARTIDO;
		return new ParserPrestacaoContasPartidoReceita2012(path).parsing();
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasCandidatoDespesa(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+ Path.SEPARATOR+uf+Path.SEPARATOR+Path.FILE_DESPESA_CANDIDATO;
		return new ParserPrestacaoContasCandidatoDespesa2012(path).parsing();
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasComiteDespesa(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_COMITE;
		return new ParserPrestacaoContasComiteDespesa2012(path).parsing();
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Transacao> readPrestacaoContasPartidoDespesa(String uf) throws IOException {
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_PARTIDO;
		return new ParserPrestacaoContasPartidoDespesa2012(path).parsing();
	}
	

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Bem> readBens(String uf) throws IOException {
		String path = Path.pathRoot +Path.FLD_BEM+Path.SEPARATOR+Path.FLD_BEM+(Path.UF_EXT.replace("$UF$", uf));
		return new ParserBemCandidato2012(path).parsing();
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * @throws IOException 
	 * 
	 * */
	@Override
	public List<Candidato> readCandidatos(String uf) throws IOException {
		String path = Path.pathRoot +Path.FLD_CONSULTA_CANDIDATO+Path.SEPARATOR+Path.FLD_CONSULTA_CANDIDATO+(Path.UF_EXT.replace("$UF$", uf));
		return new ParserConsultaCandidato2012(path).parsing();
		
	}
	
	public static void main(String[] args) {
		ComportamentoParser2012 cp = new ComportamentoParser2012();
		for (String uf : Path.UFS) {
			try {
				List<Bem> bens = cp.readBens(uf);
				for (Bem bem : bens) {
					System.out.println(bem);
				}
			} catch (IOException e) {
				System.err.println(uf);
				e.printStackTrace();
			}
		}
		System.out.println("Done");
	}

}
