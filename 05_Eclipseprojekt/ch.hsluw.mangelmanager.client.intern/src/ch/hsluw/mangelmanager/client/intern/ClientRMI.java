
package ch.hsluw.mangelmanager.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;


import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.rmi.mangel.MangelRO;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektRO;
import ch.hsluw.mangelmanager.rmi.subunternehmen.SubunternehmenRO;



/**
 * Diese Klasse stellt das Userinterface fuer die Modulverwaltung via RMI zur
 * Verfuegung
 * 
 * @version 1.0
 * @author sritz
 *
 */
public class ClientRMI {
	private static ClientRMI instance;
	 
	public static ClientRMI getInstance () {
	    if (ClientRMI.instance == null) {
	    	try {
				ClientRMI.instance = new ClientRMI();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return ClientRMI.instance;
	  }
	
	List<Projekt> projekte;
	List<Subunternehmen> subunternehmen;
	List<Mangel> maengel;
	List<Meldung> meldung;
	String anzProjekte;

	private static Logger logger = Logger.getLogger(ClientRMI.class);
	ProjektRO projektRO;
	SubunternehmenRO subunternehmenRO;
	MangelRO mangelRO;


	public static void main(String[] args) {
		try {
			// Init Application over RMI
			ClientRMI rmicon = new ClientRMI();
			System.out.println("Verbindung zu RMI Server hergestellt");
		} catch (Exception e) {
			logger.error("RMI Fehler: ", e);
			e.printStackTrace();

		}
	}

	/**
	 * Instantiates a new modulverwaltung client rmi.
	 *
	 * @throws Exception
	 */
	public ClientRMI() throws Exception {


		// init rmi connection
		String url = "rmi://localhost:1099/";
		String projektROName = "projektRO";
		String subunternehmenROName = "subunternehmenRO";
		String mangelROName = "mangelRO";

		this.projektRO = (ProjektRO) Naming.lookup(url + projektROName);
		this.mangelRO = (MangelRO) Naming.lookup(url + mangelROName);
		this.subunternehmenRO = (SubunternehmenRO) Naming.lookup(url + subunternehmenROName);
		

		
	}

	public List<Projekt> getAllProjekt() {
		// TODO Auto-generated method stub
		try {
			projekte = projektRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
		
	}
	
	public List<Subunternehmen> getAllSubunternehmen() {
		
		try {
			subunternehmen = subunternehmenRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subunternehmen;
	}
	
	public String getProjektproSubunternehmen(){
		anzProjekte = subunternehmenRO.findAllProjekte();
		return anzProjekte;
		
	}
	
	
	public List<Mangel> getAllMangel() {

		// TODO Auto-generated method stub
		try {
			maengel = mangelRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maengel;
		
	}
	
	
	


}


