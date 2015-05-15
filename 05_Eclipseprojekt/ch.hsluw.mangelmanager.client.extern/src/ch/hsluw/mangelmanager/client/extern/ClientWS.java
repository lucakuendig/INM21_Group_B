package ch.hsluw.mangelmanager.client.extern;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.webservice.MangelManagerService;
import ch.hsluw.mangelmanager.webservice.MangelManagerServiceImpl;

/**
 * Diese Klasse stellt das Userinterface fuer den MangelMangager via SOAP/WS
 * zur Verfuegung
 * 
 * @version 1.0
 * @author lkuendig
 *
 */
public class ClientWS {
	public Service service;
	public MangelManagerService proxy;
	private static ClientWS instance;
	
	public static ClientWS getInstance () {
	    if (ClientWS.instance == null) {
	    		
	    		try {
					ClientWS.instance = new ClientWS();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    return ClientWS.instance;
	  }
	/**
	 * Instantiates a new mangelmanager client rmi.
	 *
	 * @throws Exception
	 */
	public ClientWS() throws Exception {

		///1st argument service URI, refer to wsdl document above
		URL url = new URL("http://localhost:8080/MangelManager/mangelmanager?wsdl");
		//2nd argument is service name, refer to wsdl document above
	    QName qname = new QName("http://webservice.mangelmanager.hsluw.ch/", "MangelManagerServiceImplService");

	   service = Service.create(url, qname);
	    proxy = service.getPort(MangelManagerService.class);
	}
}
