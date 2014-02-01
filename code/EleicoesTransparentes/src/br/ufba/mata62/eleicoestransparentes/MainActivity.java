package br.ufba.mata62.eleicoestransparentes;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.adapters.MenuAdapter;

public class MainActivity extends FragmentActivity {

	private int[] menuItens = { R.string.mi_prestacao_contas_partido,
			R.string.mi_prestacao_contas_candidato, R.string.mi_maior_gasto,
			R.string.mi_origem_gastos, R.string.mi_doadores,
			R.string.mi_declaracao_bens, R.string.mi_eleitores };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loadComponents();
	}

	private void loadComponents() {
		ListView menu = (ListView) findViewById(R.id.menu);
		BaseAdapter adapter = new MenuAdapter(MainActivity.this, menuItens);
		menu.setAdapter(adapter);
	}
}
