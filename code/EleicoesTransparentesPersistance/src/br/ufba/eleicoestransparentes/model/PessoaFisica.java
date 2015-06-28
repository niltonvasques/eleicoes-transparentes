package br.ufba.eleicoestransparentes.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PessoaFisica")
public class PessoaFisica extends Pessoa{

	@DatabaseField(unique=true)
	private String cpf;

	@DatabaseField
	private String nacionalidade;

	@DatabaseField
	private String localNascimento;

	@DatabaseField
	private boolean alfabetizado;

	@DatabaseField(foreign = true)
	private Partido filiacao;

	@DatabaseField
	private char sexo;
	
	public PessoaFisica() {
	}

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
