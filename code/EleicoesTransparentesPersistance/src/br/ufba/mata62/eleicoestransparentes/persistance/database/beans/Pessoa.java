package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


public abstract class Pessoa {
	
	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField
	private String siglaUE;

	@DatabaseField
	private String nome;

	@DatabaseField(foreign = true)
	private SetorEconomico setorEconomico;

//TODO: Rever relação entre pessoa e bem
//	private Bem[] bem;

	public String getSiglaUE() {
		return siglaUE;
	}

	public void setSiglaUE(String siglaUE) {
		this.siglaUE = siglaUE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SetorEconomico getSetorEconomico() {
		return setorEconomico;
	}

	public void setSetorEconomico(SetorEconomico setorEconomico) {
		this.setorEconomico = setorEconomico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	

}
