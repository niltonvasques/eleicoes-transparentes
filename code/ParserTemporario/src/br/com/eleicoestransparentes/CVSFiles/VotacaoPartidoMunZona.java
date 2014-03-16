package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "VOTACAO_PARTIDO_MUN_ZONA_<ANO ELEIÇÃO>_<SIGLA UF>", headerInFile = false)
public class VotacaoPartidoMunZona extends CVSFile {
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"CODIGO_MUNICIPIO", "NOME_MUNICIPIO", "NUMERO_ZONA",
			"CODIGO_CARGO", "DESCRICAO_CARGO", "TIPO_LEGENDA",
			"NOME_COLIGACAO", "COMPOSICAO_LEGENDA", "SIGLA_PARTIDO",
			"NUMERO_PARTIDO", "NOME_PARTIDO", "QTDE_VOTOS_NOMINAIS",
			"QTDE_VOTOS_LEGENDA"};
	
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
	@CVSAttr(name = "TIPO_LEGENDA")
	public String tipoLegenda;
	@CVSAttr(name = "NOME_COLIGACAO")
	public String nomeColigacao;
	@CVSAttr(name = "COMPOSICAO_LEGENDA")
	public String composicaoLegenda;
	@CVSAttr(name = "SIGLA_PARTIDO")
	public String siglaPartido;
	@CVSAttr(name = "NUMERO_PARTIDO")
	public String numeroPartido;
	@CVSAttr(name = "NOME_PARTIDO")
	public String nomePartido;
	@CVSAttr(name = "QTDE_VOTOS_NOMINAIS")
	public String qtdeVotosNominais;
	@CVSAttr(name = "QTDE_VOTOS_LEGENDA")
	public String qtdeVotosLegenda;
}
