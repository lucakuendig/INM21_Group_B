
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.person.PersonManager;
import ch.hsluw.mangelmanager.business.person.PersonManagerImpl;
import ch.hsluw.mangelmanager.model.Person;

public class PersonROImpl extends UnicastRemoteObject implements PersonRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private PersonManager personManager;

	public PersonROImpl() throws RemoteException {
		personManager = new PersonManagerImpl();
	}

	@Override
	public Person add(Person entity) throws RemoteException, Exception {
		return personManager.add(entity);
	}

	@Override
	public Person update(Person entity) throws RemoteException, Exception {
		return personManager.update(entity);
	}

	@Override
	public void delete(Person entity) throws RemoteException, Exception {
		personManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		personManager.deleteById(id);	
	}
	
	@Override
	public Person findById(Integer id) throws RemoteException {
		return personManager.findById(id);
	}

	@Override
	public List<Person> findAll() throws RemoteException {
		return personManager.findAll();
	}

}
