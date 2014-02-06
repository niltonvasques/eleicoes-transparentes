package br.ufba.mata62.eleicoestransparentes.ui.dialogs;

import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.adapters.CandidatoAdapter;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.adapter.BemAdapter;

/**
 * Classe que implementa um Dialog(espécie de janela pop-up) dos partidos a serem escolhidas
 * @author tiagogoncalves
 *
 */
public class CandidatoBensDialog extends DialogFragment{

	private String candidatoName;
	private String sequencialCandidato;
	private List<Bem> bens;
	
	private ListView lBens;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getArguments();
		candidatoName=b.getString("candidato_nome");
		sequencialCandidato= b.getString("candidato_sequencial");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.candidato_bens_dialog, container, false);
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		lBens = (ListView)v.findViewById(R.id.list_bens);
		TextView nameCandidato = (TextView) v.findViewById(R.id.name_candidato);
		nameCandidato.setText(candidatoName);
		return v;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		new NetworkAsyncThread().execute();
	}

	private void populateBens() {
		BaseAdapter bemAdapter = new BemAdapter(getActivity(),bens); 
		lBens.setAdapter(bemAdapter);
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
			bens = EleicoesSOAP.getInstance().consultaBens(sequencialCandidato);
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			progress.dismiss();
			populateBens();
		}
	}
	}