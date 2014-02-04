package br.ufba.mata62.eleicoestransparentes.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import br.ufba.mata62.eleicoestransparentes.R;
import br.ufba.mata62.eleicoestransparentes.adapters.MenuAdapter;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class VisualizarPrestacaoDeContas extends FragmentActivity implements OnClickListener{
	
	Spinner spinnerList;
	private List<String> nomes = new ArrayList<String>();
	private String nome;
	
	public void visualizaTransacoes(Candidato candidato, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Partido partido, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Comite comite, Eleicao eleicao) {
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.listagem_generica);
		loadComponents();
		
		spinnerList = (Spinner)findViewById(R.id.spinnerListagem);

		//Adicionando Nomes no ArrayList
		nomes.add("ex1");
		nomes.add("ex2");
		nomes.add("ex3");
		nomes.add("ex4");
		nomes.add("ex5");
 
		//Identifica o Spinner no layout
		spinnerList = (Spinner) findViewById(R.id.spinner1);
		//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinnerList.setAdapter(spinnerArrayAdapter);
 
		//Método do Spinner para capturar o item selecionado
		spinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
 
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				//pega nome pela posição
				nome = parent.getItemAtPosition(posicao).toString();
				//imprime um Toast na tela com o nome que foi selecionado
				Toast.makeText(VisualizarPrestacaoDeContas.this, "Nome Selecionado: " + nome, Toast.LENGTH_LONG).show();
			}
 
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
 
			}
		});
}
	
	private void loadComponents() {
		ListView menu = (ListView) findViewById(R.id.menu);
		BaseAdapter adapter = new MenuAdapter(VisualizarPrestacaoDeContas.this, listElements);
		menu.setAdapter(adapter);
	}
	
	private int[] listElements = { R.string.mi_prestacao_contas_partido,
			R.string.mi_prestacao_contas_candidato, R.string.mi_maior_gasto,
			R.string.mi_origem_gastos, R.string.mi_doadores,
			R.string.mi_declaracao_bens, R.string.mi_eleitores };
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.string.mi_prestacao_contas_partido:

			break;
		case R.string.mi_prestacao_contas_candidato:

			break;

		case R.string.mi_maior_gasto:

			break;
		case R.string.mi_origem_gastos:

			break;
		case R.string.mi_doadores:

			break;
		case R.string.mi_declaracao_bens:

			break;
		case R.string.mi_eleitores:

			break;
		default:
			break;
		}
		
	}

}
