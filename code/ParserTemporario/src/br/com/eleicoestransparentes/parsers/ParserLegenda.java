package br.com.eleicoestransparentes.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.eleicoestransparentes.CVSFiles.ConsultaLegenda;
import br.com.eleicoestransparentes.utils.CVSToObject;
import br.com.eleicoestransparentes.utils.ELog;

public class ParserLegenda{
	
	public static void parse(ConsultaLegenda consultaLegenda){
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/flavio/Área de Trabalho/tse/candidatos/legendas/consulta_legendas_2012/consulta_legendas_2012_AC.txt"));
			while(br.ready()){  
			   consultaLegenda = new ConsultaLegenda();
			   CVSToObject.populate(consultaLegenda, consultaLegenda.header, br.readLine().split(";"));
			   ELog.print(ELog.INFO, ParserLegenda.class, "Realizando parsing."+consultaLegenda.toString());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			ELog.print(ELog.ERROR, ParserLegenda.class, e.getMessage());
		}  
		

	}
}