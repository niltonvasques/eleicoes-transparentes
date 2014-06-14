package br.com.eleicoestransparentes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.eleicoestransparentes.R;


/**
 * Fragment da titlebar
 * @author Tiago Gonçalves
 *
 */
public class BarFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bar, container, false);
		return view;
	}

}
