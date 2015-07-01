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
	private String escolaridade;

	@DatabaseField(foreign = true)
	private Partido filiacao;

	@DatabaseField
	private String sexo;
	
	@DatabaseField
	private String estadoCivil;
	
	@DatabaseField
	private String ocupacao;
	
	@DatabaseField
	private String tituloEleitoral;
	
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

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Partido getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Partido filiacao) {
		this.filiacao = filiacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

}
