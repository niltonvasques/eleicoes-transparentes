package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "DespesasPartidos", headerInFile = true)
public class DespesasPartidos extends CVSFile {
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
	@CVSAttr(name = "CPF/CNPJ do fornecedor")
	public String CPFCNPJDoFornecedor;
	@CVSAttr(name = "Nome do fornecedor")
	public String nomeDoFornecedor;
	@CVSAttr(name = "Nome Receita Fornecedor")
	public String nomeReceitaFornecedor;
	@CVSAttr(name = "Cod setor economico fornecedor")
	public String codSetorEconomicoFornecedor;
	@CVSAttr(name = "Setor economico fornecedor")
	public String setorEconomicoFornecedor;
	@CVSAttr(name = "Data da despesa")
	public String dataDaDespesa;
	@CVSAttr(name = "Valor despesa")
	public String valorDespesa;
	@CVSAttr(name = "Tipo despesa")
	public String tipoDespesa;
	@CVSAttr(name = "Descricao da despesa")
	public String descricaoDespesa;
	
	@Override
	public Object[] getBeans() {
		// TODO Auto-generated method stub
		return null;
	}
}
