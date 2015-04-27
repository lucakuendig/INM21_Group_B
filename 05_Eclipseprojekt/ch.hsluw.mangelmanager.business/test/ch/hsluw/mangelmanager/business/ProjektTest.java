package ch.hsluw.mangelmanager.business;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import ch.hsluw.mangelmanager.business.projekt.ProjektManager;
import ch.hsluw.mangelmanager.business.projekt.ProjektManagerImpl;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;


/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektTest {

	@Test
	public void test() {
		Adresse a = new Adresse("Haus 12", new Plz(3984, "Fieschertal"));
		Bauherr b = new Bauherr("Schmid", "Hans", "027 971 40 24", a);
		Projektstatus ps = new Projektstatus("offen");
		Arbeitstyp at = new Arbeitstyp("Neubau");
		Objekttyp ot = new Objekttyp("Block");
		
		List<Bauherr> bauherren = new ArrayList<Bauherr>();
		
		bauherren.add(b);
		
		Projekt projekt2 = new Projekt(a, "Neubau Haus Romantica", bauherren, new GregorianCalendar(2015, 4, 16),  
				new GregorianCalendar(2015, 4, 20),ot, at,  new GregorianCalendar(2015, 4, 20), ps);
		
		ProjektManager pm = new ProjektManagerImpl();
		
		try {
			pm.add(projekt2);
			projekt2.setBezeichnung("Block Romantica");
			pm.update(projekt2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Projekt projekt3 = pm.findById(1);
		System.out.println(projekt3.getBezeichnung());
		
		List<Projekt> projekte = pm.findAll();
		System.out.println(projekte.get(0).getEndDatum().getTime());
	}

}
