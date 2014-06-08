package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.com.eleicoestransparentes.persistence.beans.Bem;
import br.com.eleicoestransparentes.persistence.beans.Candidato;
import br.com.eleicoestransparentes.persistence.beans.EBean;

@CVSClass(notation = "BEM_CANDIDATO_<ANO ELEIÃ‡ÃƒO>_<SIGLA UF>",headerInFile = false)
public class BensCandidato extends CVSFile{
	
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"DESCRICAO_ELEICAO", "SIGLA_UF", "SQ_CANDIDATO","COLUNA_DESCONHECIDA",
			"CD_TIPO_BEM_CANDIDATO", "DS_TIPO_BEM_CANDIDATO", "VALOR_BEM",
			"DATA_ULTIMA_ATUALIZACAO", "HORA_ULTIMA_ATUALIZACAO" };
	//TODO - COLUNA_DESCONHECIDA - se encontra no arquivo, mas não há documentação para ela.
	
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
	public EBean[] getBeans() {
		EBean[] objs = {getBem()};
		return objs;
	}
	
}
