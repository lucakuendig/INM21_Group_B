package ch.hsluw.mangelmanager.persister.dao.person;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Projekt;

/**
 * Interface fuer Person Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface PersonDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Person entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Person update(Person entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Person entity) throws Exception;
	
	void deletePersonById(Integer id) throws Exception;

	/**
	 * Liefert die Person-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Person findPersonById(Integer id);

	/**
	 * Liefert alle Person-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Person> findAllPerson();

}
