package br.ufba.eleicoestransparentes.business.grafico;

import java.sql.SQLException;
import java.util.List;

import br.ufba.eleicoestransparentes.business.perfil.PerfilPartido;
import br.ufba.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.PessoaFisica;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;

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
