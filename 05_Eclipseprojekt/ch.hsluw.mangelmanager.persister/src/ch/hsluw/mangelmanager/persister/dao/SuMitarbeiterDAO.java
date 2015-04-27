package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;

/**
 * Interface fuer Subunternehmen Mitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface SuMitarbeiterDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(SuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	SuMitarbeiter update(SuMitarbeiter entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(SuMitarbeiter entity) throws Exception;
	
	void deleteSuMitarbeiterById(Integer id) throws Exception;

	/**
	 * Liefert die SuMitarbeiter-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	SuMitarbeiter findSuMitarbeiterById(Integer id);

	/**
	 * Liefert alle SuMitarbeiter-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<SuMitarbeiter> findAllSuMitarbeiter();
}