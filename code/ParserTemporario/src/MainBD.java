

import java.sql.SQLException;

import test.utils.Path;
import test.utils.ReadCVS;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Seed;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaFisica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.PessoaJuridica;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;


public class MainBD {
	
	public static void main(String[] args) {
		
		Seed.createTables();

		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
			run(t);
		}
		
//		for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
//			run(b);
//		}
		
		

	}
	
	public static void run(Transacao t){
		Comunicacao comm = new Comunicacao();
		PessoaJuridica cred = (PessoaJuridica) t.getCreditado();
		PessoaFisica deb = (PessoaFisica) t.getDebitado();
		t.getDebitado();
		SetorEconomico setor = t.getCreditado().getSetorEconomico();
		try {
			comm.insereTransacao(t);
			comm.inserePessoaJuridica(cred);
			comm.inserePessoaFisica(deb);
			comm.insereSetorEconomico(setor);
			comm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void run(Bem bem){
		Comunicacao comm = new Comunicacao();
		try {
			comm.insereBem(bem);
			comm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
