/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import ch.hsluw.mangelmanager.model.Meldung;


/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldung add(Meldung entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldung update(Meldung entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Meldung entity) throws Exception;
}