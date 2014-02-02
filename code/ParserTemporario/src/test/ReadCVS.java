package test;

import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;

public class ReadCVS {

	public static void main(String[] args) {
//		List<PrestContasCandidatoReceita> lcandrec = ParserPrestacaoContasCandidatoReceita.parsing("ReceitasCandidatos.txt");
//		List<PrestContasCandidatoDespesa> lcandesp = ParserPrestacaoContasCandidatoDespesa.parsing("DespesasCandidatos.txt");
//		List<PrestContasComiteReceita> lcomrec = ParserPrestacaoContasComiteReceita.parsing("ReceitasComites.txt");
//		List<PrestContasComiteDespesa> lcomdes = ParserPrestacaoContasComiteDespesa.parsing("DespesasComites.txt");
//		List<PrestContasPartidoReceita> lparrec = ParserPrestacaoContasPartidoReceita.parsing("ReceitasPartidos.txt");
//		List<PrestContasPartidoDespesa> lpardes = ParserPrestacaoContasPartidoDespesa.parsing("DespesasPartidos.txt");
//		
//		ArrayList<Transacao> lt= new ArrayList<Transacao>();
//		Transacao t = null;
//		for(PrestContasCandidatoReceita p:lcandrec){
//			t = ParserPrestacaoContasCandidatoReceita.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
//		for(PrestContasCandidatoDespesa p:lcandesp){
//			t = ParserPrestacaoContasCandidatoDespesa.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
//		for(PrestContasComiteReceita p:lcomrec){
//			t = ParserPrestacaoContasComiteReceita.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
//		for(PrestContasComiteDespesa p:lcomdes){
//			t = ParserPrestacaoContasComiteDespesa.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
//		for(PrestContasPartidoReceita p:lparrec){
//			t = ParserPrestacaoContasPartidoReceita.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
//		for(PrestContasPartidoDespesa p:lpardes){
//			t = ParserPrestacaoContasPartidoDespesa.populate(p);
//			lt.add(t);
//			System.out.println(t);	
//		}
		
		List<BemCandidato> bc = ParserBemCandidato.parsing("bem_candidato_2012_AC.txt");
		ArrayList<Bem> bcl= new ArrayList<Bem>();
		Bem b = null;
		for(BemCandidato bcd:bc){
			b = ParserBemCandidato.populate(bcd);
			bcl.add(b);
			System.out.println(b);	
		}
	}

}