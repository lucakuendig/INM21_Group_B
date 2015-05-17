package ch.hsluw.mangelmanager.persister.dao.person;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Person Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class PersonDAOImpl implements PersonDAO {
	@Override
	public void save(Person entity) throws Exception {
		new GenericPersisterImpl<Person>(Person.class).save(entity);
	}

	@Override
	public Person update(Person entity) throws Exception {
		if(entity instanceof SuMitarbeiter){
			return new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).update((SuMitarbeiter) entity);
		}
		else if(entity instanceof GuMitarbeiter){
			return new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).update((GuMitarbeiter)entity);
		}else{
			return new GenericPersisterImpl<Bauherr>(Bauherr.class).update((Bauherr)entity);
		}
	}

	@Override
	public void delete(Person entity) throws Exception {
		new GenericPersisterImpl<Person>(Person.class).delete(entity);
	}
	
	@Override
	public void deletePersonById(Integer id) throws Exception {
		new GenericPersisterImpl<Person>(Person.class).deleteById(id);
	}

	@Override
	public Person findPersonById(Integer id) {
		return new GenericPersisterImpl<Person>(Person.class).findById(id);
	}

	@Override
	public List<Person> findAllPerson() {
		return new GenericPersisterImpl<Person>(Person.class).findAll();
	}
	
}
