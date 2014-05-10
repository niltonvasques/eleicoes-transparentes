package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;

@CVSClass(notation = "BEM_CANDIDATO_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile = false)
public class BensCandidato extends CVSFile{
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"DESCRICAO_ELEICAO", "SIGLA_UF", "SQ_CANDIDATO",
			"CD_TIPO_BEM_CANDIDATO", "DS_TIPO_BEM_CANDIDATO", "VALOR_BEM",
			"DATA_ULTIMA_ATUALIZACAO", "HORA_ULTIMA_ATUALIZACAO" };
	
	@CVSAttr(name ="DATA_GERACAO")
	public String dataGeracao;
	@CVSAttr(name ="HORA_GERACAO")
	public String horaGeracao;
	@CVSAttr(name ="ANO_ELEICAO")
	public String anoEleicao;
	@CVSAttr(name ="DESCRICAO_ELEICAO")
	public String descricaoEleicao;
	@CVSAttr(name ="SIGLA_UF")
	public String siglaUF;
	@CVSAttr(name ="SQ_CANDIDATO")
	public String sqCandidato;
	@CVSAttr(name ="CD_TIPO_BEM_CANDIDATO")
	public String cdTipoBemCandidato;
	@CVSAttr(name ="DS_TIPO_BEM_CANDIDATO")
	public String dsTipoBemCandidato;
	@CVSAttr(name ="VALOR_BEM")
	public String valorBem;
	@CVSAttr(name ="DATA_ULTIMA_ATUALIZACAO")
	public String dataUltimaAtualizacao;
	@CVSAttr(name ="HORA_ULTIMA_ATUALIZACAO")
	public String horaUltimaAtualizacao;
	
	
	protected Bem bem;
	
	public Bem getBem(){
		bem = new Bem();
		bem.setDescricao(cdTipoBemCandidato+" "+dsTipoBemCandidato);
		bem.setValor(Float.parseFloat(valorBem));
		Candidato candidato = new Candidato();
		candidato.setSequencialCandidato(sqCandidato);
		bem.setCandidato(candidato);
		return bem;
	}

	@Override
	public Object[] getBeans() {
		Object[] objs = {getBem()};
		return objs;
	}
	
}
