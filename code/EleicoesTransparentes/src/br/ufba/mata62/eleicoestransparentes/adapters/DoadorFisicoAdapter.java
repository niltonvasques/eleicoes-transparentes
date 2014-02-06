package br.ufba.mata62.eleicoestransparentes.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans.PessoaFisicaDoador;
import br.ufba.mata62.eleicoestransparentes.ui.activities.R;
import br.ufba.mata62.eleicoestransparentes.utils.Util;

public class DoadorFisicoAdapter extends BaseAdapter{

	private List<PessoaFisicaDoador> doadores;
	private Context context;
	
	public DoadorFisicoAdapter(Context context,List<PessoaFisicaDoador> doadores){
		this.doadores =doadores;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		return doadores.size();
	}

	@Override
	public Object getItem(int position) {
		return doadores.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.doador_item, null);
		TextView nameItem = (TextView) view.findViewById(R.id.name_item);
		TextView valueItem = (TextView) view.findViewById(R.id.value_item);
		
		nameItem.setText(doadores.get(position).getPessoa().getNome());
		valueItem.setText(String.valueOf(Util.floatFormated(doadores.get(position).getValor())));
		return view;
	}


}
