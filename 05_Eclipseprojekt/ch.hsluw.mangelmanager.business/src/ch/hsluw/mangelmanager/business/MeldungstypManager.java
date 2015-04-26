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
	
	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Meldungstyp findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<Meldungstyp> findAll();
}