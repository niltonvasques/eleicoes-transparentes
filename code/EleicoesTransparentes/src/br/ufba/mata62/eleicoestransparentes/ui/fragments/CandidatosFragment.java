package br.ufba.mata62.eleicoestransparentes.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.adapters.CandidatoAdapter;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.CandidatoBensDialog;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemPartyDialog;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.events.OnSelectItemUFDialog;

public class CandidatosFragment extends Fragment  implements OnSelectItemUFDialog,OnSelectItemPartyDialog{

	private SelectionFragment sf;
	private List<Candidato> candidatos;
	private ListView listCandidatos;
	private BaseAdapter candidatoAdapter;
	
	private String UF;
	private Partido partido;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.candidatos_fragment, container, false);
		sf = (SelectionFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.selection_fragment);
		listCandidatos = (ListView) view.findViewById(R.id.list_candidatos);
		candidatos = new ArrayList<Candidato>();
		candidatoAdapter = new CandidatoAdapter(getActivity(), candidatos);
		listCandidatos.setAdapter(candidatoAdapter);
		listCandidatos.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View vi, int pos,long id) {
				DialogFragment candidatoBensDialog = new CandidatoBensDialog();
			    Bundle b = new Bundle();
			    b.putString("candidato_nome", candidatos.get(pos).getNome());
			    b.putString("candidato_sequencial", candidatos.get(pos).getSequencialCandidato());
			    candidatoBensDialog.setArguments(b);
			    candidatoBensDialog.show(getFragmentManager(), "dialog");
			}
		});
		return view;
	}

	@Override
	public void setParamUF(String UF) {
		this.UF = UF;
		sf.setParams(UF, R.id.select_uf);
		updateCandidatosList();
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
			if(partido!=null && partido.getSigla()!=null && UF!=null){
				candidatos.clear();
				candidatos.addAll(EleicoesSOAP.getInstance().consultaCandidatosPorPartido(partido.getSigla(), UF));
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			progress.dismiss();
			candidatoAdapter.notifyDataSetChanged();
		}
		
	}


	@Override
	public void setParamParty(String sigla) {
		this.partido = new Partido();
		this.partido.setSigla(sigla);
		updateCandidatosList();
	}

	@Override
	public void setParamParty(Partido partido) {
		this.partido = partido;
		updateCandidatosList();
	}

	private void updateCandidatosList() {
		if(partido!=null && partido.getSigla()!=null && UF!=null){
			new NetworkAsyncThread().execute();
		}
	}

	
}
