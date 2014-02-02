package br.ufba.mata62.eleicoestransparentes.persistance;

public class Eleicao {
	
	private int id;

	private String ano;

	/**
	 * Se municipal, estadual ou nacional
	 */
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
