package br.ufba.mata62.eleicoestransparentes.business;

import java.util.ArrayList;
import java.util.Arrays;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;

public class TransacaoBusiness {

	public ArrayList consultaTransacoesReceita(Candidato candidato, Eleicao eleicao) {
		return null;
	}

	public ArrayList consultaTransacoesDespesa(Candidato candidato, Eleicao eleicao) {
		return null;
	}

	public ArrayList consultaTransacoesReceita(Partido partido, Eleicao eleicao) {
		return null;
	}

	public ArrayList consultaTransacoesDespesa(Partido partido, Eleicao eleicao) {
		return null;
	}

	public Arrays consultaTransacoesDespesa(Comite comite, Eleicao eleicao) {
		return null;
	}

	public ArrayList<Transacao> consultaTransacoesReceita(Comite comite, Eleicao eleicao) {
		return null;
	}

}
