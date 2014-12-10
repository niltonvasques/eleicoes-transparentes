package br.ufba.mata62.eleicoestransparentes.business;

import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;

public class ExemploGrafico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AgenteEleitoral agente = new AgenteEleitoral();
		PessoaFisica fis = new PessoaFisica();
		agente.setPessoa(fis); 
		agente.getPessoa().setNome("Vinicius Gesteira");
	    PerfilPartido cand = new PerfilPartido(agente);
	    
	    Comunicacao comm = new Comunicacao();
	    
	    try {
			List<Candidato> candidato = comm.consultaCandidatos();
			for (Candidato candidato2 : candidato) {
				System.out.println(candidato2.getNome());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(cand.formatarPerfilAgenteEleitoral());
	    
	}

}
