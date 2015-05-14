package ch.hsluw.mangelmanager.persister;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

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
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Diese Klasse füllt die Datenbank mit Daten.
 * 
 * @version 1.0
 * @author mmont
 *
 */

public class CreateEntityTest {

	/**
	 * Create Lists
	 */
	List<Adresse> listAdresse = null;
	List<Arbeitstyp> listArbeitstyp = null;
	List<Bauherr> listBauherr = null;
	List<Bauherr> listBauherr2 = null;
	List<Bauherr> listBauherr3 = null;
	List<Bauherr> listBauherr4 = null;
	List<Bauherr> listBauherr5 = null;
	List<GuMitarbeiter> listGuMitarbeiter = null;
	List<Login> listLogin = null;
	List<Mangel> listMangel = null;
	List<Mangelstatus> listMangelstatus = null;
	List<Meldung> listMeldung = null;
	List<Meldungstyp> listMeldungstyp = null;
	List<Objekttyp> listObjekttyp = null;
	List<Person> listPerson = null;
	List<Plz> listPlz = null;
	List<Projekt> listProjekt = null;
	List<Projektstatus> listProjektstatus = null;
	List<ProjektGuMitarbeiter> listProjektGuMitarbeiter = null;
	List<ProjektSuMitarbeiter> listProjektSuMitarbeiter = null;
	List<Rolle> listRolle = null;
	List<Subunternehmen> listSubunternehmen = null;
	List<SuMitarbeiter> listSuMitarbeiter = null;

	EntityManager em = null;

