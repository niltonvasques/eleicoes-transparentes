package br.ufba.mata62.eleicoestransparentes;

import java.sql.SQLException;
import java.util.List;

import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;

import com.google.gson.Gson;


public class Hello {
	
	public String helloName(String name){
		
		try {
			 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
		}
		
		return name;
	}
	
	public String getSetoresEconomico(){
		
		Gson gson = new Gson();
		
		Comunicacao comm = new Comunicacao();
		
		try {
			List<SetorEconomico> setores = comm.consultaSetoresEconomico();
			comm.close();
			return gson.toJson(setores);
		} catch (SQLException e) {
			comm.close();
			return gson.toJson(e);
		}
	}
}
