package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PessoaFisica")
public class ORMPessoaFisica {

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(foreign = true, unique = true)
	private ORMPessoa pessoa;
	
	@DatabaseField
	private String cpf;

	@DatabaseField
	private String nacionalidade;

	@DatabaseField
	private String localNascimento;

	@DatabaseField
	private boolean alfabetizado;

	@DatabaseField(foreign = true)
	private ORMPartido filiacao;

	@DatabaseField
	private char sexo;
	
	public ORMPessoaFisica() {
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

	public ORMPartido getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(ORMPartido filiacao) {
		this.filiacao = filiacao;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ORMPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(ORMPessoa idPessoa) {
		this.pessoa = idPessoa;
	}
	
	

}
