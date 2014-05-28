package br.com.eleicoestransparentes.persistence.beans;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Transacao")
public class Transacao extends EBean {
	
	public static final char RECEITA = 'R';
	public static final char DESPESA = 'D';
	
	@DatabaseField(generatedId = true)
	protected int id;

	@DatabaseField
	protected String tipoDocumento;

	@DatabaseField
	protected String numeroDocumento;

	@DatabaseField
	protected Date data;

	@DatabaseField
	protected float valor;

	/**
	 * Classificação da transação, referente ao setor da transação.
	 */
	@DatabaseField
	protected String classificacao;

	@DatabaseField
	protected String descricao;

	/**
	 * Pode ser Candidato, Partido ou Comite, apenas
	 */
	@DatabaseField(foreign = true)
	protected Pessoa creditado;
	
	/**
	 * tipo creditado deverá conter o nome da tabela a qual este está apontando
	 */
	@DatabaseField
	protected String tipoCreditado;

	@DatabaseField(foreign = true)
	protected Pessoa debitado;
	
	/**
	 * tipo debitado deverá conter o nome da tabela a qual este está apontando
	 */
	@DatabaseField
	protected String tipoDebitado;

	/**
	 * R = RECEITA, D = DESPESA
	 */
	@DatabaseField
	protected char tipo;

	@DatabaseField
	protected String UF;

	@DatabaseField
	protected String municipio;

//	@DatabaseField
//	protected Pessoa[] pessoa;

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
		if(descricao.length() > 200){
			descricao = descricao.substring(0, 200);
		}
		this.descricao = descricao;
	}

	public Pessoa getCreditado() {
		return creditado;
	}

	public void setCreditado(Pessoa creditado) {
		if(creditado != null)	this.tipoCreditado = creditado.getClass().getSimpleName();
		this.creditado = creditado;
	}

	public Pessoa getDebitado() {
		return debitado;
	}

	public void setDebitado(Pessoa debitado) {
		if(debitado != null)	this.tipoDebitado = debitado.getClass().getSimpleName();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoCreditado() {
		return tipoCreditado;
	}

	public String getTipoDebitado() {
		return tipoDebitado;
	}
	
 }
