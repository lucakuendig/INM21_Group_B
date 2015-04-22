package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Objekttyp;

/**
 * Interface fuer Objekttyp Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ObjekttypDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Objekttyp entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Objekttyp update(Objekttyp entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Objekttyp entity) throws Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteObjekttypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Objekttyp-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Objekttyp findObjekttypById(Integer id);

	/**
	 * Liefert alle Objekttyp-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Objekttyp> findAllObjekttyp();

	/**
	 * Liefert die Liste mit Objekttypen f�r die �bergebene Bezeichnung zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Objekttyp> findObjekttypByBezeichnung(String bezeichnung);

}
