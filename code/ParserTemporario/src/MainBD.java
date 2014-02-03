

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

		Comunicacao comm = new Comunicacao();
//		for (Transacao t : ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0])) {
//			run(t,comm);
//		}
		
		for (Bem b : ReadCVS.readBens(Path.UFS[0])) {
			run(b,comm);
		}
		
		comm.close();
		
		

	}
	
	public static void run(Transacao t,Comunicacao comm){
		try {
			comm.insereTransacao(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void run(Bem bem, Comunicacao comm){
		try {
			comm.insereBem(bem);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
