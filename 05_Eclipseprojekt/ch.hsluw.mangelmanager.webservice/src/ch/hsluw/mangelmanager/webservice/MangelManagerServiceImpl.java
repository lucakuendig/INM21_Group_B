package ch.hsluw.mangelmanager.webservice;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Login;
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
import ch.hsluw.mangelmanager.rmi.bauherr.BauherrRO;
import ch.hsluw.mangelmanager.rmi.gumitarbeiter.GuMitarbeiterRO;
import ch.hsluw.mangelmanager.rmi.login.LoginRO;
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

@WebService(endpointInterface = "ch.hsluw.mangelmanager.webservice.MangelManagerService")
public class MangelManagerServiceImpl implements MangelManagerService{

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
	List<Bauherr> bauherren;
	List<GuMitarbeiter> guMitarbeiter;
 	
	List<Mangelstatus> mangelstatus;
	List<Meldungstyp> meldungstyp;
	String anzProjekte;
	Projekt projekt;
	Subunternehmen subunternehmennr;
	Meldung meldungnr;
	Plz plznr;
	Mangel mangelnr;
	Adresse addAdresse;
	Login login;
	Login loginnr;
	
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
	LoginRO loginRO;
	ProjektSuMitarbeiterRO projektSuMitarbeiterRO;
	BauherrRO bauherrRO;
	GuMitarbeiterRO guMitarbeiterRO;

