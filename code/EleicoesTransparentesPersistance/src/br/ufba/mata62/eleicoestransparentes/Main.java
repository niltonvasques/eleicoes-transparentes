package br.ufba.mata62.eleicoestransparentes;

import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans.PessoaFisicaDoador;
import br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans.PessoaJuridicaDoador;


public class Main {
	
	public static void main(String[] args) {
		
//		Pessoa creditado = new PessoaFisica();
//		
//		System.out.println("ClassName: "+creditado.getClass().getSimpleName());
//		
//		Seed.createTables();
		
//		System.out.println(EProperties.findTopLevelDirectory());
//		
		Comunicacao comm = new Comunicacao();
		comm.setDebug(true);
//		
		try {
			
//			comm.consultaTransacaoCandidato("10000000756", "R");
//			List<PessoaJuridicaDoador> rankingPJ = comm.rankingMaioresDoadoresPessoaJuridica("AC");
//			List<PessoaFisicaDoador> rankingPF = comm.rankingMaioresDoadoresPessoaFisica("AC");
			List<Partido> partidos = comm.consultaPartidos();
			for (Partido partido : partidos) {
				System.out.println(partido.getNome());
			}
//			Candidato candi = comm.getCandidato("10000000757");
//			System.out.println(candi);
//			List<Bem> bens = comm.consultaBens(1);
//			Candidato cand = comm.getCandidato(1);
//			for (Bem bem : bens) {
//				System.out.println(cand.getNome()+" "+bem.getDescricao()+" "+bem.getValor());
//			}
//			for(DoadorWrapper d : ranking){
//				System.out.println("Nome: "+d.getPessoa().getNome()+" VALOR: "+d.getValor());
//			}
			
//			comm.consultaTransacaoCandidato("10000000756", "D");
			
//			comm.consultaTransacaoPartido(13,"AC","R");
//			
//			comm.consultaTransacaoPartido(13,"AC","R");
//			
//			comm.consultaTransacaoCandidato(13,"AC","R");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		
//		comm.close();
//		
//		SetorEconomico setor = new SetorEconomico();
//		setor.setCodSetorEco("00023");
//		setor.setNome("TRANSPORTE");
//		
//		try {
//			comm.insereSetorEconomico(setor);
//			
//			List<SetorEconomico> setores = comm.consultaSetoresEconomico();
//			
//			for (SetorEconomico ormSetorEconomico : setores) {
//				System.out.print("id: "+ormSetorEconomico.getId());
//				System.out.print(" nome: "+ormSetorEconomico.getNome());
//				System.out.println(" codSetorEco: "+ormSetorEconomico.getCodSetorEco());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			
//		}
		
		
		
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
