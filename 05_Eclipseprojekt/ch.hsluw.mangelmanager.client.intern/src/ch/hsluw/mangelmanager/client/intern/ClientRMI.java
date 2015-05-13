
package ch.hsluw.mangelmanager.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import javafx.util.Callback;

import org.apache.log4j.Logger;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.rmi.adresse.AdresseRO;
import ch.hsluw.mangelmanager.rmi.arbeitstyp.ArbeitstypRO;
import ch.hsluw.mangelmanager.rmi.mangel.MangelRO;
import ch.hsluw.mangelmanager.rmi.mangelstatus.MangelstatusRO;
import ch.hsluw.mangelmanager.rmi.meldung.MeldungRO;
import ch.hsluw.mangelmanager.rmi.meldungstyp.MeldungstypRO;
import ch.hsluw.mangelmanager.rmi.objekttyp.ObjekttypRO;
import ch.hsluw.mangelmanager.rmi.person.PersonRO;
import ch.hsluw.mangelmanager.rmi.plz.PlzRO;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektRO;
import ch.hsluw.mangelmanager.rmi.projektgumitarbeiter.ProjektGuMitarbeiterRO;
import ch.hsluw.mangelmanager.rmi.projektsumitarbeiter.ProjektSuMitarbeiterRO;
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
	List<Projekt> suprojekte;
	List<Subunternehmen> subunternehmen;
	
	List<Mangel> maengel;
	List<Meldung> meldung;
	List<Plz> plz;
	List<Objekttyp> objekttyp;
	List<Arbeitstyp> arbeitstyp;
	List<SuMitarbeiter> sumitarbeiter;
	List<ProjektGuMitarbeiter> bauleiter;
	List<Mangel> mangelOfProjekt;
	List<Meldung> meldungByMangel;
	
	List<Mangelstatus> mangelstatus;
	List<Meldungstyp> meldungstyp;
	String anzProjekte;
	Projekt projekt;
	Subunternehmen subunternehmennr;
	Meldung meldungnr;
	Plz plznr;
	Mangel mangelnr;
	Adresse addAdresse;
	
	
	
	

	private static Logger logger = Logger.getLogger(ClientRMI.class);
	PersonRO personRO;
	ProjektRO projektRO;
	SubunternehmenRO subunternehmenRO;
	MangelRO mangelRO;
	MeldungRO meldungRO;
	PlzRO plzRO;
	AdresseRO adresseRO;
	ObjekttypRO  objekttypRO;
	ArbeitstypRO arbeitstypRO;
	MangelstatusRO mangelstatusRO;
	MeldungstypRO meldungstypRO;
	ProjektGuMitarbeiterRO projektGuMitarbeiterRO;
	ProjektSuMitarbeiterRO projektSuMitarbeiterRO;
	
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
		String plzROName ="plzRO";
		String adresseROName = "adresseRO";
		String objekttypROName = "objekttypRO";
		String arbeitstyROName = "arbeitstypRO";
		String mangelstatusROName = "mangelstatusRO";
		String meldungstypROName = "meldungstypRO";
		String projektGuMitarbeiterROName = "projektGuMitarbeiterRO";
		String projektSuMitarbeiterROName = "projektSuMitarbeiterRO";
		
		this.personRO = (PersonRO) Naming.lookup(personROName);
		this.projektRO = (ProjektRO) Naming.lookup(url + projektROName);
		this.mangelRO = (MangelRO) Naming.lookup(url + mangelROName);
		this.meldungRO = (MeldungRO) Naming.lookup(url + meldungROName);
		this.subunternehmenRO = (SubunternehmenRO) Naming.lookup(url + subunternehmenROName);
		this.plzRO = (PlzRO) Naming.lookup(url + plzROName);
		this.adresseRO = (AdresseRO) Naming.lookup(url + adresseROName);
		this.objekttypRO = (ObjekttypRO) Naming.lookup(url + objekttypROName);
		this.arbeitstypRO = (ArbeitstypRO) Naming.lookup(url + arbeitstyROName);
		this.mangelstatusRO = (MangelstatusRO) Naming.lookup(url + mangelstatusROName);
		this.meldungstypRO = (MeldungstypRO) Naming.lookup(url + meldungstypROName);
		this.projektGuMitarbeiterRO = (ProjektGuMitarbeiterRO) Naming.lookup(url + projektGuMitarbeiterROName);
		this.projektSuMitarbeiterRO = (ProjektSuMitarbeiterRO) Naming.lookup(url + projektSuMitarbeiterROName);

		
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
	
	public Meldung getMeldungById(int meldungId) {
		try {
			meldungnr = meldungRO.findById(meldungId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meldungnr;
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


	public void updateSubunternehmen(Subunternehmen subunternehmen) {
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


	public List<Projekt> getProjektByBezeichnung(String bezeichnung) {
			// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByBezeichnung(bezeichnung);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getBeschreibung());
			}
		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public List<Plz> getAllPlz() {
		try {
			plz = plzRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return plz;
		
	}

	public List<Projekt> getProjektByBauherr(String bauherr) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByBauherr(bauherr);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkBauherr().get(0).getNachname());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public List<Projekt> getProjektByPlz(String plz) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByPlz(plz);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkAdresse().getPlz().getPlz());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public List<Projekt> getProjektByOrt(String ort) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByOrt(ort);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkAdresse().getPlz().getOrt());
			}
		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public Plz getPlzById(int plzId) {
		try {
			plznr = plzRO.findById(plzId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plznr;
	}

	public List<Projekt> getProjektByObjekttyp(String objekttyp) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByObjekttyp(objekttyp);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkObjekttyp().getBezeichnung());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public List<Projekt> getProjektByArbeitstyp(String arbeitstyp) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByArbeitstyp(arbeitstyp);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkArbeitstyp().getBezeichnung());;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}

	public List<Projekt> getProjektByProjektstatus(String projektstatus) {
		// TODO Auto-generated method stub
		try {
			projekte =  projektRO.findByProjektstatus(projektstatus);
			for (Projekt projekt : projekte) {
				System.out.println(projekt.getFkProjektstatus().getBezeichnung());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projekte;
	}


	public void addAdresse(Adresse adresse) {
		try {
			adresseRO.add(adresse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addSubunternehmen(Subunternehmen addSubunternehmen) {
		try {
			subunternehmenRO.add(addSubunternehmen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Projekt> getAllSubunternehmenProjekt(Subunternehmen subunternehmen) {
		try {
			suprojekte = projektRO.findAllSubunternehmenProjekt(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return suprojekte;
	}

	public List<SuMitarbeiter> getAllSubunternehmenMitarbeiter(Subunternehmen subunternehmen) {
		try {
			sumitarbeiter = subunternehmenRO.findAllSubunternehmenMitarbeiter(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return sumitarbeiter;
	}

	public List<Objekttyp> getAllObjekttyp() {
		// TODO Auto-generated method stub
		try {
			objekttyp = objekttypRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objekttyp;
	}
	
	public List<Arbeitstyp> getAllArbeitstyp() {
		// TODO Auto-generated method stub
		try {
			arbeitstyp = arbeitstypRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arbeitstyp;
	}
	public List<Mangel> getAllMangelProjekt(Projekt projekt) {
		try {
			mangelOfProjekt = mangelRO.findAllMangelProjekt(projekt);
//			System.out.println(mangelOfProjekt.get(0).getBezeichnung());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return mangelOfProjekt;
	}

	public Mangel getMangelById(Integer mangelId) {
		try {
			mangelnr = mangelRO.findById(mangelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mangelnr;
	}

	public void updateMangel(Mangel mangel) {
		// TODO Auto-generated method stub
		try {
			mangelRO.update(mangel);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Mangelstatus> getAllMangelStatus() {
		try {
			mangelstatus = mangelstatusRO.findAllMangelStatus();
//			System.out.println(mangelOfProjekt.get(0).getBezeichnung());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return mangelstatus;
	}

	public void addMangel(Mangel mangel) {
		// TODO Auto-generated method stub
		try {
			mangelRO.add(mangel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Meldungstyp> getAllMeldungstyp() {
		// TODO Auto-generated method stub
		try {
			meldungstyp = meldungstypRO.findAll();
//			System.out.println(mangelOfProjekt.get(0).getBezeichnung());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return meldungstyp;
	}

	public void addMeldung(Meldung meldung) {
		// TODO Auto-generated method stub
		try {
			meldungRO.add(meldung);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Meldung> getAllMeldungByMangel(Mangel mangel) {
		// TODO Auto-generated method stub
		try {
			meldungByMangel = meldungRO.findAllMeldungByMangel(mangel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return meldungByMangel;
	}

	public List<Subunternehmen> getUnternehmenByProjekt(Projekt projekt2) {
		// TODO Auto-generated method stub
		try {
			subunternehmen = subunternehmenRO.findAllSubunternehmenByProjekt(projekt2);
		} catch (Exception e) {
			// TODO Auto-generated catch block<
			e.printStackTrace();
		}
			return subunternehmen;
	}

	public List<ProjektGuMitarbeiter> getBauleiterByProjekt(Projekt projekt2) {
		// TODO Auto-generated method stub
		try {
			bauleiter = projektGuMitarbeiterRO.findAllBauleiterByProjekt(projekt2);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return bauleiter;
	}

	public void updateProjekt(Projekt projekt2) {
		// TODO Auto-generated method stub
		try {
			projektRO.update(projekt2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addSuMitarbeiterByProjekt(ProjektSuMitarbeiter psum) {
		// TODO Auto-generated method stub
		try {
			projektSuMitarbeiterRO.add(psum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}



