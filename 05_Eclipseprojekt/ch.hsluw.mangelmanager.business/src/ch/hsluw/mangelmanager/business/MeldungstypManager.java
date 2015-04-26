/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldungstyp;



/**
 * Interface fuer Meldungstyp Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungstypManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldungstyp add(Meldungstyp entity) throws Exception;

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
	
	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Meldungstyp findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Meldungstyp> findAll();
}