package br.ufba.mata62.eleicoestransparentes.business.parser.ano2012;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufba.mata62.eleicoestransparentes.business.parser.ParserFile;
import br.ufba.mata62.eleicoestransparentes.business.parser.templates.ano2012.PrestContasCandidatoReceita2012;
import br.ufba.mata62.eleicoestransparentes.model.Candidato;
import br.ufba.mata62.eleicoestransparentes.model.Partido;
import br.ufba.mata62.eleicoestransparentes.model.Pessoa;
import br.ufba.mata62.eleicoestransparentes.model.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.model.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.model.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.utils.ValidatorCPFCNPJ;

public class ParserPrestacaoContasCandidatoReceita extends ParserFile<PrestContasCandidatoReceita2012, Transacao>{
	
	public ParserPrestacaoContasCandidatoReceita(String file) {
		super(file);
		setSkipHeader(true);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected PrestContasCandidatoReceita2012 populateTemplate(String[] data) {
		PrestContasCandidatoReceita2012 pcr = new PrestContasCandidatoReceita2012();
		pcr.setDataHora(data[0].trim());
		pcr.setSequencialCandidato(data[1].trim());
		pcr.setUF(data[2].trim());
		pcr.setNumeroUE(data[3].trim());
		pcr.setMunicipio(data[4].trim());
		pcr.setSiglaPartido(data[5].trim());
		pcr.setNumeroCandidato(data[6].trim());
		pcr.setCargo(data[7].trim());
		pcr.setNomeCandidato(data[8].trim());
		pcr.setCPFCandidato(data[9].trim());
		pcr.setNumeroReciboEleitoral(data[10].trim());
		pcr.setNumeroDocumento(data[11].trim());
		pcr.setCPFCNPJDoador(data[12].trim());
		pcr.setNomeDoador(data[13].trim());
		pcr.setNomeReceitaDoador(data[14]);
		pcr.setSiglaUEDoador(data[15].trim());
		pcr.setNumeroPartidoDoador(data[16].trim());
		pcr.setNumeroCandidatoDoador(data[17].trim());
		pcr.setCodSetorEconomicoDoador(data[18].trim());
		pcr.setSetorEconomicoDoador(data[19].trim());
		pcr.setDataReceita(data[20].trim());
		pcr.setValorReceita(data[21].trim());
		pcr.setTipoReceita(data[22].trim());
		pcr.setFonteRecurso(data[23].trim());
		pcr.setEspecieRecurso(data[24].trim());
		pcr.setDescricaoReceita(data[25].trim());
		return pcr;
	}
	
	@Override
	protected Transacao populateModel(PrestContasCandidatoReceita2012 pccr) {
		Transacao trans = new Transacao();
		trans.setNumeroDocumento(pccr.getNumeroDocumento());
		Date data = formatDate(pccr.getDataHora());
		if(data!=null)
			trans.setData(data);
		trans.setValor(Float.parseFloat(pccr.getValorReceita().replace(",", ".")));
		trans.setClassificacao(pccr.getTipoReceita());
		trans.setDescricao(pccr.getDescricaoReceita());
		trans.setCreditado(createCandidato(pccr));
		trans.setDebitado(createDoador(pccr));
		trans.setTipo(Transacao.RECEITA);
		trans.setUF(pccr.getUF());
		trans.setMunicipio(pccr.getMunicipio());
		return trans;
	}
	
	private static Candidato createCandidato(PrestContasCandidatoReceita2012 pccr) {
		Candidato cand = new Candidato();
		cand.setNumero(pccr.getNumeroCandidato());
		cand.setCargo(pccr.getCargo());
		cand.setUF(pccr.getUF());
		cand.setMunicipio(pccr.getMunicipio());
		cand.setSequencialCandidato(pccr.getSequencialCandidato());
		Partido partido = new Partido();
		partido.setSigla(pccr.getSiglaPartido());
		cand.setPartido(partido);
		cand.setCpf(pccr.getCPFCandidato());
		cand.setNome(pccr.getNomeCandidato());
		return cand; 
	}

	private static Pessoa createDoador(PrestContasCandidatoReceita2012 pccr) {
		Pessoa pessoa = null;
		
		if(ValidatorCPFCNPJ.isValidCPF(pccr.getCPFCNPJDoador())){
			pessoa = new PessoaFisica();
			((PessoaFisica)pessoa).setCpf(pccr.getCPFCNPJDoador());
			String np = pccr.getNumeroPartidoDoador().trim();
			if(!np.isEmpty()){
				Partido filiacao = new Partido();
				filiacao.setNumero(Integer.parseInt(np));
				filiacao.setNome(pccr.getNumeroCandidatoDoador());
				((PessoaFisica)pessoa).setFiliacao(filiacao);
			}
		}else{
			if(ValidatorCPFCNPJ.isValidCNPJ(pccr.getCPFCNPJDoador())){
				pessoa = new PessoaJuridica();
				((PessoaJuridica)pessoa).setCnpj(pccr.getCPFCNPJDoador());
			}
		}		
		
		if(pessoa != null){
			pessoa.setNome(pccr.getNomeDoador());
			pessoa.setSiglaUE(pccr.getSiglaUEDoador());
			SetorEconomico se = new SetorEconomico();
			se.setCodSetorEco(pccr.getCodSetorEconomicoDoador());
			se.setNome(pccr.getSetorEconomicoDoador());
			pessoa.setSetorEconomico(se);
		}
		return pessoa;
	}
	private static Date formatDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyhh:mm");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


}
