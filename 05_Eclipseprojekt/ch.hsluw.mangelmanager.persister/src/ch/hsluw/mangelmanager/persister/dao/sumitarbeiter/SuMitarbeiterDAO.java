package ch.hsluw.mangelmanager.persister.dao.sumitarbeiter;
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
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(SuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	SuMitarbeiter update(SuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(SuMitarbeiter entity) throws Exception;
	
	void deleteSuMitarbeiterById(Integer id) throws Exception;

	/**
	 * Liefert die SuMitarbeiter-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	SuMitarbeiter findSuMitarbeiterById(Integer id);

	/**
	 * Liefert alle SuMitarbeiter-Objekte zurück.
	 * 
	 * @return
	 */
	List<SuMitarbeiter> findAllSuMitarbeiter();
}