	@Test
	public void fillLists() {
		listAdresse = new ArrayList<Adresse>();
		listArbeitstyp = new ArrayList<Arbeitstyp>();
		listBauherr = new ArrayList<Bauherr>();
		listBauherr2 = new ArrayList<Bauherr>();
		listBauherr3 = new ArrayList<Bauherr>();
		listBauherr4 = new ArrayList<Bauherr>();
		listBauherr5 = new ArrayList<Bauherr>();
		listGuMitarbeiter = new ArrayList<GuMitarbeiter>();
		listLogin = new ArrayList<Login>();
		listMangel = new ArrayList<Mangel>();
		listMangelstatus = new ArrayList<Mangelstatus>();
		listMeldung = new ArrayList<Meldung>();
		listMeldungstyp = new ArrayList<Meldungstyp>();
		listObjekttyp = new ArrayList<Objekttyp>();
		listPerson = new ArrayList<Person>();
		listPlz = new ArrayList<Plz>();
		listProjekt = new ArrayList<Projekt>();
		listProjektstatus = new ArrayList<Projektstatus>();
		listProjektGuMitarbeiter = new ArrayList<ProjektGuMitarbeiter>();
		listProjektSuMitarbeiter = new ArrayList<ProjektSuMitarbeiter>();
		listRolle = new ArrayList<Rolle>();
		listSubunternehmen = new ArrayList<Subunternehmen>();
		listSuMitarbeiter = new ArrayList<SuMitarbeiter>();

		/**
		 * Fill Lists
		 */

		/**
		 * fill listPlz from csv
		 */
		try {
			FileReader fileread = new FileReader("Ortschaften.csv");
			CSVParser parser = new CSVParser(fileread, CSVFormat.EXCEL
					.withDelimiter(';').withHeader());
			for (CSVRecord r : parser) {
				listPlz.add(new Plz(Integer.parseInt(r.get("PLZ")), r
						.get("Ortschaftsname")));

			}
			parser.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		listAdresse.add(new Adresse("Baustrasse 1", listPlz.get(2)));
		listAdresse.add(new Adresse("Baustrasse 2", listPlz.get(2)));
		listAdresse.add(new Adresse("Baustrasse 3", listPlz.get(2)));
		listAdresse.add(new Adresse("Baustrasse 4", listPlz.get(2)));
		listAdresse.add(new Adresse("Kirchstrasse 2", listPlz.get(5)));
		listAdresse.add(new Adresse("Riedtli 3", listPlz.get(4)));
		listAdresse.add(new Adresse("Aarauigen 2", listPlz.get(4)));
		listAdresse.add(new Adresse("Hauptstrasse 123", listPlz.get(4)));
		listAdresse.add(new Adresse("Dorfbach 49", listPlz.get(10)));
		listAdresse.add(new Adresse("Waldstrasse 2", listPlz.get(15)));
		listAdresse.add(new Adresse("Kupferbach 3", listPlz.get(250)));
		listAdresse.add(new Adresse("Kupferbach 5", listPlz.get(250)));
		listAdresse.add(new Adresse("Kupferbach 23", listPlz.get(250)));
		listAdresse.add(new Adresse("Weitenberg 20", listPlz.get(340)));
		listAdresse.add(new Adresse("Weitenberg 50", listPlz.get(340)));
		listAdresse.add(new Adresse("Malberg 4", listPlz.get(890)));
		listAdresse.add(new Adresse("Biereberg 4", listPlz.get(432)));
		listAdresse.add(new Adresse("Bergberg 5", listPlz.get(523)));
		listAdresse.add(new Adresse("Seelisberg 3", listPlz.get(514)));
		listAdresse.add(new Adresse("Steinenberg 2", listPlz.get(522)));
		listAdresse.add(new Adresse("Kevin Stadelmannstrasse 40", listPlz
				.get(1)));
		listAdresse
				.add(new Adresse("Stefan Beelerstrasse 23", listPlz.get(25)));

		listArbeitstyp.add(new Arbeitstyp("Umbau"));
		listArbeitstyp.add(new Arbeitstyp("Neubau"));
		listArbeitstyp.add(new Arbeitstyp("Renovation"));
		listArbeitstyp.add(new Arbeitstyp("Teil-Renovation"));

		listBauherr.add(new Bauherr("Josef", "Schmid", "0774440303",
				listAdresse.get(0)));
		listBauherr.add(new Bauherr("Cihan", "Demir", "0779003003", listAdresse
				.get(1)));
		listBauherr2.add(new Bauherr("Mike", "Iten", "0764903838", listAdresse
				.get(2)));
		listBauherr3.add(new Bauherr("Jonas", "Justus", "0902003039",
				listAdresse.get(3)));
		listBauherr3.add(new Bauherr("Bernanrd", "Berg", "0393004039",
				listAdresse.get(4)));
		listBauherr4.add(new Bauherr("Franz", "Tomini", "0498499090",
				listAdresse.get(5)));
		listBauherr5.add(new Bauherr("Kurt", "Kugler", "0498495050",
				listAdresse.get(6)));
		listBauherr5.add(new Bauherr("Kurt", "Kert", "0484891350", listAdresse
				.get(7)));

		listProjektstatus.add(new Projektstatus("Offen"));
		listProjektstatus.add(new Projektstatus("Abgeschlossen"));

		listRolle.add(new Rolle("Sachbearbeiter"));
		listRolle.add(new Rolle("Bauleiter"));
		listRolle.add(new Rolle("Ansprechsperson"));
		listRolle.add(new Rolle("Subunternehmen-Sachbearbeiter"));

		listLogin.add(new Login("sachbearbeiter", "sachbearbeiter",
				"sachbearbeiter@mangel.ch", listRolle.get(0)));
		listLogin.add(new Login("bauleiter", "bauleiter",
				"bauleiter@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("ansprechsperson", "ansprechsperson",
				"ansprechsperson@mangel.ch", listRolle.get(2)));
		listLogin.add(new Login("subunternehmen", "subunternehmen",
				"subunternehmen@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("gumitarbeiter1", "gumitarbeiter1",
				"mitarbeiter@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter2", "gumitarbeiter2",
				"mitarbeiter2@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter3", "gumitarbeiter3",
				"mitarbeiter3@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter4", "gumitarbeiter4",
				"mitarbeiter4@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter5", "gumitarbeiter5",
				"mitarbeiter5@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter6", "gumitarbeiter6",
				"mitarbeiter6@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter7", "gumitarbeiter7",
				"mitarbeiter7@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter8", "gumitarbeiter8",
				"mitarbeiter8@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter9", "gumitarbeiter9",
				"mitarbeiter9@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter10", "gumitarbeiter10",
				"mitarbeiter10@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("gumitarbeiter11", "gumitarbeiter11",
				"mitarbeiter11@mangel.ch", listRolle.get(1)));
		listLogin.add(new Login("Gellhorn", "sumitarbeiter",
				"sumitarbeiter@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter1", "sumitarbeiter1",
				"sumitarbeiter1@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter2", "sumitarbeiter2",
				"sumitarbeiter2@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter3", "sumitarbeiter3",
				"sumitarbeiter3@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter4", "sumitarbeiter4",
				"sumitarbeiter4@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter5", "sumitarbeiter5",
				"sumitarbeiter5@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter6", "sumitarbeiter6",
				"sumitarbeiter6@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter7", "sumitarbeiter7",
				"sumitarbeiter7@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter8", "sumitarbeiter8",
				"sumitarbeiter98@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter9", "sumitarbeiter9",
				"sumitarbeiter10@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter10", "sumitarbeiter10",
				"sumitarbeiter11@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter11", "sumitarbeiter11",
				"sumitarbeiter12@mangel.ch", listRolle.get(3)));
		listLogin.add(new Login("sumitarbeiter12", "sumitarbeiter12",
				"sumitarbeiter13@mangel.ch", listRolle.get(3)));

		listMangelstatus.add(new Mangelstatus("Offen"));
		listMangelstatus.add(new Mangelstatus("Abgeschlossen"));

		listGuMitarbeiter.add(new GuMitarbeiter("von Rotz", "Horst",
				"0493904949", listLogin.get(4)));
		listGuMitarbeiter.add(new GuMitarbeiter("Baum", "Bauberg",
				"0493904529", listLogin.get(5)));
		listGuMitarbeiter.add(new GuMitarbeiter("Berdior", "Megamann",
				"9043034434", listLogin.get(6)));
		listGuMitarbeiter.add(new GuMitarbeiter("Bieber", "Horst",
				"0418393939", listLogin.get(7)));
		listGuMitarbeiter.add(new GuMitarbeiter("Hummel", "Kuchen",
				"8934932304", listLogin.get(8)));
		listGuMitarbeiter.add(new GuMitarbeiter("Rotzer", "Josef",
				"0942384938", listLogin.get(9)));
		listGuMitarbeiter.add(new GuMitarbeiter("Rotzberg", "Josefina",
				"0942384939", listLogin.get(10)));
		listGuMitarbeiter.add(new GuMitarbeiter("von Rotz", "Maria",
				"0942384935", listLogin.get(11)));
		listGuMitarbeiter.add(new GuMitarbeiter("Stadelmann", "Eva",
				"0942384934", listLogin.get(12)));
		listGuMitarbeiter.add(new GuMitarbeiter("Stadelmann", "Angelina",
				"0942384932", listLogin.get(13)));
		listGuMitarbeiter.add(new GuMitarbeiter("Stadelmann", "Kevin",
				"0942384931", listLogin.get(14)));

		listMeldungstyp.add(new Meldungstyp("Information"));
		listMeldungstyp.add(new Meldungstyp("Reklamation"));

		listObjekttyp.add(new Objekttyp("Einfamilienhaus"));
		listObjekttyp.add(new Objekttyp("Mehrfamilienhaus"));
		listObjekttyp.add(new Objekttyp("Garage"));
		listObjekttyp.add(new Objekttyp("Wohnung"));
		listObjekttyp.add(new Objekttyp("Hütte"));
		listObjekttyp.add(new Objekttyp("Untergrund"));
		listObjekttyp.add(new Objekttyp("Industriegebäude"));

		listProjekt.add(new Projekt(listAdresse.get(8), "Projekt Alpha",
				listBauherr, new GregorianCalendar(2015, 4, 14),
				new GregorianCalendar(2015, 6, 06), listObjekttyp.get(0),
				listArbeitstyp.get(1), new GregorianCalendar(2015, 6, 06),
				listProjektstatus.get(1)));
		listProjekt.add(new Projekt(listAdresse.get(8), "Projekt Beta",
				listBauherr2, new GregorianCalendar(2015, 4, 01), null,
				listObjekttyp.get(2), listArbeitstyp.get(0),
				new GregorianCalendar(2015, 7, 06), listProjektstatus.get(0)));
		listProjekt.add(new Projekt(listAdresse.get(10), "Projekt Gamma",
				listBauherr3, new GregorianCalendar(2015, 4, 30), null,
				listObjekttyp.get(3), listArbeitstyp.get(1),
				new GregorianCalendar(2015, 7, 15), listProjektstatus.get(0)));
		listProjekt.add(new Projekt(listAdresse.get(11), "Projekt Delta",
				listBauherr4, new GregorianCalendar(2015, 1, 01), null,
				listObjekttyp.get(4), listArbeitstyp.get(3),
				new GregorianCalendar(2015, 7, 25), listProjektstatus.get(0)));
		listProjekt.add(new Projekt(listAdresse.get(12), "Proejkt OMEGA",
				listBauherr5, new GregorianCalendar(2014, 4, 01), null,
				listObjekttyp.get(5), listArbeitstyp.get(0),
				new GregorianCalendar(2015, 7, 20), listProjektstatus.get(0)));
		listProjekt.add(new Projekt(listAdresse.get(13), "Projekt 9/11",
				listBauherr, new GregorianCalendar(2015, 9, 11), null,
				listObjekttyp.get(2), listArbeitstyp.get(2),
				new GregorianCalendar(2015, 3, 30), listProjektstatus.get(0)));

		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(0), listGuMitarbeiter.get(0), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 6, 06)));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(0), listGuMitarbeiter.get(1), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 6, 06)));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(0), listGuMitarbeiter.get(2), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 6, 06)));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(0), listGuMitarbeiter.get(8), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 6, 06)));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(0), listGuMitarbeiter.get(9), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 6, 06)));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(1), listGuMitarbeiter.get(3), new GregorianCalendar(2015,
				7, 06), null));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(2), listGuMitarbeiter.get(4), new GregorianCalendar(2015,
				7, 15), null));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(3), listGuMitarbeiter.get(5), new GregorianCalendar(2015,
				7, 25), null));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(4), listGuMitarbeiter.get(6), new GregorianCalendar(2015,
				7, 20), null));
		listProjektGuMitarbeiter.add(new ProjektGuMitarbeiter(listProjekt
				.get(5), listGuMitarbeiter.get(7), new GregorianCalendar(2015,
				3, 30), null));

		listSubunternehmen.add(new Subunternehmen(listAdresse.get(14),
				"Janik von Rotz GmbH", "09006665544"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(15),
				"Bosch AG", "09006663344"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(16),
				"Mangel AG", "09006662244"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(17),
				"Unternehmen AG", "09006661144"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(18),
				"Ultra Mangel AG", "09005565544"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(19),
				"Destructoid GmbH", "09003465544"));
		listSubunternehmen.add(new Subunternehmen(listAdresse.get(20),
				"Zod AG", "09002265544"));

		listSuMitarbeiter.add(new SuMitarbeiter("von Gellhorn", "Max",
				"09003042030", listSubunternehmen.get(0), listLogin.get(16)));
		listSuMitarbeiter.add(new SuMitarbeiter("Rotzi", "Janik", "0418304234",
				listSubunternehmen.get(0), listLogin.get(17)));
		listSuMitarbeiter.add(new SuMitarbeiter("Kündig", "Michael",
				"0418305555", listSubunternehmen.get(5), listLogin.get(18)));
		listSuMitarbeiter.add(new SuMitarbeiter("Ritz", "Notter", "0418334234",
				listSubunternehmen.get(4), listLogin.get(19)));
		listSuMitarbeiter.add(new SuMitarbeiter("Bekcic", "Momo", "0418305234",
				listSubunternehmen.get(0), listLogin.get(20)));
		listSuMitarbeiter.add(new SuMitarbeiter("Beeler", "Stefan",
				"09003042030", listSubunternehmen.get(1), listLogin.get(21)));
		listSuMitarbeiter.add(new SuMitarbeiter("Beeler", "Stefan",
				"09003042030", listSubunternehmen.get(1), listLogin.get(22)));
		listSuMitarbeiter.add(new SuMitarbeiter("Beeler", "Stefan",
				"09003042030", listSubunternehmen.get(2), listLogin.get(23)));
		listSuMitarbeiter.add(new SuMitarbeiter("Beeler", "Stefan",
				"09003042030", listSubunternehmen.get(3), listLogin.get(24)));
		listSuMitarbeiter.add(new SuMitarbeiter("Beeler", "Stefan",
				"09003042030", listSubunternehmen.get(0), listLogin.get(25)));
		listSuMitarbeiter.add(new SuMitarbeiter("Berger", "Stefan",
				"09003042030", listSubunternehmen.get(6), listLogin.get(15)));

		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(0), listSuMitarbeiter.get(0), new GregorianCalendar(2015,
				4, 14), new GregorianCalendar(2015, 5, 06)));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(0), listSuMitarbeiter.get(1), new GregorianCalendar(2015,
				4, 14), null));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(1), listSuMitarbeiter.get(2), new GregorianCalendar(2015,
				4, 01), null));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(2), listSuMitarbeiter.get(3), new GregorianCalendar(2015,
				4, 30), null));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(3), listSuMitarbeiter.get(4), new GregorianCalendar(2015,
				1, 01), null));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(4), listSuMitarbeiter.get(5), new GregorianCalendar(2014,
				4, 01), null));
		listProjektSuMitarbeiter.add(new ProjektSuMitarbeiter(listProjekt
				.get(5), listSuMitarbeiter.get(6), new GregorianCalendar(2015,
				9, 11), null));

		listMangel.add(new Mangel(listProjekt.get(0), "Alpha",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(15), "Dachrinne verstopft"));
		listMangel.add(new Mangel(listProjekt.get(0), "Beta",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(15), "Dachrinne abgefallen"));
		listMangel.add(new Mangel(listProjekt.get(0), "Rotz",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(15), "Wand eingestürtzt"));
		listMangel.add(new Mangel(listProjekt.get(0), "Beeler",
				new GregorianCalendar(2015, 5, 05), new GregorianCalendar(2015,
						05, 15), new GregorianCalendar(2015, 06, 01),
				listMangelstatus.get(1), listLogin.get(15),
				"Staubsauger verstopft"));
		listMangel
				.add(new Mangel(listProjekt.get(0), "Bekcic",
						new GregorianCalendar(2015, 5, 05),
						new GregorianCalendar(2015, 05, 15),
						new GregorianCalendar(2015, 06, 01), listMangelstatus
								.get(1), listLogin.get(15), "Ventilator kaputt"));
		listMangel.add(new Mangel(listProjekt.get(1), "Lothar",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(16), "Hier könnte ihre Werbung stehen"));
		listMangel.add(new Mangel(listProjekt.get(2), "Demogramma",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(17), "Hier könnte ihre Werbung stehen"));
		listMangel.add(new Mangel(listProjekt.get(3), "Demogrummu",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(18), "Hier könnte ihre Werbung stehen"));
		listMangel.add(new Mangel(listProjekt.get(4), "Projektproblem1",
				new GregorianCalendar(2015, 5, 05), null,
				new GregorianCalendar(2015, 06, 01), listMangelstatus.get(0),
				listLogin.get(19), "Hier könnte ihre Werbung stehen"));

		listMeldung.add(new Meldung(listMangel.get(0), listMeldungstyp.get(1),
				"Bitte schnell beheben", new GregorianCalendar(2015, 5, 05),
				false, listLogin.get(15)));
		listMeldung.add(new Meldung(listMangel.get(1), listMeldungstyp.get(0),
				"Besorge eine neue Dachrinne", new GregorianCalendar(2015, 5,
						05), false, listLogin.get(15)));
		listMeldung.add(new Meldung(listMangel.get(2), listMeldungstyp.get(1),
				"Es zieht", new GregorianCalendar(2015, 5, 05), false,
				listLogin.get(15)));
		listMeldung.add(new Meldung(listMangel.get(3), listMeldungstyp.get(0),
				"Krieg ihn nicht mehr raus",
				new GregorianCalendar(2015, 5, 05), true, listLogin.get(15)));
		listMeldung.add(new Meldung(listMangel.get(4), listMeldungstyp.get(1),
				"Es ist zu heiss!!!", new GregorianCalendar(2015, 5, 05), true,
				listLogin.get(15)));

		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
		for (Rolle rolle : listRolle) {
			em.persist(rolle);
		}
		for (Login login : listLogin) {
			em.persist(login);
		}
		for (Mangelstatus mangelstatus : listMangelstatus) {
			em.persist(mangelstatus);
		}
		for (Meldungstyp meldungstyp : listMeldungstyp) {
			em.persist(meldungstyp);
		}
		for (Plz plz : listPlz) {
			em.persist(plz);
		}
		for (Adresse adresse : listAdresse) {
			em.persist(adresse);
		}
		for (Arbeitstyp arbeitstyp : listArbeitstyp) {
			em.persist(arbeitstyp);
		}
		for (Objekttyp objekttyp : listObjekttyp) {
			em.persist(objekttyp);
		}
		for (Projektstatus projektstatus : listProjektstatus) {
			em.persist(projektstatus);
		}
		for (Bauherr bauherr : listBauherr) {
			em.persist(bauherr);
		}
		for (Subunternehmen subunternehmen : listSubunternehmen) {
			em.persist(subunternehmen);
		}
		for (SuMitarbeiter sumitarbeiter : listSuMitarbeiter) {
			em.persist(sumitarbeiter);
		}
		for (GuMitarbeiter guMitarbeiter : listGuMitarbeiter) {
			em.persist(guMitarbeiter);
		}
		for (Person person : listPerson) {
			em.persist(person);
		}
		for (Projekt projekt : listProjekt) {
			em.persist(projekt);
		}
		for (ProjektGuMitarbeiter projektGuMitarbeiter : listProjektGuMitarbeiter) {
			em.persist(projektGuMitarbeiter);
		}

		for (ProjektSuMitarbeiter projektSuMitarbeiter : listProjektSuMitarbeiter) {
			em.persist(projektSuMitarbeiter);
		}

		for (Mangel mangel : listMangel) {
			em.persist(mangel);
		}

		for (Meldung meldung : listMeldung) {
			em.persist(meldung);
		}

		em.getTransaction().commit();
	}

}
