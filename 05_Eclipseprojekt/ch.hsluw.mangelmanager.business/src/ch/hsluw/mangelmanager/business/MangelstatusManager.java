/*
 * ZWECK: Mangelstatusmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import ch.hsluw.mangelmanager.model.Mangelstatus;


/**
 * Interface fuer Mangelstatus Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public interface MangelstatusManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangelstatus add(Mangelstatus entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangelstatus update(Mangelstatus entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Mangelstatus entity) throws Exception;
}