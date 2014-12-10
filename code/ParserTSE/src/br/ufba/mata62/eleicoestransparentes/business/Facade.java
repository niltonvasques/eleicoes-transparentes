package br.ufba.mata62.eleicoestransparentes.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.business.grafico.GraficoBuilderBarraTopFinanciadores;
import br.ufba.mata62.eleicoestransparentes.business.parser.ParserTSEStrategy;
import br.ufba.mata62.eleicoestransparentes.business.parser.ano2012.ComportamentoParser2012;
import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.database.Comunicacao;

public class Facade {


	private static Facade instanceFacede = null;
	private Comunicacao comm;
	private Facade() {
		comm = new Comunicacao();
	}
	
	public static Facade getInstanceFacade() {
		if (instanceFacede == null)
			instanceFacede = new Facade();
		
		return instanceFacede;
		
		
	}
	
	
	public List<AgenteEleitoral> consultarCandidatos(){
		try {
			return comm.consultaCandidatosAgentes();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<AgenteEleitoral> consultarCandidatosPorNumero(String numero){
		try {
			return comm.consultaCandidatosAgentesNum(numero);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void consultarPartido() {
	}

	public void consultarDoador() {
		
		
	}
	
	public String visualizarGraficoDoadores() {
		GraficoBuilderBarraTopFinanciadores graficoFinanciadores = new GraficoBuilderBarraTopFinanciadores();
		
		graficoFinanciadores.buildValores(comm);
		
		return graficoFinanciadores.getGraficoFinal().formatarGrafico();
		
	}
	

	public void visualizarGraficoCandidatos() {
		
		
	}
	
	public void realizarParser(){
		try {
			ParserTSEStrategy parser = new ParserTSEStrategy(new ComportamentoParser2012());
			parser.resetarParser();
			parser.realizarParser();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	

}

