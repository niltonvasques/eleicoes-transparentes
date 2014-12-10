package business;


public class GraficoBuilderPizzaValorVoto extends GraficoBuilder {

	@Override
	public void buildValores()  {
		   	
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
