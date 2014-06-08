package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;
import br.com.eleicoestransparentes.persistence.beans.EBean;

@CVSClass(notation = "ReceitasPartidos", headerInFile = true)
public class ReceitasPartidos extends CVSFile {
	@CVSAttr(name = "Data e hora")
	public String dataEHora;
	@CVSAttr(name = "Sequencial Diretorio")
	public String sequencialDiretorio;
	@CVSAttr(name = "UF")
	public String UF;
	@CVSAttr(name = "Numero UE")
	public String numeroUE;
	@CVSAttr(name = "Municipio")
	public String municipio;
	@CVSAttr(name = "Tipo diretorio")
	public String tipoDiretorio;
	@CVSAttr(name = "Sigla Partido")
	public String siglaPartido;
	@CVSAttr(name = "Tipo do documento")
	public String tipoDoDocumento;
	@CVSAttr(name = "Numero do documento")
	public String numeroDoDocumento;
	@CVSAttr(name = "CPF/CNPJ do doador")
	public String CPFCNPJDoDoador;
	@CVSAttr(name = "Nome do doador")
	public String nomeDoDoador;
	@CVSAttr(name = "Nome receita doador")
	public String nomeReceitaDoador;
	@CVSAttr(name = "Sigla UE doador")
	public String siglaUEDoador;
	@CVSAttr(name = "Numero partido doador")
	public String numeroPartidoDoador;
	@CVSAttr(name = "Numero candidato doador")
	public String numeroCandidatoDoador;
	@CVSAttr(name = "Cod setor economico doador")
	public String codSetorEconomicoDoador;
	@CVSAttr(name = "Setor economico doador")
	public String setorEconomicoDoador;
	@CVSAttr(name = "Data da receita")
	public String dataDaReceita;
	@CVSAttr(name = "Valor receita")
	public String valorReceita;
	@CVSAttr(name = "Tipo receita")
	public String tipoReceita;
	@CVSAttr(name = "Fonte recurso")
	public String fonteRecurso;
	@CVSAttr(name = "Especie recurso")
	public String especieRecurso;
	@CVSAttr(name = "Descricao da receita")
	public String descricaoReceita;
	
	@Override
	public EBean[] getBeans() {
		// TODO Auto-generated method stub
		return null;
	}

}
