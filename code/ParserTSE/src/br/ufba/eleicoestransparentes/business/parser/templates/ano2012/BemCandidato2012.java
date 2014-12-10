package br.ufba.eleicoestransparentes.business.parser.templates.ano2012;

import br.ufba.eleicoestransparentes.business.annotations.Name;
import br.ufba.eleicoestransparentes.business.parser.templates.TemplateArquivo;
import br.ufba.mata62.eleicoestransparentes.util.Path;

public class BemCandidato2012 extends TemplateArquivo {
	@Name("DATA_GERACAO")
	private String dataGeracao;
	@Name("HORA_GERACAO")
	private String horaGeracao;
	@Name("ANO_ELEICAO")
	private String anoEleicao;
	@Name("DESCRICAO_ELEICAO")
	private String descricaoEleicao;
	@Name("SIGLA_UF")
	private String siglaUF;
	@Name("SQ_CANDIDATO")
	private String sequencialCandidato;
	@Name("DESCRIÇÃO")
	private String descricao;
	@Name("CD_TIPO_BEM_CANDIDATO")
	private String cdTipoBemCandidato;
	@Name("DS_TIPO_BEM_CANDIDATO")
	private String dsTipoBemCandidato;
	@Name("VALOR_BEM")
	private String valorBem;
	@Name("DATA_ULTIMA_ATUALIZACAO ")
	private String dataUltimaAtualizacao;
	@Name("HORA_ULTIMA_ATUALIZACAO ")
	private String horaUltimaAtualizacao;
	public String getDataGeracao() {
		return dataGeracao;
	}
	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	public String getHoraGeracao() {
		return horaGeracao;
	}
	public void setHoraGeracao(String horaGeracao) {
		this.horaGeracao = horaGeracao;
	}
	public String getAnoEleicao() {
		return anoEleicao;
	}
	public void setAnoEleicao(String anoEleicao) {
		this.anoEleicao = anoEleicao;
	}
	public String getDescricaoEleicao() {
		return descricaoEleicao;
	}
	public void setDescricaoEleicao(String descricaoEleicao) {
		this.descricaoEleicao = descricaoEleicao;
	}
	public String getSiglaUF() {
		return siglaUF;
	}
	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	public String getSequencialCandidato() {
		return sequencialCandidato;
	}
	public void setSequencialCandidato(String sequencialCandidato) {
		this.sequencialCandidato = sequencialCandidato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCdTipoBemCandidato() {
		return cdTipoBemCandidato;
	}
	public void setCdTipoBemCandidato(String cdTipoBemCandidato) {
		this.cdTipoBemCandidato = cdTipoBemCandidato;
	}
	public String getDsTipoBemCandidato() {
		return dsTipoBemCandidato;
	}
	public void setDsTipoBemCandidato(String dsTipoBemCandidato) {
		this.dsTipoBemCandidato = dsTipoBemCandidato;
	}
	public String getValorBem() {
		return valorBem;
	}
	public void setValorBem(String valorBem) {
		this.valorBem = valorBem;
	}
	public String getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	public String getHoraUltimaAtualizacao() {
		return horaUltimaAtualizacao;
	}
	public void setHoraUltimaAtualizacao(String horaUltimaAtualizacao) {
		this.horaUltimaAtualizacao = horaUltimaAtualizacao;
	}
	
	@Override
	public String getNomeArquivo() {
		return Path.FLD_BEM + Path.UF_EXT;
	}
	@Override
	public int getAnoTemplate() {
		return 2012;
	}
	
	
}

