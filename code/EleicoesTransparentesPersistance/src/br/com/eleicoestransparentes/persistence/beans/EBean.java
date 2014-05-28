package br.com.eleicoestransparentes.persistence.beans;

import java.lang.reflect.Field;

public class EBean {

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
}
