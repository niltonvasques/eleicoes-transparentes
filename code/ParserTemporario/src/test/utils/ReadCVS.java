package test.utils;

import java.util.ArrayList;
import java.util.List;

import test.ParserPrestacaoContasCandidatoDespesa;
import test.ParserPrestacaoContasCandidatoReceita;
import test.ParserPrestacaoContasComiteDespesa;
import test.ParserPrestacaoContasComiteReceita;
import test.ParserPrestacaoContasPartidoDespesa;
import test.ParserPrestacaoContasPartidoReceita;
import test.dadosBrutos.PrestContasCandidatoDespesa;
import test.dadosBrutos.PrestContasCandidatoReceita;
import test.dadosBrutos.PrestContasComiteDespesa;
import test.dadosBrutos.PrestContasComiteReceita;
import test.dadosBrutos.PrestContasPartidoDespesa;
import test.dadosBrutos.PrestContasPartidoReceita;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class ReadCVS {

	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Transacao> readPrestacaoContasCandidatoReceita(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_RECEITA_CANDIDATO;
		List<PrestContasCandidatoReceita> contas = ParserPrestacaoContasCandidatoReceita.parsing(path);
		Transacao t = null;
		for (PrestContasCandidatoReceita p : contas) {
			t = ParserPrestacaoContasCandidatoReceita.populate(p);
			trans.add(t);
		}
		return trans;
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Transacao> readPrestacaoContasComiteReceita(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+  Path.FILE_RECEITA_COMITE;
		List<PrestContasComiteReceita> contas = ParserPrestacaoContasComiteReceita.parsing(path);
		Transacao t = null;
		for (PrestContasComiteReceita p : contas) {
			t = ParserPrestacaoContasComiteReceita.populate(p);
			trans.add(t);
		}
		return trans;
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Transacao> readPrestacaoContasPartidoReceita(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+ Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+   Path.FILE_RECEITA_PARTIDO;
		List<PrestContasPartidoReceita> contas = ParserPrestacaoContasPartidoReceita.parsing(path);
		Transacao t = null;
		for (PrestContasPartidoReceita p : contas) {
			t = ParserPrestacaoContasPartidoReceita.populate(p);
			trans.add(t);
		}
		return trans;
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	
	public static List<Transacao> readPrestacaoContasCandidatoDespesa(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO +Path.SEPARATOR+ Path.FLD_CANDIDATO+ Path.SEPARATOR+uf+Path.SEPARATOR+Path.FILE_DESPESA_CANDIDATO;
		List<PrestContasCandidatoDespesa> contas = ParserPrestacaoContasCandidatoDespesa.parsing(path);
		Transacao t = null;
		for (PrestContasCandidatoDespesa p : contas) {
			t = ParserPrestacaoContasCandidatoDespesa.populate(p);
			trans.add(t);
		}
		return trans;
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Transacao> readPrestacaoContasComiteDespesa(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_COMITE+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_COMITE;
		List<PrestContasComiteDespesa> contas = ParserPrestacaoContasComiteDespesa.parsing(path);
		Transacao t = null;
		for (PrestContasComiteDespesa p : contas) {
			t = ParserPrestacaoContasComiteDespesa.populate(p);
			trans.add(t);
		}
		return trans;
	}

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Transacao> readPrestacaoContasPartidoDespesa(String uf) {
		ArrayList<Transacao> trans = new ArrayList<Transacao>();
		String path = Path.pathRoot + Path.FLD_PRESTACAO  +Path.SEPARATOR+  Path.FLD_PARTIDO+Path.SEPARATOR+uf+Path.SEPARATOR+ Path.FILE_DESPESA_PARTIDO;
		List<PrestContasPartidoDespesa> contas = ParserPrestacaoContasPartidoDespesa.parsing(path);
		Transacao t = null;
		for (PrestContasPartidoDespesa p : contas) {
			t = ParserPrestacaoContasPartidoDespesa.populate(p);
			trans.add(t);
		}
		return trans;
	}
	
	public static void main(String[] args) {
		
		for (String uf : Path.UFS) {
			List<Transacao> trans = ReadCVS.readPrestacaoContasPartidoReceita(uf);
			for (Transacao transacao : trans) {
				System.out.println(transacao);
			}
		}
		System.out.println("Done");
	}
	

}