package br.com.eleicoestransparentes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.eleicoestransparentes.R;


/**
 * Fragment dos itens
 * @author Tiago Gonçalves
 *
 */
public class ItemFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.item_fragment, container, false);
//		TextView txtItem = (TextView)view.findViewById(R.id.txt_item);
//		txtItem.setText("Eleitorado");
//		txtItem.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.eleitorado_i_g, 0, 0);
		return view;
	}

}
