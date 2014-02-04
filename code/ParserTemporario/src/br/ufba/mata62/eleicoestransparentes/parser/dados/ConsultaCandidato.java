package br.ufba.mata62.eleicoestransparentes.parser.dados;

import br.ufba.mata62.eleicoestransparentes.parser.Name;

/**
 * @author niltonvasques
 *
 */
public class ConsultaCandidato {
	/**
	 * Data de geração do arquivo (data da extração)
	 */
	@Name("Data") 				
	private String data;
	public static final int INDEX_DATA = 0;
	
	/**
	 * Hora de geração do arquivo (hora da extração) - Horário de Brasília
	 */
	@Name("Hora") 			
	private String hora;
	public static final int INDEX_HORA = 1;
	
	/**
	 * Ano da eleição
	 */
	@Name("Ano Eleicao") 		
	private String anoEleicao;
	public static final int INDEX_ANO_ELEICAO = 2;
	/**
	 * Número do turno
	 */
	@Name("Número do Turno") 
	private String numTurno;
	public static final int INDEX_NUM_TURNO = 3;
	/**
	 * Descrição da eleição
	 */
	@Name("Descricao Eleicao") //	
	private String descricaoEleicao;
	public static final int INDEX_DESCRICAO_ELEICAO = 4;
	/**
	 * Sigla da Unidade da Federação em que ocorreu a eleição
	 */
	@Name("Sigla UF")			//	
	private String siglaUf;
	public static final int INDEX_SIGLA_UF = 5;
	/**
	 * Sigla da Unidade Eleitoral (Em caso de eleição majoritária é a 
	 * sigla da UF que o candidato concorre (texto) e em caso de
	 * eleição municipal é o código TSE do município (número)).
	 * 	Assume os valores especiais BR, ZZ e VT para designar,
	 * 	respectivamente, o Brasil, Exterior e Voto em Trânsito	
	 */
	@Name("Sigla UE")				
	private String siglaUE;			
	public static final int INDEX_SIGLA_UE = 6;
									
	/**
	 * Descrição da Unidade Eleitoral
	 */
	@Name("Descricao UE")	
	private String descricaoUE;
	public static final int INDEX_DESCRICAO_UE = 7;
	/**
	 * Código do cargo a que o candidato concorre
	 */
	@Name("Codigo Cargo")
	private String codigoCargo;
	public static final int INDEX_CODIGO_CARGO = 8;
	/**
	 * Descrição do cargo a que o candidato concorre
	 */
	@Name("Descricao Cargo")
	private String descricaoCargo;
	public static final int INDEX_DESCRICAO_CARGO = 9;
	/**
	 * Nome completo do candidato
	 */
	@Name("Nome Candidato")
	private String nomeCandidato;
	public static final int INDEX_NOME_CANDIDATO = 10;
	/**
	 * Número sequencial do candidato gerado internamente pelos
	 * sistemas eleitorais. Não é o número de campanha do
	 * candidato.
	 */
	@Name("Sequencial Candidato")
	private String sequencialCandidadto;
	public static final int INDEX_SEQUENCIAL_CANDIDATO = 11;
	/**
	 * Número do candidato na urna
	 */
	@Name("Numero Candidato")
	private String numeroCandidadto;
	public static final int INDEX_NUMERO_CANDIDATO = 12;
	/**
	 * Nome de urna do candidato
	 */
	@Name("Nome Urna Candidato")
	private String nomeUrnaCandidato;
	public static final int INDEX_NOME_URNA_CANDIDATO = 13;
	/**
	 * Código da situação de candidatura
	 */
	@Name("COD_SITUACAO_CANDIDATURA")
	private String codSituacaoCandidatura;
	public static final int INDEX_COD_SITUACAO_CANDIDADATURA = 14;
	/**
	 * Descrição da situação de candidatura
	 */
	@Name("DES_SITUACAO_CANDIDATURA")
	private String desSituacaoCandidatura;
	public static final int INDEX_DES_SITUACAO_CANDIDATURA = 15;
	/**
	 * Número do partido
	 */
	@Name("NUMERO_PARTIDO")
	private String numeroPartido;
	public static final int INDEX_NUMERO_PARTIDO = 16;
	/**
	 * Sigla do partido
	 */
	@Name("SIGLA_PARTIDO")
	private String siglaPartido;
	public static final int INDEX_SIGLA_PARTIDO = 17;
	/**
	 * Nome do partido
	 */
	@Name("NOME_PARTIDO")
	private String nomePartido;
	public static final int INDEX_NOME_PARTIDO = 18;
	/**
	 * Código sequencial da legenda gerado pela Justiça Eleitoral
	 */
	@Name("CODIGO_LEGENDA")
	private String codigoLegenda;
	public static final int INDEX_CODIGO_LEGENDA = 19;
	/**
	 * Sigla da legenda
	 */
	@Name("SIGLA_LEGENDA")
	private String siglaLegenda;
	public static final int INDEX_SIGLA_LEGENDA = 20;
	/**
	 * Composição da legenda
	 */
	@Name("COMPOSICAO_LEGENDA")
	private String composicaoLegenda;
	public static final int INDEX_COMPOSICAO_LEGENDA = 21;
	/**
	 * Nome da legenda
	 */
	@Name("NOME_LEGENDA")
	private String nomeLegenda;
	public static final int INDEX_NOME_LEGENDA = 22;
	/**
	 * Código da ocupação do candidato
	 */
	@Name("CODIGO_OCUPACAO")
	private String codigoOcupacao;
	public static final int INDEX_CODIGO_OCUPACAO = 23;
	/**
	 * Descrição da ocupação do candidato
	 */
	@Name("DESCRICAO_OCUPACAO")
	private String descricaoOcupacao;
	public static final int INDEX_DESCRICAO_OCUPACAO = 24;
	/**
	 * Data de nascimento do candidato
	 */
	@Name("DATA_NASCIMENTO")
	private String dataNascimento;
	public static final int INDEX_DATA_NASCIMENTO = 25;
	/**
	 * Número do título eleitoral do candidato
	 */
	@Name("NUM_TITULO_ELEITORAL_CANDIDATO")
	private String numTituloEleitoralCandidato;
	public static final int INDEX_NUM_TITULO_ELEITORAL_CANDIDATO = 26;
	
