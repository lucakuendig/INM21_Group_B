/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.gumitarbeiter;

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;

/**
 * Interface fuer GuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface GuMitarbeiterManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	GuMitarbeiter add(GuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	GuMitarbeiter update(GuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(GuMitarbeiter entity) throws Exception;
	
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	GuMitarbeiter findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<GuMitarbeiter> findAll();
}