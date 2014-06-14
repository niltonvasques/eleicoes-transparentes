package br.ufba.mata62.eleicoestransparentes.ui.events;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public interface OnSelectionListener {
	public void setParams(String uf, Partido partido);
}
