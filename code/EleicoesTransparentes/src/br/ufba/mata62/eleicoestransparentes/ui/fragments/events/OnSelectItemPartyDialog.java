package br.ufba.mata62.eleicoestransparentes.ui.fragments.events;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;


public interface OnSelectItemPartyDialog {
	public void setParamParty(String sigla);
	public void setParamParty(Partido partido);
}
