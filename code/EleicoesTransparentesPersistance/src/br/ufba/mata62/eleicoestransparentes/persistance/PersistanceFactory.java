package br.ufba.mata62.eleicoestransparentes.persistance;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMBem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMCandidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMComite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMEleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPartido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMPessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMSetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.ORMTransacao;

public class PersistanceFactory {
	
	public static SetorEconomico createSetorEconomico(ORMSetorEconomico orm){
		SetorEconomico setor = new SetorEconomico();
		
		setor.setId(orm.getId());
		setor.setNome(orm.getNome());
		setor.setCodSetorEco(orm.getCodSetorEco());
		
		return setor;
	}
	
	public static Partido createPartido(ORMPartido orm){
		
		Partido partido = new Partido();
		
		partido.setCnpj(orm.getPessoaJuridica().getCnpj());
		partido.setFaturamento(orm.getPessoaJuridica().getFaturamento());
		partido.setFundacao(orm.getPessoaJuridica().getFundacao());
		partido.setLocalizacao(orm.getPessoaJuridica().getLocalizacao());
		partido.setLucro(orm.getPessoaJuridica().getLucro());
		partido.setNome(orm.getPessoaJuridica().getPessoa().getNome());
		partido.setNumero(orm.getNumero());
		partido.setResumo(orm.getPessoaJuridica().getResumo());
		partido.setSegmento(orm.getPessoaJuridica().getSegmento());
		partido.setSetorEconomico(createSetorEconomico(orm.getPessoaJuridica().getPessoa().getSetorEconomico()));
		
		return partido;
	}

	public static Candidato createCandidato(ORMCandidato orm){
		Candidato candidato = new Candidato();
		
		candidato.setAlfabetizado(orm.getPessoaFisica().isAlfabetizado());
		candidato.setCargo(orm.getCargo());
		candidato.setCpf(orm.getPessoaFisica().getCpf());
		candidato.setFiliacao(createPartido(orm.getPartido()));
		candidato.setLocalNascimento(orm.getPessoaFisica().getLocalNascimento());
		candidato.setMunicipio(orm.getMunicipio());
		candidato.setNacionalidade(orm.getPessoaFisica().getNacionalidade());
		candidato.setNome(orm.getPessoaFisica().getPessoa().getNome());
		candidato.setNumero(orm.getNumero());
		candidato.setPartido(createPartido(orm.getPartido()));
		candidato.setSequencialCandidato(orm.getSequencialCandidato());
		candidato.setSexo(orm.getPessoaFisica().getSexo());
		candidato.setSiglaUE(orm.getPessoaFisica().getPessoa().getSiglaUE());
		candidato.setUF(orm.getUF());
		
		return candidato;
	}
	
	public static Bem createBem(ORMBem orm){
		Bem bem = new Bem();
		bem.setCandidato(createCandidato(orm.getCandidato()));
		bem.setDescricao(orm.getDescricao());
		bem.setId(orm.getId());
		bem.setValor(orm.getValor());
		
		return bem;
	}
	
	public static Comite createComite(ORMComite orm){
		Comite comite = new Comite();
		
		comite.setId(orm.getId());
		comite.setMunicipio(orm.getMunicipio());
		comite.setPartido(createPartido(orm.getPartido()));
		comite.setTipo(orm.getTipo());
		comite.setUF(orm.getUF());
		
		return comite;
	}
	
	public static Eleicao createEleicao(ORMEleicao orm){
		Eleicao eleicao = new Eleicao();
		
		eleicao.setAno(orm.getAno());
		eleicao.setTipo(orm.getTipo());
		eleicao.setId(orm.getId());
		
		return eleicao;
	}
	
	public static Pessoa createPessoa(ORMPessoa orm){
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(orm.getNome());
		pessoa.setSetorEconomico(createSetorEconomico(orm.getSetorEconomico()));
		pessoa.setSiglaUE(orm.getSiglaUE());
		
		return pessoa;
	}
	
	public static PessoaFisica createPessoaFisica(ORMPessoaFisica orm){
		PessoaFisica pessoa = new PessoaFisica();
		
		pessoa.setAlfabetizado(orm.isAlfabetizado());
		pessoa.setCpf(orm.getCpf());
		pessoa.setFiliacao(createPartido(orm.getFiliacao()));
		pessoa.setLocalNascimento(orm.getLocalNascimento());
		pessoa.setNacionalidade(orm.getNacionalidade());
		pessoa.setNome(orm.getPessoa().getNome());
		pessoa.setSetorEconomico(createSetorEconomico(orm.getPessoa().getSetorEconomico()));
		pessoa.setSexo(orm.getSexo());
		pessoa.setSiglaUE(orm.getPessoa().getSiglaUE());
		
		return pessoa;
	}
	
	public static PessoaJuridica createPessoaJuridica(ORMPessoaJuridica orm){
		PessoaJuridica pessoa = new PessoaJuridica();
		
		pessoa.setCnpj(orm.getCnpj());
		pessoa.setFaturamento(orm.getFaturamento());
		pessoa.setFundacao(orm.getFundacao());
		pessoa.setLocalizacao(orm.getLocalizacao());
		pessoa.setLucro(orm.getLucro());
		pessoa.setNome(orm.getPessoa().getNome());
		pessoa.setResumo(orm.getResumo());
		pessoa.setSegmento(orm.getSegmento());
		pessoa.setSetorEconomico(createSetorEconomico(orm.getPessoa().getSetorEconomico()));
		pessoa.setSiglaUE(orm.getPessoa().getSiglaUE());
		
		return pessoa;
	}
	
	public static Transacao createTransacao(ORMTransacao orm){
		Transacao transacao = new Transacao();
		
		transacao.setClassificacao(orm.getClassificacao());
		transacao.setCreditado(createPessoa(orm.getCreditado()));
		transacao.setDebitado(createPessoa(orm.getDebitado()));
		transacao.setDescricao(orm.getDescricao());
		transacao.setMunicipio(orm.getMunicipio());
		transacao.setNumeroDocumento(orm.getNumeroDocumento());
		transacao.setTipo(orm.getTipo());
		transacao.setTipoDocumento(orm.getTipoDocumento());
		transacao.setUF(orm.getUF());
		transacao.setValor(orm.getValor());
		
		return transacao;
	}
	
}
