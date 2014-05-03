package br.com.eleicoestransparentes.test;

import br.com.eleicoestransparentes.CVSFiles.PerfilEleitorado;
import br.com.eleicoestransparentes.parsers.Parser;
import br.com.eleicoestransparentes.parsers.ParserPerfilEleitorado;
import br.com.eleicoestransparentes.utils.Repository;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {

//		for(String path:Repository.getPaths())
//			System.out.println(path);
		
//		ReceitasComites dc = new ReceitasComites();
//		String[] years = {"2012"};
//		String[] ufs = {"AC"};
//		String[] persons = {"Comite"};
//		String[] transactions = {"Receitas"};
//		
		Parser parser; 
//		
//		for(String path:Repository.PrestacaoDeContas.getPaths(years, ufs, persons, transactions)){
//			paser = new ParserReceitasComites(dc, path);
//			paser.parse();
//		}
		
		String[] years = {"2012"};
		String[] ufs = {"AC"};
		
//		BensCandidato bc = new BensCandidato();
//		for(String path:Repository.BemCandidato.getPaths(years, Repository.UFS)){
//			paser = new ParserBensCandidato(bc, path);
//			paser.parse();
//		}
		
		PerfilEleitorado cc = new PerfilEleitorado();
		for(String path:Repository.PerfilEleitorado.getPaths()){
			parser = new ParserPerfilEleitorado(cc, path);
			parser.parse();
		}
	}

}