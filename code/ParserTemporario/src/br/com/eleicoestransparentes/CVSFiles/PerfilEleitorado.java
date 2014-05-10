package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

/**
 * Classe do arquivo CVS de perfil do eleitorado.
 * @author tiagogoncalves
 *
 */
@CVSClass(notation = "PERFIL_ELEITORADO_<ANO ELEIÇÃO>_<SIGLA UF>",headerInFile = false)
public class PerfilEleitorado  extends CVSFile{
	
	public String[] header = { "PERIODO", "UF", "MUNICIPIO",
			"COD_MUNICIPIO_TSE", "NR_ZONA", "SEXO", "FAIXA_ETARIA",
			"GRAU_DE_ESCOLARIDADE", "QTD_ELEITORES_NO_PERFIL" };

	@CVSAttr(name = "PERIODO")
	public String periodo;
	@CVSAttr(name = "UF")
	public String UF;
	@CVSAttr(name = "MUNICIPIO")
	public String municipio;
	@CVSAttr(name = "COD_MUNICIPIO_TSE")
	public String codMunicipioTSE;
	@CVSAttr(name = "NR_ZONA")
	public String nrZona;
	@CVSAttr(name = "SEXO")
	public String sexo;
	@CVSAttr(name = "FAIXA_ETARIA")
	public String faixaEtaria;
	@CVSAttr(name = "GRAU_DE_ESCOLARIDADE")
	public String grauDeEscolaridade;
	@CVSAttr(name = "QTD_ELEITORES_NO_PERFIL")
	public String qtdEleitoresNoPerfil;
	
	@Override
	public Object[] getBeans() {
		// TODO Auto-generated method stub
		return null;
	}
}
