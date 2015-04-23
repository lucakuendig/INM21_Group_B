package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import ch.hsluw.mangelmanager.model.Meldungstyp;



/**
 * Interface fuer Meldungstyp Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungstypDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Meldungstyp entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldungstyp update(Meldungstyp entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Meldungstyp entity) throws Exception;
	
	
}
