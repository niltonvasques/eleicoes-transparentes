package br.ufba.mata62.eleicoestransparentes.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.database.MySqlDatabase;

public class GraficoBuilderBarraTopFinanciadores extends GraficoBuilder {

	@Override
	public void buildValores() {
		MySqlDatabase db = new MySqlDatabase();

		String query =  "select pj.nome, sum(t.valor) as valor " +
	      		"from Transacao t inner join PessoaFisica pj on pj.id = t.debitado_id  " +
	      		"where t.tipo = 'R' and t.tipoDebitado = 'PessoaFisica' " +
	      		"group by t.debitado_id order by sum(t.valor) desc LIMIT 5;";


		ResultSet result = null;
		try {
			result = db.query(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(query);

		
			try {
				while(result.next()){
				     //Retrieve by column name
				     String nome  = result.getString("pj.nome");
				     double financimento = result.getDouble("valor");
				     PontosGrafico ponto = new PontosGrafico(nome, financimento);
				     this.graficoFinal.getPontosGrafico().add(ponto);
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			db.close();
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
