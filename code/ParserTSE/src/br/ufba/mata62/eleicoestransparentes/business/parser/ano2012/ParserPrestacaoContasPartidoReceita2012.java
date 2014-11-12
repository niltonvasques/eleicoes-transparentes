package br.ufba.mata62.eleicoestransparentes.business.parser.ano2012;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufba.mata62.eleicoestransparentes.business.parser.ParserFile;
import br.ufba.mata62.eleicoestransparentes.business.parser.templates.ano2012.PrestContasPartidoReceita2012;
import br.ufba.mata62.eleicoestransparentes.model.Partido;
import br.ufba.mata62.eleicoestransparentes.model.Pessoa;
import br.ufba.mata62.eleicoestransparentes.model.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.model.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.model.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.util.ValidatorCPFCNPJ;

public class ParserPrestacaoContasPartidoReceita2012 extends ParserFile<PrestContasPartidoReceita2012, Transacao>{
	
	public ParserPrestacaoContasPartidoReceita2012(String file) {
		super(file);
		setSkipHeader(true);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected PrestContasPartidoReceita2012 populateTemplate(String[] data) {
		PrestContasPartidoReceita2012 pcr = new PrestContasPartidoReceita2012();
		pcr.setDataHora(data[0].trim());
		pcr.setSequencialPartido(data[1].trim());
		pcr.setUF(data[2].trim());
		pcr.setNumeroUE(data[3].trim());
		pcr.setMunicipio(data[4].trim());
		pcr.setTipoPartido(data[5].trim());
		pcr.setSiglaPartido(data[6].trim());
		pcr.setTipoDocumento(data[7].trim());
		pcr.setNumeroDocumento(data[8].trim());
		pcr.setCPFCNPJDoador(data[9].trim());
		pcr.setNomeDoador(data[10].trim());
		pcr.setNomeReceitaDoador(data[11].trim());
		pcr.setSiglaUEDoador(data[12].trim());
		pcr.setNumeroPartidoDoador(data[13].trim());
		pcr.setNumeroCandidatoDoador(data[14].trim());
		pcr.setCodSetorEconomicoDoador(data[15].trim());
		pcr.setSetorEconomicoDoador(data[16].trim());
		pcr.setDataReceita(data[17].trim());
		pcr.setValorReceita(data[18].trim());
		pcr.setTipoReceita(data[19].trim());
		pcr.setFonteRecurso(data[20].trim());
		pcr.setEspecieRecurso(data[21].trim());
		pcr.setDescricaoReceita(data[22].trim());
		return pcr;
	}
	
	@Override
	public Transacao populateModel(PrestContasPartidoReceita2012 pccr){
		Transacao trans = new Transacao();
		trans.setNumeroDocumento(pccr.getNumeroDocumento());
		Date data = formatDate(pccr.getDataHora());
		if(data!=null)
			trans.setData(data);
		trans.setValor(Float.parseFloat(pccr.getValorReceita().replace(",", ".")));
		trans.setClassificacao(pccr.getTipoReceita());
		trans.setDescricao(pccr.getDescricaoReceita());
		trans.setCreditado(createPartido(pccr));
		trans.setDebitado(createDoador(pccr));
		trans.setTipo(Transacao.RECEITA);
		trans.setUF(pccr.getUF());
		trans.setMunicipio(pccr.getMunicipio());
		return trans;
	}
	
	private static Partido createPartido(PrestContasPartidoReceita2012 pccr) {
		Partido part = new Partido();
		part.setSigla(pccr.getSiglaPartido());
		return part; 
	}

	private static Pessoa createDoador(PrestContasPartidoReceita2012 pccr) {
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
