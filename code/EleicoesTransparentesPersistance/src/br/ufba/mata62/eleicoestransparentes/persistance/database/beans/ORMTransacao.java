package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Transacao")
public class ORMTransacao {
	
	public static final char RECEITA = 'R';
	public static final char DESPESA = 'D';
	
	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField
	private String tipoDocumento;

	@DatabaseField
	private String numeroDocumento;

	@DatabaseField
	private Date data;

	@DatabaseField
	private float valor;

	/**
	 * Classificação da transação, referente ao setor da transação.
	 */
	@DatabaseField
	private String classificacao;

	@DatabaseField
	private String descricao;

	/**
	 * Pode ser Candidato, Partido ou Comite, apenas
	 */
	@DatabaseField(foreign = true)
	private ORMPessoa creditado;

	@DatabaseField(foreign = true)
	private ORMPessoa debitado;

	/**
	 * R = RECEITA, D = DESPESA
	 */
	@DatabaseField
	private char tipo;

	@DatabaseField
	private String UF;

	@DatabaseField
	private String municipio;

//	@DatabaseField
//	private Pessoa[] pessoa;

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

	public ORMPessoa getCreditado() {
		return creditado;
	}

	public void setCreditado(ORMPessoa creditado) {
		this.creditado = creditado;
	}

	public ORMPessoa getDebitado() {
		return debitado;
	}

	public void setDebitado(ORMPessoa debitado) {
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
}