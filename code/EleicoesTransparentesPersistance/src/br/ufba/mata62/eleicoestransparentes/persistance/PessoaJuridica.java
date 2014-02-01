package br.ufba.mata62.eleicoestransparentes.persistance;

import java.util.Date;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	/**
	 * Fonte: wikipedia, etc
	 */
	private String resumo;

	/**
	 * Fonte: wikipedia, etc
	 */
	private String segmento;

	/**
	 * Fonte: wikipedia, etc
	 */
	private Date fundacao;

	private String localizacao;

	/**
	 * Fonte: wikipedia, etc
	 */
	private float faturamento;

	/**
	 * Fonte: wikipedia, etc
	 */
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
}
