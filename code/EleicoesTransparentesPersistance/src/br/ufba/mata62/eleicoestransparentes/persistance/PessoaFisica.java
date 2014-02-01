package br.ufba.mata62.eleicoestransparentes.persistance;

public class PessoaFisica extends Pessoa {

	private String cpf;

	private String nacionalidade;

	private String localNascimento;

	private boolean alfabetizado;

	private Partido filiacao;

	private char sexo;

	public boolean verificarEleitor() {
		return false;
	}

	public String verificaSexo() {
		return null;
	}

	public void consultarRelacaoEleitoresPorFiliados() {

	}

	public void consultarDados() {

	}

}
