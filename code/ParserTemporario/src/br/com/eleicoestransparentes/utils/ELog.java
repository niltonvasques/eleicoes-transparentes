package br.com.eleicoestransparentes.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Classe de Log do projeto. As mensagens de log aparecem no
 * Console e são salvas no arquivo elog.txt.
 * @author tiagogoncalves
 *
 */
public class ELog {

	public static final String ERROR="ERROR";
	public static final String WARNING="WARNING";
	public static final String INFO="INFO";
	
	
	public static void print(String type,Class<?> where, String message){
		printInLogFile(logMessage(type, where, message));
		printInConsole(logMessage(type, where, message));
	}
	
	private static String logMessage(String type, Class<?> where, String message) {
		return "Type: "+type+", Class: "+where.getName()+", Message: "+message;
	}

	private static void printInConsole(String logMessage) {
		System.out.println(logMessage);
	}

	private static void printInLogFile(String logMessage){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("elog.txt",true), "utf-8"));
		    writer.write(logMessage+"\n");
		} catch (IOException ex) {
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
