package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldungstyp;
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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Meldungstyp entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldungstyp update(Meldungstyp entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Meldungstyp entity) throws Exception;
	
	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteMeldungstypById(Integer id) throws Exception;
	
	/**
	 * Liefert die Meldungstyp-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Meldungstyp findMeldungstypById(Integer id);

	/**
	 * Liefert alle Meldungstyp-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Meldungstyp> findAllMeldungstyp();
}
