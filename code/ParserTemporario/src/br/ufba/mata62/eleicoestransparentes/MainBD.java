package br.ufba.mata62.eleicoestransparentes;


import java.sql.SQLException;

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

		Comunicacao comm = new Comunicacao();
<<<<<<< HEAD
		for (Transacao t : ReadCVS.readPrestacaoContasPartidoDespesa(Path.UFS[0])) {
=======
		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
>>>>>>> 55ad02230c7ea1816e3a66527db460e667123a2a
			run(t,comm);
		}
		
//		for(Candidato c : ReadCVS.readCandidatos(Path.UFS[0])){
//			run(c,comm);
//		}
<<<<<<< HEAD
//		
=======
		
>>>>>>> 55ad02230c7ea1816e3a66527db460e667123a2a
//		for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
//			run(b,comm);
//		}
//		
//		comm.close();
		
		

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
