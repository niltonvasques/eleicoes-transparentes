package br.ufba.mata62.eleicoestransparentes.connection.test;

import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;



public class Main {

	
//	EleicoesTransparentesPersistance
	
	public static void main(String[] args) {
		
		EleicoesSOAP eleicoes = new EleicoesSOAP(false);
		
		System.out.println("AppPath: "+eleicoes.consultaApplicationPath());;
		
		System.out.println("CreateTables: "+eleicoes.createTables());
		
//		
//		List<SetorEconomico> setores = eleicoes.consultaSetoresEconomico();
//		
//		for (SetorEconomico setorEconomico : setores) {
//			System.out.println("Setor: "+setorEconomico.getNome());
//		}
//		
//		List<Candidato> candidatos = eleicoes.consultaCandidatos();
//		
//		for (Candidato candidato : candidatos) {
//			System.out.println("Candidato: "+candidato.getNome());
//		}
		
		
	}
	

}
