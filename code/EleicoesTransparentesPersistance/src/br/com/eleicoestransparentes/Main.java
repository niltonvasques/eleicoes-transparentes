package br.com.eleicoestransparentes;

import java.sql.SQLException;
import java.util.List;

import br.com.eleicoestransparentes.persistence.beans.Bem;
import br.com.eleicoestransparentes.persistence.beans.Candidato;
import br.com.eleicoestransparentes.persistence.beans.Partido;
import br.com.eleicoestransparentes.persistence.beans.logic.PessoaFisicaDoador;
import br.com.eleicoestransparentes.persistence.beans.logic.PessoaJuridicaDoador;
import br.com.eleicoestransparentes.persistence.database.Comunicacao;


public class Main {
	
	public static void main(String[] args) {
		
		Comunicacao comm = new Comunicacao();
		comm.setDebug(true);
		try {
			testPartidoPorSigla(comm);
//			testPartidos(comm);
//			testCandidatosPorPartidoUF(comm);
//			testCandidatos(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		comm.close();

	}

	private static void testPartidoPorSigla(Comunicacao comm)
			throws SQLException {
		Partido partido = comm.consultaPartido("PT");
		System.out.println(partido.getNome());
	}

	private static void testPartidos(Comunicacao comm) throws SQLException {
		List<Partido> partidos = comm.consultaPartidos();
		for (Partido partido : partidos) {
			System.out.println(partido.getNome());
		}
	}

	private static void testCandidatosPorPartidoUF(Comunicacao comm) throws SQLException {
		List<Candidato> candidatos = comm.consultaCandidatos(1, "AC");
		for (Candidato candidato : candidatos) {
			System.out.println(candidato.getNome()+" "+candidato.getCargo());
		}
	}
	
	private static void testCandidatos(Comunicacao comm) throws SQLException {
		List<Candidato> candidatos = comm.consultaCandidatos();
		for (Candidato candidato : candidatos) {
			System.out.println(candidato.getNome()+" "+candidato.getCargo());
		}
	}
}
