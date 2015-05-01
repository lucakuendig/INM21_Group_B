package ch.hsluw.mangelmanager.persister;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

import javafx.scene.control.Tab;

import javax.persistence.EntityManager;











import org.junit.Test;

import ch.hsluw.mangelmanager.helper.TemporalDateTyp;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

public class CreateEntityTest {

	
	@Test
	public void test() {
		
		
		EntityManager em =JpaUtil.createEntityManager();
		
		Plz plz1 = new Plz(3984, "Fiesch");
		Adresse adresse1 = new Adresse("Cheera 13", plz1);
		
		Plz plz2 = new Plz(3930, "Visp");
		Adresse adresse2 = new Adresse("Härpfelstrasse 12", plz2);
		
		Bauherr bauherr1 = new Bauherr("Schmid", "Josef", "0278744545" ,adresse2);
		List<Bauherr> bauherren = new ArrayList<Bauherr>();
		bauherren.add(bauherr1);
		
		Arbeitstyp arbeitstyp1 = new Arbeitstyp("Umbau");
		Projektstatus projektstatus1 = new Projektstatus("abgeschlossen");
		
		Projekt projekt1 = new Projekt(adresse1, "sdasdasd", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
		Projekt projekt2 = new Projekt(adresse1, "Umbau Hütte auf Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
		Projekt projekt3 = new Projekt(adresse1, "Umbau Hütte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 11, 10), projektstatus1);
		Projekt projekt4 = new Projekt(adresse1, "Umbau Hütte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 8, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
		Projekt projekt5 = new Projekt(adresse1, "Umbau Hütte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 10, 10), projektstatus1);
		Projekt projekt6 = new Projekt(adresse1, "Umbau Hütte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
		Projekt projekt7 = new Projekt(adresse1, "Umbau Hütte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alphütte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
		Subunternehmen su1 = new Subunternehmen(adresse2, "ddduuud", "daahahah");
		Subunternehmen su2 = new Subunternehmen(adresse2, "ddduussssssud", "ddddddaahahah");
		Login login = new Login("sandro", "1234", "sandroritz@ewcom.ch", new Rolle("admin"));
		
		Mangel mangel1 = new Mangel(projekt1, "Mangel 1", new GregorianCalendar(2015,8,06), new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015,6,06), new Mangelstatus("offen"), login, "Es liegt ein Mangel vor");

	
				
		
		em.getTransaction().begin();
	
		em.persist(projekt1);
		em.persist(projekt2);
		em.persist(projekt3);
		em.persist(projekt4);
		em.persist(projekt5);
		em.persist(projekt6);
		em.persist(projekt7);
		em.persist(su1);
		em.persist(su2);
		em.persist(mangel1);

		em.getTransaction().commit();
	}

}
