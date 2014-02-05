package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Pessoa;

public class VisualizarRankingMaioresDoadores extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_ranking_maiores_doadores);
	}
	
	public void visualizarRankingDoadores(Pessoa pessoa, Eleicao eleicao) {

	}

	public void visualizarRankingDoadores(Eleicao eleicao, Partido partido) {

	}

}
