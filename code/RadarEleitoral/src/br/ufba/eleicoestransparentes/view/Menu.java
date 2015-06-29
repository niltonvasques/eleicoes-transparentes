package br.ufba.eleicoestransparentes.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jfree.ui.RefineryUtilities;

import br.ufba.eleicoestransparentes.business.Facade;
import br.ufba.eleicoestransparentes.business.grafico.GraficoFinal;
import br.ufba.eleicoestransparentes.business.parser.ComportamentoParser.OnProgressListener;
import br.ufba.eleicoestransparentes.business.perfil.PerfilCandidato;
import br.ufba.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.util.Util;
import br.ufba.eleicoestransparentes.view.chart.GraficoBarra;
import br.ufba.eleicoestransparentes.view.chart.GraficoPizza;

import com.google.gson.Gson;


public class Menu {

	private static final String DEFAULT_ADMIN_PASS	= "matb14";

	private static final int SAIR 					= 0;
	private static final int CONSULTA_CANDIDATOS 	= 1;
	private static final int REALIZAR_PARSER 		= 2;
	private static final int EXIBIR_GRAFICO_1 		= 3;
	private static final int EXIBIR_GRAFICO_2 		= 4;
	private static final int EXIBIR_GRAFICO_3 		= 5;
	private static final int EXIBIR_GRAFICO_4 		= 6;
	private static final int CONSULTA_CANDIDATOS_NUM	= 7;
	private static final int RESETAR_PARSER 		= 8;

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
					
				case RESETAR_PARSER:
					if(solicitaSenhaAdmin()){
						opcaoResetarParser();						
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

				case CONSULTA_CANDIDATOS_NUM:
					opcaoExibirPerfilCandidatoPorNumero();
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
		System.out.println("-----------------------------MENU---------------------------");
		System.out.println("(1) - Consulta Candidatos");
		System.out.println("(2) - Realizar Parser");
		System.out.println("(3) - Gráfico Barra Ranking Maiores Financiadores PF ");
		System.out.println("(4) - Gráfico Pizza Ranking Maiores Financiadores PF ");
		System.out.println("(5) - Gráfico Barra Ranking Maiores Financiadores PJ ");
		System.out.println("(6) - Gráfico Barra Ranking Candidatos ");
		System.out.println("(7) - Consulta Candidatos por número");
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
		List<AgenteEleitoral> candidatos = Facade.getInstanceFacade().consultarCandidatos();
		for (AgenteEleitoral c : candidatos) {
			System.out.println(c.getPessoa().getNome());
		}		
	}

	private void opcaoRealizarParser(){
		final ProgressBarTraditional progressBar = new ProgressBarTraditional();
//		ProgressBarRotating progress = new ProgressBarRotating();
		progressBar.start();
		Facade.getInstanceFacade().realizarParser(new OnProgressListener() {			
			@Override
			public void onProgressChange(String job, String message, float progress) {
//				System.out.println(job+" "+message+" "+Util.round(progress, 4)+"%");
				progressBar.update((float)Util.round(progress, 4), job+" "+message);
				
			}
		});
		progressBar.finish();
	}
	
	private void opcaoResetarParser() {
		Facade.getInstanceFacade().resetarParser();
	}

	private void opcaoExibirGrafico1(){
		String json = Facade.getInstanceFacade().visualizarGraficoDoadoresPF();
		System.out.println(json);
		Gson gson = new Gson();
		GraficoFinal graficoParse = gson.fromJson(json, GraficoFinal.class);
		System.out.println(graficoParse.getClass());

		System.out.println(graficoParse.getNome());
		GraficoBarra view1 = new GraficoBarra(graficoParse);
		view1.pack();
		RefineryUtilities.centerFrameOnScreen(view1);
		view1.setVisible(true);
	}

	private void opcaoExibirGrafico2(){
		String json = Facade.getInstanceFacade().visualizarGraficoDoadoresPF();

		Gson gson = new Gson();
		GraficoFinal graficoParse = gson.fromJson(json, GraficoFinal.class);
		System.out.println(graficoParse.getClass());

		System.out.println(graficoParse.getNome());
		GraficoPizza view2 = new GraficoPizza(graficoParse);
		view2.pack();
		RefineryUtilities.centerFrameOnScreen(view2);
		view2.setVisible(true);		
	}
	
	private void opcaoExibirGrafico3(){
		String json = Facade.getInstanceFacade().visualizarGraficoDoadoresPJ();
		System.out.println(json);
		Gson gson = new Gson();
		GraficoFinal graficoParse = gson.fromJson(json, GraficoFinal.class);
		System.out.println(graficoParse.getClass());

		System.out.println(graficoParse.getNome());
		GraficoBarra view1 = new GraficoBarra(graficoParse);
		view1.pack();
		RefineryUtilities.centerFrameOnScreen(view1);
		view1.setVisible(true);
	}
	
	private void opcaoExibirGrafico4(){
		String json = Facade.getInstanceFacade().visualizarGraficoCandidatos();
		System.out.println(json);
		Gson gson = new Gson();
		GraficoFinal graficoParse = gson.fromJson(json, GraficoFinal.class);
		System.out.println(graficoParse.getClass());

		System.out.println(graficoParse.getNome());
		GraficoBarra view1 = new GraficoBarra(graficoParse);
		view1.pack();
		RefineryUtilities.centerFrameOnScreen(view1);
		view1.setVisible(true);
	}

	private void opcaoExibirPerfilCandidatoPorNumero() throws IOException {
		System.out.println("Número Candidato: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String numero = reader.readLine();
		List<AgenteEleitoral> candidatos = Facade.getInstanceFacade().consultarCandidatosPorNumero(numero);
		int count = 0; 
		for (AgenteEleitoral c : candidatos) {
			Candidato ca = (Candidato) c.getPessoa();
			System.out.println(count++ + " " +c.getPessoa().getNome() + " - "+ca.getSequencialCandidato() );
		}
		if(count > 0){
			System.out.println("Escolha um candidato para visualizar o perfil: ");
			numero = reader.readLine();	
			try{
				int op = Integer.valueOf(numero);
				if(op >= 0 && op < count){
					PerfilCandidato perfil = new PerfilCandidato(candidatos.get(op));
					System.out.println(perfil.gerarInformacaoAdicional());
				}else{
					System.out.println("Opção inválida!!");
				}
			}catch(Exception e){
				System.out.println("Opção inválida!!");
			}
		}

	}

}
