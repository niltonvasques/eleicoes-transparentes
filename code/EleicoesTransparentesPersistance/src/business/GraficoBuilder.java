package business;

import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.*;

public abstract class GraficoBuilder {

	public GraficoFinal graficoFinal;
	
	public abstract void buildValores(ArrayList<AgenteEleitoral> candidatos);

	public abstract void buildTipo();
	
	public abstract void buildNome(String nomeGrafico);
}
