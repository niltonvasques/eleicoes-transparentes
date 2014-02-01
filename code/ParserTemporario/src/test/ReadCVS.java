package test;

import java.util.List;

public class ReadCVS {

	public static void main(String[] args) {
		List<PrestContasCandidatoReceita> l = ParserPrestacaoContasCandidatoReceita.parsing("ReceitasCandidatos.txt");
		Transacao t;
//		for(PrestContasCandidatoReceita p:l)
			t = ParserPrestacaoContasCandidatoReceita.populate(l.get(0));
		
		System.out.println("Done");
	}

}