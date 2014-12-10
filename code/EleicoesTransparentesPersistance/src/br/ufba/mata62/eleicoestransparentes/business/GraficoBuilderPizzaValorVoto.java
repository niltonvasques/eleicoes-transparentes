package br.ufba.mata62.eleicoestransparentes.business;

import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;


public class GraficoBuilderPizzaValorVoto extends GraficoBuilder {

	@Override
	public void buildTipo() {
		this.graficoFinal.setTipo("pie");
		
	}

	@Override
	public void buildNome() {
		this.graficoFinal.setNome("Divisão da renda dos candidatos que mais receberam receita.");
		
	}

	@Override
	public void buildValores() {
		Comunicacao comunicacao = new Comunicacao();
		
		this.pontos = comunicacao.topCandidatos();
		
		this.graficoFinal.setPontosGrafico(pontos);
				;
			
	}

}
