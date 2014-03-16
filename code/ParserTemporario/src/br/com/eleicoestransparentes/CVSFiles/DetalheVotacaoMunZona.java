package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "DETALHE_VOTACAO_MUN_ZONA_<ANO ELEIÇÃO>_<SIGLA UF>", headerInFile = false)
public class DetalheVotacaoMunZona extends CVSFile{
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"CODIGO_MUNICIPIO", "NOME_MUNICIPIO", "NUMERO_ZONA",
			"CODIGO_CARGO", "DESCRICAO_CARGO", "QTD_APTOS", "QTD_SECOES",
			"QTD_SECOES_AGREGADAS", "QTD_APTOS_TOT", "QTD_SECOES_TOT",
			"QTD_COMPARECIMENTO", "QTD_ABSTENCOES", "QTD_VOTOS_NOMINAIS",
			"QTD_VOTOS_BRANCOS", "QTD_VOTOS_NULOS", "QTD_VOTOS_LEGENDA",
			"QTD_VOTOS_ANULADOS_APU_SEP", "DATA_ULT_TOTALIZACAO",
			"HORA_ULT_TOTALIZACAO" };
	
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
	@CVSAttr(name = "NUMERO_ZONA")
	public String numeroZona;
	@CVSAttr(name = "CODIGO_CARGO")
	public String codigoCargo;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "QTD_APTOS")
	public String qtdAptos;
	@CVSAttr(name = "QTD_SECOES")
	public String qtdeSecoes;
	@CVSAttr(name = "QTD_SECOES_AGREGADAS")
	public String qtdeSecoesAgregadas;
	@CVSAttr(name = "QTD_APTOS_TOT")
	public String qtdAptosTot;
	@CVSAttr(name = "QTD_SECOES_TOT")
	public String qtdSecoesTot;
	@CVSAttr(name = "QTD_COMPARECIMENTO")
	public String qtdComparecimento;
	@CVSAttr(name = "QTD_ABSTENCOES")
	public String qtdAbstencoes;
	@CVSAttr(name = "QTD_VOTOS_NOMINAIS")
	public String qtdVotosNominais;
	@CVSAttr(name = "QTD_VOTOS_BRANCOS")
	public String qtdVotosBrancos;
	@CVSAttr(name = "QTD_VOTOS_NULOS")
	public String qtdVotosNulos;
	@CVSAttr(name = "QTD_VOTOS_LEGENDA")
	public String qtdVotosLegenda;
	@CVSAttr(name = "QTD_VOTOS_ANULADOS_APU_SEP")
	public String qtdVotosAnuladosApuSep;
	@CVSAttr(name = "DATA_ULT_TOTALIZACAO")
	public String dataUltTotalizacao;
	@CVSAttr(name = "HORA_ULT_TOTALIZACAO")
	public String horaUltTotalizacao;
}
