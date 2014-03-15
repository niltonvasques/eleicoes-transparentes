package br.com.eleicoestransparentes.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.eleicoestransparentes.CVSFiles.ConsultaCandidato;
import br.com.eleicoestransparentes.utils.CVSToObject;
import br.com.eleicoestransparentes.utils.ELog;

public class ParserCandidato{
	
	public static void parse(ConsultaCandidato consultaCandidato){
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/flavio/Área de Trabalho/tse/candidatos/consulta_cand_2012/consulta_cand_2012_AC.txt"));
			while(br.ready()){  
			   consultaCandidato = new ConsultaCandidato();
			   CVSToObject.populate(consultaCandidato, consultaCandidato.header, br.readLine().split(";"));
			   consultaCandidato.getCandidato();
			   ELog.print(ELog.INFO, ParserCandidato.class, "Realizando parsing.");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			ELog.print(ELog.ERROR, ParserCandidato.class, e.getMessage());
		}  
		

	}
}
