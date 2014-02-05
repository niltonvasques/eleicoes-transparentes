package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Spinner;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class VisualizarPrestacaoDeContas extends FragmentActivity implements OnClickListener{
	
	ListView listGenerica;
	Spinner spinnerList;
	
	public void visualizaTransacoes(Candidato candidato, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Partido partido, Eleicao eleicao) {
		
	}

	public void visualizaTransacoes(Comite comite, Eleicao eleicao) {
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_prestacao_contas);
		loadComponents();
		
}
	
	private void loadComponents() {
//		listGenerica = (ListView) findViewById(R.id.listGenerica);
//		BaseAdapter adapterList = new MenuAdapter(this, listElements);
//		listGenerica.setAdapter(adapterList);
//		
//		spinnerList = (Spinner)findViewById(R.id.spinnerListagem);
//		ArrayAdapter adapterSpinner = ArrayAdapter.createFromResource(this, R.array.itens, android.R.layout.simple_spinner_item);
//		adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinnerList.setAdapter(adapterSpinner);
//		spinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
// 
//			@Override
//			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
//				
//				TextView myText= (TextView) v;
//				Toast.makeText(VisualizarPrestacaoDeContas.this, "Nome Selecionado: " + myText.getText(), Toast.LENGTH_LONG).show();
//				
//				/*//pega nome pela posiï¿½ï¿½o
//				nome = parent.getItemAtPosition(posicao).toString();
//				//imprime um Toast na tela com o nome que foi selecionado
//				EleicoesSOAP soap = new EleicoesSOAP();
//				float valor = soap.consultaTransacaoPartido(13, "AC", "D");
//				Toast.makeText(VisualizarPrestacaoDeContas.this, "O PT gastou: " + valor, Toast.LENGTH_LONG).show();*/
//			}
// 
//			@Override
//			public void onNothingSelected(AdapterView<?> parent) {
// 
//			}
//		});
	}
	
//	private int[] listElements = { R.string.mi_prestacao_contas_partido,
//			R.string.mi_prestacao_contas_candidato, R.string.mi_maior_gasto,
//			R.string.mi_origem_gastos, R.string.mi_doadores,
//			R.string.mi_declaracao_bens, R.string.mi_eleitores };
	
	@Override
	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.string.mi_prestacao_contas_partido:
//
//			break;
//		case R.string.mi_prestacao_contas_candidato:
//
//			break;
//
//		case R.string.mi_maior_gasto:
//
//			break;
//		case R.string.mi_origem_gastos:
//
//			break;
//		case R.string.mi_doadores:
//
//			break;
//		case R.string.mi_declaracao_bens:
//
//			break;
//		case R.string.mi_eleitores:
//
//			break;
//		default:
//			break;
//		}
		
	}

}
