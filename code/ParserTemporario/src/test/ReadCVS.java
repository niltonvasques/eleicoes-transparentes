package test;

import java.util.List;

public class ReadCVS {

	public static void main(String[] args) {
		List<PrestContasCandidatoDespesa> l = ParserPrestacaoContasCandidatoDespesa.parsing("DespesasCandidatos.txt");
		Transacao t;
		for(PrestContasCandidatoDespesa p:l)
			t = ParserPrestacaoContasCandidatoDespesa.populate(p);
		
		System.out.println("Done");
	}

}