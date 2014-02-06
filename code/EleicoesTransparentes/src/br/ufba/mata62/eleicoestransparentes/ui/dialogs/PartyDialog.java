package br.ufba.mata62.eleicoestransparentes.ui.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.PrestacaoContasFragment;

/**
 * Classe que implementa um Dialog(espécie de janela pop-up) dos partidos a serem escolhidas
 * @author tiagogoncalves
 *
 */
public class PartyDialog extends DialogFragment implements OnItemClickListener{

	public static final String[] PARTIES = { "PMDB", "PTB", "PDT", "PT", "DEM",
			"PCdoB", "PSB", "PSDB", "PTC", "PSC", "PMN", "PRP", "PPS", "PV",
			"PTdoB", "PP", "PSTU", "PCB", "PRTB", "PHS", "PSDC", "PCO", "PTN",
			"PSL", "PRB", "PSOL", "PR", "PSD", "PPL", "PEN", " PROS", "SDD" };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.uf_list_dialog, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ListView languageList = (ListView) v.findViewById(R.id.uf_list);
        languageList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,PARTIES));
        
        languageList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				PrestacaoContasFragment prestacaoFragment = (PrestacaoContasFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.prestacao_contas_fragment);
//				if(!ufSelected.equals(""))//TODO
					prestacaoFragment.setParamParty(PARTIES[3]);
				//TODO Por mensagem
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
	public void onItemClick(AdapterView<?> a, View vi, int pos, long id) {
		PrestacaoContasFragment prestacaoFragment = (PrestacaoContasFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.prestacao_contas_fragment);
//		if(!ufSelected.equals(""))//TODO
			prestacaoFragment.setParamParty(PARTIES[3]);
		//TODO Por mensagem
	}
}