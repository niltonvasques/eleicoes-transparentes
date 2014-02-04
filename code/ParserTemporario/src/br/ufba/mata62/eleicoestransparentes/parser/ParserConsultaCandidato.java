package br.ufba.mata62.eleicoestransparentes.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.parser.dados.ConsultaCandidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Partido;

public class ParserConsultaCandidato {
	
	public static List<ConsultaCandidato> parsing(String path){
		List<ConsultaCandidato> pccList = new ArrayList<ConsultaCandidato>();
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

			try {
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					line = line.replace("\"\"", " ");
					line = line.replace("\"", " ");
					String data[] = line.split(cvsSplitBy);
						pccList.add(populate(data));
				}
				br.close();
				return pccList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

	}

	/**
	 * Populando em um objeto
	 * @param pcc
	 * @param data
	 */
	private static ConsultaCandidato populate(String[] data) {
		ConsultaCandidato cc = new ConsultaCandidato();
		
		cc.setAnoEleicao(data[ConsultaCandidato.INDEX_ANO_ELEICAO]);
		cc.setCodGrauInstrucao(data[ConsultaCandidato.INDEX_COD_GRAU_INSTRUCAO]);
		cc.setCodigoCargo(data[ConsultaCandidato.INDEX_CODIGO_CARGO]);
		cc.setCodigoEstadoCivil(data[ConsultaCandidato.INDEX_CODIGO_ESTADO_CIVIL]);
		cc.setCodigoLegenda(data[ConsultaCandidato.INDEX_CODIGO_LEGENDA]);
		cc.setCodigoMunicipioNascimento(data[ConsultaCandidato.INDEX_CODIGO_MUNICIPIO_NASCIMENTO]);
		cc.setCodigoNacionalidade(data[ConsultaCandidato.INDEX_CODIGO_NACIONALIDADE]);
		cc.setCodigoOcupacao(data[ConsultaCandidato.INDEX_CODIGO_OCUPACAO]);
		cc.setCodigoSexo(data[ConsultaCandidato.INDEX_CODIGO_SEXO]);
		cc.setCodSitTotTurno(data[ConsultaCandidato.INDEX_COD_SIT_TOT_TURNO]);
		cc.setCodSituacaoCandidatura(data[ConsultaCandidato.INDEX_COD_SITUACAO_CANDIDADATURA]);
		cc.setData(data[ConsultaCandidato.INDEX_DATA]);
		cc.setDataNascimento(data[ConsultaCandidato.INDEX_DATA_NASCIMENTO]);
		cc.setDescricaoCargo(data[ConsultaCandidato.INDEX_DESCRICAO_CARGO]);
		cc.setDescricaoEleicao(data[ConsultaCandidato.INDEX_DESCRICAO_ELEICAO]);
		cc.setDescricaoEstadoCivil(data[ConsultaCandidato.INDEX_DESCRICAO_ESTADO_CIVIL]);
		cc.setDescricaoGrauInstrucao(data[ConsultaCandidato.INDEX_DESCRICAO_GRAU_INSTRUCAO]);
		cc.setDescricaoNacionalidade(data[ConsultaCandidato.INDEX_DESCRICAO_NACIONALIDADE]);
		cc.setDescricaoOcupacao(data[ConsultaCandidato.INDEX_DESCRICAO_OCUPACAO]);
		cc.setDescricaoSexo(data[ConsultaCandidato.INDEX_DESCRICAO_SEXO]);
		cc.setDescricaoUE(data[ConsultaCandidato.INDEX_DESCRICAO_UE]);
		cc.setDescSitTotTurno(data[ConsultaCandidato.INDEX_DESC_SIT_TOT_TURNO]);
		cc.setDespesaMaxCampanha(data[ConsultaCandidato.INDEX_DESPESA_MAX_CAMPANHA]);
		cc.setDesSituacaoCandidatura(data[ConsultaCandidato.INDEX_DES_SITUACAO_CANDIDATURA]);
		cc.setHora(data[ConsultaCandidato.INDEX_HORA]);
		cc.setIdadeDataEleicao(data[ConsultaCandidato.INDEX_IDADE_DATA_ELEICAO]);
		cc.setNomeCandidato(data[ConsultaCandidato.INDEX_NOME_CANDIDATO]);
		cc.setNomeLegenda(data[ConsultaCandidato.INDEX_NOME_CANDIDATO]);
		cc.setNomeMunicipioNascimento(data[ConsultaCandidato.INDEX_NOME_MUNICIPIO_NASCIMENTO]);
		cc.setNomePartido(data[ConsultaCandidato.INDEX_NOME_PARTIDO]);
		cc.setNomeUrnaCandidato(data[ConsultaCandidato.INDEX_NOME_URNA_CANDIDATO]);
		cc.setNumeroCandidadto(data[ConsultaCandidato.INDEX_NUMERO_CANDIDATO]);
		cc.setNumeroPartido(data[ConsultaCandidato.INDEX_NUMERO_PARTIDO]);
		cc.setNumTituloEleitoralCandidato(data[ConsultaCandidato.INDEX_NUM_TITULO_ELEITORAL_CANDIDATO]);
		cc.setNumTurno(data[ConsultaCandidato.INDEX_NUM_TURNO]);
		cc.setSequencialCandidadto(data[ConsultaCandidato.INDEX_SEQUENCIAL_CANDIDATO]);
		cc.setSiglaLegenda(data[ConsultaCandidato.INDEX_SIGLA_LEGENDA]);
		cc.setSiglaPartido(data[ConsultaCandidato.INDEX_SIGLA_PARTIDO]);
		cc.setSiglaUE(data[ConsultaCandidato.INDEX_SIGLA_UE]);
		cc.setSiglaUf(data[ConsultaCandidato.INDEX_SIGLA_UF]);
		cc.setSiglaUfNascimento(data[ConsultaCandidato.INDEX_SIGLA_UF_NASCIMENTO]);
		
		return cc;
	}
	
	public static Candidato populate(ConsultaCandidato bc){
		Candidato cand = new Candidato();
		try{
			cand.setCargo(bc.getDescricaoCargo());
			cand.setLocalNascimento(bc.getNomeMunicipioNascimento());
			cand.setNacionalidade(bc.getDescricaoNacionalidade());
			cand.setNome(bc.getNomeCandidato());
			cand.setNumero(bc.getNumeroCandidadto());
			cand.setSequencialCandidato(bc.getSequencialCandidadto());
			
			Partido p = new Partido();
			p.setNumero(Integer.parseInt(bc.getNumeroPartido()));
			p.setSigla(bc.getSiglaPartido());
			p.setNome(bc.getNomePartido());
			cand.setPartido(p);
	//		bem.setSexo(bc.ge)
			cand.setSiglaUE(bc.getSiglaUE());
			cand.setUF(bc.getSiglaUf());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return cand;
	}
}
