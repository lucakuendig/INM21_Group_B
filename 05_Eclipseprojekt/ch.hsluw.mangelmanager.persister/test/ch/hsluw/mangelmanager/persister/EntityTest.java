package ch.hsluw.mangelmanager.persister;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

import javax.persistence.RollbackException;

import org.junit.Test;
import org.eclipse.persistence.exceptions.DatabaseException;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.persister.dao.adresse.AdresseDAO;
import ch.hsluw.mangelmanager.persister.dao.adresse.AdresseDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAO;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAO;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAO;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.plz.PlzDAO;
import ch.hsluw.mangelmanager.persister.dao.plz.PlzDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.projekt.ProjektDAO;
import ch.hsluw.mangelmanager.persister.dao.projekt.ProjektDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.projektstatus.ProjektstatusDAO;
import ch.hsluw.mangelmanager.persister.dao.projektstatus.ProjektstatusDAOImpl;

/**
 * Diese Klasse testet die Methoden von ProjektDAO und ProjektDAOImpl
 * 
 * @version 1.0
 * @author mmont
 *
 */

public class EntityTest {
	/**
	 * Tests if Adressen are updateable
	 */
	@Test
	public void adressenUpdateTest() {
		try {
			AdresseDAO adressen = new AdresseDAOImpl();
			List<Adresse> listAdresse = adressen.findAllAdresse();
			Adresse adresse = listAdresse.get(listAdresse.size() - 1);
			adresse.setStrasse("testStrasse");
			adressen.update(adresse);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update AdressStrasse");
		}
	}
	/**
	 * Tests if Projekte are updateable
	 */
	@Test
	public void projektUpdateTest() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			projekt.setBezeichnung("TestName");
			projektdao.update(projekt);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't update ProjektBezeichnung");
		}
	}
	/**
	 * Tests if Projekte & Adressen are addable
	 */
	@Test
	public void projektAdresseSaveTest() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			PlzDAO plzdao = new PlzDAOImpl();
			List<Plz> listPlz = plzdao.findAllPlz();

			BauherrDAO bauherrdao = new BauherrDAOImpl();
			List<Bauherr> listBauherr = bauherrdao.findAllBauherr();

			ProjektstatusDAO projektstatusdao = new ProjektstatusDAOImpl();
			List<Projektstatus> listProjektstatus = projektstatusdao
					.findAllProjektstatus();

			ObjekttypDAO objekttypdao = new ObjekttypDAOImpl();
			List<Objekttyp> listObjekttyp = objekttypdao.findAllObjekttyp();

			ArbeitstypDAO arbeitstypdao = new ArbeitstypDAOImpl();
			List<Arbeitstyp> listArbeitstyp = arbeitstypdao.findAllArbeitstyp();

			AdresseDAO adressdao = new AdresseDAOImpl();
			Adresse adresse = new Adresse("Test Strasse 12", listPlz.get(99));
			adressdao.save(adresse);

			Projekt projekt = new Projekt(adresse, "Projekt Test", listBauherr,
					new GregorianCalendar(2014, 4, 01), null,
					listObjekttyp.get(5), listArbeitstyp.get(0),
					new GregorianCalendar(2015, 4, 20),
					listProjektstatus.get(0));

			projektdao.save(projekt);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't save Projekt / Adresse");
		}
	}

	/**
	 * Test if Projekte are delete able and expects an RollbackException
	 * 
	 * @throws Exception
	 */

	@Test(expected = RollbackException.class)
	public void deleteProjekt() throws Exception {
		ProjektDAO projektdao = new ProjektDAOImpl();
		List<Projekt> listProjekt = projektdao.findAllProjekt();
		Projekt projekt = listProjekt.get(listProjekt.size() - 1);
		projektdao.delete(projekt);
	}

	/**
	 * Test if Projekte are deleteable by ID and throws a DtabaseException
	 * 
	 * @throws Exception
	 */
	@Test(expected = DatabaseException.class)
	public void deleteProjektById() throws Exception {
		ProjektDAO projektdao = new ProjektDAOImpl();
		projektdao.deleteProjektById(109);

	}

	/**
	 * Test if Projekte are findable by ID
	 */
	@Test
	public void findProjektById() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			System.out
					.println(projektdao.findProjektById(109).getBezeichnung());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by ID");
		}
	}
	/**
	 * Tests if Projekte are findable by Bezeichnung
	 */
	@Test
	public void findProjektByBezeichnung() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			assertTrue(projektdao.findProjektByBezeichnung("Projekt Alpha")
					.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Bezeichnung");
		}
	}
	/**
	 * Tests if Projekte are findable by Projektstatus
	 */
	@Test
	public void findProjektByProjektstatus() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			assertTrue(projektdao.findProjektByProjektstatus("Abgeschlossen")
					.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Projektstatus");
		}
	}
	/**
	 * Tests if Projekte are findable by Ort
	 */
	@Test
	public void findProjektByOrt() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			assertTrue(projektdao.findProjektByOrt(
					projekt.getFkAdresse().getPlz().getOrt()).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Ort");
		}
	}
	/**
	 * Tests if Projekte are findable by Plz
	 */
	@Test
	public void findProjektByPlz() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			assertTrue(projektdao.findProjektByPlz(
					projekt.getFkAdresse().getPlz().getPlz().toString()).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Plz");
		}
	}
	/**
	 * Tests if Projekte are findable by Bauherr
	 */
	@Test
	public void findProjektByBauherr() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			assertTrue(projektdao.findProjektByBauherr(
					projekt.getFkBauherr().get(0).getNachname()).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Bauherr");
		}
	}
	/**
	 * Tests if Projekte are findable by Objekttyp
	 */
	@Test
	public void findProjektByObjekttyp() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			assertTrue(projektdao.findProjektByObjekttyp(
					projekt.getFkObjekttyp().getBezeichnung()).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Objekttyp");
		}
	}

	/**
	 * Test if Projekte are findable by Arbeitstyp
	 */
	@Test
	public void findProjektByArbeitstyp() {
		try {
			ProjektDAO projektdao = new ProjektDAOImpl();
			List<Projekt> listProjekt = projektdao.findAllProjekt();
			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
			assertTrue(projektdao.findProjektByArbeitstyp(
					projekt.getFkArbeitstyp().getBezeichnung()).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Couldn't find Projekt by Arbeitstyp");
		}
	}
///**
// * Tests if Projekte are findable by Subunternehmen
// */
//	@Test
//	public void findProjekByfindAllSubunternehmenProjekt() {
//		try {
//			ProjektDAO projektdao = new ProjektDAOImpl();
//			List<Projekt> listProjekt = projektdao.findAllProjekt();
//			Projekt projekt = listProjekt.get(listProjekt.size() - 1);
//			assertTrue(projektdao.findAllSubunternehmenProjekt(
//					projekt.getFkProjektSuMitarbeiter().get(0)
//							.getFkMitarbeiter().getFkSubunternehmen()).size() > 0);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Couldn't find Projekt by findAllSubunternehmenProjekt");
//		}
//	}

}
