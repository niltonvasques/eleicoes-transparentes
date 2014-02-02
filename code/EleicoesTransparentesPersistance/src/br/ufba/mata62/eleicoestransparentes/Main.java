package br.ufba.mata62.eleicoestransparentes;

import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;


public class Main {
	
	public static void main(String[] args) {
		
//		Seed.createTables();
		
		Comunicacao comm = new Comunicacao();
		
		SetorEconomico setor = new SetorEconomico();
		setor.setCodSetorEco("00023");
		setor.setNome("TRANSPORTE");
		
		try {
			comm.insereSetorEconomico(setor);
			
			List<SetorEconomico> setores = comm.consultaSetoresEconomico();
			
			for (SetorEconomico ormSetorEconomico : setores) {
				System.out.print("id: "+ormSetorEconomico.getId());
				System.out.print(" nome: "+ormSetorEconomico.getNome());
				System.out.println(" codSetorEco: "+ormSetorEconomico.getCodSetorEco());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		Candidato candidato = new Candidato();
//		candidato.setAlfabetizado(true);
//		candidato.setCargo("Prefeito");
//		candidato.setCpf("01232145612");
//		candidato.set
//		
//		
//		Bem bem = new Bem();
//
//		bem.setDescricao("FAZENDA NOVA IGUAÇU");
//		
//		bem.setValor(500000f);
//		
//		bem.setCandidato(candidato);
//		
//		comm.insereBem(bem);

	}
}
