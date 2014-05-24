package br.com.eleicoestransparentes.strategy;

import br.com.eleicoestransparentes.CVSFiles.BensCandidato;
import br.com.eleicoestransparentes.CVSFiles.ConsultaCandidato;
import br.com.eleicoestransparentes.CVSFiles.ConsultaLegenda;
import br.com.eleicoestransparentes.CVSFiles.ConsultaVagas;
import br.com.eleicoestransparentes.parsers.Parser;
import br.com.eleicoestransparentes.parsers.ParserBensCandidato;
import br.com.eleicoestransparentes.parsers.ParserConsultaCandidato;
import br.com.eleicoestransparentes.parsers.ParserConsultaLegenda;
import br.com.eleicoestransparentes.parsers.ParserConsultaVagas;
import br.com.eleicoestransparentes.utils.Repository;

public class ParserStrategy {

	private static Parser parser;
	private static CatchBeanEvent catchBeanEvent;
	
	public static class FirstStep {
		
		public static void run(){
			String[] years={"2012"};
			String[] ufs = {"SP"};
			generatePartido(years,ufs);//Só é necessária uma amostra (um estado) para gerar partidos.
			generateCandidato(years, Repository.UFS);
			generateBem(years, Repository.UFS);
			generateEleicao(years, Repository.UFS);
		}
		
		public static void generatePartido(String[] years, String[] ufs){
			ConsultaLegenda consultaLegenda = new ConsultaLegenda();
			for (String path : Repository.ConsultaLegenda.getPaths(years,ufs)) {
				parser = new ParserConsultaLegenda(consultaLegenda, path);
				catchBeanEvent = new CatchBeanEvent();
				parser.addListener(catchBeanEvent);
				parser.parse();
			}
		}
		
		public static void generateCandidato(String[] years, String[] ufs){
			ConsultaCandidato consultaCandidato = new ConsultaCandidato();
			for (String path : Repository.ConsultaCandidato.getPaths(years,ufs)) {
				parser = new ParserConsultaCandidato(consultaCandidato, path);
				catchBeanEvent = new CatchBeanEvent();
				parser.addListener(catchBeanEvent);
				parser.parse();
			}
		}
		
		public static void generateBem(String[] years, String[] ufs){
			BensCandidato bensCandidato = new BensCandidato();
			for (String path : Repository.BemCandidato.getPaths(years,ufs)) {
				parser = new ParserBensCandidato(bensCandidato, path);
				catchBeanEvent = new CatchBeanEvent();
				parser.addListener(catchBeanEvent);
				parser.parse();
			}
		}
		
		public static void generateEleicao(String[] years, String[] ufs){
			ConsultaVagas consultaVagas = new ConsultaVagas();
			for (String path : Repository.ConsultaVagas.getPaths(years,ufs)) {
				parser = new ParserConsultaVagas(consultaVagas, path);
				catchBeanEvent = new CatchBeanEvent();
				parser.addListener(catchBeanEvent);
				parser.parse();
			}
		}
	}

	public static class SecondStep {

	}

	public static class ThirdStep {

	}

	public static class FourthStep {

	}

	public static class FifthStep {

	}

	public static class SixthStep {

	}

	public static class SeventhStep {

	}
}
