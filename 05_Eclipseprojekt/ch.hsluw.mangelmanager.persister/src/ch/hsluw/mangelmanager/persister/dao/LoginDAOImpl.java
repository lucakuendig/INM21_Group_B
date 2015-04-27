package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Login Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public class LoginDAOImpl implements LoginDAO {
	@Override
	public void save(Login entity) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).save(entity);
	}

	@Override
	public Login update(Login entity) throws Exception {
		return new GenericPersisterImpl<Login>(Login.class).update(entity);
	}

	@Override
	public void delete(Login entity) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).delete(entity);
	}
	
	@Override
	public void deleteLoginById(Integer id) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).deleteById(id);
	}

	@Override
	public Login findLoginById(Integer id) {
		return new GenericPersisterImpl<Login>(Login.class).findById(id);
	}

	@Override
	public List<Login> findAllLogin() {
		return new GenericPersisterImpl<Login>(Login.class).findAll();
	}
	
}
