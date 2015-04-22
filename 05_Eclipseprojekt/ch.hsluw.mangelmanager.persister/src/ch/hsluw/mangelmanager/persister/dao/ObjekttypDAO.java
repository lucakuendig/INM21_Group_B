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
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Objekttyp entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Objekttyp update(Objekttyp entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Objekttyp entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteObjekttypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Objekttyp-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Objekttyp findObjekttypById(Integer id);

	/**
	 * Liefert alle Objekttyp-Objekte zurück.
	 * 
	 * @return
	 */
	List<Objekttyp> findAllObjekttyp();

	/**
	 * Liefert die Liste mit Objekttypen für die übergebene Bezeichnung zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Objekttyp> findObjekttypByBezeichnung(String bezeichnung);

}
