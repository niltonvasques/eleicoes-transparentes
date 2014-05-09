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

	public static final String[] UFS = { "AC", "AL", "AM", "AP", "BA",
		"CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
		"PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
		"SP", "TO" };
	
	private static final String EXTENSION = "txt";
	
	private static String getPathRoot() {
		return EProperties.getPathRoot();
	}
	
	public static class PrestacaoDeContas {
		
		public static final String YEARS[] = { "2002", "2004", "2006", "2008",
			"2010", "2012" };
		
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"PrestacaoDeContas";
		private static final String FOLDER_YEAR = "[YEAR]";

		
		public static final String[] PERSONS = { "Candidato", "Comite",
		"Partido" };
		
		public static final String[] TRANSACTIONS ={"Receitas","Despesas"};
		
		
		
		/**
		 * Método que retorna todos os caminhos de todos os arquivos da Prestação de Contas.
		 * @return
		 */
		public static List<String> getPaths(String[] years,String[] ufs, String[] persons, String[] transactions){
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ?YEARS:years;
			ufs = (ufs == null) || (ufs.length == 0) ?UFS:ufs;
			persons = (persons == null) || (persons.length == 0) ?PERSONS:persons;
			transactions = (transactions == null) || (transactions.length == 0) ?TRANSACTIONS:transactions;
			
			for(String year:years){
				String folder = FOLDER_ROOT+File.separator+FOLDER_YEAR.replace("[YEAR]", year);
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
	
	
	
	public static class BemCandidato{
		
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"Candidatos"+File.separator+"BemCandidato";
		private static final String FILE_BEM_CANDIDATO = "bem_candidato_[YEAR]_[UF]";  
		
		public static final String YEARS[] = { "2006", "2008",
			"2010", "2012" };
		
		public static List<String> getPaths(String[] years, String[] ufs) {
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ? YEARS : years;
			ufs = (ufs == null) || (ufs.length == 0) ? UFS : ufs;
			
			for (String year : years) {
				for(String uf:ufs){
					paths.add(FOLDER_ROOT+File.separator+year+File.separator+FILE_BEM_CANDIDATO.replace("[YEAR]", year).replace("[UF]",uf)+"."+EXTENSION);
				}
			}
			return paths;
		}
		
		public static List<String> getPaths(){
			return getPaths(YEARS, UFS);
		}
		
	}
	
	public static class ConsultaCandidato{
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"Candidatos"+File.separator+"ConsultaCandidato";
		private static final String FILE_CONSULTA_CANDIDATO = "consulta_cand_[YEAR]_[UF]";  
		
		public static final String YEARS[] = { "1994", "1996", "1998", "2000",
				"2002", "2004", "2006", "2008", "2010", "2012" };

		public static List<String> getPaths(String[] years, String[] ufs) {
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ? YEARS : years;
			ufs = (ufs == null) || (ufs.length == 0) ? UFS : ufs;
			
			for (String year : years) {
				for(String uf:ufs){
					paths.add(FOLDER_ROOT+File.separator+year+File.separator+FILE_CONSULTA_CANDIDATO.replace("[YEAR]", year).replace("[UF]",uf)+"."+EXTENSION);
				}
			}
			return paths;
		}
		
		
		public static List<String> getPaths(){
			return getPaths(YEARS, UFS);
		}
		
	}
	
	
	public static class ConsultaLegenda{
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"Candidatos"+File.separator+"ConsultaLegenda";
		private static final String FILE_CONSULTA_LEGENDA = "consulta_legendas_[YEAR]_[UF]";  
		
		public static final String YEARS[] = { "1950", "1955", "1960", "1970",
				"1974", "1978", "1982", "1986", "1989", "1990", "1994", "1996",
				"1998", "2000", "2002", "2004", "2006", "2008", "2010", "2012" };
		
		public static List<String> getPaths(String[] years, String[] ufs) {
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ? YEARS : years;
			ufs = (ufs == null) || (ufs.length == 0) ? UFS : ufs;
			
			for (String year : years) {
				for(String uf:ufs){
					paths.add(FOLDER_ROOT+File.separator+year+File.separator+FILE_CONSULTA_LEGENDA.replace("[YEAR]", year).replace("[UF]",uf)+"."+EXTENSION);
				}
			}
			return paths;
		}
		
		public static List<String> getPaths(){
			return getPaths(YEARS, UFS);
		}
		
	}
	
	
	public static class ConsultaVagas{
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"Candidatos"+File.separator+"ConsultaVagas";
		private static final String FILE_CONSULTA_VAGAS = "consulta_vagas_[YEAR]_[UF]";  
		
		public static final String YEARS[] = { "1970", "1974", "1978", "1982",
				"1986", "1990", "1994", "1996", "1998", "2000", "2002", "2004",
				"2006", "2008", "2010", "2012" };
		
		public static List<String> getPaths(String[] years, String[] ufs) {
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ? YEARS : years;
			ufs = (ufs == null) || (ufs.length == 0) ? UFS : ufs;
			
			for (String year : years) {
				for(String uf:ufs){
					paths.add(FOLDER_ROOT+File.separator+year+File.separator+FILE_CONSULTA_VAGAS.replace("[YEAR]", year).replace("[UF]",uf)+"."+EXTENSION);
				}
			}
			return paths;
		}
		
		public static List<String> getPaths(){
			return getPaths(YEARS, UFS);
		}
		
	}
<<<<<<< HEAD

	
	public static class PerfilEleitorado{
		private static final String FOLDER_ROOT = Repository.getPathRoot()+File.separator+"Eleitorado"+File.separator+"PerfilEleitorado";
		private static final String FILE_PERFIL_ELEITORADO = "perfil_eleitorado_[YEAR]";  
		
		public static final String YEARS[] = {"1994", "1996", "1998", "2000", "2002", "2004",
				"2006", "2008", "2010", "2012","ATUAL" };
		
		public static List<String> getPaths(String[] years) {
			List<String> paths = new ArrayList<String>();
			years = (years == null) || (years.length == 0) ? YEARS : years;
			
			for (String year : years) {
					paths.add(FOLDER_ROOT+File.separator+File.separator+FILE_PERFIL_ELEITORADO.replace("[YEAR]", year)+"."+EXTENSION);
			}
			return paths;
		}
		
		public static List<String> getPaths(){
			return getPaths(YEARS);
		}
		
	}
	
	
	/**
		Etapa de Resultados - a princípio não implementada na primeira versão do EleicoesTransparentes.
		TODO - implementar
	 */
	
	public static class DetalheVotacaoMunZona{
		//TODO Implementar
	}
	
	public static class DetalheVotacaoSecao{
		//TODO Implementar
		
	}
	
	public static class VotacaoCandidatoMunZona{
		//TODO Implementar
	}
	
	public static class VotacaoPartidoMunZona{
		//TODO Implementar
	}
	
	public static class VotoSecao{
		//TODO Implementar
	}
=======
	
	
>>>>>>> 707dd437d879ecc40efea19a45c8202633b38029
	
	
	/**
	 * Método que retorna os caminhos de todos os arquivos do repositório.
	 * @return
	 */
	public static List<String> getPaths(){
		List<String> paths=new ArrayList<String>();
		paths.addAll(PrestacaoDeContas.getPaths());
		paths.addAll(BemCandidato.getPaths());
		paths.addAll(ConsultaCandidato.getPaths());
		paths.addAll(ConsultaLegenda.getPaths());
		paths.addAll(ConsultaVagas.getPaths());
<<<<<<< HEAD
		paths.addAll(PerfilEleitorado.getPaths());
=======
>>>>>>> 707dd437d879ecc40efea19a45c8202633b38029
		
		return paths;
	}
}
