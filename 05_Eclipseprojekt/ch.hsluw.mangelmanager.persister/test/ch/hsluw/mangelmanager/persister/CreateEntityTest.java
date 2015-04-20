package ch.hsluw.mangelmanager.persister;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;


import org.junit.Test;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

public class CreateEntityTest {

	
	@Test
	public void test() {
		
		
		EntityManager em =JpaUtil.createEntityManager();
		
		Plz plz1 = new Plz(3984, "Fiesch");
		Adresse adresse1 = new Adresse("Cheera 13", plz1);
		
		Plz plz2 = new Plz(3930, "Visp");
		Adresse adresse2 = new Adresse("H�rpfelstrasse 12", plz2);
		
		Bauherr bauherr1 = new Bauherr("Schmid", "Josef", "0278744545" ,adresse2);
		List<Bauherr> bauherren = new ArrayList<Bauherr>();
		bauherren.add(bauherr1);
		
		Arbeitstyp arbeitstyp1 = new Arbeitstyp("Umbau");
		Projektstatus projektstatus1 = new Projektstatus("abgeschlossen");
		
		Projekt projekt1 = new Projekt(adresse1, "Umbau H�tte auf der Fieschalp", bauherren,  new GregorianCalendar(2015, 6, 06), new GregorianCalendar(2015, 7, 06),
				new Objekttyp("Alph�tte"), arbeitstyp1, new GregorianCalendar(2015, 8, 10), projektstatus1);
				
		
		em.getTransaction().begin();
		em.persist(projekt1);
		em.getTransaction().commit();
	}

}
