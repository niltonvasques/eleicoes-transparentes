package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class VisualizarDoadoresPartidoCandidatoEleicao extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_doadores_partido_candidato_eleicao);
	}

	public void visualizaDoadoresPartido(Partido partido, Eleicao eleicao) {

	}

	public void visualizaDoadoresCandidato(Candidato candidato, Eleicao eleicao) {

	}

}
