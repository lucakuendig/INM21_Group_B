package ch.hsluw.mangelmanager.client.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
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
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.model.Rolle;
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
import ch.hsluw.mangelmanager.rmi.projektstatus.ProjektstatusRO;
import ch.hsluw.mangelmanager.rmi.projektsumitarbeiter.ProjektSuMitarbeiterRO;
import ch.hsluw.mangelmanager.rmi.rolle.RolleRO;
import ch.hsluw.mangelmanager.rmi.subunternehmen.SubunternehmenRO;
import ch.hsluw.mangelmanager.rmi.sumitarbeiter.SuMitarbeiterRO;

/**
 * Diese Klasse testet die Methoden von ClientRMI
 * 
 * @version 1.0
 * @author mmont
 *
 */

public class ClientRMITest {

	// all the needed objects
	
	List<Person> person;
	List<Projekt> projekte;
	List<Projekt> suprojekte;
	List<Projektstatus> projektstatus;
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
	Person personnr;
	List<Rolle> rollen;

	PersonRO personRO;
	ProjektRO projektRO;
	SubunternehmenRO subunternehmenRO;
	MangelRO mangelRO;
	MeldungRO meldungRO;
	PlzRO plzRO;
	AdresseRO adresseRO;
	ObjekttypRO objekttypRO;
	ArbeitstypRO arbeitstypRO;
	MangelstatusRO mangelstatusRO;
	MeldungstypRO meldungstypRO;
	ProjektGuMitarbeiterRO projektGuMitarbeiterRO;
	LoginRO loginRO;
	ProjektSuMitarbeiterRO projektSuMitarbeiterRO;
	BauherrRO bauherrRO;
	GuMitarbeiterRO guMitarbeiterRO;
	ProjektstatusRO projektstatusRO;
	SuMitarbeiterRO suMitarbeiterRO;
	RolleRO rolleRO;

	// The Tests
	
