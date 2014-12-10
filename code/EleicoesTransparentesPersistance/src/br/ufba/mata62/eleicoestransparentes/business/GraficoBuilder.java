package br.ufba.mata62.eleicoestransparentes.business;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.*;

import br.ufba.mata62.eleicoestransparentes.model.database.*;

public abstract class GraficoBuilder {

	public ArrayList<PontosGrafico> pontos; 
	
	public GraficoFinal graficoFinal = new GraficoFinal();
	
	public abstract void buildValores();
	
	public abstract void buildTipo();
	
	public abstract void buildNome();

	public GraficoBuilder() {
		super();
		

	
		this.graficoFinal = new GraficoFinal();
		
		this.buildNome();
		
		this.buildTipo();
		
		
	}
	

	
	
}
