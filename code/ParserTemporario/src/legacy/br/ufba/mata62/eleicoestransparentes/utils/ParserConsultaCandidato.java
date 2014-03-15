package legacy.br.ufba.mata62.eleicoestransparentes.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		cc.setAnoEleicao(data[ConsultaCandidato.INDEX_ANO_ELEICAO].trim());
		cc.setCodGrauInstrucao(data[ConsultaCandidato.INDEX_COD_GRAU_INSTRUCAO].trim());
		cc.setCodigoCargo(data[ConsultaCandidato.INDEX_CODIGO_CARGO].trim());
		cc.setCodigoEstadoCivil(data[ConsultaCandidato.INDEX_CODIGO_ESTADO_CIVIL].trim());
		cc.setCodigoLegenda(data[ConsultaCandidato.INDEX_CODIGO_LEGENDA].trim());
		cc.setCodigoMunicipioNascimento(data[ConsultaCandidato.INDEX_CODIGO_MUNICIPIO_NASCIMENTO].trim());
		cc.setCodigoNacionalidade(data[ConsultaCandidato.INDEX_CODIGO_NACIONALIDADE].trim());
		cc.setCodigoOcupacao(data[ConsultaCandidato.INDEX_CODIGO_OCUPACAO].trim());
		cc.setCodigoSexo(data[ConsultaCandidato.INDEX_CODIGO_SEXO].trim());
		cc.setCodSitTotTurno(data[ConsultaCandidato.INDEX_COD_SIT_TOT_TURNO].trim());
		cc.setCodSituacaoCandidatura(data[ConsultaCandidato.INDEX_COD_SITUACAO_CANDIDADATURA].trim());
		cc.setData(data[ConsultaCandidato.INDEX_DATA].trim());
		cc.setDataNascimento(data[ConsultaCandidato.INDEX_DATA_NASCIMENTO].trim());
		cc.setDescricaoCargo(data[ConsultaCandidato.INDEX_DESCRICAO_CARGO].trim());
		cc.setDescricaoEleicao(data[ConsultaCandidato.INDEX_DESCRICAO_ELEICAO].trim());
		cc.setDescricaoEstadoCivil(data[ConsultaCandidato.INDEX_DESCRICAO_ESTADO_CIVIL].trim());
		cc.setDescricaoGrauInstrucao(data[ConsultaCandidato.INDEX_DESCRICAO_GRAU_INSTRUCAO].trim());
		cc.setDescricaoNacionalidade(data[ConsultaCandidato.INDEX_DESCRICAO_NACIONALIDADE].trim());
		cc.setDescricaoOcupacao(data[ConsultaCandidato.INDEX_DESCRICAO_OCUPACAO].trim());
		cc.setDescricaoSexo(data[ConsultaCandidato.INDEX_DESCRICAO_SEXO].trim());
		cc.setDescricaoUE(data[ConsultaCandidato.INDEX_DESCRICAO_UE].trim());
		cc.setDescSitTotTurno(data[ConsultaCandidato.INDEX_DESC_SIT_TOT_TURNO].trim());
		cc.setDespesaMaxCampanha(data[ConsultaCandidato.INDEX_DESPESA_MAX_CAMPANHA].trim());
		cc.setDesSituacaoCandidatura(data[ConsultaCandidato.INDEX_DES_SITUACAO_CANDIDATURA].trim());
		cc.setHora(data[ConsultaCandidato.INDEX_HORA].trim());
		cc.setIdadeDataEleicao(data[ConsultaCandidato.INDEX_IDADE_DATA_ELEICAO].trim());
		cc.setNomeCandidato(data[ConsultaCandidato.INDEX_NOME_CANDIDATO].trim());
		cc.setNomeLegenda(data[ConsultaCandidato.INDEX_NOME_CANDIDATO].trim());
		cc.setNomeMunicipioNascimento(data[ConsultaCandidato.INDEX_NOME_MUNICIPIO_NASCIMENTO].trim());
		cc.setNomePartido(data[ConsultaCandidato.INDEX_NOME_PARTIDO].trim());
		cc.setNomeUrnaCandidato(data[ConsultaCandidato.INDEX_NOME_URNA_CANDIDATO].trim());
		cc.setNumeroCandidadto(data[ConsultaCandidato.INDEX_NUMERO_CANDIDATO].trim());
		cc.setNumeroPartido(data[ConsultaCandidato.INDEX_NUMERO_PARTIDO].trim());
		cc.setNumTituloEleitoralCandidato(data[ConsultaCandidato.INDEX_NUM_TITULO_ELEITORAL_CANDIDATO].trim());
		cc.setNumTurno(data[ConsultaCandidato.INDEX_NUM_TURNO].trim());
		cc.setSequencialCandidadto(data[ConsultaCandidato.INDEX_SEQUENCIAL_CANDIDATO].trim());
		cc.setSiglaLegenda(data[ConsultaCandidato.INDEX_SIGLA_LEGENDA].trim());
		cc.setSiglaPartido(data[ConsultaCandidato.INDEX_SIGLA_PARTIDO].trim());
		cc.setSiglaUE(data[ConsultaCandidato.INDEX_SIGLA_UE].trim());
		cc.setSiglaUf(data[ConsultaCandidato.INDEX_SIGLA_UF].trim());
		cc.setSiglaUfNascimento(data[ConsultaCandidato.INDEX_SIGLA_UF_NASCIMENTO].trim());
		
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
			p.setNumero(Integer.parseInt(bc.getNumeroPartido().trim()));
			p.setSigla(bc.getSiglaPartido());
			p.setNome(bc.getNomePartido());
			cand.setPartido(p);
	//		bem.setSexo(bc.ge)
			cand.setSiglaUE(bc.getSiglaUE());
			cand.setUF(bc.getSiglaUf());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cand;
	}
}
