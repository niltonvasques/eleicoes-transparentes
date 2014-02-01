package test;

import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class ReadCVS {

	public static void main(String[] args) {
		List<PrestContasCandidatoReceita> l = ParserPrestacaoContasCandidatoReceita.parsing("ReceitasCandidatos.txt");
		ArrayList<Transacao> lt= new ArrayList<Transacao>();
		Transacao t = null;
		for(PrestContasCandidatoReceita p:l){
			t = ParserPrestacaoContasCandidatoReceita.populate(p);
			lt.add(t);
			System.out.println(t);
		}
		
		System.out.println("Done");
	}

}