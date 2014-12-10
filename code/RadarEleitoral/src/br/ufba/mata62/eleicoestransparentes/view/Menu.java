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
	
	
}
