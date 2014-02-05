package br.ufba.mata62.eleicoestransparentes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class MenuAdapter extends BaseAdapter{

	private int[] itens;
	private Context context;
	
	public MenuAdapter(Context context,int[] itens){
		this.itens =itens;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		return itens.length;
	}

	@Override
	public Object getItem(int position) {
		return itens[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.menu_item, null);
		TextView labelItem = (TextView) view.findViewById(R.id.label_item);
		labelItem.setText(context.getResources().getString(itens[position]));
		return view;
	}


}
