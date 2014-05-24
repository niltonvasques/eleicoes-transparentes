package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.VotacaoCandidatoMunZona;

public class ParserVotacaoCandidatoMunZona extends Parser{
	
	public ParserVotacaoCandidatoMunZona(VotacaoCandidatoMunZona votacaoCandidatoMunZona,String path){
		super(votacaoCandidatoMunZona,votacaoCandidatoMunZona.header,path);
	}

}
