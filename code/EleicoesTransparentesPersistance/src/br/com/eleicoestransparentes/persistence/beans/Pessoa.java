package br.com.eleicoestransparentes.persistence.beans;

import com.j256.ormlite.field.DatabaseField;


public abstract class Pessoa extends EBean {
	
	@DatabaseField(generatedId = true)
	protected int id;

	@DatabaseField
	protected String siglaUE;

	@DatabaseField
	protected String nome;

	@DatabaseField(foreign = true)
	protected SetorEconomico setorEconomico;

//TODO: Rever relação entre pessoa e bem
//	protected Bem[] bem;

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
