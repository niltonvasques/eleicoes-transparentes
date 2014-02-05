package br.ufba.mata62.eleicoestransparentes.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.parser.dados.PrestContasComiteDespesa;
import br.ufba.mata62.eleicoestransparentes.parser.dados.PrestContasComiteReceita;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;
import br.ufba.mata62.eleicoestransparentes.utils.ValidatorCPFCNPJ;

public class ParserPrestacaoContasComiteReceita {
	
	public static List<PrestContasComiteReceita> parsing(String path){
		List<PrestContasComiteReceita> pccList = new ArrayList<PrestContasComiteReceita>();
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
					line = line.replace("#NULO#", " ");
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
	private static PrestContasComiteReceita populate(String[] data) {
		PrestContasComiteReceita pcr = new PrestContasComiteReceita();
		pcr.setDataHora(data[0]);
		pcr.setSequencialComite(data[1].trim());
		pcr.setUF(data[2].trim());
		pcr.setNumeroUE(data[3].trim());
		pcr.setMunicipio(data[4]);
		pcr.setTipoComite(data[5]);
		pcr.setSiglaPartido(data[6].trim());
		pcr.setTipoDocumento(data[7]);
		pcr.setNumeroDocumento(data[8].trim());
		pcr.setCPFCNPJDoador(data[9].trim());
		pcr.setNomeDoador(data[10]);
		pcr.setNomeReceitaDoador(data[11]);
		pcr.setSiglaUEDoador(data[12].trim());
		pcr.setNumeroPartidoDoador(data[13].trim());
		pcr.setNumeroCandidatoDoador(data[14].trim());
		pcr.setCodSetorEconomicoDoador(data[15].trim());
		pcr.setSetorEconomicoDoador(data[16]);
		pcr.setDataReceita(data[17]);
		pcr.setValorReceita(data[18].trim());
		pcr.setTipoReceita(data[19]);
		pcr.setFonteRecurso(data[20]);
		pcr.setEspecieRecurso(data[21]);
		pcr.setDescricaoReceita(data[22]);
		return pcr;
	}
	
	public static Transacao populate(PrestContasComiteReceita pccr){
		Transacao trans = new Transacao();
		trans.setNumeroDocumento(pccr.getNumeroDocumento());
		Date data = formatDate(pccr.getDataHora());
		if(data!=null)
			trans.setData(data);
		trans.setValor(Float.parseFloat(pccr.getValorReceita().replace(",", ".")));
		trans.setClassificacao(pccr.getTipoReceita());
		trans.setDescricao(pccr.getDescricaoReceita());
//		trans.setCreditado(createComite(pccr)); TODO Comite não é uma pessoa
		trans.setDebitado(createDoador(pccr));
		trans.setTipo(Transacao.RECEITA);
		trans.setUF(pccr.getUF());
		trans.setMunicipio(pccr.getMunicipio());
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

	private static Pessoa createDoador(PrestContasComiteReceita pccr) {
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
