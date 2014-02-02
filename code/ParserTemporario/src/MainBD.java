

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
		
		Comunicacao comm = new Comunicacao();
		
		Transacao t = ReadCVS.readPrestacaoContasCandidatoDespesa(Path.UFS[0]).get(0);
		
		PessoaJuridica cred = (PessoaJuridica) t.getCreditado();
		PessoaFisica deb = (PessoaFisica) t.getDebitado();
		t.getDebitado();
		SetorEconomico setor = t.getCreditado().getSetorEconomico();
		
		
//		SetorEconomico setor = new SetorEconomico();
//		setor.setCodSetorEco("00023");
//		setor.setNome("TRANSPORTE");
		
		try {
			
			comm.insereTransacao(t);
			comm.inserePessoaJuridica(cred);
			comm.inserePessoaFisica(deb);
			comm.insereSetorEconomico(setor);
			System.out.println("done");
			
//			List<SetorEconomico> setores = comm.consultaSetoresEconomico();
//			
//			for (SetorEconomico ormSetorEconomico : setores) {
//				System.out.print("id: "+ormSetorEconomico.getId());
//				System.out.print(" nome: "+ormSetorEconomico.getNome());
//				System.out.println(" codSetorEco: "+ormSetorEconomico.getCodSetorEco());
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		Candidato candidato = new Candidato();
//		candidato.setAlfabetizado(true);
//		candidato.setCargo("Prefeito");
//		candidato.setCpf("01232145612");
//		candidato.set
//		
//		
//		Bem bem = new Bem();
//
//		bem.setDescricao("FAZENDA NOVA IGUAÇU");
//		
//		bem.setValor(500000f);
//		
//		bem.setCandidato(candidato);
//		
//		comm.insereBem(bem);

	}
}
