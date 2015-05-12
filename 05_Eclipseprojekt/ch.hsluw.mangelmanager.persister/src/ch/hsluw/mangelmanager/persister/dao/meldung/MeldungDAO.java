/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.persister.dao.meldung;

import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldung;



/**
 * Interface fuer Meldung Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public interface MeldungDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Meldung entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Meldung update(Meldung entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Meldung entity) throws Exception;
	
	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteMeldungById(Integer id) throws Exception;
	
	/**
	 * Liefert die Meldung-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Meldung findMeldungById(Integer id);

	/**
	 * Liefert alle Meldung-Meldung zur�ck.
	 * 
	 * @return
	 */
	List<Meldung> findAllMeldung();

	List<Meldung> findAllMeldungByMangel(Mangel mangel);
	
}
