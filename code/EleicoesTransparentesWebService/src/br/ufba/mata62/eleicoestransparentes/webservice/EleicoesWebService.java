package br.ufba.mata62.eleicoestransparentes.webservice;

import java.util.List;

import br.ufba.mata62.eleicoestransparentes.EProperties;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Seed;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.webservice.util.MD5;

import com.google.gson.Gson;



public class EleicoesWebService {

	private static final String CHAVE_SEGURANCA = "eleicoes-transparentes-mata62-ufba";

	//	public static void main(String[] args) {
	//		String md5 = MD5.crypt(CHAVE_SEGURANCA);
	//		System.out.println(md5);
	//	}

	public String createTables(String chaveSeguranca){
		try{
			Gson gson = new Gson();
			if(MD5.crypt(CHAVE_SEGURANCA).equals(chaveSeguranca)){
				try{
					Seed.createTables();
				}catch (Exception e) {
					return e.getMessage();
				}
				return gson.toJson("Tabelas criadas com sucesso!");
			}else{
				return gson.toJson("Chave de Segurança inválida!");
			}
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	public String consultaApplicationPath(){
		try{
			Gson gson = new Gson();
			return gson.toJson(EProperties.findAppDirectory());
		}catch (Exception e) {
			return e.getCause().getMessage();
		}
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
