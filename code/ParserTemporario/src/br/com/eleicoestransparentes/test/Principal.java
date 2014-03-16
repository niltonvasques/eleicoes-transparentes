package br.com.eleicoestransparentes.test;

import br.com.eleicoestransparentes.CVSFiles.BensCandidato;
import br.com.eleicoestransparentes.parsers.ParserBensCandidato;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {
		BensCandidato bc = new BensCandidato();
		new ParserBensCandidato(bc,"/home/flavio/Área de Trabalho/tse/candidatos/bens candidatos/bem_candidato_2012/bem_candidato_2012_AC.txt").parse();
	}

}