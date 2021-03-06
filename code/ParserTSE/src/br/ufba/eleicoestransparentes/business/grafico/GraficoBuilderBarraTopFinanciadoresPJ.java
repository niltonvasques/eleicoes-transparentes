package br.ufba.eleicoestransparentes.business.grafico;

import br.ufba.eleicoestransparentes.model.database.Comunicacao;

public class GraficoBuilderBarraTopFinanciadoresPJ extends GraficoBuilder {

	@Override
	public void buildValores(Comunicacao comunicacao) {
		
		this.setPontos(comunicacao.topFinanciadoresPJ());
		
	}

	@Override
	public void buildTipo() {
		this.getGraficoFinal().setTipo("bar");
		
	}

	@Override
	public void buildNome() {
		this.getGraficoFinal().setNome("Maiores Financiadores Jurídicos");
		
	}

}
