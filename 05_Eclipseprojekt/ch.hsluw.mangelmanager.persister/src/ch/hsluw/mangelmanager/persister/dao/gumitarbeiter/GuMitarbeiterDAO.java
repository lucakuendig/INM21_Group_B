package ch.hsluw.mangelmanager.persister.dao.gumitarbeiter;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;

/**
 * Interface fuer GuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface GuMitarbeiterDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(GuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	GuMitarbeiter update(GuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(GuMitarbeiter entity) throws Exception;
	
	void deleteGuMitarbeiterById(Integer id) throws Exception;

	/**
	 * Liefert die GuMitarbeiter-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	GuMitarbeiter findGuMitarbeiterById(Integer id);

	/**
	 * Liefert alle GuMitarbeiter-Objekte zurück.
	 * 
	 * @return
	 */
	List<GuMitarbeiter> findAllGuMitarbeiter();
	
}