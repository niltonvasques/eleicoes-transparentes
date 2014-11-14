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
import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.Comite;
import br.ufba.mata62.eleicoestransparentes.model.Partido;
import br.ufba.mata62.eleicoestransparentes.model.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.model.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.model.Transacao;

public class ParserPrestacaoContasComiteDespesa2012 extends ParserFile<PrestContasComiteDespesa2012, Transacao>{
	
	public ParserPrestacaoContasComiteDespesa2012(String file) {
		super(file);
		setSkipHeader(true);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected PrestContasComiteDespesa2012 populateTemplate(String[] data) {
		PrestContasComiteDespesa2012 pcc = new PrestContasComiteDespesa2012();
		pcc.setDataHora(data[0].trim());
		pcc.setSequencialComite(data[1].trim());
		pcc.setUF(data[2].trim());
		pcc.setNumeroUE(data[3].trim());
		pcc.setMunicipio(data[4].trim());
		pcc.setTipoComite(data[5].trim());
		pcc.setSiglaPartido(data[6].trim());
		pcc.setTipoDocumento(data[7].trim());
		pcc.setNumeroDocumento(data[8].trim());
		pcc.setCPFCNPJFornecedor(data[9].trim());
		pcc.setNomeFornecedor(data[10].trim());
		pcc.setNomeReceitaFornecedor(data[11].trim());
		pcc.setCodSetorEconomicoFornecedor(data[12].trim());
		pcc.setSetorEconomicoFornecedor(data[13].trim());
		pcc.setDataDespesa(data[14].trim());
		pcc.setValorDespesa(data[15].trim());
		pcc.setTipoDespesa(data[16].trim());
		pcc.setDescricaoDespesa(data[17].trim());
		return pcc;
	}
	
	@Override
	protected Transacao populateModel(PrestContasComiteDespesa2012 pccd) {
		Transacao trans = new Transacao();
		trans.setTipoDocumento(pccd.getTipoDocumento());
		trans.setNumeroDocumento(pccd.getNumeroDocumento());
		Date data = formatDate(pccd.getDataHora());
		if(data!=null)
			trans.setData(data);
		trans.setValor(Float.parseFloat(pccd.getValorDespesa().replace(",", ".")));
		trans.setClassificacao(pccd.getTipoDespesa());
		trans.setDescricao(pccd.getDescricaoDespesa());
		trans.setCreditado(createFornecedor(pccd));
		trans.setDebitado(createComite(pccd));//TODO Comite não é tipo Pessoa
		trans.setTipo(Transacao.DESPESA);
		trans.setUF(pccd.getUF());
		trans.setMunicipio(pccd.getMunicipio());
		return trans;
	}
	
	@Override
	protected String getCharset() {
		return "utf-8";
	}

	private static AgenteEleitoral createComite(PrestContasComiteDespesa2012 pccd) {
		Comite com = new Comite();
		com.setUF(pccd.getUF());
		com.setMunicipio(pccd.getMunicipio());
		com.setTipo(pccd.getTipoComite());
		com.setSequencialComite(pccd.getUF()+pccd.getTipoComite()+pccd.getSiglaPartido());
		Partido partido = new Partido();
		partido.setSigla(pccd.getSiglaPartido());
		com.setPartido(partido);
		AgenteEleitoral agente = new AgenteEleitoral();
		agente.setComite(com);
		return agente; 
	}

	private static AgenteEleitoral createFornecedor(PrestContasComiteDespesa2012 pccd) {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj(pccd.getCPFCNPJFornecedor());
		pj.setNome(pccd.getNomeFornecedor());
		SetorEconomico se = new SetorEconomico();
		se.setNome(pccd.getSetorEconomicoFornecedor());
		se.setCodSetorEco(pccd.getCodSetorEconomicoFornecedor());
		pj.setSetorEconomico(se);
		AgenteEleitoral agente = new AgenteEleitoral();
		agente.setPessoa(pj);
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
