package ch.hsluw.mangelmanager.persister.dao.projekt;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



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
public interface ProjektDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Projekt entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projekt entity) throws Exception;
	
	void deleteProjektById(Integer id) throws Exception;

	/**
	 * Liefert die Projekt-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Projekt findProjektById(Integer id);

	/**
	 * Liefert alle Projekt-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Projekt> findAllProjekt();
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebene Bezeichnung zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Projekt> findProjektByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Projektstatus zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param projektstatus
	 * @return
	 */
	public List<Projekt> findProjektByProjektstatus(String projektstatus);
	
	/**
	 * Liefert die Liste mit Projekten f�r dem �bergebenen Ort zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Projekt> findProjektByOrt(String ort);
	
	/**
	 * Liefert die Liste mit Projekten f�r dem �bergebenen Plz zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param plz
	 * @return
	 */
	public List<Projekt> findProjektByPlz(String plz);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Bauherren zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bauherr
	 * @return
	 */
	public List<Projekt> findProjektByBauherr(String bauherr);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Objekttyp zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param objekttyp
	 * @return
	 */
	public List<Projekt> findProjektByObjekttyp(String objekttyp);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Arbeitstyp zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param arbeitstyp
	 * @return
	 */
	public List<Projekt> findProjektByArbeitstyp(String arbeitstyp);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Zeitrahmen.
	 * 
	 * @param fromDatum
	 * @param endDatum
	 * @return
	 */

	public List<Projekt> findAllSubunternehmenProjekt(Integer subunternehmen);

	public List<Projekt> findProjektByPerson(Person person);
}
