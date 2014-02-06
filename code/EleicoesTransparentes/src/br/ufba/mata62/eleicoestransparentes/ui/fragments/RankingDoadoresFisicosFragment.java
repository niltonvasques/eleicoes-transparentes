package br.ufba.mata62.eleicoestransparentes.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.adapters.DoadorFisicoAdapter;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans.PessoaFisicaDoador;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemUFDialog;

public class RankingDoadoresFisicosFragment extends Fragment implements OnSelectItemUFDialog{
	
	private SelectionFragment sf;
	private List<PessoaFisicaDoador> doadores;
	private EleicoesSOAP eleicoesSOAP;
	private ListView listDoadores;
	private BaseAdapter doadorAdapter;
	private String UF;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ranking_doadores, container, false);
		sf = (SelectionFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.selection_fragment);
		Button selectParty = (Button)sf.getView().findViewById(R.id.select_party);
		selectParty.setVisibility(Button.GONE);
		listDoadores = (ListView) view.findViewById(R.id.list_doadores);
		doadores = new ArrayList<PessoaFisicaDoador>();
		doadorAdapter = new DoadorFisicoAdapter(getActivity(), doadores);
		listDoadores.setAdapter(doadorAdapter);
		
		return view;
	}

	@Override
	public void setParamUF(String UF) {
		this.UF=UF;
		reloadList(UF);
		sf.setParams(UF, R.id.select_uf);
	}

	private void reloadList(String UF) {
		new NetworkAsyncThread().execute();
	}
	
	private class NetworkAsyncThread extends AsyncTask{
		private ProgressDialog progress;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progress = new ProgressDialog(getActivity());
			progress.setTitle("Aguarde!");
			progress.setMessage("Consultando dados!");
			progress.show();
		}
		@Override
		protected Object doInBackground(Object... params) {
			reload();
			return null;
		}
		
		@Override
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			doadorAdapter.notifyDataSetChanged();
		}
		
		private void reload(){
			eleicoesSOAP = new EleicoesSOAP(false);
			doadores.addAll(eleicoesSOAP.rankingMaioresDoadoresPessoaFisica(UF));
			progress.dismiss();
		}
		
	}

}
