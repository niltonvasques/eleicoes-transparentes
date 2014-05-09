package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

@CVSClass(notation = "CONSULTA_LEGENDAS_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile=false)
public class ConsultaLegenda  extends CVSFile {
	
	/**
	 * Cabeçalho do arquivo - o cabeçalho não aparece nos arquivos, por isso a 
	 * necessidade de tê-lo aqui.
	 */
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"NOME_UE", "CODIGO_CARGO", "DESCRICAO_CARGO", "TIPO_LEGENDA",
			"NUM_PARTIDO", "SIGLA_PARTIDO", "NOME_PARTIDO", "SIGLA_COLIGACAO",
			"NOME_COLIGACAO", "COMPOSICAO_COLIGACAO"/*, "SEQUENCIAL_COLIGACAO"*/ };
	
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
	 @CVSAttr(name = "NOME_UE")
	 public String nomeUE;
	 @CVSAttr(name = "CODIGO_CARGO")
	 public String codigoCargo;
	 @CVSAttr(name = "DESCRICAO_CARGO")
	 public String descricaoCargo;
	 @CVSAttr(name = "TIPO_LEGENDA")
	 public String tipoLegenda;
	 @CVSAttr(name = "NUM_PARTIDO")
	 public String numPartido;
	 @CVSAttr(name = "SIGLA_PARTIDO")
	 public String siglaPartido;
	 @CVSAttr(name = "NOME_PARTIDO")
	 public String nomePartido;
	 @CVSAttr(name = "SIGLA_COLIGACAO")
	 public String siglaColigacao;
	 @CVSAttr(name = "NOME_COLIGACAO")
	 public String nomeColigacao;
	 @CVSAttr(name = "COMPOSICAO_COLIGACAO")
	 public String composicaoColigacao;
//	 @CVSAttr(name = "SEQUENCIAL_COLIGACAO") TODO Esse campo existe no README, mas não existe no arquivo.
//	 public String sequencialColigacao;
	 
	 protected Partido partido;
	 
	 public Partido getPartido(){
		 partido = new Partido();
		 partido.setNumero(Integer.parseInt(numPartido));
		 partido.setSigla(siglaPartido);
		 partido.setNome(nomePartido);
		 return partido;
	 }
	 
	 
}
