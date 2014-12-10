package br.ufba.mata62.eleicoestransparentes.business;

public class Facade {


	private static Facade instanceFacede = null;
	
	private Facade() {
		
	}
	
	public static Facade getInstanceFacade() {
		if (instanceFacede == null)
			instanceFacede = new Facade();
		
		return instanceFacede;
		
		
	}
	
	
	public void consultarCandidato(){
		
		
	}

	public void consultarPartido() {
		
		
	}

	public void consultarDoador() {
		
		
	}
	
	public void visualizarGraficoDoadores() {
		
		
	}
	

	public void visualizarGraficoCandidatos() {
		
		
	}

}

