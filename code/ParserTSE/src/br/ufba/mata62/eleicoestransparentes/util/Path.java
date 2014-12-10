package br.ufba.mata62.eleicoestransparentes.util;

import br.ufba.eleicoestransparentes.util.EProperties;

public abstract class Path {
	
	
	public static final String pathRoot=EProperties.getPathRoot();//TODO mudar para o caminho certo no servidor
	public static final char SEPARATOR='/';
	
	public static final String FLD_PRESTACAO="prestacao_final_2012";
	public static final String FLD_BEM="bem_candidato_2012";
	public static final String FLD_CONSULTA_CANDIDATO="consulta_cand_2012";
	
	
	
	public static final String FLD_CANDIDATO="candidato";
	public static final String FLD_COMITE="comite";
	public static final String FLD_PARTIDO="partido";
	
	public static final String[] UFS = { "AC", "AL", "AM", "AP", "BA", "CE",
			"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
			"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }; 
	
	
	public static final String FILE_RECEITA_PARTIDO="ReceitasPartidos.txt";
	public static final String FILE_DESPESA_PARTIDO="DespesasPartidos.txt";
	public static final String FILE_RECEITA_COMITE="ReceitasComites.txt";
	public static final String FILE_DESPESA_COMITE="DespesasComites.txt";
	public static final String FILE_RECEITA_CANDIDATO="ReceitasCandidatos.txt";
	public static final String FILE_DESPESA_CANDIDATO="DespesasCandidatos.txt";
	
	public static final String UF_EXT="_$UF$.txt";//FLD_BEM+FILE_BEM_UF, $UF$/ufs[x]
	
	

}
