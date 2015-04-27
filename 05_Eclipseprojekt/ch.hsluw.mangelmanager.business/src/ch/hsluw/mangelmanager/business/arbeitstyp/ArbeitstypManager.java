/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.arbeitstyp;

import java.util.List;

import ch.hsluw.mangelmanager.model.Arbeitstyp;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ArbeitstypManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Arbeitstyp add(Arbeitstyp entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Arbeitstyp update(Arbeitstyp entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Arbeitstyp entity) throws Exception;
	
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
	Arbeitstyp findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Arbeitstyp> findAll();
	
	/**
	 * Liefert die Liste mit Arbeitstypen f�r die �bergebene Bezeichnung zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	List<Arbeitstyp> findByBezeichnung(String bezeichnung);
	
}

