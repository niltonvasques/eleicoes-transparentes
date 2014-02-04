
import java.lang.reflect.Type;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.google.gson.Gson;

public class SoapRequest {
	
	public static final String NAMESPACE_DEBUG = "http://webservice.eleicoestransparentes.mata62.ufba.br/";
	public static final String NAMESPACE_PRODUCTION = "http://webservice.eleicoestransparentes.mata62.ufba.br/";
	
	public static final String URL_PRODUCTION = "http://192.241.169.62:8080/EleicoesTransparentesWebService/services/EleicoesWebService?wsdl";
	public static final String URL_DEBUG = "http://localhost:8080/WebService/services/EleicoesWebService?wsdl";
	
	
	private boolean debug;
	private String url;
	private String namespace;
	
	public SoapRequest() {
		this(URL_PRODUCTION,NAMESPACE_PRODUCTION);
	}
	
	public SoapRequest(String URL,String namespace) {
		this.url = URL;
		this.namespace = namespace;
	}
	
	public <T> T executeSoapRequest(String method, Type type){
		return executeSoapRequest(method, type, null);
	}
	
	public <T> T executeSoapRequest(String method, Type type,  List<PropertyInfo> params){
		return executeSoapRequest(namespace+method, method, type, params);
	}
	
	public <T> T executeSoapRequest(String soapAction, String method, Type type){
		return executeSoapRequest(soapAction, method, type, null);
	}

	public <T> T executeSoapRequest(String soapAction, String method, Type type, List<PropertyInfo> params){
		SoapObject request = new SoapObject(namespace, method);
		
		if(params != null){
			for (PropertyInfo propertyInfo : params) {
				request.addProperty(propertyInfo);
			}
		}

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);

		try {
			androidHttpTransport.call(soapAction, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			if(debug){
				System.out.println("Response: "+response);
			}
			Gson gson = new Gson();
			T t = gson.fromJson(response.toString(), type);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setDebug(boolean b) {
		this.debug = b;	
	}
}
