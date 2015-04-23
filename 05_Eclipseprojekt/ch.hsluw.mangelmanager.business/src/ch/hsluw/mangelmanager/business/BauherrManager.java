/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.List;

import ch.hsluw.mangelmanager.model.Bauherr;


/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface BauherrManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Bauherr add(Bauherr entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Bauherr update(Bauherr entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Bauherr entity) throws Exception;
	
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
	Bauherr findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Bauherr> findAll();
}

