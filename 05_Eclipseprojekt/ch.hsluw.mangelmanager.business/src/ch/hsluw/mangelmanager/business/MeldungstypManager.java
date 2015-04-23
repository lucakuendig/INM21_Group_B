/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import ch.hsluw.mangelmanager.model.Meldungstyp;


/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungstypManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldungstyp add(Meldungstyp entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldungstyp update(Meldungstyp entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Meldungstyp entity) throws Exception;
}