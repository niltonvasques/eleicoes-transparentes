package br.ufba.mata62.eleicoestransparentes.business;

import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class Comunicacao {

	public void consultaTransacao(ArrayList filtros) {

	}

	public ArrayList<Transacao> consultaGastos(ArrayList filtros) {
		return null;
	}

	public void insereCandidato(Candidato candidato) {

	}

	public void inserePartido(Partido partido) {

	}

	public void insereComite(Comite comite) {

	}

	public void inserePessoaFisica(PessoaFisica pfisica) {

	}

	public void inserePessoaJuridica(PessoaJuridica pjuridica) {

	}

	public void insereTransacao(Transacao transacao) {

	}

	public ArrayList consultaDoadores(ArrayList filtros) {
		return null;
	}

	public ArrayList consultarColigacao(ArrayList filtros) {
		return null;
	}

	public ArrayList consultaEleitor(Pessoa eleitor, Eleicao eleicao) {
		return null;
	}

	public int consultaIndiceAnalfabetismo(Eleicao eleicao, Pessoa pessoa) {
		return 0;
	}

	public int realizarComparaticoSexo(Eleicao eleicao, Pessoa pessoa) {
		return 0;
	}

	public void realizarComparacaoDiversa(ArrayList filtros) {

	}

	public ArrayList verificarRelacaoEleitores(ArrayList filtros) {
		return null;
	}

	public PessoaJuridica consultaPessoaJuridica(String nome) {
		return null;
	}

	public PessoaFisica consultaPessoaFisica(String nome) {
		return null;
	}

	public ArrayList consultaCandidatosEleicao(Eleicao eleicao) {
		return null;
	}

	public Bem consultaBensCandidato(String numero, Eleicao eleicao) {
		return null;
	}

	public int consultaComparativoIdade(Eleicao eleicao) {
		return 0;
	}

	public ArrayList consultaComparativoDonatarios(Eleicao eleicao) {
		return null;
	}

	public PessoaFisica atualizaPessoaFisica(String query) {
		return null;
	}

	public Candidato atualizaCandidato(String query) {
		return null;
	}

	public PessoaJuridica atualizaPessoaJuridica(String query) {
		return null;
	}

}
