package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.BensCandidato;

public class ParserBensCandidato extends Parser {

	public ParserBensCandidato(BensCandidato bensCandidato,String path) {
		super(bensCandidato,bensCandidato.header,path);
	}

}
