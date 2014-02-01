package br.ufba.mata62.eleicoestransparentes.persistance;

public class PessoaFisica extends Pessoa {

	private String cpf;

	private String nacionalidade;

	private String localNascimento;

	private boolean alfabetizado;

	private Partido filiacao;

	private char sexo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	public boolean isAlfabetizado() {
		return alfabetizado;
	}

	public void setAlfabetizado(boolean alfabetizado) {
		this.alfabetizado = alfabetizado;
	}

	public Partido getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Partido filiacao) {
		this.filiacao = filiacao;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}



}
