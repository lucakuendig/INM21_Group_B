package ch.hsluw.mangelmanager.persister.dao;

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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Mangelstatus entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangelstatus update(Mangelstatus entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Mangelstatus entity) throws Exception;

	void deleteMangelstatusById(Integer id) throws Exception;

	/**
	 * Liefert die Mangelstatus-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Mangelstatus findMangelstatusById(Integer id);

	/**
	 * Liefert alle Mangelstatus-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Mangelstatus> findAllMangelstatus();
}
