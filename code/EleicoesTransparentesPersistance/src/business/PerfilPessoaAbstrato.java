package business;

import br.ufba.mata62.eleicoestransparentes.model.Pessoa;

import com.google.gson.Gson;

public abstract class PerfilPessoaAbstrato {
	
	public Pessoa pessoa;
	
	public Gson formatarPerfilPessoa() {
		
		return null;
	}
	
	public abstract void carregarImagem();
	
	public abstract void carregarTrajetoriaWikipedia();
	
}
