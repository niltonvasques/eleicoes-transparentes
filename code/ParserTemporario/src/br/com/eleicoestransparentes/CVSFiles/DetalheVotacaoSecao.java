package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "DETALHE_VOTACAO_SECAO_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile = false)
public class DetalheVotacaoSecao extends CVSFile {
	
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"CODIGO_MUNICIPIO", "NOME_MUNICIPIO", "NUMERO_ZONA",
			"NUMERO_SECAO", "CODIGO_CARGO", "DESCRICAO_CARGO", "QTD_APTOS",
			"QTD_COMPARECIMENTO", "QTD_ABSTENCOES", "QT_VOTOS_NOMINAIS",
			"QT_VOTOS_BRANCOS", "QT_VOTOS_NULOS", "QT_VOTOS_LEGENDA",
			"QT_VOTOS_ANULADOS_APU_SEP" };
	
	
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
	@CVSAttr(name = "NUMERO_SECAO")
	public String numeroSecao;
	@CVSAttr(name = "CODIGO_CARGO")
	public String codigoCargo;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "QTD_APTOS")
	public String qtdAptos;
	@CVSAttr(name = "QTD_COMPARECIMENTO")
	public String qtdComparecimento;
	@CVSAttr(name = "QTD_ABSTENCOES")
	public String qtdAbstencoes;
	@CVSAttr(name = "QT_VOTOS_NOMINAIS")
	public String qtVotosNominais;
	@CVSAttr(name = "QT_VOTOS_BRANCOS")
	public String qtVotosBrancos;
	@CVSAttr(name = "QT_VOTOS_NULOS")
	public String qtVotosNulos;
	@CVSAttr(name = "QT_VOTOS_LEGENDA")
	public String qtVotosLegenda;
	@CVSAttr(name = "QT_VOTOS_ANULADOS_APU_SEP")
	public String qtVotosAnuladosApuSep;
	
	
	@Override
	public Object[] getBeans() {
		// TODO Auto-generated method stub
		return null;
	}

}
