package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Arbeitstyp;

/**
 * Interface fuer Arbeitstyp Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ArbeitstypDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Arbeitstyp entity) throws Exception;

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
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteArbeitstypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Arbeitstyp-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Arbeitstyp findArbeitstypById(Integer id);

	/**
	 * Liefert alle Arbeitstyp-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Arbeitstyp> findAllArbeitstyp();

	/**
	 * Liefert die Liste mit Arbeitstypen f�r die �bergebene Bezeichnung zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Arbeitstyp> findArbeitstypByBezeichnung(String bezeichnung);

}
