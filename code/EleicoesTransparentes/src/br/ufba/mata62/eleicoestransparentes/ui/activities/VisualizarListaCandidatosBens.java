package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;

public class VisualizarListaCandidatosBens extends FragmentActivity{

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_lista_candidatos_bens);
	}
	
	
	public void visualizarListaCandidatosEleicao(Eleicao eleicao) {

	}

	public void visualizarDeclaracaoCandidato(String numero, Eleicao eleicao) {

	}

}
