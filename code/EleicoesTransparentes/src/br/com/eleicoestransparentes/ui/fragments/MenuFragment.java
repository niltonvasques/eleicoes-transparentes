package br.com.eleicoestransparentes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import br.com.eleicoestransparentes.R;
import br.com.eleicoestransparentes.ui.adapters.MenuAdapter;

/**
 * Fragment do menu principal
 * 
 * @author Tiago Gonçalves
 * 
 */
public class MenuFragment extends ListFragment {

	  @Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    MenuAdapter ma = new MenuAdapter(getActivity(), getItens());
	    setListAdapter(ma);
	  }

	@Override
	  public void onListItemClick(ListView l, View v, int position, long id) {
	    // do something with the data
	  }

	
	/**
	 * Método que monta a estrutura dos itens do menu
	 * @return ItemMenus
	 */
	private ItemMenu[] getItens() {
		ItemMenu[] itens = {new ItemMenu(R.drawable.eleitorado_i_g, R.string.lbl_eleitorado, R.string.lbl_desc_eleitorado),
							new ItemMenu(R.drawable.candidatos_i_g, R.string.lbl_candidatos, R.string.lbl_desc_candidatos),
							new ItemMenu(R.drawable.resultado_i_g, R.string.lbl_resultados, R.string.lbl_desc_resultados),
							new ItemMenu(R.drawable.prestacao__i_g, R.string.lbl_prestacao, R.string.lbl_desc_prestacao),
							new ItemMenu(R.drawable.favorito__i_g, R.string.lbl_favoritos, R.string.lbl_desc_favoritos),
							};
		return itens;
	}
	  
}
