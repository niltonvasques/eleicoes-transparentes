package br.com.eleicoestransparentes.CVSFiles;

import java.lang.reflect.Field;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.EBean;

/**
 * Classe corresponde ao arquivo CVS de dados.
 * @author tiagogoncalves
 *
 */
public abstract class CVSFile {
	public String[] header = {};
	
	
	public String toString() {
		String str = this.getClass().getSimpleName()+":[";
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field f : fields) {
				try {
					str += " "+f.getName() + ":" + f.get(this);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
		}
		return str+"]";
	}
	
	public abstract EBean[] getBeans();
	
}