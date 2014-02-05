package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class VisualizarPrestacaoDeContas extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_prestacao_contas);
		loadComponents();
		visualizaTransacoes(new Candidato(), null);
		
}
	
	private void loadComponents() {
	}
	
	public void visualizaTransacoes(Candidato candidato, Eleicao eleicao) {
		EleicoesSOAP eleicoes = new EleicoesSOAP(false);
		eleicoes.consultaTransacaoPartido(13, "AC", "D");
	}

	public void visualizaTransacoes(Partido partido, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Comite comite, Eleicao eleicao) {
		
	}
}