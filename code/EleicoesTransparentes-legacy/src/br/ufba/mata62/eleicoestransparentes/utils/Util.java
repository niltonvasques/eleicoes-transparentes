package br.ufba.mata62.eleicoestransparentes.utils;


public class Util {

	public static String floatFormated(float f){
		Float vlr = new Float(f); 
		DecimalFormat df = new DecimalFormat("#.#");
		String s = df.format(vlr);  
		return "R$ "+s;
	} 
}
