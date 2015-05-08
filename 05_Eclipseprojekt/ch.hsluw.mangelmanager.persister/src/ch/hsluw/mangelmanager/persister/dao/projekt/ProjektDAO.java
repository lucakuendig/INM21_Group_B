package ch.hsluw.mangelmanager.persister.dao.projekt;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ProjektDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Projekt entity) throws Exception;

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
	
	void deleteProjektById(Integer id) throws Exception;

	/**
	 * Liefert die Projekt-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Projekt findProjektById(Integer id);

	/**
	 * Liefert alle Projekt-Objekte zurück.
	 * 
	 * @return
	 */
	List<Projekt> findAllProjekt();
	
	/**
	 * Liefert die Liste mit Projekten für die übergebene Bezeichnung zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Projekt> findProjektByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Projektstatus zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param projektstatus
	 * @return
	 */
	public List<Projekt> findProjektByProjektstatus(String projektstatus);
	
	/**
	 * Liefert die Liste mit Projekten für dem übergebenen Ort zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Projekt> findProjektByOrt(String ort);
	
	/**
	 * Liefert die Liste mit Projekten für dem übergebenen Plz zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param plz
	 * @return
	 */
	public List<Projekt> findProjektByPlz(String plz);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Bauherren zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bauherr
	 * @return
	 */
	public List<Projekt> findProjektByBauherr(String bauherr);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Objekttyp zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param objekttyp
	 * @return
	 */
	public List<Projekt> findProjektByObjekttyp(String objekttyp);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Arbeitstyp zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param arbeitstyp
	 * @return
	 */
	public List<Projekt> findProjektByArbeitstyp(String arbeitstyp);
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Zeitrahmen.
	 * 
	 * @param fromDatum
	 * @param endDatum
	 * @return
	 */
	public List<Projekt> findProjektByDatumFromTillEnd(Date fromDatum, Date endDatum);

	List<Projekt> findAllSubunternehmenProjekt(Subunternehmen subunternehmen);
}
