package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.VotoSecao;

public class ParserVotoSecao extends Parser{

	public ParserVotoSecao(VotoSecao votoSecao, String path) {
		super(votoSecao, votoSecao.header, path);
	}

}
