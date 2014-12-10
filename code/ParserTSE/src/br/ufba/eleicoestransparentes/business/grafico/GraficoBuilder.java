package br.ufba.eleicoestransparentes.business.grafico;

import java.util.ArrayList;

import br.ufba.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.eleicoestransparentes.model.logicbeans.PontosGrafico;

public abstract class GraficoBuilder {

	public ArrayList<PontosGrafico> getPontos() {
		return this.graficoFinal.getPontosGrafico();
	}

	public void setPontos(ArrayList<PontosGrafico> pontos) {
		this.graficoFinal.setPontosGrafico(pontos);
	}

	public GraficoFinal getGraficoFinal() {
		return graficoFinal;
	}

	public void setGraficoFinal(GraficoFinal graficoFinal) {
		this.graficoFinal = graficoFinal;
	}

	private GraficoFinal graficoFinal;
	
	public abstract void buildValores(Comunicacao comunicacao);
	
	public abstract void buildTipo();
	
	public abstract void buildNome();

	public GraficoBuilder() {
		super();
	
		this.graficoFinal = new GraficoFinal();
		
		this.buildNome();
		
		this.buildTipo();
		
		
	}
	

	
	
}
