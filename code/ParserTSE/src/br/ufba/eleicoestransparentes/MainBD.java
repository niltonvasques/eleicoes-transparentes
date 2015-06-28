package br.ufba.eleicoestransparentes;


import java.sql.SQLException;

import br.ufba.eleicoestransparentes.business.Facade;
import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Transacao;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;


public class MainBD {
	
	public static void main(String[] args) {
		
		try {
			Facade.getInstanceFacade().resetarParser();
			Facade.getInstanceFacade().realizarParser();
		} catch (Exception e) {
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
