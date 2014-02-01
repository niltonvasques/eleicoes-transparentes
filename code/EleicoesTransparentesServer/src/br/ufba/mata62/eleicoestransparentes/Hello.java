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
}
