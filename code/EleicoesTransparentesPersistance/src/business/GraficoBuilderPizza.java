package business;

import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;

public class GraficoBuilderPizza extends GraficoBuilder {

	@Override
	public void buildValores(ArrayList<AgenteEleitoral> candidatos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildTipo() {
		this.graficoFinal.tipo = "pie";
		
	}

	@Override
	public void buildNome(String nomeGrafico) {
		this.graficoFinal.nome = nomeGrafico;
		
	}

}
