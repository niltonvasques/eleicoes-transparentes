package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.DetalheVotacaoMunZona;

public class ParserDetalheVotacaoMunZona extends Parser {

	public ParserDetalheVotacaoMunZona(DetalheVotacaoMunZona detalheVotacaoMunZona,String path) {
		super(detalheVotacaoMunZona,detalheVotacaoMunZona.header,path);
	}

}
