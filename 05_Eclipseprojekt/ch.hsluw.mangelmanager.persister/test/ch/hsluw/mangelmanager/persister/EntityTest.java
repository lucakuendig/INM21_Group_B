package ch.hsluw.mangelmanager.persister;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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
import ch.hsluw.mangelmanager.persister.dao.adresse.AdresseDAO;
import ch.hsluw.mangelmanager.persister.dao.adresse.AdresseDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAO;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAO;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.login.LoginDAO;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAO;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.plz.PlzDAO;
import ch.hsluw.mangelmanager.persister.dao.plz.PlzDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.projekt.ProjektDAO;
import ch.hsluw.mangelmanager.persister.dao.projekt.ProjektDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.projektstatus.ProjektstatusDAO;
import ch.hsluw.mangelmanager.persister.dao.projektstatus.ProjektstatusDAOImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

public class EntityTest {
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

//	@Test
//	public void projektAdresseSaveTest() {
//		try {
//			ProjektDAO projektdao = new ProjektDAOImpl();
//			PlzDAO plzdao = new PlzDAOImpl();
//			List<Plz> listPlz = plzdao.findAllPlz();
//
//			BauherrDAO bauherrdao = new BauherrDAOImpl();
//			List<Bauherr> listBauherr = bauherrdao.findAllBauherr();
//
//			ProjektstatusDAO projektstatusdao = new ProjektstatusDAOImpl();
//			List<Projektstatus> listProjektstatus = projektstatusdao
//					.findAllProjektstatus();
//
//			ObjekttypDAO objekttypdao = new ObjekttypDAOImpl();
//			List<Objekttyp> listObjekttyp = objekttypdao.findAllObjekttyp();
//
//			ArbeitstypDAO arbeitstypdao = new ArbeitstypDAOImpl();
//			List<Arbeitstyp> listArbeitstyp = arbeitstypdao.findAllArbeitstyp();
//
//			AdresseDAO adressdao = new AdresseDAOImpl();
//			Adresse adresse = new Adresse("Test Strasse 12", listPlz.get(99));
//			adressdao.save(adresse);
//			
//		Projekt projekt = new Projekt(adresse, "Projekt Test",
//					listBauherr, new GregorianCalendar(2014, 4, 01), null,
//					listObjekttyp.get(5), listArbeitstyp.get(0),
//					new GregorianCalendar(2015, 4, 20),
//					listProjektstatus.get(0));
//
//			projektdao.save(projekt); 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Couldn't save Projekt / Adresse");
//		}
//	}
	/**
	 * Test if Projekts are delete able
	 */

	@Test(expected=AssertionError.class)
		public void deleteProjekt() {
		try	{
				ProjektDAO projektdao = new ProjektDAOImpl();
				List<Projekt> listProjekt = projektdao.findAllProjekt();
				Projekt projekt = listProjekt.get(listProjekt.size() - 1);
				projektdao.delete(projekt);
			} catch (Exception e) {
				e.printStackTrace();
				fail("Couldn't delete Projekt");
			}
			}
	/**
	 * Test if Projekts are delete able
	 */
		@Test(expected=AssertionError.class)
		public void deleteProjektById() {
		try	{
				ProjektDAO projektdao = new ProjektDAOImpl();
				projektdao.deleteProjektById(109);
			} catch (Exception e) {
				e.printStackTrace();
				fail("Couldn't delete Projekt");
			}
	}
		/**
		 * Test if Projekte are findable by ID
		 */
		@Test
		public void findProjektById() {
		try	{
				ProjektDAO projektdao = new ProjektDAOImpl();
				System.out.println(projektdao.findProjektById(109).getBezeichnung());
			} catch (Exception e) {
				e.printStackTrace();
				fail("Couldn't find Projekt by ID");
			}
			}
		@Test
		public void findProjektByArbeitstyp() {
		try	{
			ArbeitstypDAO arbeitstypdao = new ArbeitstypDAOImpl();
			List<Arbeitstyp> listArbeitstyp = arbeitstypdao.findAllArbeitstyp();
			Arbeitstyp arbeitstyp = listArbeitstyp.get(listArbeitstyp.size() - 1);
				ProjektDAO projektdao = new ProjektDAOImpl();
				System.out.println(projektdao.findProjektByArbeitstyp("Umbau").size());
			} catch (Exception e) {
				e.printStackTrace();
				fail("Couldn't find Projekt by Arbeitstyp");
			}
			}
}

