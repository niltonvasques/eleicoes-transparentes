package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.dadosBrutos.PrestContasCandidatoDespesa;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class ParserPrestacaoContasCandidatoDespesa {
	
	public static List<PrestContasCandidatoDespesa> parsing(String path){
		List<PrestContasCandidatoDespesa> pccList = new ArrayList<PrestContasCandidatoDespesa>();
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

			try {
				br = new BufferedReader(new FileReader(csvFile));
				br.readLine().split(cvsSplitBy);//Eliminando o cabeçalho
				while ((line = br.readLine()) != null) {
					line = line.replace("\"\"", " ");
					line = line.replace("\"", " ");
					String data[] = line.split(cvsSplitBy);
						pccList.add(populate(data));
				}
				br.close();
				return pccList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	private static PrestContasCandidatoDespesa populate(String[] data) {
		PrestContasCandidatoDespesa pcc = new PrestContasCandidatoDespesa();
		pcc.setDataHora(data[0]);
		pcc.setSequencialCandidato(data[1]);
		pcc.setUF(data[2]);
		pcc.setNumeroUE(data[3]);
		pcc.setMunicipio(data[4]);
		pcc.setSiglaPartido(data[5]);
		pcc.setNumerocandidato(data[6]);
		pcc.setCargo(data[7]);
		pcc.setNomeCandidato(data[8]);
		pcc.setCPFCandidato(data[9]);
		pcc.setTipoDocumento(data[10]);
		pcc.setNumeroDocumento(data[11]);
		pcc.setCPFCNPJFornecedor(data[12]);
		pcc.setNomeFornecedor(data[13]);
		pcc.setNomeReceitaFornecedor(data[14]);
		pcc.setCodSetorEconomicoFornecedor(data[15]);
		pcc.setSetorEconomicoFornecedor(data[16]);
		pcc.setDataDespesa(data[17]);
		pcc.setValorDespesa(data[18]);
		pcc.setTipoDespesa(data[19]);
		pcc.setDescricaoDespesa(data[20]);
		return pcc;
	}
	
	public static Transacao populate(PrestContasCandidatoDespesa pccd){
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
		trans.setDebitado(createCandidato(pccd));
		trans.setTipo(Transacao.DESPESA);
		trans.setUF(pccd.getUF());
		trans.setMunicipio(pccd.getMunicipio());
		return trans;
	}

	private static Candidato createCandidato(PrestContasCandidatoDespesa pccd) {
		Candidato cand = new Candidato();
		cand.setNumero(pccd.getNumerocandidato());
		cand.setCargo(pccd.getCargo());
		cand.setUF(pccd.getUF());
		cand.setMunicipio(pccd.getMunicipio());
		cand.setSequencialCandidato(pccd.getSequencialCandidato());
		Partido partido = new Partido();
		partido.setSigla(pccd.getSiglaPartido());
		cand.setPartido(partido);
		return cand; 
	}

	private static PessoaJuridica createFornecedor(PrestContasCandidatoDespesa pccd) {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj(pccd.getCPFCNPJFornecedor());
		pj.setNome(pccd.getNomeFornecedor());
		SetorEconomico se = new SetorEconomico();
		se.setNome(pccd.getSetorEconomicoFornecedor());
		se.setCodSetorEco(pccd.getCodSetorEconomicoFornecedor());
		pj.setSetorEconomico(se);
		return pj;
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
