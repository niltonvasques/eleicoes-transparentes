package business;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.plot.PiePlot;
import org.afree.chart.title.TextTitle;
import org.afree.data.general.DefaultPieDataset;
import org.afree.data.general.PieDataset;
import org.afree.graphics.geom.Font;

import br.ufba.mata62.eleicoestransparentes.model.*;

import com.google.gson.*;

public class ExemploGrafico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AgenteEleitoral agente = new AgenteEleitoral();
		PessoaFisica fis = new PessoaFisica();
		agente.setPessoa(fis); 
		agente.getPessoa().setNome("Vinicius Gesteira");
	    PerfilPartido cand = new PerfilPartido(agente);
	    
	    System.out.println(cand.formatarPerfilAgenteEleitoral());
	    
	}

}
