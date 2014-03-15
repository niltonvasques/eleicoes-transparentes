package legacy.br.ufba.mata62.eleicoestransparentes.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;

public class ParserPrestacaoContasComiteDespesa {
	
	public static List<PrestContasComiteDespesa> parsing(String path){
		List<PrestContasComiteDespesa> pccList = new ArrayList<PrestContasComiteDespesa>();
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
	private static PrestContasComiteDespesa populate(String[] data) {
		PrestContasComiteDespesa pcc = new PrestContasComiteDespesa();
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
	
	public static Transacao populate(PrestContasComiteDespesa pccd){
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
//		trans.setDebitado(createComite(pccd));//TODO Comite não é tipo Pessoa
		trans.setTipo(Transacao.DESPESA);
		trans.setUF(pccd.getUF());
		trans.setMunicipio(pccd.getMunicipio());
		return trans;
	}

	private static Comite createComite(PrestContasComiteDespesa pccd) {
		Comite com = new Comite();
		com.setUF(pccd.getUF());
		com.setMunicipio(pccd.getMunicipio());
		com.setTipo(pccd.getTipoComite());
		Partido partido = new Partido();
		partido.setSigla(pccd.getSiglaPartido());
		com.setPartido(partido);
		return com; 
	}

	private static PessoaJuridica createFornecedor(PrestContasComiteDespesa pccd) {
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
