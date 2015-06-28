package br.ufba.eleicoestransparentes.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SetorEconomico")
public class SetorEconomico {

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(unique = true)
	private String codSetorEco;

	@DatabaseField
	private String nome;

	public String getCodSetorEco() {
		return codSetorEco;
	}

	public void setCodSetorEco(String codSetorEco) {
		this.codSetorEco = codSetorEco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
