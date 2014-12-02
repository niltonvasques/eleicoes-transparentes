package business;

import br.ufba.mata62.eleicoestransparentes.model.Pessoa;

import com.google.gson.Gson;

public abstract class PerfilPessoaAbstrato {
	
	public Pessoa pessoa;
	
	public String formatarPerfilPessoa() {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(this);
		
		
		return json;
	}
	
	public abstract String carregarEnderecoImagem();
	
	public abstract String carregarBiografia();
	
}
