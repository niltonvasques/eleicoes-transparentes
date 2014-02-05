package br.ufba.mata62.eleicoestransparentes.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.parser.dados.BemCandidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;

public class ParserBemCandidato {
	
	public static List<BemCandidato> parsing(String path){
		List<BemCandidato> pccList = new ArrayList<BemCandidato>();
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

			try {
				br = new BufferedReader(new FileReader(csvFile));
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
	private static BemCandidato populate(String[] data) {
		BemCandidato bc = new BemCandidato();
		bc.setDataGeracao(data[0]);
		bc.setHoraGeracao(data[1]);
		bc.setAnoEleicao(data[2].trim());
		bc.setDescricaoEleicao(data[3]);
		bc.setSiglaUF(data[4].trim());
		bc.setSequencialCandidato(data[5].trim());
		bc.setDescricao(data[6]);
		bc.setCdTipoBemCandidato(data[7]);
		bc.setDsTipoBemCandidato(data[8]);
		bc.setValorBem(data[9].trim());
		bc.setDataUltimaAtualizacao(data[10]);
		bc.setHoraUltimaAtualizacao(data[11]);
		return bc;
	}
	
	public static Bem populate(BemCandidato bc){
		Bem bem = new Bem();
		bem.setDescricao(bc.getDescricao()+","+bc.getCdTipoBemCandidato()+","+bc.getDsTipoBemCandidato());
		Candidato cand = new Candidato();
		cand.setSequencialCandidato(bc.getSequencialCandidato());
		bem.setCandidato(cand);
		bem.setValor(Float.parseFloat(bc.getValorBem().replace(",", ".")));
		
		return bem;
	}
}
