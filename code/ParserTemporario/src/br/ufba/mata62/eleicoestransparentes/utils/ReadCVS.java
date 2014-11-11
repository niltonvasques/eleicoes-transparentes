package br.ufba.mata62.eleicoestransparentes.utils;

import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.business.dados.BemCandidato;
import br.ufba.mata62.eleicoestransparentes.business.dados.ConsultaCandidato;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasCandidatoDespesa;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasCandidatoReceita;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasComiteDespesa;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasComiteReceita;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasPartidoDespesa;
import br.ufba.mata62.eleicoestransparentes.business.dados.PrestContasPartidoReceita;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserBemCandidato;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserConsultaCandidato;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasCandidatoDespesa;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasCandidatoReceita;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasComiteDespesa;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasComiteReceita;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasPartidoDespesa;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserPrestacaoContasPartidoReceita;
import br.ufba.mata62.eleicoestransparentes.model.Bem;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;

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
	

	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Bem> readBens(String uf) {
		ArrayList<Bem> bens = new ArrayList<Bem>();
		String path = Path.pathRoot +Path.FLD_BEM+Path.SEPARATOR+Path.FLD_BEM+(Path.FILE_BEM_UF.replace("$UF$", uf));
		List<BemCandidato> bcs = ParserBemCandidato.parsing(path);
		Bem b = null;
		for (BemCandidato p : bcs) {
			b = ParserBemCandidato.populate(p);
			bens.add(b);
		}
		return bens;
	}
	
	/**
	 * Lê dos arquivos correspondentes
	 * 
	 * @param uf - Unidades Federadas. ver Path.UFS	 
	 * 
	 * */
	public static List<Candidato> readCandidatos(String uf) {
		ArrayList<Candidato> bens = new ArrayList<Candidato>();
		String path = Path.pathRoot +Path.FLD_CONSULTA_CANDIDATO+Path.SEPARATOR+Path.FLD_CONSULTA_CANDIDATO+(Path.FILE_BEM_UF.replace("$UF$", uf));
		List<ConsultaCandidato> bcs = ParserConsultaCandidato.parsing(path);
		Candidato camd = null;
		for (ConsultaCandidato p : bcs) {
			camd = ParserConsultaCandidato.populate(p);
			bens.add(camd);
		}
		return bens;
	}
	
	public static void main(String[] args) {
		
		for (String uf : Path.UFS) {
			List<Bem> bens = ReadCVS.readBens(uf);
			for (Bem bem : bens) {
				System.out.println(bem);
			}
		}
		System.out.println("Done");
	}
	

}