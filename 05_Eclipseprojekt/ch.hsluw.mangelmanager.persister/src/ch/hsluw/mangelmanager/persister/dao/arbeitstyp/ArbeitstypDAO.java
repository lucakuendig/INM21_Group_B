package ch.hsluw.mangelmanager.persister.dao.arbeitstyp;

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
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Arbeitstyp entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Arbeitstyp update(Arbeitstyp entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Arbeitstyp entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteArbeitstypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Arbeitstyp-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Arbeitstyp findArbeitstypById(Integer id);

	/**
	 * Liefert alle Arbeitstyp-Objekte zurück.
	 * 
	 * @return
	 */
	List<Arbeitstyp> findAllArbeitstyp();

	/**
	 * Liefert die Liste mit Arbeitstypen für die übergebene Bezeichnung zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Arbeitstyp> findArbeitstypByBezeichnung(String bezeichnung);

}
