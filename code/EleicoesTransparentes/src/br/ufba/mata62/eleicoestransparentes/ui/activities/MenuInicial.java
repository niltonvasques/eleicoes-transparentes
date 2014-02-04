package br.ufba.mata62.eleicoestransparentes.ui.activities;

import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuInicial extends ListActivity {

	//TODO Seguir requisitos eleitos que estão no TRello.
	String classes[] = {VisualizarPrestacaoDeContas.class.getSimpleName(),
						VisualizarRankingMaioresDoadores.class.getSimpleName(),
						VisualizarListaCandidatos.class.getSimpleName(),
						VisualizarDoadoresPartidoCandidatoEleicao.class.getSimpleName(),
						VisualizarDoadoresPartidoCandidatoEleicao.class.getSimpleName(),
						};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EleicoesSOAP eleicoes = new EleicoesSOAP(false);
		float x = eleicoes.consultaTransacaoPartido(13, "AC", "D");
		
		setListAdapter(new ArrayAdapter<String>(MenuInicial.this,android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String classSelected = classes[position];
		
		try
		{
			Class nossaClasse = Class.forName("br.ufba.mata62.eleicoestransparentes.ui.activities." + classSelected+"");
			Intent classeParaAbrir = new Intent(MenuInicial.this, nossaClasse);
			startActivity(classeParaAbrir);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	
}
