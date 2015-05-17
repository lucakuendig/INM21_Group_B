/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projekt;

import java.util.List;

import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Projekt;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ProjektManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt add(Projekt entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projekt entity) throws Exception;
	
	/**
	 * Löscht die Entity mit übergebener Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Projekt findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<Projekt> findAll();
	
	/**
	 * Liefert die Liste mit Projekten für die übergebene Bezeichnung zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	List<Projekt> findByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Projektstatus zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param projektstatus
	 * @return
	 */
	List<Projekt> findByProjektstatus(String projektstatus);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Ort zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	List<Projekt> findByOrt(String ort);
	
	/**
	 * Liefert die Liste mit Projekten für die übergebene Plz zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param plz
	 * @return
	 */
	List<Projekt> findByPlz(String plz);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Bauherren zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bauherr
	 * @return
	 */
	List<Projekt> findByBauherr(String bauherr);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Objekttyp zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param objekttyp
	 * @return
	 */
	List<Projekt> findByObjekttyp(String objekttyp);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Arbeitstyp zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param arbeitstyp
	 * @return
	 */
	List<Projekt> findByArbeitstyp(String arbeitstyp);
	

	List<Projekt> findAllSubunternehmenProjekt(Integer subunternehmen2);

	List<Projekt> findProjektbyPerson(Person person);


	
}