	/**
	 * Idade do candidato da data da eleição 
	 */
	@Name("IDADE_DATA_ELEICAO")
	private String idadeDataEleicao;
	public static final int INDEX_IDADE_DATA_ELEICAO = 27;
	
	/**
	 * Código do sexo do candidatoTRIBUNAL SUPERIOR ELEITORAL 
	 */
	@Name("CODIGO_SEXO")
	private String codigoSexo;
	public static final int INDEX_CODIGO_SEXO = 28;
	
	/**
	 * Descrição do sexo do candidato
	 */
	@Name("DESCRICAO_SEXO")
	private String descricaoSexo;
	public static final int INDEX_DESCRICAO_SEXO = 29;
	
	/**
	 * Código do grau de instrução do candidato. Gerado
	 * internamente pelos sistemas eleitorais
	 */
	@Name("COD_GRAU_INSTRUCAO")
	private String codGrauInstrucao;
	public static final int INDEX_COD_GRAU_INSTRUCAO = 30;
	
	/**
	 * Descrição do grau de instrução do candidato
	 */
	@Name("DESCRICAO_GRAU_INSTRUCAO")
	private String descricaoGrauInstrucao;
	public static final int INDEX_DESCRICAO_GRAU_INSTRUCAO = 31;
	
	/**
	 * Código do estado civil do candidato
	 */
	@Name("CODIGO_ESTADO_CIVIL")
	private String codigoEstadoCivil;
	public static final int INDEX_CODIGO_ESTADO_CIVIL = 32;
	
	/**
	 * Descrição do estado civil do candidato
	 */
	@Name("DESCRICAO_ESTADO_CIVIL")
	private String descricaoEstadoCivil;
	public static final int INDEX_DESCRICAO_ESTADO_CIVIL = 33;
	
	/**
	 * Código da nacionalidade do candidato
	 */
	@Name("CODIGO_NACIONALIDADE")
	private String codigoNacionalidade;
	public static final int INDEX_CODIGO_NACIONALIDADE = 34;
	/**
	 * Descrição da nacionalidade do candidato
	 */
	@Name("DESCRICAO_NACIONALIDADE")
	private String descricaoNacionalidade;
	public static final int INDEX_DESCRICAO_NACIONALIDADE = 35;
	
