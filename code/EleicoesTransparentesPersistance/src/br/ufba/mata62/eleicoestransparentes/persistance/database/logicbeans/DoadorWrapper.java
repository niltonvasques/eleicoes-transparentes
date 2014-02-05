package br.ufba.mata62.eleicoestransparentes.persistance.database.logicbeans;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Pessoa;

public class DoadorWrapper{
	private Pessoa pessoa;
	private float valor;
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}