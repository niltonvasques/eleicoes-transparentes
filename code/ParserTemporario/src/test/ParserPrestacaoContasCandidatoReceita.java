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

import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;
import br.ufba.mata62.eleicoestransparentes.persistance.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;

public class ParserPrestacaoContasCandidatoReceita {
	
	public static List<PrestContasCandidatoReceita> parsing(String path){
		List<PrestContasCandidatoReceita> pccList = new ArrayList<PrestContasCandidatoReceita>();
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
	private static PrestContasCandidatoReceita populate(String[] data) {
		PrestContasCandidatoReceita pcr = new PrestContasCandidatoReceita();
		pcr.setDataHora(data[0]);
		pcr.setSequencialCandidato(data[1]);
		pcr.setUF(data[2]);
		pcr.setNumeroUE(data[3]);
		pcr.setMunicipio(data[4]);
		pcr.setSiglaPartido(data[5]);
		pcr.setNumeroCandidato(data[6]);
		pcr.setCargo(data[7]);
		pcr.setNomeCandidato(data[8]);
		pcr.setCPFCandidato(data[9]);
		pcr.setNumeroReciboEleitoral(data[10]);
		pcr.setNumeroDocumento(data[11]);
		pcr.setCPFCNPJDoador(data[12].trim());
		pcr.setNomeDoador(data[13]);
		pcr.setNomeReceitaDoador(data[14]);
		pcr.setSiglaUEDoador(data[15]);
		pcr.setNumeroPartidoDoador(data[16]);
		pcr.setNumeroCandidatoDoador(data[17]);
		pcr.setCodSetorEconomicoDoador(data[18]);
		pcr.setSetorEconomicoDoador(data[19]);
		pcr.setDataReceita(data[20]);
		pcr.setValorReceita(data[21]);
		pcr.setTipoReceita(data[22]);
		pcr.setFonteRecurso(data[23]);
		pcr.setEspecieRecurso(data[24]);
		pcr.setDescricaoReceita(data[25]);
		return pcr;
	}
	
	public static Transacao populate(PrestContasCandidatoReceita pccr){
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
	
	private static Candidato createCandidato(PrestContasCandidatoReceita pccr) {
		Candidato cand = new Candidato();
		cand.setNumero(pccr.getNumeroCandidato());
		cand.setCargo(pccr.getCargo());
		cand.setUF(pccr.getUF());
		cand.setMunicipio(pccr.getMunicipio());
		Partido partido = new Partido();
		partido.setSigla(pccr.getSiglaPartido());
		cand.setPartido(partido);
		return cand; 
	}

	private static Pessoa createDoador(PrestContasCandidatoReceita pccr) {
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
