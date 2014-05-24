package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.ConsultaCandidato;

public class ParserConsultaCandidato extends Parser {

	public ParserConsultaCandidato(ConsultaCandidato consultaCandidato,String path) {
		super(consultaCandidato,consultaCandidato.header,path);
	}

}
