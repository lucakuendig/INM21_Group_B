/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Rolle;

/**
 * Interface fuer Rolle Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public interface RolleManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Rolle add(Rolle entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Rolle update(Rolle entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Rolle entity) throws Exception;
	
}

