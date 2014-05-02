package br.com.eleicoestransparentes.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class treats the paths of Repository
 * 
 * @author Tiago Gonçalves
 * 
 */
public abstract class Repository {

	private static List<String> paths;

	public static final String[] UFS = { "AC", "AL", "AM", "AP", "BA",
		"CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
		"PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
		"SP", "TO" };
	
	private static final String EXTENSION = "txt";
	
	private static String getPathRoot() {
		return EProperties.getPathRoot();
	}
	
	public static final String FOLDER_BEM = "bem_candidato_[YEAR]";
	public static final String FOLDER_CONSULTA_CANDIDATO = "consulta_cand_[YEAR]";

	public static class PrestacaoDeContas {
		
		public static final String YEARS[] = { "2002", "2004", "2006", "2008",
			"2010", "2012" };
		
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"PrestacaoDeContas";
		private static final String FOLDER_PRESTACAO = "prestacao_final_[YEAR]";

		
		public static final String[] PERSONS = { "Candidato", "Comite",
		"Partido" };
		
		public static final String[] TRANSACTIONS ={"Receitas","Despesas"};
		
		
		
		/**
		 * Método que retorna todos os caminhos de todos os arquivos da Prestação de Contas.
		 * @return
		 */
		public static List<String> getPaths(String[] years,String[] ufs, String[] persons, String[] transactions){
			paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ?YEARS:years;
			ufs = (ufs == null) || (ufs.length == 0) ?UFS:ufs;
			persons = (persons == null) || (persons.length == 0) ?PERSONS:persons;
			transactions = (transactions == null) || (transactions.length == 0) ?TRANSACTIONS:transactions;
			
			for(String year:years){
				String folder = FOLDER_ROOT+File.separator+FOLDER_PRESTACAO.replace("[YEAR]", year);
					for(String uf:ufs){
						for(String person:persons){
							for(String transaction:transactions)
								paths.add(folder+File.separator+person.toLowerCase()+File.separator+uf+File.separator+transaction+person+"s."+EXTENSION);
						}
					}
			}
			return paths;
		}
		
		
		/**
		 * Método que retorna todos os caminhos de todos os arquivos da Prestação de Contas.
		 * @return
		 */
		public static List<String> getPaths(){
			return getPaths(YEARS, UFS, PERSONS, TRANSACTIONS);
		}
		
		
	}
	
	/**
	 * Método que retorna os caminhos de todos os arquivos do repositório.
	 * @return
	 */
	public static List<String> getPaths(){
		paths=new ArrayList<String>();
		paths.addAll(PrestacaoDeContas.getPaths());
		return paths;
	}
}
