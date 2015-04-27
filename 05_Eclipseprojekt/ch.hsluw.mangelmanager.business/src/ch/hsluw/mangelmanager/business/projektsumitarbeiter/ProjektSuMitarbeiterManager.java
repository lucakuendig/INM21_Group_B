/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projektsumitarbeiter;

import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;


/**
 * Interface fuer ProjektSuMitarbeiterSuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface ProjektSuMitarbeiterManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektSuMitarbeiter entity) throws Exception;
	
	void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert die Entity für die übergebenen Werte zurück.
	 * 
	 * @param id
	 * @return
	 */
	ProjektSuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<ProjektSuMitarbeiter> findAll();
}