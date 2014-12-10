package br.ufba.mata62.eleicoestransparentes.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.business.Facade;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserTSEStrategy;
import br.ufba.mata62.eleicoestransparentes.business.parser.ano2012.ComportamentoParser2012;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;

public class Menu {
	
	private static final String DEFAULT_ADMIN_PASS	= "matc89";
	
	private static final int SAIR 					= 0;
	private static final int CONSULTA_CANDIDATOS 	= 1;
	private static final int REALIZAR_PARSER 		= 2;
	private static final int EXIBIR_GRAFICO_1 		= 3;
	private static final int EXIBIR_GRAFICO_2 		= 4;
	private static final int EXIBIR_GRAFICO_3		= 5;
	private static final int EXIBIR_GRAFICO_4		= 6;
	
	public void start() {
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
					opcaoConsultaCandidatos();
					break;
					
				case REALIZAR_PARSER:
					if(solicitaSenhaAdmin()){
						opcaoRealizarParser();						
					}
					break;
					
				case EXIBIR_GRAFICO_1:
					opcaoExibirGrafico1();
					break;
					
				case EXIBIR_GRAFICO_2:
					opcaoExibirGrafico2();
					break;
					
				case EXIBIR_GRAFICO_3:
					opcaoExibirGrafico3();
					break;
					
				case EXIBIR_GRAFICO_4:
					opcaoExibirGrafico4();
					break;

				default:
					break;
				}
				if(opcao == 0) break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void desenhaMenu(){
		System.out.println("------------------------------------------------------------");
		System.out.println("(1) - Consulta Candidatos");
		System.out.println("(2) - Realizar Parser");
		System.out.println("(3) - Exibir gráfico 1");
		System.out.println("(4) - Exibir gráfico 2");
		System.out.println("(5) - Exibir gráfico 3");
		System.out.println("(6) - Exibir gráfico 4");
		System.out.println("(0) - Sair");
		System.out.println("------------------------------------------------------------");
		
	}
	
	private  int perguntaOpcao() throws IOException{
		System.out.println("Opção: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opcao = 0;
		String num = reader.readLine();
		try{
			opcao = Integer.valueOf(num);
		}catch(Exception e){
			
		}
		return opcao;
	}
	
	private boolean solicitaSenhaAdmin() throws IOException{
		System.out.println("Senha: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String senha = reader.readLine();
		if(!senha.equals(DEFAULT_ADMIN_PASS)){
			System.out.println("ERRO! Senha inválida!!!");
			return false;	
		}
		return true;
	}
	
	private  void opcaoConsultaCandidatos(){
		List<Candidato> candidatos = Facade.getInstanceFacade().consultarCandidatos();
		for (Candidato candidato2 : candidatos) {
			System.out.println(candidato2.getNome());
		}		
	}
	
	private void opcaoRealizarParser(){

		try {
			ParserTSEStrategy parser = new ParserTSEStrategy(new ComportamentoParser2012());
			parser.resetarParser();
			parser.realizarParser();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void opcaoExibirGrafico1(){
		
	}
	
	private void opcaoExibirGrafico2(){
		
	}
	
	private void opcaoExibirGrafico3(){
		
	}
	
	private void opcaoExibirGrafico4(){
		
	}
	
	
}
