package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class BeanFactory {
	
	public static ORMBem createORMBem(Bem bem){
		ORMBem orm = new ORMBem();
		
		orm.setDescricao(bem.getDescricao());
		orm.setId(bem.getId());
		orm.setValor(bem.getValor());
		orm.setCandidato(createORMCandidato(bem.getCandidato()));
		
		return orm;
	}
	
	public static ORMSetorEconomico createORMSetorEconomico(SetorEconomico setor){
		ORMSetorEconomico orm = new ORMSetorEconomico();
		
		orm.setId(setor.getId());
		orm.setCodSetorEco(setor.getCodSetorEco());
		orm.setNome(setor.getNome());
		
		return orm;
	}
	
	
	public static ORMPessoa createORMPessoa(Pessoa pessoa){
		ORMPessoa orm = new ORMPessoa();
		
//		orm.setId(pessoa.getId());
		
		orm.setNome(pessoa.getNome());
		orm.setSetorEconomico(createORMSetorEconomico(pessoa.getSetorEconomico()));
		orm.setSiglaUE(pessoa.getSiglaUE());
		
		return orm;
	}
	
	public static ORMPessoaJuridica createORMPessoaJuridica(PessoaJuridica pessoa){
		ORMPessoaJuridica orm = new ORMPessoaJuridica();
		
		orm.setCnpj(pessoa.getCnpj());
		orm.setFaturamento(pessoa.getFaturamento());
		orm.setFundacao(pessoa.getFundacao());
//		orm.setId(pessoa.getId);
		orm.setLocalizacao(pessoa.getLocalizacao());
		orm.setLucro(pessoa.getLucro());
		orm.setPessoa(createORMPessoa(pessoa));
		orm.setResumo(pessoa.getResumo());
		orm.setSegmento(pessoa.getSegmento());
		
		return orm;
	}
	
	public static ORMPartido createORMPartido(Partido partido){
		ORMPartido orm = new ORMPartido();
		
//		orm.setId(partido.getId());
		orm.setNumero(partido.getNumero());
		orm.setPessoaJuridica(createORMPessoaJuridica(partido));
		orm.setSigla(partido.getSigla());
		
		return orm;
		
	}
	
	public static ORMPessoaFisica createORMPessoaFisica(PessoaFisica pessoa){
		ORMPessoaFisica orm = new ORMPessoaFisica();
		orm.setAlfabetizado(pessoa.isAlfabetizado());
		orm.setCpf(pessoa.getCpf());
		orm.setFiliacao(createORMPartido(pessoa.getFiliacao()));
//		orm.setId(pessoa.getId());
		orm.setLocalNascimento(pessoa.getLocalNascimento());
		orm.setNacionalidade(pessoa.getNacionalidade());
		orm.setPessoa(createORMPessoa(pessoa));
		orm.setSexo(pessoa.getSexo());
		
		return orm;
	}
	
	
	public static ORMCandidato createORMCandidato(Candidato cand){
		ORMCandidato orm = new ORMCandidato();
		
		orm.setCargo(cand.getCargo());
		orm.setMunicipio(cand.getMunicipio());
		orm.setNumero(cand.getNumero());
		orm.setPartido(createORMPartido(cand.getPartido()));
		orm.setPessoaFisica(createORMPessoaFisica(cand));
		orm.setUF(cand.getUF());
		orm.setSequencialCandidato(cand.getSequencialCandidato());
//		orm.setId(id)
		
		return orm;
	}
	
	public static ORMComite createORMComite(Comite comite){
		ORMComite orm = new ORMComite();
		
		orm.setId(comite.getId());
		orm.setMunicipio(comite.getMunicipio());
		orm.setPartido(createORMPartido(comite.getPartido()));
		orm.setTipo(comite.getTipo());
		orm.setUF(comite.getUF());
		
		return orm;
	}

	public static ORMEleicao createORMEleicao(Eleicao eleicao) {
		ORMEleicao orm = new ORMEleicao();
		
		orm.setAno(eleicao.getAno());
//		orm.setId(eleicao.getId());
		orm.setTipo(eleicao.getTipo());
		
		return orm;
	}

	public static ORMTransacao createORMTransacao(Transacao transacao) {
		ORMTransacao orm = new ORMTransacao();
		
		orm.setClassificacao(transacao.getClassificacao());
		//TODO: Rever a adição de objetos da superclasse
		orm.setCreditado(createORMPessoa(transacao.getCreditado()));
		orm.setData(transacao.getData());
		orm.setDebitado(createORMPessoa(transacao.getDebitado()));
		orm.setDescricao(transacao.getDescricao());
//		orm.setId(transacao.getId());
		orm.setMunicipio(transacao.getMunicipio());
		orm.setNumeroDocumento(transacao.getNumeroDocumento());
		orm.setTipo(transacao.getTipo());
		orm.setTipoDocumento(transacao.getTipoDocumento());
		orm.setUF(transacao.getUF());
		orm.setValor(transacao.getValor());
		
		return orm;
	}

	
}
