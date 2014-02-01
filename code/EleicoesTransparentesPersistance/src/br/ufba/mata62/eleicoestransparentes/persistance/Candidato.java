package br.ufba.mata62.eleicoestransparentes.persistance;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Candidato")
public class Candidato {

	@DatabaseField(canBeNull = false)
	private String numero;

	@DatabaseField
	private String cargo;

	@DatabaseField
	private String UF;

	@DatabaseField
	private String municipio;

	@DatabaseField
	private Partido partido;

}
