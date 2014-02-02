package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Partido")
public class Partido {
	
	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(foreign = true, unique = true)
	private PessoaJuridica pessoaJuridica;
	
	@DatabaseField(unique = true)
	private String sigla;

	@DatabaseField(unique = true)
	private int numero;

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

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica idPessoaJuridica) {
		this.pessoaJuridica = idPessoaJuridica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
