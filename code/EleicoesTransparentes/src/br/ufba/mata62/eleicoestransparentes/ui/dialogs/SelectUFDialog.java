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
import android.widget.Button;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.ui.activities.VisualizarListaCandidatosBens;
import br.ufba.mata62.eleicoestransparentes.ui.activities.VisualizarPrestacaoDeContas;
import br.ufba.mata62.eleicoestransparentes.ui.activities.VisualizarRankingMaioresDoadores;
import br.ufba.mata62.eleicoestransparentes.ui.dialogs.adapters.UFAdapter;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.CandidatosFragment;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.PrestacaoContasFragment;
import br.ufba.mata62.eleicoestransparentes.ui.fragments.RankingDoadoresFragment;

/**
 * Classe que implementa um Dialog(espécie de janela pop-up) das UFS a serem escolhidas
 * @author tiagogoncalves
 *
 */
public class SelectUFDialog extends DialogFragment{

	public static final String[] UFS = { "AC", "AL", "AM", "AP", "BA", "CE",
		"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
		"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
	private String ufSelected="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.uf_list_dialog, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ListView ufList = (ListView) v.findViewById(R.id.uf_list);
        UFAdapter ufAdapter = new UFAdapter(SelectUFDialog.this.getActivity(), UFS );
        ufList.setAdapter(ufAdapter);
        
        ufList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View vi, int position,long id) {
				ufSelected=UFS[position];
			}
		});
        
        Button cancel = (Button) v.findViewById(R.id.cancel);
        cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SelectUFDialog.this.dismiss();
				
			}
		});
        
        Button ok = (Button) v.findViewById(R.id.ok);
        ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(getActivity().getClass().equals(VisualizarPrestacaoDeContas.class)){
					PrestacaoContasFragment prestacaoFragment = (PrestacaoContasFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.prestacao_contas_fragment);
	//				if(!ufSelected.equals(""))//TODO
						prestacaoFragment.setParamUF(UFS[0]);
					//TODO Por mensagem
				}else if(getActivity().getClass().equals(VisualizarRankingMaioresDoadores.class)){
					RankingDoadoresFragment rankingFragment = (RankingDoadoresFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.ranking_doadores_fragment);
	//				if(!ufSelected.equals(""))//TODO
						rankingFragment.setParamUF(UFS[0]);
					//TODO Por mensagem
				}else if(getActivity().getClass().equals(VisualizarListaCandidatosBens.class)){
					CandidatosFragment candidatoFragment = (CandidatosFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.candidatos_Fragment);
	//				if(!ufSelected.equals(""))//TODO
						candidatoFragment.setParamUF(UFS[0]);
					//TODO Por mensagem
				}
					SelectUFDialog.this.dismiss();
			}
		});
        
        return v;
    }

}