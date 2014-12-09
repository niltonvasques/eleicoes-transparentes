package business;

import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.*;

public abstract class GraficoBuilder {

	public GraficoFinal graficoFinal;
	
	public abstract void buildValores();

	public abstract void buildTipo();
	
	public abstract void buildNome();
}
