package br.ufba.mata62.eleicoestransparentes;



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
		
//		Gson gson = new Gson();
//		
//		Comunicacao comm = new Comunicacao();
//		
//		try {
//			List<SetorEconomico> setores = comm.consultaSetoresEconomico();
//			comm.close();
//			return "Result: "+gson.toJson(setores);
//		} catch (SQLException e) {
//			comm.close();
//			return "Result: "+ gson.toJson(e);
//		}
		return "TESTANDO GET SETORES ECONOMICOS";
	}
}
