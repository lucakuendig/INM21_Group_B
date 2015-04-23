package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import ch.hsluw.mangelmanager.model.Meldung;



/**
 * Interface fuer Meldung Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Meldung entity) throws Exception;

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
