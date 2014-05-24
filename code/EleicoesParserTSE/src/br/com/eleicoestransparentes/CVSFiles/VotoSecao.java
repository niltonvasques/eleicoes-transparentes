package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.EBean;

@CVSClass(notation = "VOTO_SECAO_<ANO ELEIÇÃO>_<SIGLA UF>", headerInFile = false)
public class VotoSecao extends CVSFile {
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"CODIGO_MUNICIPIO", "NOME_MUNICIPIO", "NUM_ZONA", "NUM_SECAO",
			"CODIGO_CARGO", "DESCRICAO_CARGO", "NUM_VOTAVEL", "QTDE_VOTOS" };
	
	@CVSAttr(name = "DATA_GERACAO")
	public String dataGeracao;
	@CVSAttr(name = "HORA_GERACAO")
	public String horaGeracao;
	@CVSAttr(name = "ANO_ELEICAO")
	public String anoEleicao;
	@CVSAttr(name = "NUM_TURNO")
	public String numTurno;
	@CVSAttr(name = "DESCRICAO_ELEICAO")
	public String descricaoEleicao;
	@CVSAttr(name = "SIGLA_UF")
	public String siglaUF;
	@CVSAttr(name = "SIGLA_UE")
	public String siglaUE;
	@CVSAttr(name = "CODIGO_MUNICIPIO")
	public String codigoMunicipio;
	@CVSAttr(name = "NOME_MUNICIPIO")
	public String nomeMunicipio;
	@CVSAttr(name = "NUM_ZONA")
	public String numZona;
	@CVSAttr(name = "NUM_SECAO")
	public String numSecao;
	@CVSAttr(name = "CODIGO_CARGO")
	public String codigoCargo;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "NUM_VOTAVEL")
	public String numVotavel;
	@CVSAttr(name = "QTDE_VOTOS")
	public String qtdeVotos;
	
	@Override
	public EBean[] getBeans() {
		// TODO Auto-generated method stub
		return null;
	}

}
