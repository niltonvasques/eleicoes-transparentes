package br.ufba.mata62.eleicoestransparentes.business;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.*;

import br.ufba.mata62.eleicoestransparentes.model.database.*;

public abstract class GraficoBuilder {

	public ArrayList<PontosGrafico> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<PontosGrafico> pontos) {
		this.pontos = pontos;
	}

	public GraficoFinal getGraficoFinal() {
		return graficoFinal;
	}

	public void setGraficoFinal(GraficoFinal graficoFinal) {
		this.graficoFinal = graficoFinal;
	}

	private ArrayList<PontosGrafico> pontos; 
	
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
