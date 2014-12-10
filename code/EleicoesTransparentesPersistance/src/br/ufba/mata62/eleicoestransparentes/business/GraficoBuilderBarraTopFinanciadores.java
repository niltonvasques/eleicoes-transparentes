package br.ufba.mata62.eleicoestransparentes.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.model.database.MySqlDatabase;

public class GraficoBuilderBarraTopFinanciadores extends GraficoBuilder {

	@Override
	public void buildValores() {
		Comunicacao comunicacao = new Comunicacao();
		
		this.pontos = comunicacao.topCandidatos();
		
	
	
	}

	@Override
	public void buildTipo() {
		this.graficoFinal.setTipo("bar");
		
	}

	@Override
	public void buildNome() {
		this.graficoFinal.setNome("Maiores financiadores");
		
	}

}
