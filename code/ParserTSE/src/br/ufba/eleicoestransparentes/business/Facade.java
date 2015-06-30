package br.ufba.eleicoestransparentes.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.ufba.eleicoestransparentes.business.grafico.GraficoBuilderBarraTopCandidatosRecebedores;
import br.ufba.eleicoestransparentes.business.grafico.GraficoBuilderBarraTopFinanciadoresPF;
import br.ufba.eleicoestransparentes.business.grafico.GraficoBuilderBarraTopFinanciadoresPJ;
import br.ufba.eleicoestransparentes.business.parser.ParserTSE;
import br.ufba.eleicoestransparentes.business.parser.ComportamentoParser.OnProgressListener;
import br.ufba.eleicoestransparentes.business.parser.ano2012.ComportamentoParser2012;
import br.ufba.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.eleicoestransparentes.model.database.Comunicacao;

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
	
	public String visualizarGraficoDoadoresPF() {
		GraficoBuilderBarraTopFinanciadoresPF graficoFinanciadores = new GraficoBuilderBarraTopFinanciadoresPF();
		
		graficoFinanciadores.buildValores(comm);
		
		return graficoFinanciadores.getGraficoFinal().formatarGrafico();
		
	}
	
	public String visualizarGraficoDoadoresPJ() {
		GraficoBuilderBarraTopFinanciadoresPJ graficoFinanciadores = new GraficoBuilderBarraTopFinanciadoresPJ();
		
		graficoFinanciadores.buildValores(comm);
		
		return graficoFinanciadores.getGraficoFinal().formatarGrafico();
		
	}
	

	public String visualizarGraficoCandidatos() {
		GraficoBuilderBarraTopCandidatosRecebedores graficoFinanciadores = new GraficoBuilderBarraTopCandidatosRecebedores();
		
		graficoFinanciadores.buildValores(comm);
		
		return graficoFinanciadores.getGraficoFinal().formatarGrafico();
		
	}
	
	public void realizarParser(){
		realizarParser(null);
	}
	
	public void realizarParser(OnProgressListener listener){
		try {
			ParserTSE parser = new ParserTSE(new ComportamentoParser2012());
			parser.setListener(listener);			
			parser.realizarParser();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void resetarParser(){
		ParserTSE parser = new ParserTSE(new ComportamentoParser2012());
		parser.resetarParser();
	}
}

