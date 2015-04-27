/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.plz;

import java.util.List;

import ch.hsluw.mangelmanager.model.Plz;


/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface PlzManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Plz add(Plz entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Plz update(Plz entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Plz entity) throws Exception;
	
	/**
	 * L�scht die Entity mit der �begebenen Id.
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
	Plz findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Plz> findAll();
}

