package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "VOTACAO_CANDIDATO_MUN_ZONA_<ANO ELEIÇÃO>_<SIGLA UF>", headerInFile = false)
public class VotacaoCandidatoMunZona extends CVSFile{

	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"CODIGO_MUNICIPIO", "NOME_MUNICIPIO", "NUMERO_ZONA",
			"CODIGO_CARGO", "NUMERO_CAND", "SQ_CANDIDATO", "NOME_CANDIDATO",
			"NOME_URNA_CANDIDATO", "DESCRICAO_CARGO", "COD_SIT_CAND_SUPERIOR",
			"DESC_SIT_CAND_SUPERIOR", "CODIGO_SIT_CANDIDATO",
			"DESC_SIT_CANDIDATO", "CODIGO_SIT_CAND_TOT", "DESC_SIT_CAND_TOT",
			"NUMERO_PARTIDO", "SIGLA_PARTIDO", "NOME_PARTIDO",
			"SEQUENCIAL_LEGENDA", "NOME_COLIGACAO", "COMPOSICAO_LEGENDA",
			"TOTAL_VOTOS" };

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
	@CVSAttr(name = "NUMERO_CAND")
	public String numeroCand;
	@CVSAttr(name = "SQ_CANDIDATO")
	public String sqCandidato;
	@CVSAttr(name = "NOME_CANDIDATO")
	public String nomeCandidato;
	@CVSAttr(name = "NOME_URNA_CANDIDATO")
	public String nomeUrnaCandidato;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "COD_SIT_CAND_SUPERIOR")
	public String codSitCandSuperior;
	@CVSAttr(name = "DESC_SIT_CAND_SUPERIOR")
	public String descSitCandSuperior;
	@CVSAttr(name = "CODIGO_SIT_CANDIDATO")
	public String codigoSitCandidato;
	@CVSAttr(name = "DESC_SIT_CANDIDATO")
	public String descSitCandidato;
	@CVSAttr(name = "CODIGO_SIT_CAND_TOT")
	public String codigoSitCandTot;
	@CVSAttr(name = "DESC_SIT_CAND_TOT")
	public String descSitCandTot;
	@CVSAttr(name = "NUMERO_PARTIDO")
	public String numeroPartido;
	@CVSAttr(name = "SIGLA_PARTIDO")
	public String siglaPartido;
	@CVSAttr(name = "NOME_PARTIDO")
	public String nomePartido;
	@CVSAttr(name = "SEQUENCIAL_LEGENDA")
	public String sequencialLegenda;
	@CVSAttr(name = "NOME_COLIGACAO")
	public String nomeColigacao;
	@CVSAttr(name = "COMPOSICAO_LEGENDA")
	public String composicaoLegenda;
	@CVSAttr(name = "TOTAL_VOTOS")
	public String totalVotos;
}
