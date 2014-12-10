package br.ufba.mata62.eleicoestransparentes.business.grafico;

import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;

public class GraficoBuilderBarraTopCandidatosRecebedores extends GraficoBuilder {

	@Override
	public void buildValores(Comunicacao comunicacao) {
		
		this.setPontos(comunicacao.topCandidatos());
		
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
