package br.com.eleicoestransparentes.persistence.beans;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PessoaJuridica")
public class PessoaJuridica extends Pessoa{

	@DatabaseField(unique=true)
	protected String cnpj;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	protected String resumo;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	protected String segmento;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	protected Date fundacao;

	@DatabaseField
	protected String localizacao;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	protected float faturamento;

	/**
	 * Fonte: wikipedia, etc
	 */
	@DatabaseField
	protected float lucro;

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

}
