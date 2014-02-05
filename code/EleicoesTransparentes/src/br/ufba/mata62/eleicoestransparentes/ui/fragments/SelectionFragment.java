package br.ufba.mata62.eleicoestransparentes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.PartyDialog;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.SelectUFDialog;

public class SelectionFragment extends Fragment{
	
	private String uf;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.selection_fragment, container, false);
		loadComponents(view);
		return view;
	}

	private void loadComponents(View view) {
		Button selectUF = (Button) view.findViewById(R.id.select_uf);
		selectUF.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SelectUFDialog selectionDialog = new SelectUFDialog();
			    selectionDialog.show(getFragmentManager(), "dialog");
			}
		});
		
		Button selectParty = (Button) view.findViewById(R.id.select_party);
		selectParty.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragment partieDialog = new PartyDialog();
			    partieDialog.show(getFragmentManager(), "dialog");
			    Partido partido = new Partido();
			    partido.setNumero(13);
			}
		});
	}


}
