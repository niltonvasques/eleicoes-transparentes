package br.ufba.mata62.eleicoestransparentes.business;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;
import br.ufba.mata62.eleicoestransparentes.model.Pessoa;

public class PerfilPartido extends PerfilAgenteEleitoral {


	

	@Override
	public String gerarInformacaoAdicional() {
		
		String nomePesquisa = this.getPerfil().getPessoa().getNome();
		
		String padrao = "\\s";
	    Pattern regPat = Pattern.compile(padrao);
	    Matcher matcher = regPat.matcher(nomePesquisa);
	    nomePesquisa = matcher.replaceAll("-");
		
	    nomePesquisa = nomePesquisa.toLowerCase();
	    
	    String normalizador = Normalizer.normalize(nomePesquisa, Normalizer.Form.NFD);
	    nomePesquisa = normalizador.replaceAll("[^\\p{ASCII}]", "");
	    
		nomePesquisa = "http://www.tse.jus.br/partidos/partidos-politicos/" + nomePesquisa;
		
		return nomePesquisa;
		
	}

	public PerfilPartido(AgenteEleitoral perfil) {
		super(perfil);
		// TODO Auto-generated constructor stub
	}

	
	
}
