package br.ufba.mata62.eleicoestransparentes;


import java.io.IOException;
import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.business.parser.ParserTSE;
import br.ufba.mata62.eleicoestransparentes.business.parser.ano2012.ComportamentoParser2012;
import br.ufba.mata62.eleicoestransparentes.model.Bem;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.model.database.Seed;


public class MainBD {
	
	public static void main(String[] args) {
		
		try {
			ParserTSE parser = new ParserTSE(new ComportamentoParser2012());
			parser.resetarParser();
			parser.realizarParser();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void run(Transacao t,Comunicacao comm){
		try {
			comm.insereTransacao(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void run(Bem bem, Comunicacao comm){
		try {
			comm.insereBem(bem);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void run(Candidato cand, Comunicacao comm){
		try {
			comm.insereCandidato(cand);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
