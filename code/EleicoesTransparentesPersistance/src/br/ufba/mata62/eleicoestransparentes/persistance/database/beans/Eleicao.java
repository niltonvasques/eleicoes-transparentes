package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Eleicao")
public class Eleicao extends EBean {
	
	@DatabaseField(generatedId = true)
	protected int id;

	@DatabaseField(unique = true)
	protected String ano;

	/**
	 * Se municipal, estadual ou nacional
	 */
	@DatabaseField
	protected int tipo;

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
