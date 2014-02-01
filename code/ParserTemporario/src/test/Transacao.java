package test;

import java.util.Date;

public class Transacao {
	
	public static char DESPESA = 'D';
	public static char RECEITA = 'R';

	private String tipoDocumento;
	private String numeroDocumento;
	private Date data;
	private float valor;
	private String classificacao;
	private String descricao;
	private Pessoa creditado;
	private Pessoa debitado;
	private char tipo;
	private String UF;
	private String municipio;
	private Pessoa[] pessoa;
	
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getCreditado() {
		return creditado;
	}
	public void setCreditado(Pessoa creditado) {
		this.creditado = creditado;
	}
	public Pessoa getDebitado() {
		return debitado;
	}
	public void setDebitado(Pessoa debitado) {
		this.debitado = debitado;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
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
	public Pessoa[] getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa[] pessoa) {
		this.pessoa = pessoa;
	}

}