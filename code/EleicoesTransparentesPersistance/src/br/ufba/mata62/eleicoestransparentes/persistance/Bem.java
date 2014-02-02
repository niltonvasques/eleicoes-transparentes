package br.ufba.mata62.eleicoestransparentes.persistance;



/**
 * @author niltonvasques
 *
 */
public class Bem {

	private int id;
	
	private String descricao;

	private float valor;
	
	private Candidato candidato;
	
	public Bem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
 
 }
