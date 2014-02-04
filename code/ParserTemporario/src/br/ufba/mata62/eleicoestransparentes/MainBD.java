package br.ufba.mata62.eleicoestransparentes;


import java.sql.SQLException;

import br.ufba.mata62.eleicoestransparentes.EProperties;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Seed;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;
import br.ufba.mata62.eleicoestransparentes.utils.Path;
import br.ufba.mata62.eleicoestransparentes.utils.ReadCVS;


public class MainBD {
	
	public static void main(String[] args) {
		
		Seed.createTables();

<<<<<<< HEAD
		Comunicacao comm = new Comunicacao();
//		for (Transacao t : ReadCVS.readPrestacaoContasPartidoDespesa(Path.UFS[0])) {
//			run(t,comm);
//		}
		
		for(Candidato c : ReadCVS.readCandidatos(Path.UFS[0])){
			run(c,comm);
		}
		
//		
=======
//		Comunicacao comm = new Comunicacao();
//		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
//			run(t,comm);
//		}
		
//		for(Candidato c : ReadCVS.readCandidatos(Path.UFS[0])){
//			run(c,comm);
//		}
		
>>>>>>> 15dde06ef25b89c1688483bc7ea6a3fcdf9fe98c
//		for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
//			run(b,comm);
//		}
//		
//		comm.close();
		
		try {
			Comunicacao comm = new Comunicacao();
			
			for (Candidato t : ReadCVS.readCandidatos(Path.UFS[0])) {
				comm.insereCandidato(t);
			}
		
			for (Transacao t : ReadCVS.readPrestacaoContasPartidoReceita(Path.UFS[0])) {
				comm.insereTransacao(t);
			}
			
			for (Transacao t : ReadCVS.readPrestacaoContasPartidoDespesa(Path.UFS[0])) {
				comm.insereTransacao(t);
			}
			
			for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
				comm.insereTransacao(t);
			}
			
			for (Transacao t : ReadCVS.readPrestacaoContasCandidatoReceita(Path.UFS[0])) {
				comm.insereTransacao(t);
			}
			
			for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
				comm.insereBem(b);
			}
	//		
			comm.close();
		
		} catch (SQLException e) {
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
