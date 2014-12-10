package br.ufba.eleicoestransparentes.business.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class ParserFile <T, M> {
	
	private String csvFile;
	private boolean skipHeader = false;
	
	public ParserFile(String file) {
		this.csvFile = file;
	}
	
	public List<M> parsing() throws IOException{
		List<T> pccList = new ArrayList<T>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), getCharset()));
		int count = 0;
		while ((line = br.readLine()) != null) {
			if(count == 0 && skipHeader){
				count++;
				continue;
			}
			line = line.replace("\"\"", " ");
			line = line.replace("\"", " ");
			line = line.replace("#NULO#", " ");
			String data[] = line.split(cvsSplitBy);
				pccList.add(populateTemplate(data));
		}
		br.close();
		
		List<M> modelList = new ArrayList<M>();
		for (T p : pccList) {
			M b = populateModel(p);
			modelList.add(b);
		}
		return modelList;

	}
	
	protected String getCharset() {
		return "ISO-8859-1";
	}

	public void setSkipHeader(boolean skip){
		this.skipHeader = skip;
	}
	
	protected abstract T populateTemplate(String[] data);
	
	protected abstract M populateModel(T data);

}
