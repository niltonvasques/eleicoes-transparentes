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

public class UFAdapter extends BaseAdapter{

	private List<String> ufs;
	private Context context;
	
	
	public UFAdapter(Context context,String[] ufs){
		this.context=context;
		this.ufs = new ArrayList<String>();
		for (String s : ufs) {
			this.ufs.add(s);
		}
	}
	
	
	@Override
	public int getCount() {
		return ufs.size();
	}

	@Override
	public Object getItem(int position) {
		return ufs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.item_uf, null);
		RadioButton itemLanguage = (RadioButton) view.findViewById(R.id.item_uf);
		itemLanguage.setText(ufs.get(position));
		return view;
	}


}
