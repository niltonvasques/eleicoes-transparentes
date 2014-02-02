package test;

import java.util.ArrayList;
import java.util.List;

import test.dadosBrutos.PrestContasCandidatoDespesa;
import test.dadosBrutos.PrestContasCandidatoReceita;
import test.dadosBrutos.PrestContasComiteDespesa;
import test.dadosBrutos.PrestContasComiteReceita;
import test.dadosBrutos.PrestContasPartidoDespesa;
import test.dadosBrutos.PrestContasPartidoReceita;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class ReadCVS {

	public static void main(String[] args) {
		List<PrestContasCandidatoReceita> lcandrec = ParserPrestacaoContasCandidatoReceita.parsing("ReceitasCandidatos.txt");
		List<PrestContasCandidatoDespesa> lcandesp = ParserPrestacaoContasCandidatoDespesa.parsing("DespesasCandidatos.txt");
		List<PrestContasComiteReceita> lcomrec = ParserPrestacaoContasComiteReceita.parsing("ReceitasComites.txt");
		List<PrestContasComiteDespesa> lcomdes = ParserPrestacaoContasComiteDespesa.parsing("DespesasComites.txt");
		List<PrestContasPartidoReceita> lparrec = ParserPrestacaoContasPartidoReceita.parsing("ReceitasPartidos.txt");
		List<PrestContasPartidoDespesa> lpardes = ParserPrestacaoContasPartidoDespesa.parsing("DespesasPartidos.txt");
		
		ArrayList<Transacao> lt= new ArrayList<Transacao>();
		Transacao t = null;
		for(PrestContasCandidatoReceita p:lcandrec){
			t = ParserPrestacaoContasCandidatoReceita.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
		for(PrestContasCandidatoDespesa p:lcandesp){
			t = ParserPrestacaoContasCandidatoDespesa.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
		for(PrestContasComiteReceita p:lcomrec){
			t = ParserPrestacaoContasComiteReceita.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
		for(PrestContasComiteDespesa p:lcomdes){
			t = ParserPrestacaoContasComiteDespesa.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
		for(PrestContasPartidoReceita p:lparrec){
			t = ParserPrestacaoContasPartidoReceita.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
		for(PrestContasPartidoDespesa p:lpardes){
			t = ParserPrestacaoContasPartidoDespesa.populate(p);
			lt.add(t);
			System.out.println(t);	
		}
	}

}