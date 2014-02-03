

import java.sql.SQLException;

import test.utils.Path;
import test.utils.ReadCVS;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Comunicacao;
import br.ufba.mata62.eleicoestransparentes.persistance.database.Seed;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;


public class MainBD {
	
	public static void main(String[] args) {
		
//		Seed.createTables();

//		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
//			run(t);
//		}
//		
		for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
			run(b);
		}
		
		

	}
	
	public static void run(Transacao t){
		try {
			Comunicacao comm = new Comunicacao();
			comm.insereTransacao(t);
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
