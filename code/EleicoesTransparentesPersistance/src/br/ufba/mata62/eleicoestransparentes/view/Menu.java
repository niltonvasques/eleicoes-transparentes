package br.ufba.mata62.eleicoestransparentes.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;

public class Menu {
	private static final int SAIR = 0;
	private static final int CONSULTA_CANDIDATOS = 1;
	
	public void start() {
		Comunicacao comm = new Comunicacao();
		try {
			boolean running = true;
			while(running){
				desenhaMenu();
				int opcao = perguntaOpcao();
				switch (opcao) {
				case SAIR:
					running = false;
					break;
					
				case CONSULTA_CANDIDATOS:
					opcaoConsultaCandidatos(comm);
					break;

				default:
					break;
				}
				if(opcao == 0) break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		comm.close();
	}
	
	private  void desenhaMenu(){
		System.out.println("------------------------------------------------------------");
		System.out.println("(1) - Consulta Candidatos");
		System.out.println("(0) - Sair");
		System.out.println("------------------------------------------------------------");
		
	}
	private  int perguntaOpcao() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opcao = 0;
		String num = reader.readLine();
		try{
			opcao = Integer.valueOf(num);
		}catch(Exception e){
			
		}
		return opcao;
	}
	
	private  void opcaoConsultaCandidatos(Comunicacao comm){
		try {
			List<Candidato> candidato = comm.consultaCandidatos();
			for (Candidato candidato2 : candidato) {
				System.out.println(candidato2.getNome());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
