package br.ufba.mata62.eleicoestransparentes.persistance;

public class Pessoa {

	private String siglaUE;

	private String nome;

	private SetorEconomico setorEconomico;

	private Bem bens;

	private Bem[] bem;

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

	public Bem getBens() {
		return bens;
	}

	public void setBens(Bem bens) {
		this.bens = bens;
	}

	public Bem[] getBem() {
		return bem;
	}

	public void setBem(Bem[] bem) {
		this.bem = bem;
	}
	
	

}
