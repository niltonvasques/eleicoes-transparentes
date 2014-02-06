package br.ufba.mata62.eleicoestransparentes.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.adapters.DoadorAdapter;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans.PessoaJuridicaDoador;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemUFDialog;

public class RankingDoadoresFragment extends Fragment implements OnSelectItemUFDialog{
	
	private SelectionFragment sf;
	private List<PessoaJuridicaDoador> doadores;
	private EleicoesSOAP eleicoesSOAP;
	private ListView listDoadores;
	private BaseAdapter doadorAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ranking_doadores, container, false);
		sf = (SelectionFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.selection_fragment);
		Button selectParty = (Button)sf.getView().findViewById(R.id.select_party);
		selectParty.setVisibility(Button.GONE);
		listDoadores = (ListView) view.findViewById(R.id.list_doadores);
		doadores = new ArrayList<PessoaJuridicaDoador>();
		doadorAdapter = new DoadorAdapter(getActivity(), doadores);
		listDoadores.setAdapter(doadorAdapter);
		
		return view;
	}

	@Override
	public void setParamUF(String UF) {
		reloadList(UF);
		sf.setParams(UF, R.id.select_uf);
	}

	private void reloadList(String UF) {
		eleicoesSOAP = new EleicoesSOAP(false);
		doadores.addAll(eleicoesSOAP.rankingMaioresDoadoresPessoaJuridica(UF));
		doadorAdapter = new DoadorAdapter(getActivity(), doadores);
		listDoadores.setAdapter(doadorAdapter);
	}

}
