package br.com.eleicoestransparentes.persistence.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Partido")
public class Partido extends PessoaJuridica{
	
	@DatabaseField(unique = true)
	protected String sigla;

	@DatabaseField(unique = false)//TODO pq no arquivo que popula não tem essa info.
	protected int numero;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


}
