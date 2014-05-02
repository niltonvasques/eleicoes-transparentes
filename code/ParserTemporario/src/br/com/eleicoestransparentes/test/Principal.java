package br.com.eleicoestransparentes.test;

import br.com.eleicoestransparentes.CVSFiles.ReceitasComites;
import br.com.eleicoestransparentes.parsers.Parser;
import br.com.eleicoestransparentes.parsers.ParserReceitasComites;
import br.com.eleicoestransparentes.utils.Repository;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {

//		for(String path:Repository.getPaths())
//			System.out.println(path);
		
		ReceitasComites dc = new ReceitasComites();
		String[] years = {"2012"};
		String[] ufs = {"AC"};
		String[] persons = {"Comite"};
		String[] transactions = {"Receitas"};
		
		Parser paser; 
		
		for(String path:Repository.PrestacaoDeContas.getPaths(years, ufs, persons, transactions)){
			paser = new ParserReceitasComites(dc, path);
			paser.parse();
		}
	}

}