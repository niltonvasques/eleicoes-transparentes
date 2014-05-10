package br.com.eleicoestransparentes.parsers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.eleicoestransparentes.CVSFiles.CVSFile;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.com.eleicoestransparentes.strategy.OnCatchBeanListener;
import br.com.eleicoestransparentes.utils.CVSToObject;
import br.com.eleicoestransparentes.utils.ELog;

/**
 * Classe que realiza o parsing entre o arquivo para objeto do tipo CVSFile.
 * @author tiagogoncalves
 *
 */
public abstract class Parser{
	private CVSFile cvsFile;
	private String[] header;
	private String path;
	 List<OnCatchBeanListener> listeners = new ArrayList<OnCatchBeanListener>();
	
	public void addListener(OnCatchBeanListener onCatchBeanListener) {
		listeners.add(onCatchBeanListener);
	}
	
	public Parser(CVSFile cvsFile,String[] header,String path){
		this.cvsFile=cvsFile;
		this.header=header;
		this.path=path;
	}
	
	public Parser(CVSFile cvsFile,String path){
		this.cvsFile=cvsFile;
		this.path=path;
	}
	
	public void parse(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			CVSClass cvsClass = cvsFile.getClass().getAnnotation(CVSClass.class);
			if (cvsClass.headerInFile())
				header = br.readLine().split(";");
			while (br.ready()) {
				CVSToObject.populate(cvsFile, header, br.readLine().split(";"));
				ELog.getInstance().print(ELog.INFO, Parser.class, "Realizando parsing." + cvsFile.toString());
				for(OnCatchBeanListener ocbl: listeners)
					ocbl.getBeans(cvsFile.getBeans());
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			ELog.getInstance().print(ELog.ERROR, Parser.class, e.getMessage());
		}  
	}

}
