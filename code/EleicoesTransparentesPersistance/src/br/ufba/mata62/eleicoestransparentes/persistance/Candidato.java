package br.ufba.mata62.eleicoestransparentes.persistance;

import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Candidato")
public class Candidato extends PessoaFisica{

	@DatabaseField(canBeNull = false)
	private String numero;

	@DatabaseField
	private String cargo;

	@DatabaseField
	private String UF;

	@DatabaseField
	private String municipio;

	@DatabaseField
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
	
	

}
