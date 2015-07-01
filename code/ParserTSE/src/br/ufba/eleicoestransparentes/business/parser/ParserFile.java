package br.ufba.eleicoestransparentes.business.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.ufba.eleicoestransparentes.business.file.FileUtil;

public abstract class ParserFile <T, M> {

	private String csvFile;
	private boolean skipHeader = false;

	public interface OnReadDataListener<M>{
		public void onRead(M data, int line, int totalLines);
	}

	public ParserFile(String file) {
		this.csvFile = file;
	}

	public void parsing(OnReadDataListener<M> dataListener) throws IOException{
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "§";
		
		int totalLines = FileUtil.countLines(csvFile);
		int indexLine = 0;

		br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), getCharset()));
		int count = 0;
		while ((line = br.readLine()) != null) {
			if(count == 0 && skipHeader){
				count++;
				indexLine++;
				continue;
			}
			line = line.replace("§", " ");
			line = line.replace("\";\"", "\"§\"");
			line = line.replace("\"\"", " ");
			line = line.replace("\"", " ");
			line = line.replace("#NULO#", " ");
			String data[] = line.split(cvsSplitBy);
			if(dataListener != null){
				dataListener.onRead(populateModel(populateTemplate(data)), indexLine, totalLines);
			}
			indexLine++;
		}
		br.close();
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
