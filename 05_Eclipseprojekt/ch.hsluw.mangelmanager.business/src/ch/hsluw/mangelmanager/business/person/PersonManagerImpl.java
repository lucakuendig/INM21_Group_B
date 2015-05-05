/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.person;
import java.util.List;

import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.persister.dao.person.PersonDAO;
import ch.hsluw.mangelmanager.persister.dao.person.PersonDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * PersonManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class PersonManagerImpl implements PersonManager {

	private PersonDAO personDAO = new PersonDAOImpl();

	@Override
	public Person add(Person entity) throws Exception {

		if (entity.getId() == null) {
			personDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Person update(Person entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return personDAO.update(entity);
		}
	}

	@Override
	public void delete(Person entity) throws Exception {
		personDAO.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		personDAO.deletePersonById(id);
		
	}
	
	@Override
	public Person findById(Integer id) {
		return personDAO.findPersonById(id);
	}

	@Override
	public List<Person> findAll() {
		return personDAO.findAllPerson();
	}
}
