
package ch.hsluw.mangelmanager.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;

import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

import org.apache.log4j.Logger;













import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.rmi.mangel.MangelRO;
import ch.hsluw.mangelmanager.rmi.meldung.MeldungRO;
import ch.hsluw.mangelmanager.rmi.person.PersonRO;
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
	
	List<Person> person;
	List<Projekt> projekte;
	List<Subunternehmen> subunternehmen;
	List<Mangel> maengel;
	List<Meldung> meldung;
	String anzProjekte;
	Projekt projekt;
	Subunternehmen subunternehmennr;
	
	
	

	private static Logger logger = Logger.getLogger(ClientRMI.class);
	PersonRO personRO;
	ProjektRO projektRO;
	SubunternehmenRO subunternehmenRO;
	MangelRO mangelRO;
	MeldungRO meldungRO;


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
		String personROName = "personRO";
		String projektROName = "projektRO";
		String subunternehmenROName = "subunternehmenRO";
		String mangelROName = "mangelRO";
		String meldungROName ="meldungRO";
		
		this.personRO = (PersonRO) Naming.lookup(personROName);
		this.projektRO = (ProjektRO) Naming.lookup(url + projektROName);
		this.mangelRO = (MangelRO) Naming.lookup(url + mangelROName);
		this.meldungRO = (MeldungRO) Naming.lookup(url + meldungROName);
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
	
	public String getProjektproSubunternehmen(int subunternehmen){
		try {
			anzProjekte = subunternehmenRO.findAllProjekte(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
	public List<Meldung> getAllMeldung(){
		try {
			meldung = meldungRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meldung;
	}

	public Projekt getProjektById(int projektId) {
		// TODO Auto-generated method stub
		try {
			projekt = projektRO.findById(projektId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekt;
	}

	public Subunternehmen getSubunternehmenById(int subunternehmenId) {
		try {
			subunternehmennr = subunternehmenRO.findById(subunternehmenId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subunternehmennr;
	}
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		try {
			person = personRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return person;
	}


	public void update(Subunternehmen subunternehmen) {
			try {
				subunternehmenRO.update(subunternehmen);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}


