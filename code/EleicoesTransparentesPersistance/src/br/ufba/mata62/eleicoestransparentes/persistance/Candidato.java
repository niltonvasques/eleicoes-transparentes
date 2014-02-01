package br.ufba.mata62.eleicoestransparentes.persistance;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Candidato")
public class Candidato{
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(foreign = true, unique = true)
	private PessoaFisica pessoaFisica;

	@DatabaseField(canBeNull = false)
	private String numero;

	@DatabaseField
	private String cargo;

	@DatabaseField
	private String UF;

	@DatabaseField
	private String municipio;

	@DatabaseField(foreign = true)
	private Partido partido;
	
	//TODO: Rever como irá fazer com a relação entre candidatos e eleição
//	@DatabaseField
//	private List<Eleicao> eleicoes;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica idPessoaFisica) {
		this.pessoaFisica = idPessoaFisica;
	}
	
	
	
	

}
