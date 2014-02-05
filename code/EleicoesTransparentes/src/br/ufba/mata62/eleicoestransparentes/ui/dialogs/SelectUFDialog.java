package br.ufba.mata62.eleicoestransparentes.ui.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

/**
 * Classe que implementa um Dialog(espécie de janela pop-up) das UFS a serem escolhidas
 * @author tiagogoncalves
 *
 */
public class SelectUFDialog extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.uf_list_dialog, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ListView languageList = (ListView) v.findViewById(R.id.uf_list);
        UFAdapter languageAdapter = new UFAdapter(SelectUFDialog.this.getActivity(), null);
        languageList.setAdapter(languageAdapter);
        return v;
    }
}