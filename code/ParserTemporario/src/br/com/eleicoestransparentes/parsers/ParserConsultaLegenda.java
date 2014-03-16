package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.ConsultaLegenda;

public class ParserConsultaLegenda extends Parser {

	public ParserConsultaLegenda(ConsultaLegenda consultaLegenda,String path) {
		super(consultaLegenda,consultaLegenda.header,path);
	}

}
