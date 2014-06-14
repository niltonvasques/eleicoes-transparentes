package br.ufba.mata62.eleicoestransparentes.ui.dialogs.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class BemAdapter extends BaseAdapter{

	private List<Bem> bens;
	private Context context;
	
	public BemAdapter(Context context,List<Bem> bens){
		this.bens =bens;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		return bens.size();
	}

	@Override
	public Object getItem(int position) {
		return bens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.bem_item, null);
		TextView nameItem = (TextView) view.findViewById(R.id.name_item);
		TextView valueItem = (TextView) view.findViewById(R.id.value_item);
		
		nameItem.setText(bens.get(position).getDescricao());
		valueItem.setText(String.valueOf(bens.get(position).getValor()));
		return view;
	}


}
