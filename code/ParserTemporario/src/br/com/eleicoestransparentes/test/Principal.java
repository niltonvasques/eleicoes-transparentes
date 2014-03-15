package br.com.eleicoestransparentes.test;

import br.com.eleicoestransparentes.CVSFiles.ConsultaLegenda;
import br.com.eleicoestransparentes.parsers.ParserLegenda;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {
		ConsultaLegenda consultaLegenda = new ConsultaLegenda();
		ParserLegenda.parse(consultaLegenda);
	}

}