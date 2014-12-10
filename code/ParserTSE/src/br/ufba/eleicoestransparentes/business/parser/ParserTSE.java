package br.ufba.eleicoestransparentes.business.parser;

import java.io.IOException;
import java.sql.SQLException;

import br.ufba.eleicoestransparentes.model.database.Seed;

public class ParserTSE {
	private ComportamentoParser comportamento;
	
	public ParserTSE(ComportamentoParser comportamento) {
		this.comportamento = comportamento;
	}
	
	public void realizarParser() throws IOException, SQLException{
		comportamento.seguirModelo();
	}
	
	public void resetarParser(){
		Seed.dropTables();
		Seed.createTables();
	}

}
