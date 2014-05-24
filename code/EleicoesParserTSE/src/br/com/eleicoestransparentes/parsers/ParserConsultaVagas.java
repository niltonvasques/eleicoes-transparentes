package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.ConsultaVagas;

public class ParserConsultaVagas extends Parser {

	public ParserConsultaVagas(ConsultaVagas consultaVagas,String path) {
		super(consultaVagas,consultaVagas.header,path);
	}

}
