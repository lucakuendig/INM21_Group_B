/*
 * ZWECK: Referenzprojekt
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Tim Burkhard - April 2015
 */
package ch.hsluw.mangelmanager.client.intern;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;


import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektRO;



/**
 * Diese Klasse stellt das Userinterface fuer die Modulverwaltung via RMI zur
 * Verfuegung
 * 
 * @version 1.0
 * @author sritz
 *
 */
public class ClientRMI {

	private static Logger logger = Logger.getLogger(ClientRMI.class);
	ProjektRO projektRO;


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
		String projektROName = "projektRO";

		this.projektRO = (ProjektRO) Naming.lookup(url + projektROName);

		Adresse a1 = new Adresse("Furkastrasse", new Plz(3984, "Fieschertal"));
		Adresse a = new Adresse("Haus 12", new Plz(3984, "Fieschertal"));
		Bauherr b = new Bauherr("Schmid", "Hans", "027 971 40 24", a);
		Projektstatus ps = new Projektstatus("offen");
		Arbeitstyp at = new Arbeitstyp("Neubau");
		Objekttyp ot = new Objekttyp("Block");
		
		List<Bauherr> bauherren = new ArrayList<Bauherr>();		
		bauherren.add(b);
	
		
		Projekt projekt2 = new Projekt(a, "Neubau Haus Romantica 2", bauherren, new GregorianCalendar(2015, 4, 16),  
				new GregorianCalendar(2015, 4, 20),ot, at,  new GregorianCalendar(2015, 4, 20), ps);
		
		
		
		
		try {
			projektRO.add(projekt2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Projekt> romatikaProjekt = projektRO.findByBezeichnung("Neubau Haus Romantica 2");
		System.out.println(romatikaProjekt.get(0).getFkProjektstatus().getBezeichnung());
		
		List<Projekt> offeneProjekte = projektRO.findByProjektstatus("offen");
		System.out.println(offeneProjekte.get(0).getBezeichnung());
		
		List<Projekt> projekteInFiesch = projektRO.findByOrt("Fieschertal");
		System.out.println(projekteInFiesch.get(0).getBezeichnung());
		
		List<Projekt> projektByBauherr = projektRO.findByBauherr("Schmid");
		System.out.println(projektByBauherr.get(0).getFkBauherr().get(0).getNachname());
		
	}
	
	


}


