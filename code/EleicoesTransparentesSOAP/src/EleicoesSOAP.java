import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;

import com.google.gson.reflect.TypeToken;


public class EleicoesSOAP {

	public static final String METHOD_APP_PATH				= "consultaApplicationPath";
	
	public static final String METHOD_CREATE_TABLES			= "createTables";
	
	public static final String METHOD_SETORES				= "consultaSetoresEconomico";
	public static final String METHOD_CANDIDATOS			= "consultaCandidatos";
	
	private static final String AUTH_KEY 			= "f877fbd3d7c0d0313d3243ff0edcc73d";
	
	private SoapRequest soap;
	public EleicoesSOAP() {
		 this(false);
	}
	
	public EleicoesSOAP(boolean localhost){
		if(localhost){
			soap = new SoapRequest(SoapRequest.URL_DEBUG,SoapRequest.NAMESPACE_DEBUG);
		}else{
			soap = new SoapRequest();
		}
	}
	
	public List<SetorEconomico> consultaSetoresEconomico(){
		
		Type t = new TypeToken<List<SetorEconomico>>(){}.getType();
		List<SetorEconomico> setores = soap.executeSoapRequest(EleicoesSOAP.METHOD_SETORES, t);
		
		return setores;
	}

	
	public List<Candidato> consultaCandidatos() {
		
		Type t = new TypeToken<List<Candidato>>(){}.getType();
		List<Candidato> candidatos = soap.executeSoapRequest(EleicoesSOAP.METHOD_CANDIDATOS, t);
		
		return candidatos;
	}

	public String consultaApplicationPath(){
		
		Type t = new TypeToken<String>(){}.getType();
		String result = soap.executeSoapRequest(EleicoesSOAP.METHOD_APP_PATH, t);
		
		return result;
	}
	
	public String createTables(){
		Type t = new TypeToken<String>(){}.getType();
		
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("chaveSeguranca", AUTH_KEY));
		
		String result = soap.executeSoapRequest(EleicoesSOAP.METHOD_CREATE_TABLES, t, params);
		
		return result;
	}
	
	private static PropertyInfo createParam(String name, String value) {
		return createParam(name, value, String.class);
	}
	
	private static <T> PropertyInfo createParam(String name, Object value, Class<T> type) {
		PropertyInfo chaveSegurancaProperty = new PropertyInfo();
		chaveSegurancaProperty.setName(name);
		chaveSegurancaProperty.setValue(value);
		chaveSegurancaProperty.setType(type);
		return chaveSegurancaProperty;
	}
}

