package br.com.eleicoestransparentes.strategy;

import br.com.eleicoestransparentes.strategy.OnCatchBeanListener;

/**
 * Classe que escuta o Parser. Toda vez que o Parser tiver algum bean para realizar
 * CRUD no banco, aparecerá no método getBeans.
 * Design Patterns: Observer
 * @author Tiago
 *
 */
public class CatchBeanEvent implements OnCatchBeanListener{

	@Override
	public void getBeans(Object[] beans) {
		System.out.println("catched!"+beans.toString());
	}
	
	
	

}
