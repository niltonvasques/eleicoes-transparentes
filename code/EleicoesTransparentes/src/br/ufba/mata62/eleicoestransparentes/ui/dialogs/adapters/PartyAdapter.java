package br.ufba.mata62.eleicoestransparentes.ui.dialogs.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class PartyAdapter extends BaseAdapter{

	private List<Partido> parties;
	private Context context;
	
	public PartyAdapter(Context context,List<Partido> parties){
		this.context=context;
		this.parties = parties;
	}
	
	@Override
	public int getCount() {
		return parties.size();
	}

	@Override
	public Object getItem(int position) {
		return parties.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.item_party, null);
		TextView itemLanguage = (TextView) view.findViewById(R.id.item_party);
		itemLanguage.setText(parties.get(position).getSigla());
		return view;
	}


}
