package br.ufba.mata62.eleicoestransparentes.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Eleicao")
public class Eleicao {
	
	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(unique = true)
	private String ano;

	/**
	 * Se municipal, estadual ou nacional
	 */
	@DatabaseField
	private int tipo;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
