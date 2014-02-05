package br.ufba.mata62.eleicoestransparentes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class PrestacaoContasFragment extends Fragment{

	private EleicoesSOAP eleicoes;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.prestacao_fragment, container, false);
		eleicoes = new EleicoesSOAP(false);
		loadComponents(view);
		return view;
	}
	
	private void loadComponents(View view) {
		Eleicao eleicao = null;
		Partido partido = null;
		
		TextView despesa = (TextView)view.findViewById(R.id.despesa);
		TextView receita = (TextView)view.findViewById(R.id.receita);
		
		float valorDespesa = visualizaTransacoes(partido, eleicao, String.valueOf(Transacao.DESPESA));
		despesa.setText(despesa.getText().toString().replace("$valor$", String.valueOf(valorDespesa)));
		
		float valorReceita = visualizaTransacoes(partido, eleicao, String.valueOf(Transacao.RECEITA));
		receita.setText(receita.getText().toString().replace("$valor$", String.valueOf(valorReceita)));
	}

	public float visualizaTransacoes(Partido partido, Eleicao eleicao, String tipoTransacao) {
		return eleicoes.consultaTransacaoPartido(13, "AC", tipoTransacao);
	}


}