	/**
	 * Sigla da UF de nascimento do candidato
	 */
	@Name("SIGLA_UF_NASCIMENTO")
	private String siglaUfNascimento;
	public static final int INDEX_SIGLA_UF_NASCIMENTO = 36;
	/**
	 * Código TSE do município da nascimento do candidato
	 */
	@Name("CODIGO_MUNICIPIO_NASCIMENTO")
	private String codigoMunicipioNascimento;
	public static final int INDEX_CODIGO_MUNICIPIO_NASCIMENTO = 37;
	/**
	 * Nome do município de nascimento do candidato
	 */
	@Name("NOME_MUNICIPIO_NASCIMENTO")
	private String nomeMunicipioNascimento;
	public static final int INDEX_NOME_MUNICIPIO_NASCIMENTO = 38;
	/**
	 * Despesa máxima de campanha declarada pelo partido para
	 * aquele cargo. Valores em Reais.
	 */
	@Name("DESPESA_MAX_CAMPANHA")
	private String despesaMaxCampanha;
	public static final int INDEX_DESPESA_MAX_CAMPANHA = 39;
	
	/**
	 * Código da situação de totalização do candidato naquele turno
	 */
	@Name("COD_SIT_TOT_TURNO")
	private String codSitTotTurno;
	public static final int INDEX_COD_SIT_TOT_TURNO = 40;
	/**
	 * Descrição da situação de totalização do candidato naquele
	 * turno
	 */
	@Name("DESC_SIT_TOT_TURNO")
	private String descSitTotTurno;
	public static final int INDEX_DESC_SIT_TOT_TURNO = 41;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getAnoEleicao() {
		return anoEleicao;
	}
	public void setAnoEleicao(String anoEleicao) {
		this.anoEleicao = anoEleicao;
	}
	public String getNumTurno() {
		return numTurno;
	}
	public void setNumTurno(String numTurno) {
		this.numTurno = numTurno;
	}
	public String getDescricaoEleicao() {
		return descricaoEleicao;
	}
	public void setDescricaoEleicao(String descricaoEleicao) {
		this.descricaoEleicao = descricaoEleicao;
	}
	public String getSiglaUf() {
		return siglaUf;
	}
	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}
	public String getSiglaUE() {
		return siglaUE;
	}
	public void setSiglaUE(String siglaUE) {
		this.siglaUE = siglaUE;
	}
	public String getDescricaoUE() {
		return descricaoUE;
	}
	public void setDescricaoUE(String descricaoUE) {
		this.descricaoUE = descricaoUE;
	}
	public String getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public String getDescricaoCargo() {
		return descricaoCargo;
	}
	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}
	public String getNomeCandidato() {
		return nomeCandidato;
	}
	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}
	public String getSequencialCandidadto() {
		return sequencialCandidadto;
	}
	public void setSequencialCandidadto(String sequencialCandidadto) {
		this.sequencialCandidadto = sequencialCandidadto;
	}
	public String getNumeroCandidadto() {
		return numeroCandidadto;
	}
	public void setNumeroCandidadto(String numeroCandidadto) {
		this.numeroCandidadto = numeroCandidadto;
	}
	public String getNomeUrnaCandidato() {
		return nomeUrnaCandidato;
	}
	public void setNomeUrnaCandidato(String nomeUrnaCandidato) {
		this.nomeUrnaCandidato = nomeUrnaCandidato;
	}
	public String getCodSituacaoCandidatura() {
		return codSituacaoCandidatura;
	}
	public void setCodSituacaoCandidatura(String codSituacaoCandidatura) {
		this.codSituacaoCandidatura = codSituacaoCandidatura;
	}
	public String getDesSituacaoCandidatura() {
		return desSituacaoCandidatura;
	}
	public void setDesSituacaoCandidatura(String desSituacaoCandidatura) {
		this.desSituacaoCandidatura = desSituacaoCandidatura;
	}
	public String getNumeroPartido() {
		return numeroPartido;
	}
	public void setNumeroPartido(String numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	public String getSiglaPartido() {
		return siglaPartido;
	}
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}
	public String getNomePartido() {
		return nomePartido;
	}
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	public String getCodigoLegenda() {
		return codigoLegenda;
	}
	public void setCodigoLegenda(String codigoLegenda) {
		this.codigoLegenda = codigoLegenda;
	}
	public String getSiglaLegenda() {
		return siglaLegenda;
	}
	public void setSiglaLegenda(String siglaLegenda) {
		this.siglaLegenda = siglaLegenda;
	}
	public String getComposicaoLegenda() {
		return composicaoLegenda;
	}
	public void setComposicaoLegenda(String composicaoLegenda) {
		this.composicaoLegenda = composicaoLegenda;
	}
	public String getNomeLegenda() {
		return nomeLegenda;
	}
	public void setNomeLegenda(String nomeLegenda) {
		this.nomeLegenda = nomeLegenda;
	}
	public String getCodigoOcupacao() {
		return codigoOcupacao;
	}
	public void setCodigoOcupacao(String codigoOcupacao) {
		this.codigoOcupacao = codigoOcupacao;
	}
	public String getDescricaoOcupacao() {
		return descricaoOcupacao;
	}
	public void setDescricaoOcupacao(String descricaoOcupacao) {
		this.descricaoOcupacao = descricaoOcupacao;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNumTituloEleitoralCandidato() {
		return numTituloEleitoralCandidato;
	}
	public void setNumTituloEleitoralCandidato(String numTituloEleitoralCandidato) {
		this.numTituloEleitoralCandidato = numTituloEleitoralCandidato;
	}
	public String getIdadeDataEleicao() {
		return idadeDataEleicao;
	}
	public void setIdadeDataEleicao(String idadeDataEleicao) {
		this.idadeDataEleicao = idadeDataEleicao;
	}
	public String getCodigoSexo() {
		return codigoSexo;
	}
	public void setCodigoSexo(String codigoSexo) {
		this.codigoSexo = codigoSexo;
	}
	public String getDescricaoSexo() {
		return descricaoSexo;
	}
	public void setDescricaoSexo(String descricaoSexo) {
		this.descricaoSexo = descricaoSexo;
	}
	public String getCodGrauInstrucao() {
		return codGrauInstrucao;
	}
	public void setCodGrauInstrucao(String codGrauInstrucao) {
		this.codGrauInstrucao = codGrauInstrucao;
	}
	public String getDescricaoGrauInstrucao() {
		return descricaoGrauInstrucao;
	}
	public void setDescricaoGrauInstrucao(String descricaoGrauInstrucao) {
		this.descricaoGrauInstrucao = descricaoGrauInstrucao;
	}
	public String getCodigoEstadoCivil() {
		return codigoEstadoCivil;
	}
	public void setCodigoEstadoCivil(String codigoEstadoCivil) {
		this.codigoEstadoCivil = codigoEstadoCivil;
	}
	public String getDescricaoEstadoCivil() {
		return descricaoEstadoCivil;
	}
	public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
		this.descricaoEstadoCivil = descricaoEstadoCivil;
	}
	public String getCodigoNacionalidade() {
		return codigoNacionalidade;
	}
	public void setCodigoNacionalidade(String codigoNacionalidade) {
		this.codigoNacionalidade = codigoNacionalidade;
	}
	public String getDescricaoNacionalidade() {
		return descricaoNacionalidade;
	}
	public void setDescricaoNacionalidade(String descricaoNacionalidade) {
		this.descricaoNacionalidade = descricaoNacionalidade;
	}
	public String getSiglaUfNascimento() {
		return siglaUfNascimento;
	}
	public void setSiglaUfNascimento(String siglaUfNascimento) {
		this.siglaUfNascimento = siglaUfNascimento;
	}
	public String getCodigoMunicipioNascimento() {
		return codigoMunicipioNascimento;
	}
	public void setCodigoMunicipioNascimento(String codigoMunicipioNascimento) {
		this.codigoMunicipioNascimento = codigoMunicipioNascimento;
	}
	public String getNomeMunicipioNascimento() {
		return nomeMunicipioNascimento;
	}
	public void setNomeMunicipioNascimento(String nomeMunicipioNascimento) {
		this.nomeMunicipioNascimento = nomeMunicipioNascimento;
	}
	public String getDespesaMaxCampanha() {
		return despesaMaxCampanha;
	}
	public void setDespesaMaxCampanha(String despesaMaxCampanha) {
		this.despesaMaxCampanha = despesaMaxCampanha;
	}
	public String getCodSitTotTurno() {
		return codSitTotTurno;
	}
	public void setCodSitTotTurno(String codSitTotTurno) {
		this.codSitTotTurno = codSitTotTurno;
	}
	public String getDescSitTotTurno() {
		return descSitTotTurno;
	}
	public void setDescSitTotTurno(String descSitTotTurno) {
		this.descSitTotTurno = descSitTotTurno;
	}
	
}
