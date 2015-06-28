package br.ufba.eleicoestransparentes.business.grafico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufba.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;
import br.ufba.eleicoestransparentes.model.database.MySqlDatabase;

public class GraficoBuilderBarraTopFinanciadoresPF extends GraficoBuilder {

	@Override
	public void buildValores(Comunicacao comunicacao) {
		
		this.setPontos(comunicacao.topFinanciadoresPF());
		
	}

	@Override
	public void buildTipo() {
		this.getGraficoFinal().setTipo("bar");
		
	}

	@Override
	public void buildNome() {
		this.getGraficoFinal().setNome("Maiores financiadores");
		
	}

}
