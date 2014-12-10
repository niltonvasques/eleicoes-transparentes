package br.ufba.mata62.eleicoestransparentes.business;

import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;


public class GraficoBuilderPizzaValorVoto extends GraficoBuilder {

	@Override
	public void buildTipo() {
		this.getGraficoFinal().setTipo("pie");
		
	}

	@Override
	public void buildNome() {
		this.getGraficoFinal().setNome("Divisão da renda dos candidatos que mais receberam receita.");
		
	}

	@Override
	public void buildValores(Comunicacao comunicacao) {
		
		this.setPontos(comunicacao.topCandidatos());
		
		this.getGraficoFinal().setPontosGrafico(this.getPontos());
			
		
			
	}

}
