package br.ufba.mata62.eleicoestransparentes.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;

public class CandidatoAdapter extends BaseAdapter{

	private List<Candidato> candidatos;
	private Context context;
	
	public CandidatoAdapter(Context context,List<Candidato> candidatos){
		this.candidatos =candidatos;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		return candidatos.size();
	}

	@Override
	public Object getItem(int position) {
		return candidatos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.candidato_item, null);
		TextView nameItem = (TextView) view.findViewById(R.id.name_item);
		nameItem.setText(candidatos.get(position).getNome());
		return view;
	}


}
