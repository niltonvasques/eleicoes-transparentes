package br.com.eleicoestransparentes.CVSFiles;

import br.com.eleicoestransparentes.annotations.CVSAttr;
import br.com.eleicoestransparentes.annotations.CVSClass;

@CVSClass(notation = "ReceitasCandidatos", headerInFile = true)
public class ReceitasCandidatos extends CVSFile {

	@CVSAttr(name = "Data e hora")
	public String dataEHora;
	@CVSAttr(name = "Sequencial Candidato")
	public String sequencialCandidato;
	@CVSAttr(name = "UF")
	public String UF;
	@CVSAttr(name = "Numero UE")
	public String numeroUE;
	@CVSAttr(name = "Municipio")
	public String municipio;
	@CVSAttr(name = "Sigla Partido")
	public String siglaPartido;
	@CVSAttr(name = "Numero candidato")
	public String numeroCandidato;
	@CVSAttr(name = "Cargo")
	public String cargo;
	@CVSAttr(name = "Nome candidato")
	public String nomeCandidato;
	@CVSAttr(name = "CPF do candidato")
	public String CPFCandidato;
	@CVSAttr(name = "Numero Recibo Eleitoral")
	public String numeroReciboEleitoral;
	@CVSAttr(name = "Numero do documento")
	public String numeroDoDocumento;
	@CVSAttr(name = "CPF/CNPJ do doador")
	public String CPFCNPJDoDoador;
	@CVSAttr(name = "Nome do doador")
	public String nomeDoDoador;
	@CVSAttr(name = "Nome Receita Doador")
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
}
