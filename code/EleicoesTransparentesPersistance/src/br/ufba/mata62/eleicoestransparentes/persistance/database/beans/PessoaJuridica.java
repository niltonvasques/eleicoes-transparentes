package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PessoaJuridica")
public class PessoaJuridica {

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(foreign = true, unique = true)
	private Pessoa pessoa;
	
	@DatabaseField
	private String cnpj;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	private String resumo;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	private String segmento;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	private Date fundacao;

	@DatabaseField
	private String localizacao;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	private float faturamento;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	private float lucro;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Date getFundacao() {
		return fundacao;
	}

	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa idPessoa) {
		this.pessoa = idPessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
