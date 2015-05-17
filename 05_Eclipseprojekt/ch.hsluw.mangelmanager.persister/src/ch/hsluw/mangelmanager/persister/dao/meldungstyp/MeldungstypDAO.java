package ch.hsluw.mangelmanager.persister.dao.meldungstyp;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldungstyp;



/**
 * Implementierung fuer MeldungstypDAO
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungstypDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Meldungstyp entity) throws Exception;

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
	 * @param entity
	 * @throws Exception
	 */
	void deleteMeldungstypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Meldungstyp-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Meldungstyp findMeldungstypById(Integer id);

	/**
	 * Liefert alle Meldungstyp-Objekte zurück.
	 * 
	 * @return
	 */
	List<Meldungstyp> findAllMeldungstyp();
}
