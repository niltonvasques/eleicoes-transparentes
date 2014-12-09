package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;

public class GraficoBuilderPizzaValorVoto extends GraficoBuilder {

	@Override
	public void buildValores() throws SQLException {
	} {
		   	
	}

	@Override
	public void buildTipo() {
		this.graficoFinal.setTipo("pie");
		
	}

	@Override
	public void buildNome() {
		this.graficoFinal.setNome("Candidatos por maior razao entre voto e montande de financiamento.");
		
	}

}