	@Test
	public void getAllProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getAllProjekt();
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekte");
		}
	}

	@Test
	public void getAllSubunternehmenTest() {
		try {
			ClientRMI client = new ClientRMI();
			subunternehmen = client.getAllSubunternehmen();
			assertTrue(subunternehmen.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Subunternehmen");
		}
	}

	@Test
	public void getProjektproSubunternehmenTest() {
		try {
			ClientRMI client = new ClientRMI();
			anzProjekte = client.getProjektproSubunternehmen(80);
			System.out.println(anzProjekte);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find ProjektproSubunternehmen");
		}
	}

	@Test
	public void getAllMangelTest() {
		try {
			ClientRMI client = new ClientRMI();
			maengel = client.getAllMangel();
			assertTrue(maengel.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Subunternehmen");
		}
	}

	@Test
	public void getAllMeldungTest() {
		try {
			ClientRMI client = new ClientRMI();
			meldung = client.getAllMeldung();
			assertTrue(meldung.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Meldung");
		}
	}

	@Test
	public void getProjektByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekt = client.getProjektById(109);
			assertTrue(projekt.getId().equals(109));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by ID");
		}
	}

	@Test
	public void getSubunternehmenByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			subunternehmennr = client.getSubunternehmenById(74);
			assertTrue(subunternehmennr.getId().equals(74));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Subunternehme by ID");
		}
	}

	@Test
	public void getMeldungByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			meldungnr = client.getMeldungById(141);
			assertTrue(meldungnr.getId().equals(141));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Meldung by ID");
		}
	}

	@Test
	public void getAllPersonTest() {
		try {
			ClientRMI client = new ClientRMI();
			person = client.getAllPerson();
			assertTrue(person.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Person");
		}
	}

	@Test
	public void updateSubunternehmenTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updateSubunternehmen(client.getSubunternehmenById(74));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Subunternehmen");
		}
	}

	@Test
	public void getProjektByBezeichnungTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekt = client.getAllProjekt().get(1);
			projekte = client.getProjektByBezeichnung(projekt.getBezeichnung());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Bezeichnung");
		}
	}

	@Test
	public void getAllPlzTest() {
		try {
			ClientRMI client = new ClientRMI();
			plz = client.getAllPlz();
			assertTrue(plz.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find PLZ");
		}
	}

	@Test
	public void getProjektByBauherrTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByBauherr(client.getAllProjekt().get(0)
					.getFkBauherr().get(0).getNachname().toString());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Bauherr");
		}
	}

	@Test
	public void getProjektByPlzTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByPlz(client.getAllProjekt().get(0)
					.getFkAdresse().getPlz().getPlz().toString());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Plz");
		}
	}

	@Test
	public void getProjektByOrtTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByOrt(client.getAllProjekt().get(0)
					.getFkAdresse().getPlz().getOrt());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Ort");
		}
	}

	@Test
	public void getPlzByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			plznr = client.getPlzById(client.getAllProjekt().get(0).getId());
			System.out.println(plznr);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Plz by Id");
		}
	}

	@Test
	public void getProjektByObjekttypTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByObjekttyp(client.getAllProjekt()
					.get(2).getFkObjekttyp().getBezeichnung());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Objekttyp");
		}
	}

	@Test
	public void getProjektByArbeitstypTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByArbeitstyp(client.getAllProjekt()
					.get(0).getFkArbeitstyp().getBezeichnung());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Arbeitstyp");
		}
	}

	@Test
	public void getProjektByProjektstatusTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektByProjektstatus(client.getAllProjekt()
					.get(2).getFkProjektstatus().getBezeichnung());
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Projektstatus");
		}
	}

	@Test
	public void addAdresseTest() {
		try {
			ClientRMI client = new ClientRMI();
			Adresse test = new Adresse("RMI Strasse", client.getAllPlz()
					.get(50));
			client.addAdresse(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add Adresse");
		}
	}

	@Test
	public void addSubunternehmenTest() {
		try {
			ClientRMI client = new ClientRMI();

			Subunternehmen test = new Subunternehmen(client.getAllBauherr()
					.get(3).getFkAdresse(), "RMI Unternehmen", "0418332938");
			client.addSubunternehmen(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add Subunternehmen");
		}
	}

	@Test
	public void getAllSubunternehmenProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			suprojekte = client.getAllSubunternehmenProjekt(client
					.getAllSubunternehmen().get(0).getId());
			assertTrue(suprojekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Subunternehmenprojekte");
		}
	}

	@Test
	public void getAllSubunternehmenMitarbeiterTest() {
		try {
			ClientRMI client = new ClientRMI();
			sumitarbeiter = client.getAllSubunternehmenMitarbeiter(client
					.getAllSubunternehmen().get(0));
			assertTrue(sumitarbeiter.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Subunternehmenmitarbeiter");
		}
	}

	@Test
	public void getAllObjekttypTest() {
		try {
			ClientRMI client = new ClientRMI();
			objekttyp = client.getAllObjekttyp();
			assertTrue(objekttyp.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Objekttyp");
		}
	}

	@Test
	public void getAllArbeitstypTest() {
		try {
			ClientRMI client = new ClientRMI();
			arbeitstyp = client.getAllArbeitstyp();
			assertTrue(arbeitstyp.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find  Arbeitstyp");
		}
	}

	@Test
	public void getAllMangelProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			mangelOfProjekt = client.getAllMangelProjekt(client.getAllProjekt()
					.get(0).getId());
			assertTrue(mangelOfProjekt.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find  MangelOfProjekt");
		}
	}

	@Test
	public void getMangelByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			mangelnr = client.getMangelById(client.getAllMangel().get(0)
					.getId());
			System.out.println(mangelnr);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find  MangelOfProjekt");
		}
	}

	@Test
	public void updateMangelTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updateMangel(client.getMangelById(client.getAllMangel()
					.get(0).getId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Mangel");
		}
	}

	@Test
	public void getAllMangelStatusTest() {
		try {
			ClientRMI client = new ClientRMI();
			mangelstatus = client.getAllMangelStatus();
			assertTrue(mangelstatus.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find  AllMangelStatus");
		}
	}

	@Test
	public void addMangelTest() {
		try {
			ClientRMI client = new ClientRMI();
			Mangel test = new Mangel(client.getAllProjekt().get(0), "RMI Test",
					new GregorianCalendar(2015, 5, 05), new GregorianCalendar(
							2015, 06, 01), client.getAllMangelStatus().get(0),
					client.getLoginById(15), "RMI getestet");
			client.addMangel(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add Mangel");
		}
	}

	@Test
	public void getAllMeldungstypTest() {
		try {
			ClientRMI client = new ClientRMI();
			meldungstyp = client.getAllMeldungstyp();
			assertTrue(meldungstyp.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Meldungstyp");
		}
	}

	@Test
	public void addMeldungTest() {
		try {
			ClientRMI client = new ClientRMI();
			Meldung test = new Meldung(client.getAllMangel().get(0), client
					.getAllMeldungstyp().get(0), "RMI Test",
					new GregorianCalendar(2015, 06, 01), false,
					client.getLoginById(15));
			client.addMeldung(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add Meldung");
		}
	}

	@Test
	public void getAllMeldungByMangelTest() {
		try {
			ClientRMI client = new ClientRMI();
			meldungByMangel = client.getAllMeldungByMangel(client
					.getAllMangel().get(3));
			assertTrue(meldungByMangel.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Meldung by Mangel");
		}
	}

	@Test
	public void getUnternehmenByProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			subunternehmen = client.getUnternehmenByProjekt(client
					.getAllProjekt().get(3).getId());
			assertTrue(subunternehmen.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Unternehmen by Projekt");
		}
	}

	@Test
	public void getBauleiterByProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			bauleiter = client.getBauleiterByProjekt(client.getAllProjekt()
					.get(3));
			assertTrue(bauleiter.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Bauleiter by Projekt");
		}
	}

	@Test
	public void getLoginByNameTest() {
		try {
			ClientRMI client = new ClientRMI();
			login = client.getLoginByName("bauleiter");
			assertTrue(login.getId() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Login by Name");
		}
	}

	@Test
	public void getLoginByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			loginnr = client.getLoginById(29);
			assertTrue(loginnr.getId() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Login by ID");
		}
	}

	@Test
	public void updateProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updateProjekt(client.getAllProjekt().get(3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Projekt");
		}
	}

	@Test
	public void addSuMitarbeiterByProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			ProjektSuMitarbeiter test = new ProjektSuMitarbeiter(client
					.getAllProjekt().get(2), client
					.getAllSubunternehmenMitarbeiter(
							client.getAllSubunternehmen().get(0)).get(0),
					new GregorianCalendar(2015, 4, 01), null);
			client.addSuMitarbeiterByProjekt(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add ProjektSuMitarbeiter");
		}
	}

	@Test
	public void getAllBauherrTest() {
		try {
			ClientRMI client = new ClientRMI();
			bauherren = client.getAllBauherr();
			assertTrue(bauherren.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Bauherr");
		}
	}

	@Test
	public void addProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			Projekt test = new Projekt(client.getAllProjekt().get(0)
					.getFkAdresse(), "RMI Test", projekt.getFkBauherr(),
					new GregorianCalendar(2015, 5, 18), new GregorianCalendar(
							2015, 6, 06), client.getAllObjekttyp().get(3),
					client.getAllArbeitstyp().get(1), new GregorianCalendar(
							2015, 6, 06), client.getAllProjektstatus().get(1));
			client.addProjekt(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add Projekt");
		}
	}

	@Test
	public void getAllGuMitarbeiterTest() {
		try {
			ClientRMI client = new ClientRMI();
			guMitarbeiter = client.getAllGuMitarbeiter();
			assertTrue(guMitarbeiter.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all guMitarbeiter");
		}
	}

	@Test
	public void addGuMitarbeiterByProjektTest() {
		try {
			ClientRMI client = new ClientRMI();
			ProjektGuMitarbeiter test = new ProjektGuMitarbeiter(client
					.getAllProjekt().get(2), client.getAllGuMitarbeiter()
					.get(0), new GregorianCalendar(2015, 4, 01), null);
			client.addGuMitarbeiterByProjekt(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add GuMitarbeiter by Projekt");
		}
	}

	@Test
	public void updateProjektGuMitarbeiterTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updateProjektGuMitarbeiter(client.getAllGuMitarbeiter().get(
					0));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Subunternehmen");
		}
	}

	@Test
	public void getAllProjektstatusTest() {
		try {
			ClientRMI client = new ClientRMI();
			projektstatus = client.getAllProjektstatus();
			assertTrue(projektstatus.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Projektstatus");
		}
	}

	@Test
	public void addGuMitarbeiterTest() {
		try {
			ClientRMI client = new ClientRMI();
			GuMitarbeiter test = new GuMitarbeiter("bernand", "baum",
					"0978392929", client.getLoginById(18));
			client.addGuMitarbeiter(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add GuMitarbeiter by Projekt");
		}
	}

	@Test
	public void addSuMitarbeiterTest() {
		try {
			ClientRMI client = new ClientRMI();
			SuMitarbeiter test = new SuMitarbeiter("RMI", "test", "0900203090",
					client.getSubunternehmenById(74), client.getLoginById(18));
			client.addSuMitarbeiter(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add SuMitarbeiter");
		}
	}

	@Test
	public void addBauherrTest() {
		try {
			ClientRMI client = new ClientRMI();
			Adresse adressetest = new Adresse("RMI Strasse 2", client
					.getAllPlz().get(54));
			client.addAdresse(adressetest);
			Bauherr test = new Bauherr("RMI", "Bauherr", "0900393930",
					adressetest);
			client.addBauherr(test);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't add SuMitarbeiter");
		}
	}

	@Test
	public void getAllRolleTest() {
		try {
			ClientRMI client = new ClientRMI();
			rollen = client.getAllRolle();
			assertTrue(rollen.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find all Rollen");
		}
	}

	@Test
	public void getPersonByIdTest() {
		try {
			ClientRMI client = new ClientRMI();
			personnr = client.getPersonById(client.getAllProjekt().get(1)
					.getFkBauherr().get(0).getId());
			assertTrue(personnr == client.getAllProjekt().get(1).getFkBauherr()
					.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Person by ID");
		}
	}

	@Test
	public void getProjektbyPersonTest() {
		try {
			ClientRMI client = new ClientRMI();
			projekte = client.getProjektbyPerson(client.getAllProjekt().get(1)
					.getFkBauherr().get(0));
			assertTrue(projekte.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Person");
		}
	}

	@Test
	public void updatePersonTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updatePerson(client.getAllGuMitarbeiter().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Person");
		}
	}

	@Test
	public void updateMeldungTest() {
		try {
			ClientRMI client = new ClientRMI();
			client.updateMeldung(client.getAllMeldung().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update Meldung");
		}
	}
}
