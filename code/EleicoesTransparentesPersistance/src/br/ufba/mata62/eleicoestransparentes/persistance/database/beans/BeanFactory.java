package br.ufba.mata62.eleicoestransparentes.persistance.database.beans;

import br.ufba.mata62.eleicoestransparentes.persistance.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;

public class BeanFactory {
	
	public ORMBem createORMBem(Bem bem){
		ORMBem orm = new ORMBem();
		
		orm.setDescricao(bem.getDescricao());
		orm.setId(bem.getId());
		orm.setValor(bem.getValor());
		
		return orm;
	}
	
	public ORMSetorEconomico createORMSetorEconomico(SetorEconomico setor){
		ORMSetorEconomico orm = new ORMSetorEconomico();
		
		orm.setCodSetorEco(setor.getCodSetorEco());
		orm.setNome(setor.getNome());
		
		return orm;
	}
	
	
	public ORMPessoa createORMPessoa(Pessoa pessoa){
		ORMPessoa orm = new ORMPessoa();
		
//		orm.setId(pessoa.getId());
		
		orm.setNome(pessoa.getNome());
		orm.setSetorEconomico(createORMSetorEconomico(pessoa.getSetorEconomico()));
		orm.setSiglaUE(pessoa.getSiglaUE());
		
		return orm;
	}
	
	public ORMPessoaJuridica createORMPessoaJuridica(PessoaJuridica pessoa){
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
	
	public ORMPartido createORMPartido(Partido partido){
		ORMPartido orm = new ORMPartido();
		
//		orm.setId(partido.getId());
		orm.setNumero(partido.getNumero());
		orm.setPessoaJuridica(createORMPessoaJuridica(partido));
		orm.setSigla(partido.getSigla());
		
		return orm;
		
	}
	
	public ORMPessoaFisica createORMPessoaFisica(PessoaFisica pessoa){
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
	
	
	public ORMCandidato createORMCandidato(Candidato cand){
		ORMCandidato orm = new ORMCandidato();
		
		orm.setCargo(cand.getCargo());
		orm.setMunicipio(cand.getMunicipio());
		orm.setNumero(cand.getNumero());
		orm.setPartido(createORMPartido(cand.getPartido()));
		orm.setPessoaFisica(createORMPessoaFisica(cand));
		orm.setUF(cand.getUF());
//		orm.setId(id)
		
		return orm;
	}

	
}
