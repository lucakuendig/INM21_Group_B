/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.Date;
import java.util.List;

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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektGuMitarbeiter add(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektGuMitarbeiter entity) throws Exception;
	
	void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert die Entity f�r die �bergebenen Werte zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	ProjektGuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<ProjektGuMitarbeiter> findAll();
}