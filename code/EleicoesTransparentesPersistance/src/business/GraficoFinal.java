package business;

import com.google.gson.Gson;

public class GraficoFinal {
	
	public PontosGrafico pontosGrafico;
	
	public String tipo;
	
	public String nome;
	
	public String formatarGrafico(){
		
		Gson gson = new Gson();
	
		String json = gson.toJson(this); 
		
		return json;
		
	}
	
}
