package br.ufba.mata62.eleicoestransparentes.business;

import br.ufba.mata62.eleicoestransparentes.model.*;

import com.google.gson.*;

public abstract class PerfilAgenteEleitoral {
	
	private AgenteEleitoral Perfil;
	
	private String Sobre = "";

	//metodo template
	public String formatarPerfilAgenteEleitoral() {
	
		this.setSobre(this.gerarInformacaoAdicional()); 

		Gson gson = new Gson();
		
		String jsonRetornavel = gson.toJson(this);	
		
		return jsonRetornavel;
	}
	
	//metodo componente do template que implementa uma informacao adicional 
	public abstract String gerarInformacaoAdicional();

	public void setAgenteEleitoral(AgenteEleitoral agenteEleitoral) {
		this.Perfil = agenteEleitoral;
	}
	
	public AgenteEleitoral getPerfil() {
		return Perfil;
	}


	
	public String getPágina() {
		return Sobre;
	}


	public void setSobre(String Sobre) {
		Sobre = Sobre;
	}


	public PerfilAgenteEleitoral(AgenteEleitoral perfil) {
		super();
		this.setAgenteEleitoral(perfil);
	}


	
}
