package br.ufba.mata62.eleicoestransparentes.business;

import java.util.ArrayList;

import com.google.gson.*;

public class GraficoFinal {
	
	private ArrayList<PontosGrafico> pontosGrafico;
	
	private String tipo;
	
	private String nome;
	
	public String formatarGrafico(){
		
		Gson gson = new Gson();
	
		JsonObject dadosGrafico = new JsonObject();
		
		return gson.toJson(this);
		
	}

	public ArrayList<PontosGrafico> getPontosGrafico() {
		return pontosGrafico;
	}

	public void setPontosGrafico(ArrayList<PontosGrafico> pontosGrafico) {
		this.pontosGrafico = pontosGrafico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
