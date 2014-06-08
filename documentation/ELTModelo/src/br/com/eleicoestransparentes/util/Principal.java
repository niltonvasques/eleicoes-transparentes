package br.com.eleicoestransparentes.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Principal {
	public static void main(String[] args) {
//		read("files", "BENS_DE_CANDIDATO");
//		read("files", "CONSULTA_CANDIDATURA");
//		read("files", "CONSULTA_LEGENDAS");
//		read("files", "CONSULTA_VAGAS");
//		read("files", "DETALHE_VOTACAO_MUN_ZONA");
//		read("files", "DETALHE_VOTACAO_SECAO");
//		read("files", "ELEITORADO");
//		read("files", "VOTACAO_CANDIDATO_MUN_ZONA");
//		read("files", "VOTACAO_PARTIDO_MUN_ZONA");
//		read("files", "VOTO_SECAO");
		read("files", "DESPESAS_CANDIDATOS");
		read("files", "DESPESAS_COMITES");
		read("files", "DESPESAS_PARTIDOS");
		read("files", "RECEITAS_CANDIDATOS");
		read("files", "RECEITAS_COMITES");
		read("files", "RECEITAS_PARTIDOS");
		
	}
	
	public static void read(String path,String fileName){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path+"/"+fileName+".txt"), "UTF-8"));
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("target/"+treatClass(fileName.split("_"))+".java",true), "utf-8"));
			
			
			writer.write("package br.com.eleicoestransparentes.persistance.beans;\n");
			writer.write("public class "+treatClass(fileName.split("_"))+"{\n");
			while (br.ready()) {
				String[] attr = br.readLine().split(";");
//				writer.write("/**"+attr[1]+"*/\n");
				writer.write("protected String "+treatAttr(attr[0].replace("(*)", "").split("_"))+";\n");
			}
			writer.write("}");
			
			br.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	private static String treatAttr(String[] attr){
		  String str = "";
		  for (int i = 1; i< attr.length;i++)
			  str+=attr[i]+" ";
	      StringBuffer stringbf = new StringBuffer();
	      Matcher m = Pattern.compile("([a-z])([a-z]*)",
	      Pattern.CASE_INSENSITIVE).matcher(str);
	      while (m.find()) {
	         m.appendReplacement(stringbf, 
	         m.group(1).toUpperCase() + m.group(2).toLowerCase());
	      }
		return attr[0].toLowerCase()+m.appendTail(stringbf).toString().replace(" ", "");
	}
	
	private static String treatClass(String[] attr){
		  String str = "";
		  for (int i = 0; i< attr.length;i++)
			  str+=attr[i]+" ";
	      StringBuffer stringbf = new StringBuffer();
	      Matcher m = Pattern.compile("([a-z])([a-z]*)",
	      Pattern.CASE_INSENSITIVE).matcher(str);
	      while (m.find()) {
	         m.appendReplacement(stringbf, 
	         m.group(1).toUpperCase() + m.group(2).toLowerCase());
	      }
		return m.appendTail(stringbf).toString().replace(" ", "");
	}
}
