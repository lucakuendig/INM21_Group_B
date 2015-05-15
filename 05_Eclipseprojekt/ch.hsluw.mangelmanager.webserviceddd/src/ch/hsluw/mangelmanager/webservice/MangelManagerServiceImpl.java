package ch.hsluw.mangelmanager.webservice;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.jws.WebService;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.rmi.adresse.AdresseRO;
import ch.hsluw.mangelmanager.rmi.arbeitstyp.ArbeitstypRO;
import ch.hsluw.mangelmanager.rmi.bauherr.BauherrRO;
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

	Login login;
	
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

	public MangelManagerServiceImpl() throws Exception {

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

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
	}
	
	
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
	
}
