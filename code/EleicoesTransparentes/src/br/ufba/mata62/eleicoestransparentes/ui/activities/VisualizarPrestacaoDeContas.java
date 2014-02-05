package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class VisualizarPrestacaoDeContas extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_prestacao_contas);
//		visualizaTransacoes(new Candidato(), null);
		
}
	
	public void visualizaTransacoes(Candidato candidato, Eleicao eleicao) {
	}

	public void visualizaTransacoes(Partido partido, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Comite comite, Eleicao eleicao) {
		
	}
}