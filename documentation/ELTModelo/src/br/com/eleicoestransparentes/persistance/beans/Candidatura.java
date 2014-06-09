package br.com.eleicoestransparentes.persistance.beans;

public class Candidatura {
	protected Eleicao eleicao;
	
	protected Situacao[] situacoes;
	protected Candidato candidato;

	protected Cargo cargo;
	protected String codSituacaoCandidatura;
	protected String desSituacaoCandidatura;

	protected Partido partido;
	protected Legenda legenda;

	protected float despesaMaxCampanha;

}