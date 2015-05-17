/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.subunternehmen;

import java.util.List;

import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * Interface fuer Subunternehmen Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface SubunternehmenManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Subunternehmen add(Subunternehmen entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void update(Subunternehmen entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Subunternehmen entity) throws Exception;
	
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Subunternehmen findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Subunternehmen> findAll();


	String findAllProjekte(int subunternehmen);

	void save(Subunternehmen subunternehmen);

	List<SuMitarbeiter> findAllSubunternehmenMitarbeiter(Subunternehmen subunternehmen);

	List<Subunternehmen> findAllSubunternehmenByProjekt(Integer projekt2);
}