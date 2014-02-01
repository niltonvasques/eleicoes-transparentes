package br.ufba.mata62.eleicoestransparentes.persistance;

import java.util.Date;

public class Transacao {

	private String tipoDocumento;

	private String numeroDocumento;

	private Date data;

	private float valor;

	/**
	 * Classificação da transação, referente ao setor da transação.
	 */
	private String classificacao;

	private String descricao;

	/**
	 * Pode ser Candidato, Partido ou Comite, apenas
	 */
	private Pessoa creditado;

	private Pessoa debitado;

	/**
	 * R = RECEITA, D = DESPESA
	 */
	private char tipo;

	private String UF;

	private String municipio;

	private Pessoa[] pessoa;

}
