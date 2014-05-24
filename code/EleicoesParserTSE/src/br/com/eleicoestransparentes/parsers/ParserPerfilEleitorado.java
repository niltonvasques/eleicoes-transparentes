package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.PerfilEleitorado;

public class ParserPerfilEleitorado extends Parser {

	public ParserPerfilEleitorado(PerfilEleitorado perfilEleitorado,String path) {
		super(perfilEleitorado,perfilEleitorado.header,path);
	}

}
