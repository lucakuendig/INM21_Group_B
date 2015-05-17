package ch.hsluw.mangelmanager.persister.dao.rolle;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Rolle entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Rolle update(Rolle entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Rolle entity) throws Exception;
	
	void deleteRolleById(Integer id) throws Exception;

	/**
	 * Liefert die Rolle-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Rolle findRolleById(Integer id);

	/**
	 * Liefert alle Rolle-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Rolle> findAllRolle();

}
