package br.ufba.mata62.eleicoestransparentes.business.parser.ano2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.business.parser.ParserFile;
import br.ufba.mata62.eleicoestransparentes.business.parser.templates.ano2012.PrestContasComiteDespesa2012;
import br.ufba.mata62.eleicoestransparentes.business.parser.templates.ano2012.PrestContasComiteReceita2012;
import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.Comite;
import br.ufba.mata62.eleicoestransparentes.model.Partido;
import br.ufba.mata62.eleicoestransparentes.model.Pessoa;
import br.ufba.mata62.eleicoestransparentes.model.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.model.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.model.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;
import br.ufba.mata62.eleicoestransparentes.util.ValidatorCPFCNPJ;

public class ParserPrestacaoContasComiteReceita2012 extends ParserFile<PrestContasComiteReceita2012, Transacao> {
	
	public ParserPrestacaoContasComiteReceita2012(String file) {
		super(file);
		setSkipHeader(true);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected PrestContasComiteReceita2012 populateTemplate(String[] data) {
		PrestContasComiteReceita2012 pcr = new PrestContasComiteReceita2012();
		pcr.setDataHora(data[0].trim());
		pcr.setSequencialComite(data[1].trim());
		pcr.setUF(data[2].trim());
		pcr.setNumeroUE(data[3].trim());
		pcr.setMunicipio(data[4].trim());
		pcr.setTipoComite(data[5].trim());
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
	protected Transacao populateModel(PrestContasComiteReceita2012 pccr) {
		Transacao trans = new Transacao();
		trans.setNumeroDocumento(pccr.getNumeroDocumento());
		Date data = formatDate(pccr.getDataHora());
		if(data!=null)
			trans.setData(data);
		trans.setValor(Float.parseFloat(pccr.getValorReceita().replace(",", ".")));
		trans.setClassificacao(pccr.getTipoReceita());
		trans.setDescricao(pccr.getDescricaoReceita());
		trans.setCreditado(createComite(pccr)); //TODO Comite não é uma pessoa
		trans.setDebitado(createDoador(pccr));
		trans.setTipo(Transacao.RECEITA);
		trans.setUF(pccr.getUF());
		trans.setMunicipio(pccr.getMunicipio());
		return trans;
	}
	
	private static AgenteEleitoral createComite(PrestContasComiteReceita2012 pccd) {
		Comite com = new Comite();
		com.setUF(pccd.getUF());
		com.setMunicipio(pccd.getMunicipio());
		com.setTipo(pccd.getTipoComite());
		Partido partido = new Partido();
		partido.setSigla(pccd.getSiglaPartido());
		com.setPartido(partido);
		AgenteEleitoral agente = new AgenteEleitoral();
		agente.setComite(com);
		return agente; 
	}

	private static AgenteEleitoral createDoador(PrestContasComiteReceita2012 pccr) {
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
		AgenteEleitoral agente = new AgenteEleitoral();
		agente.setPessoa(pessoa);
		return agente;
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
