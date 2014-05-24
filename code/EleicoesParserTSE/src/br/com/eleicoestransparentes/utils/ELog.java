package br.com.eleicoestransparentes.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.GregorianCalendar;

/**
 * Classe de Log do projeto. As mensagens de log aparecem no
 * Console e são salvas no arquivo elog.txt.
 * @author tiagogoncalves
 *
 */
public class ELog {
	
	private static ELog instance;

	public static final String ERROR="ERROR";
	public static final String WARNING="WARNING";
	public static final String INFO="INFO";
	
	
	public ELog(){
		clear();
	}

	/**
	 * Mostra a mensagem no console e no arquivo elog.txt.
	 * @param type - Elog.ERROR,Elog.WARNING ou Elog.INFO.
	 * @param where - Classe onde está sendo executada a mensagem.
	 * @param message - Mensagem.
	 */
	public void print(String type,Class<?> where, String message){
		printInLogFile(logMessage(type, where, message));
		printInConsole(logMessage(type, where, message));
	}
	
	/**
	 * Formatação da mensagem
	 */
	private String logMessage(String type, Class<?> where, String message) {
		return "Date: "+new GregorianCalendar().getTime()+", Type: "+type+", Class: "+where.getName()+", Message: "+message;
	}

	private  void printInConsole(String logMessage) {
		System.out.println(logMessage);
	}

	private void printInLogFile(String logMessage){
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
	
	private void clear(){
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("elog.txt",false), "utf-8"));
		    writer.write("");
		    writer.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static ELog getInstance() {
		if(instance == null)
			instance = new ELog();
		return instance;
	}

}
