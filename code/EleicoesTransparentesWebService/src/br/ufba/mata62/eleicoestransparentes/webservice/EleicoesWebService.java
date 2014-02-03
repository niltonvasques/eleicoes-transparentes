package br.ufba.mata62.eleicoestransparentes.webservice;

import java.util.List;

import br.ufba.mata62.eleicoestransparentes.EProperties;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;

import com.google.gson.Gson;



public class EleicoesWebService {
	
	public String consultaApplicationPath(){
		return EProperties.findAppDirectory();
	}
	
	public String consultaSetoresEconomico(){
		
		try {
			Gson gson = new Gson();
			Comunicacao comm = new Comunicacao();
			List<SetorEconomico> list = comm.consultaSetoresEconomico();
			comm.close();
			return gson.toJson(list);
		} catch (Exception e) {
			return e.getCause().getMessage();
		}
		
	}
	
	public String consultaCandidatos(){
		
		try {
			Gson gson = new Gson();
			Comunicacao comm = new Comunicacao();
			List<Candidato> list = comm.consultaCandidatos();
			comm.close();
			return gson.toJson(list);
		} catch (Exception e) {
			return e.getCause().getMessage();
		}
		
	}
}
