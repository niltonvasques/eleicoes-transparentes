package br.ufba.eleicoestransparentes.business.parser.ano2012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.ufba.eleicoestransparentes.business.parser.ParserFile;
import br.ufba.eleicoestransparentes.business.parser.templates.ano2012.ConsultaCandidato2012;
import br.ufba.eleicoestransparentes.model.Candidato;
import br.ufba.eleicoestransparentes.model.Partido;

public class ParserConsultaCandidato2012 extends ParserFile<ConsultaCandidato2012, Candidato>{
	
	public ParserConsultaCandidato2012(String file) {
		super(file);
	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	@Override
	protected ConsultaCandidato2012 populateTemplate(String[] data) {
		ConsultaCandidato2012 cc = new ConsultaCandidato2012();
		
		cc.setAnoEleicao(data[ConsultaCandidato2012.INDEX_ANO_ELEICAO].trim());
		cc.setCodGrauInstrucao(data[ConsultaCandidato2012.INDEX_COD_GRAU_INSTRUCAO].trim());
		cc.setCodigoCargo(data[ConsultaCandidato2012.INDEX_CODIGO_CARGO].trim());
		cc.setCodigoEstadoCivil(data[ConsultaCandidato2012.INDEX_CODIGO_ESTADO_CIVIL].trim());
		cc.setCodigoLegenda(data[ConsultaCandidato2012.INDEX_CODIGO_LEGENDA].trim());
		cc.setCodigoMunicipioNascimento(data[ConsultaCandidato2012.INDEX_CODIGO_MUNICIPIO_NASCIMENTO].trim());
		cc.setCodigoNacionalidade(data[ConsultaCandidato2012.INDEX_CODIGO_NACIONALIDADE].trim());
		cc.setCodigoOcupacao(data[ConsultaCandidato2012.INDEX_CODIGO_OCUPACAO].trim());
		cc.setCodigoSexo(data[ConsultaCandidato2012.INDEX_CODIGO_SEXO].trim());
		cc.setCodSitTotTurno(data[ConsultaCandidato2012.INDEX_COD_SIT_TOT_TURNO].trim());
		cc.setCodSituacaoCandidatura(data[ConsultaCandidato2012.INDEX_COD_SITUACAO_CANDIDADATURA].trim());
		cc.setData(data[ConsultaCandidato2012.INDEX_DATA].trim());
		cc.setDataNascimento(data[ConsultaCandidato2012.INDEX_DATA_NASCIMENTO].trim());
		cc.setDescricaoCargo(data[ConsultaCandidato2012.INDEX_DESCRICAO_CARGO].trim());
		cc.setDescricaoEleicao(data[ConsultaCandidato2012.INDEX_DESCRICAO_ELEICAO].trim());
		cc.setDescricaoEstadoCivil(data[ConsultaCandidato2012.INDEX_DESCRICAO_ESTADO_CIVIL].trim());
		cc.setDescricaoGrauInstrucao(data[ConsultaCandidato2012.INDEX_DESCRICAO_GRAU_INSTRUCAO].trim());
		cc.setDescricaoNacionalidade(data[ConsultaCandidato2012.INDEX_DESCRICAO_NACIONALIDADE].trim());
		cc.setDescricaoOcupacao(data[ConsultaCandidato2012.INDEX_DESCRICAO_OCUPACAO].trim());
		cc.setDescricaoSexo(data[ConsultaCandidato2012.INDEX_DESCRICAO_SEXO].trim());
		cc.setDescricaoUE(data[ConsultaCandidato2012.INDEX_DESCRICAO_UE].trim());
		cc.setDescSitTotTurno(data[ConsultaCandidato2012.INDEX_DESC_SIT_TOT_TURNO].trim());
		cc.setDespesaMaxCampanha(data[ConsultaCandidato2012.INDEX_DESPESA_MAX_CAMPANHA].trim());
		cc.setDesSituacaoCandidatura(data[ConsultaCandidato2012.INDEX_DES_SITUACAO_CANDIDATURA].trim());
		cc.setHora(data[ConsultaCandidato2012.INDEX_HORA].trim());
		cc.setIdadeDataEleicao(data[ConsultaCandidato2012.INDEX_IDADE_DATA_ELEICAO].trim());
		cc.setNomeCandidato(data[ConsultaCandidato2012.INDEX_NOME_CANDIDATO].trim());
		cc.setNomeLegenda(data[ConsultaCandidato2012.INDEX_NOME_CANDIDATO].trim());
		cc.setNomeMunicipioNascimento(data[ConsultaCandidato2012.INDEX_NOME_MUNICIPIO_NASCIMENTO].trim());
		cc.setNomePartido(data[ConsultaCandidato2012.INDEX_NOME_PARTIDO].trim());
		cc.setNomeUrnaCandidato(data[ConsultaCandidato2012.INDEX_NOME_URNA_CANDIDATO].trim());
		cc.setNumeroCandidadto(data[ConsultaCandidato2012.INDEX_NUMERO_CANDIDATO].trim());
		cc.setNumeroPartido(data[ConsultaCandidato2012.INDEX_NUMERO_PARTIDO].trim());
		cc.setNumTituloEleitoralCandidato(data[ConsultaCandidato2012.INDEX_NUM_TITULO_ELEITORAL_CANDIDATO].trim());
		cc.setNumTurno(data[ConsultaCandidato2012.INDEX_NUM_TURNO].trim());
		cc.setSequencialCandidadto(data[ConsultaCandidato2012.INDEX_SEQUENCIAL_CANDIDATO].trim());
		cc.setSiglaLegenda(data[ConsultaCandidato2012.INDEX_SIGLA_LEGENDA].trim());
		cc.setSiglaPartido(data[ConsultaCandidato2012.INDEX_SIGLA_PARTIDO].trim());
		cc.setSiglaUE(data[ConsultaCandidato2012.INDEX_SIGLA_UE].trim());
		cc.setSiglaUf(data[ConsultaCandidato2012.INDEX_SIGLA_UF].trim());
		cc.setSiglaUfNascimento(data[ConsultaCandidato2012.INDEX_SIGLA_UF_NASCIMENTO].trim());
		
		return cc;
	}

	@Override
	protected Candidato populateModel(ConsultaCandidato2012 data) {
		Candidato cand = new Candidato();
		try{
			cand.setCargo(data.getDescricaoCargo());
			cand.setLocalNascimento(data.getNomeMunicipioNascimento());
			cand.setNacionalidade(data.getDescricaoNacionalidade());
			cand.setNome(data.getNomeCandidato());
			cand.setNumero(data.getNumeroCandidadto());
			cand.setSequencialCandidato(data.getSequencialCandidadto());
			
			Partido p = new Partido();
			p.setNumero(Integer.parseInt(data.getNumeroPartido().trim()));
			p.setSigla(data.getSiglaPartido());
			p.setNome(data.getNomePartido());
			cand.setPartido(p);
	//		bem.setSexo(bc.ge)
			cand.setSiglaUE(data.getSiglaUE());
			cand.setUF(data.getSiglaUf());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cand;
	}
}
