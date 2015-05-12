/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projektgumitarbeiter;

import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;


/**
 * Interface fuer ProjektGuMitarbeiterGuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface ProjektGuMitarbeiterManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektGuMitarbeiter add(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektGuMitarbeiter entity) throws Exception;
	
	void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert die Entity für die übergebenen Werte zurück.
	 * 
	 * @param id
	 * @return
	 */
	ProjektGuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) throws Exception;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<ProjektGuMitarbeiter> findAll();

	List<ProjektGuMitarbeiter> findAllBauleiterByProjekt(Projekt projekt2) throws Exception;
}