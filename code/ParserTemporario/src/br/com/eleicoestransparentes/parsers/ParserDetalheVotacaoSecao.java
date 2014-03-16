package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.DetalheVotacaoSecao;

public class ParserDetalheVotacaoSecao extends Parser {

	public ParserDetalheVotacaoSecao(DetalheVotacaoSecao detalheVotacaoSecao,String path) {
		super(detalheVotacaoSecao,detalheVotacaoSecao.header,path);
	}

}
