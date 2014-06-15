package br.com.eleicoestransparentes.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.eleicoestransparentes.R;
import br.com.eleicoestransparentes.ui.fragments.ItemMenu;


/**
 * Adapter dos itens do menu principal.
 * @author Tiago Gonçalves
 *
 */
public class MenuAdapter extends ArrayAdapter<ItemMenu> {
	  private final Context context;
	  private final ItemMenu[] itens;

	  public MenuAdapter(Context context, ItemMenu[] itens) {
	    super(context, R.layout.item_menu, itens);
	    this.context = context;
	    this.itens = itens;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.item_menu, parent, false);
	    
	    TextView label = (TextView) rowView.findViewById(R.id.label);
	    TextView description = (TextView) rowView.findViewById(R.id.description);
	    ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
	    
	    label.setText(getContext().getString(itens[position].getLabel()));
	    description.setText(getContext().getString(itens[position].getDescription()));
	    icon.setImageResource(itens[position].getIcon());
	    
	    return rowView;
	  }
	} 