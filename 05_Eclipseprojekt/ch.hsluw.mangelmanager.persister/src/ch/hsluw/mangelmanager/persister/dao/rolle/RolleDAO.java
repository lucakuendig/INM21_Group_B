package ch.hsluw.mangelmanager.persister.dao.rolle;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Rolle;

/**
 * Interface fuer Rolle Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public interface RolleDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Rolle entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Rolle update(Rolle entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Rolle entity) throws Exception;
	
	void deleteRolleById(Integer id) throws Exception;

	/**
	 * Liefert die Rolle-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Rolle findRolleById(Integer id);

	/**
	 * Liefert alle Rolle-Objekte zurück.
	 * 
	 * @return
	 */
	List<Rolle> findAllRolle();

}
