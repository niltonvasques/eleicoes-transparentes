package br.com.eleicoestransparentes.strategy;

import br.com.eleicoestransparentes.persistence.beans.Bem;
import br.com.eleicoestransparentes.persistence.beans.Candidato;
import br.com.eleicoestransparentes.persistence.beans.Comite;
import br.com.eleicoestransparentes.persistence.beans.EBean;
import br.com.eleicoestransparentes.persistence.beans.Eleicao;
import br.com.eleicoestransparentes.persistence.beans.Partido;
import br.com.eleicoestransparentes.persistence.beans.PessoaFisica;
import br.com.eleicoestransparentes.persistence.beans.PessoaJuridica;
import br.com.eleicoestransparentes.persistence.beans.SetorEconomico;
import br.com.eleicoestransparentes.persistence.beans.Transacao;
import br.com.eleicoestransparentes.utils.ELog;

/**
 * Classe que escuta o Parser. Toda vez que o Parser tiver algum bean para realizar
 * CRUD no banco, aparecerá no método getBeans.
 * Design Patterns: Observer
 * @author Tiago
 *
 */
public class CatchBeanEvent implements OnCatchBeanListener{

	@Override
	public void getBeans(EBean[] beans) {
		populate(beans);
	}
	
	//TODO Teste - isso deve ser implementado na persistência.
	public void populate(EBean[] beans){
		for(Object bean:beans){
			if(bean instanceof Bem)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Bem)bean).toString());
			if(bean instanceof Candidato)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Candidato)bean).toString());
			if(bean instanceof Comite)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Comite)bean).toString());
			if(bean instanceof Eleicao)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Eleicao)bean).toString());
			if(bean instanceof Partido)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Partido)bean).toString());
			if(bean instanceof PessoaFisica)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((PessoaFisica)bean).toString());
			if(bean instanceof PessoaJuridica)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((PessoaJuridica)bean).toString());
			if(bean instanceof SetorEconomico)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((SetorEconomico)bean).toString());
			if(bean instanceof Transacao)
				ELog.getInstance().print(ELog.INFO, CatchBeanEvent.class, "Catching bean:" + ((Transacao)bean).toString());
		}
	}

}
