package br.com.eleicoestransparentes.parsers;

import br.com.eleicoestransparentes.CVSFiles.VotacaoPartidoMunZona;

public class ParserVotacaoPartidoMunZona extends Parser{
	
	public ParserVotacaoPartidoMunZona(VotacaoPartidoMunZona votacaoPartidoMunZona,String path){
		super(votacaoPartidoMunZona,votacaoPartidoMunZona.header,path);
	}

}
