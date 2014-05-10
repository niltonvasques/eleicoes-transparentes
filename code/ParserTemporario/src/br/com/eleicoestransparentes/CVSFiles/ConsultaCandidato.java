package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;


/**
 * Classe do Objeto gerado de uma linha do arquivo CVS. Maiores
 * detalhes quanto ao campo, consultar arquivo README. 
 * @author tiagogoncalves
 *
 */
@CVSClass(notation = "CONSULTA_CAND_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile=false)
public class ConsultaCandidato  extends CVSFile{
	
	/**
	 * Cabeçalho do arquivo - o cabeçalho não aparece nos arquivos, por isso a 
	 * necessidade de tê-lo aqui.
	 */
	public String[] header = { "DATA_GERACAO", "HORA_GERACAO", "ANO_ELEICAO",
			"NUM_TURNO", "DESCRICAO_ELEICAO", "SIGLA_UF", "SIGLA_UE",
			"DESCRICAO_UE", "CODIGO_CARGO", "DESCRICAO_CARGO",
			"NOME_CANDIDATO", "SEQUENCIAL_CANDIDATO", "NUMERO_CANDIDATO",
			"NOME_URNA_CANDIDATO", "COD_SITUACAO_CANDIDATURA",
			"DES_SITUACAO_CANDIDATURA", "NUMERO_PARTIDO", "SIGLA_PARTIDO",
			"NOME_PARTIDO", "CODIGO_LEGENDA", "SIGLA_LEGENDA",
			"COMPOSICAO_LEGENDA", "NOME_LEGENDA", "CODIGO_OCUPACAO",
			"DESCRICAO_OCUPACAO", "DATA_NASCIMENTO",
			"NUM_TITULO_ELEITORAL_CANDIDATO", "IDADE_DATA_ELEICAO",
			"CODIGO_SEXO", "DESCRICAO_SEXO", "COD_GRAU_INSTRUCAO",
			"DESCRICAO_GRAU_INSTRUCAO", "CODIGO_ESTADO_CIVIL",
			"DESCRICAO_ESTADO_CIVIL", "CODIGO_NACIONALIDADE",
			"DESCRICAO_NACIONALIDADE", "SIGLA_UF_NASCIMENTO",
			"CODIGO_MUNICIPIO_NASCIMENTO", "NOME_MUNICIPIO_NASCIMENTO",
			"DESPESA_MAX_CAMPANHA", "COD_SIT_TOT_TURNO",
			"DESC_SIT_TOT_TURNO" };
	
	
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
	@CVSAttr(name = "DESCRICAO_UE")
	public String descricaoUE;
	@CVSAttr(name = "CODIGO_CARGO")
	public String codigoCargo;
	@CVSAttr(name = "DESCRICAO_CARGO")
	public String descricaoCargo;
	@CVSAttr(name = "NOME_CANDIDATO")
	public String nomeCandidato;
	@CVSAttr(name = "SEQUENCIAL_CANDIDATO")
	public String sequencialCandidato;
	@CVSAttr(name = "NUMERO_CANDIDATO")
	public String numeroCandidato;
	@CVSAttr(name = "NOME_URNA_CANDIDATO")
	public String nomeUrnaCandidato;
	@CVSAttr(name = "COD_SITUACAO_CANDIDATURA")
	public String codSituacaoCandidatura;
	@CVSAttr(name = "DES_SITUACAO_CANDIDATURA")
	public String desSituacaoCandidatura;
	@CVSAttr(name = "NUMERO_PARTIDO")
	public String numeroPartido;
	@CVSAttr(name = "SIGLA_PARTIDO")
	public String siglaPartido;
	@CVSAttr(name = "NOME_PARTIDO")
	public String nomePartido;
	@CVSAttr(name = "CODIGO_LEGENDA")
	public String codigoLegenda;
	@CVSAttr(name = "SIGLA_LEGENDA")
	public String siglaLegenda;
	@CVSAttr(name = "COMPOSICAO_LEGENDA")
	public String composicaoLegenda;
	@CVSAttr(name = "NOME_LEGENDA")
	public String nomeLegenda;
	@CVSAttr(name = "CODIGO_OCUPACAO")
	public String codigoOcupacao;
	@CVSAttr(name = "DESCRICAO_OCUPACAO")
	public String descricaoOcupacao;
	@CVSAttr(name = "DATA_NASCIMENTO")
	public String dataNascimento;
	@CVSAttr(name = "NUM_TITULO_ELEITORAL_CANDIDATO")
	public String numTituloEleitoralCandidato;
	@CVSAttr(name = "IDADE_DATA_ELEICAO")
	public String idadeDataEleicao;
	@CVSAttr(name = "CODIGO_SEXO")
	public String codigoSexo;
	@CVSAttr(name = "DESCRICAO_SEXO")
	public String descricaoSexo;
	@CVSAttr(name = "COD_GRAU_INSTRUCAO")
	public String codGrauInstrucao;
	@CVSAttr(name = "DESCRICAO_GRAU_INSTRUCAO")
	public String descricaoGrauInstrucao;
	@CVSAttr(name = "CODIGO_ESTADO_CIVIL")
	public String codigoEstadoCivil;
	@CVSAttr(name = "DESCRICAO_ESTADO_CIVIL")
	public String descricaoEstadoCivil;
	@CVSAttr(name = "CODIGO_NACIONALIDADE")
	public String codigoNacionalidade;
	@CVSAttr(name = "DESCRICAO_NACIONALIDADE")
	public String descricaoNacionalidade;
	@CVSAttr(name = "SIGLA_UF_NASCIMENTO")
	public String siglaUFNascimento;
	@CVSAttr(name = "CODIGO_MUNICIPIO_NASCIMENTO")
	public String codigoMunicipioNascimento;
	@CVSAttr(name = "NOME_MUNICIPIO_NASCIMENTO")
	public String nomeMunicipioNascimento;
	@CVSAttr(name = "DESPESA_MAX_CAMPANHA")
	public String despesaMaxCampanha;
	@CVSAttr(name = "COD_SIT_TOT_TURNO")
	public String codSitTotTurno;
	@CVSAttr(name = "DESC_SIT_TOT_TURNO")
	public String descSitTotTurno;
	
	/**
	 * Objeto candidato extraído do Objeto CVS.
	 */
	protected Candidato candidato;
	
	public Candidato getCandidato() {
		candidato = new Candidato();
		candidato.setCargo(this.descricaoCargo);
		candidato.setLocalNascimento(this.nomeMunicipioNascimento);
		candidato.setNacionalidade(this.descricaoNacionalidade);
		candidato.setNome(this.nomeCandidato);
		candidato.setNumero(this.numeroCandidato);
		candidato.setSequencialCandidato(this.sequencialCandidato);
		candidato.setSiglaUE(this.siglaUE);
		candidato.setUF(this.siglaUF);

		Partido p = new Partido();
		p.setNumero(Integer.parseInt(this.numeroPartido));
		p.setSigla(this.siglaPartido);
		p.setNome(this.nomePartido);
		candidato.setPartido(p);

		return candidato;
	}
	
	@Override
	public Object[] getBeans() {
		Object[] objs = {getCandidato()};
		return objs;
	}
	
}
