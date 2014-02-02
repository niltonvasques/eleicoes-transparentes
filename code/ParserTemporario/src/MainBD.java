

import java.sql.SQLException;

import test.utils.Path;
import test.utils.ReadCVS;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.Transacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Seed;


public class MainBD {
	
	public static void main(String[] args) {
		
		Seed.createTables();

		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
			run(t);
		}

	}
	
	public static void run(Transacao t){
		Comunicacao comm = new Comunicacao();
		PessoaJuridica cred = (PessoaJuridica) t.getCreditado();
		PessoaFisica deb = (PessoaFisica) t.getDebitado();
		t.getDebitado();
		SetorEconomico setor = t.getCreditado().getSetorEconomico();
		try {
//			comm.insereTransacao(t);
			comm.inserePessoaJuridica(cred);
//			comm.inserePessoaFisica(deb);
//			comm.insereSetorEconomico(setor);
			comm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
}
