package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.EBean;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Eleicao;

@CVSClass(notation = "CONSULTA_VAGAS_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile = false)
public class ConsultaVagas extends CVSFile{
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE", "NOME_UE",
			"CODIGO_CARGO", "DESCRICAO_CARGO", "QTDE_VAGAS" };
	
	@CVSAttr(name = "DATA_GERACAO")
	public String dataGeracao;
	@CVSAttr(name = "HORA_GERACAO")
	public String horaGeracao;
	@CVSAttr(name = "ANO_ELEICAO")
	public String anoELeicao;
	@CVSAttr(name = "DESCRICAO_ELEICAO")
	public String descricaoEleicao;
	@CVSAttr(name = "SIGLA_UF")
	public String siglaUF;
	@CVSAttr(name = "SIGLA_UE")
	public String siglaUE;
	@CVSAttr(name = "NOME_UE")
	public String nomeUE;
	@CVSAttr(name = "CODIGO_CARGO")
	public String codigoCargo;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "QTDE_VAGAS")
	public String qtdeVagas;
	

	protected Eleicao eleicao;
	
	public Eleicao getEleicao(){
		eleicao = new Eleicao();
		eleicao.setAno(anoELeicao);
//		eleicao.setTipo(descricaoEleicao);TODO ver esse tipo
		return eleicao;
	}
	
	@Override
	public EBean[] getBeans() {
		EBean[] objs = {getEleicao()};
		return objs;
	}
	
	
	
}
