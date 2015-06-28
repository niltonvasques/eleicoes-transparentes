package br.ufba.eleicoestransparentes.business.parser.ano2012;

import br.ufba.eleicoestransparentes.business.parser.ParserFile;
import br.ufba.eleicoestransparentes.business.parser.templates.ano2012.BemCandidato2012;
import br.ufba.eleicoestransparentes.model.Bem;
import br.ufba.eleicoestransparentes.model.Candidato;

public class ParserBemCandidato2012 extends ParserFile<BemCandidato2012, Bem> {
	
	public ParserBemCandidato2012(String file) {
		super(file);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected BemCandidato2012 populateTemplate(String[] data) {
		BemCandidato2012 bc = new BemCandidato2012();
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
	
	@Override
	protected Bem populateModel(BemCandidato2012 bc) {
		Bem bem = new Bem();
		bem.setDescricao(bc.getDescricao()+","+bc.getCdTipoBemCandidato()+","+bc.getDsTipoBemCandidato());
		Candidato cand = new Candidato();
		cand.setSequencialCandidato(bc.getSequencialCandidato());
		bem.setCandidato(cand);
		bem.setValor(Float.parseFloat(bc.getValorBem().replace(",", ".")));
		
		return bem;
	}
}
