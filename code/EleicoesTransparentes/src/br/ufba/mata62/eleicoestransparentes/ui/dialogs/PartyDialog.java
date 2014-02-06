package br.ufba.mata62.eleicoestransparentes.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.connection.EleicoesSOAP;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.adapters.PartyAdapter;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.PrestacaoContasFragment;

/**
 * Classe que implementa um Dialog(espécie de janela pop-up) dos partidos a serem escolhidas
 * @author tiagogoncalves
 *
 */
public class PartyDialog extends DialogFragment implements OnItemClickListener{
	
	private static final String TAG = "[PartyDialog]";

	private List<Partido> partidos;
	private Partido partidoSelected;
	private PartyAdapter partyAdapter;
	private EleicoesSOAP eleicoesSOAP;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.partie_list_dialog, container, false);
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		ListView partyList = (ListView) v.findViewById(R.id.party_list);
		partidos = new ArrayList<Partido>();

		partyAdapter = new PartyAdapter(PartyDialog.this.getActivity(), partidos);
		partyList.setAdapter(partyAdapter);

		partyList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				PrestacaoContasFragment prestacaoFragment = (PrestacaoContasFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.prestacao_contas_fragment);
				//    				if(!ufSelected.equals(""))//TODO
				partidoSelected = partidos.get(position);
				prestacaoFragment.setParamParty(partidoSelected);
				PartyDialog.this.dismiss();

			}
		});

		Button cancel = (Button) v.findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PartyDialog.this.dismiss();
			}
		});


		return v;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		new NetworkAsyncThread().execute();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

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
			partyAdapter.notifyDataSetChanged();
			Log.d(TAG, "onPostExecute");
		}

		private void reload(){
			eleicoesSOAP = new EleicoesSOAP(false);
			partidos.addAll(eleicoesSOAP.consultaPartidos());
			progress.dismiss();
		}

	}


}