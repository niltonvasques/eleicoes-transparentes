package br.com.eleicoestransparentes.strategy;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.EBean;


public interface OnCatchBeanListener{
	
	public void getBeans(EBean[] beans);

}
