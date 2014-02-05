package br.ufba.mata62.eleicoestransparentes.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class PartyAdapter extends BaseAdapter{

	private List<String> parties;
	private Context context;
	
	
	public PartyAdapter(Context context,String[] parties){
		this.context=context;
		this.parties = new ArrayList<String>();
		for (String s : parties) {
			this.parties.add(s);
		}
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
		RadioButton itemLanguage = (RadioButton) view.findViewById(R.id.item_party);
		itemLanguage.setText(parties.get(position));
		return view;
	}


}