	public MangelManagerServiceImpl() throws Exception {
		/*
		 * Host-IP und RMI-Port definieren (an sich würde man diese Angaben aus
		 * der Property-Datei einlesen)
		 */
		String hostIp;
		int rmiPort;
		String url;

		// SecurityManager braucht nicht installiert zu werden, da Tomcat einen
		// eigenen SecurityManager hat

		try {

			/* Properties laden */
			Properties props = new Properties();

			InputStream is = MangelManagerServiceImpl.class.getClassLoader()
					.getResourceAsStream("ws.properties");

			props.load(is);

			hostIp = props.getProperty("rmi.host_ip");
			rmiPort = Integer.parseInt(props.getProperty("rmi.port"));
			url = "rmi://" + hostIp + ":" + rmiPort + "/";

			// URLs definieren
			
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
			String loginROName = "loginRO";
			String projektSuMitarbeiterROName = "projektSuMitarbeiterRO";
			String bauherrROName = "bauherrRO";
			String guMitarbeiterROName = "guMitarbeiterRO";
			
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
			this.loginRO = (LoginRO) Naming.lookup(url+ loginROName);
			this.projektSuMitarbeiterRO = (ProjektSuMitarbeiterRO) Naming.lookup(url + projektSuMitarbeiterROName);
			this.bauherrRO = (BauherrRO) Naming.lookup(url + bauherrROName);
			this.guMitarbeiterRO = (GuMitarbeiterRO) Naming.lookup(url + guMitarbeiterROName);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllProjekt()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllSubunternehmen()
	 */
	@Override
	public List<Subunternehmen> getAllSubunternehmen() {
		
		try {
			subunternehmen = subunternehmenRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subunternehmen;
	}
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektproSubunternehmen(int)
	 */
	@Override
	public String getProjektproSubunternehmen(int subunternehmen){
		try {
			anzProjekte = subunternehmenRO.findAllProjekte(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anzProjekte;
		
	}
	
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMangel()
	 */
	@Override
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
	
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMeldung()
	 */
	@Override
	public List<Meldung> getAllMeldung(){
		try {
			meldung = meldungRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meldung;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektById(int)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getSubunternehmenById(int)
	 */
	@Override
	public Subunternehmen getSubunternehmenById(int subunternehmenId) {
		try {
			subunternehmennr = subunternehmenRO.findById(subunternehmenId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subunternehmennr;
	}
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getMeldungById(int)
	 */
	@Override
	public Meldung getMeldungById(int meldungId) {
		try {
			meldungnr = meldungRO.findById(meldungId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meldungnr;
	}
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllPerson()
	 */
	@Override
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


	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#updateSubunternehmen(ch.hsluw.mangelmanager.model.Subunternehmen)
	 */
	@Override
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


	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByBezeichnung(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllPlz()
	 */
	@Override
	public List<Plz> getAllPlz() {
		try {
			plz = plzRO.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return plz;
		
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByBauherr(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByPlz(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByOrt(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getPlzById(int)
	 */
	@Override
	public Plz getPlzById(int plzId) {
		try {
			plznr = plzRO.findById(plzId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plznr;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByObjekttyp(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByArbeitstyp(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getProjektByProjektstatus(java.lang.String)
	 */
	@Override
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


	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addAdresse(ch.hsluw.mangelmanager.model.Adresse)
	 */
	@Override
	public void addAdresse(Adresse adresse) {
		try {
			adresseRO.add(adresse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addSubunternehmen(ch.hsluw.mangelmanager.model.Subunternehmen)
	 */
	@Override
	public void addSubunternehmen(Subunternehmen addSubunternehmen) {
		try {
			subunternehmenRO.add(addSubunternehmen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllSubunternehmenProjekt(ch.hsluw.mangelmanager.model.Subunternehmen)
	 */
	@Override
	public List<Projekt> getAllSubunternehmenProjekt(Subunternehmen subunternehmen) {
		try {
			suprojekte = projektRO.findAllSubunternehmenProjekt(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return suprojekte;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllSubunternehmenMitarbeiter(ch.hsluw.mangelmanager.model.Subunternehmen)
	 */
	@Override
	public List<SuMitarbeiter> getAllSubunternehmenMitarbeiter(Subunternehmen subunternehmen) {
		try {
			sumitarbeiter = subunternehmenRO.findAllSubunternehmenMitarbeiter(subunternehmen);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return sumitarbeiter;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllObjekttyp()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllArbeitstyp()
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMangelProjekt(ch.hsluw.mangelmanager.model.Projekt)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getMangelById(java.lang.Integer)
	 */
	@Override
	public Mangel getMangelById(Integer mangelId) {
		try {
			mangelnr = mangelRO.findById(mangelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mangelnr;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#updateMangel(ch.hsluw.mangelmanager.model.Mangel)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMangelStatus()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addMangel(ch.hsluw.mangelmanager.model.Mangel)
	 */
	@Override
	public void addMangel(Mangel mangel) {
		// TODO Auto-generated method stub
		try {
			mangelRO.add(mangel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMeldungstyp()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addMeldung(ch.hsluw.mangelmanager.model.Meldung)
	 */
	@Override
	public void addMeldung(Meldung meldung) {
		// TODO Auto-generated method stub
		try {
			meldungRO.add(meldung);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllMeldungByMangel(ch.hsluw.mangelmanager.model.Mangel)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getUnternehmenByProjekt(ch.hsluw.mangelmanager.model.Projekt)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getBauleiterByProjekt(ch.hsluw.mangelmanager.model.Projekt)
	 */
	@Override
	public List<ProjektGuMitarbeiter> getBauleiterByProjekt(Projekt projekt2) {
		// TODO Auto-generated method stub
		try {
			bauleiter = projektGuMitarbeiterRO.findAllBauleiterByProjekt(projekt2);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return bauleiter;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getLoginByName(java.lang.String)
	 */
	@Override
	public Login getLoginByName(String name) {
		// TODO Auto-generated method stub
		try {
			login = loginRO.findByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getLoginById(java.lang.Integer)
	 */
	@Override
	public Login getLoginById(Integer loginId) {
		// TODO Auto-generated method stub
		try {
			loginnr = loginRO.findById(loginId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginnr;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#updateProjekt(ch.hsluw.mangelmanager.model.Projekt)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addSuMitarbeiterByProjekt(ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllBauherr()
	 */
	@Override
	public List<Bauherr> getAllBauherr() {
		// TODO Auto-generated method stub
		try {
			bauherren = bauherrRO.findAll();
//			System.out.println(mangelOfProjekt.get(0).getBezeichnung());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return bauherren;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addProjekt(ch.hsluw.mangelmanager.model.Projekt)
	 */
	@Override
	public void addProjekt(Projekt projekt2) {
		// TODO Auto-generated method stub
		try {
			projektRO.add(projekt2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#getAllGuMitarbeiter()
	 */
	@Override
	public List<GuMitarbeiter> getAllGuMitarbeiter() {
		// TODO Auto-generated method stub
		try {
			guMitarbeiter = guMitarbeiterRO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return guMitarbeiter;
	}

	/* (non-Javadoc)
	 * @see ch.hsluw.mangelmanager.webservice.MangelManagerServiced#addGuMitarbeiterByProjekt(ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter)
	 */
	@Override
	public void addGuMitarbeiterByProjekt(
			ProjektGuMitarbeiter projektGuMitarbeiter) {
		// TODO Auto-generated method stub
		try {
			projektGuMitarbeiterRO.add(projektGuMitarbeiter);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
