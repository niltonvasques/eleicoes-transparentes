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
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemPartyDialog;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemUFDialog;

public class PrestacaoContasFragment extends Fragment  implements OnSelectItemUFDialog,OnSelectItemPartyDialog{

	private EleicoesSOAP eleicoesSOAP;
	private Eleicao eleicao;
	private Partido partido;
	
	private TextView despesa;
	private TextView receita;
	private String uf;
	private SelectionFragment sf;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.prestacao_fragment, container, false);
		sf = (SelectionFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.selection_fragment);
		eleicoesSOAP = new EleicoesSOAP(false);
		eleicao = new Eleicao();
		eleicao.setAno("2012");
		loadComponents(view);
		return view;
	}
	
	private void loadComponents(View view) {
		despesa = (TextView)view.findViewById(R.id.despesa);
		receita = (TextView)view.findViewById(R.id.receita);
		
	}

	public float visualizaTransacoes(Partido partido, Eleicao eleicao, String tipoTransacao) {
		return eleicoesSOAP.consultaTransacaoPartido(13, "AC", tipoTransacao);
	}

	@Override
	public void setParamUF(String UF) {
		this.uf = UF;
		sf.setParams(uf, R.id.select_uf);
	}

	@Override
	public void setParamParty(String sigla) {
		this.partido = new Partido();
		partido.setSigla(sigla);
		sf.setParams(sigla, R.id.select_party);
		loadPrestacao();
	}


	@Override
	public void setParamParty(Partido partido) {
		this.partido = partido;
	}
	
	private void loadPrestacao() {
		if(partido!=null && partido.getSigla()!=null && uf!=null){
			float valorDespesa = visualizaTransacoes(partido, eleicao, String.valueOf(Transacao.DESPESA));
			despesa.setText(despesa.getText().toString().replace("$valor$", String.valueOf(valorDespesa)));
			
			float valorReceita = visualizaTransacoes(partido, eleicao, String.valueOf(Transacao.RECEITA));
			receita.setText(receita.getText().toString().replace("$valor$", String.valueOf(valorReceita)));
			
		}
	}


}
