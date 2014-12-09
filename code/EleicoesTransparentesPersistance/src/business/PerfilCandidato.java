package business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.Pessoa;

public class PerfilCandidato extends PerfilAgenteEleitoral {

	
	@Override
	public String gerarInformacaoAdicional() {
		
		String nomePesquisa = this.getPerfil().getPessoa().getNome();
		
		String padrao = "\\s";
	    Pattern regPat = Pattern.compile(padrao);
	    Matcher matcher = regPat.matcher(nomePesquisa);
	    nomePesquisa = matcher.replaceAll("_");
		
		nomePesquisa = "http://pt.wikipedia.org/wiki/" + nomePesquisa;
		
		
		return nomePesquisa;
		
	}

	public PerfilCandidato(AgenteEleitoral perfil) {
		super(perfil);
		// TODO Auto-generated constructor stub
	}

	
	
}
