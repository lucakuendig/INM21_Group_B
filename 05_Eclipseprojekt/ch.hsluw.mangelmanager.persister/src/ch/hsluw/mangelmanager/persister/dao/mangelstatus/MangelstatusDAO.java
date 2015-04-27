package ch.hsluw.mangelmanager.persister.dao.mangelstatus;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Mangelstatus;

/**
 * Interface fuer Mangelstatus Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public interface MangelstatusDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Mangelstatus entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangelstatus update(Mangelstatus entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Mangelstatus entity) throws Exception;

	void deleteMangelstatusById(Integer id) throws Exception;

	/**
	 * Liefert die Mangelstatus-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Mangelstatus findMangelstatusById(Integer id);

	/**
	 * Liefert alle Mangelstatus-Objekte zurück.
	 * 
	 * @return
	 */
	List<Mangelstatus> findAllMangelstatus();
}
