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

import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Plz Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class PlzDAOImpl implements PlzDAO {
	@Override
	public void save(Plz entity) throws Exception {
		new GenericPersisterImpl<Plz>(Plz.class).save(entity);
	}

	@Override
	public Plz update(Plz entity) throws Exception {
		return new GenericPersisterImpl<Plz>(Plz.class).update(entity);
	}

	@Override
	public void delete(Plz entity) throws Exception {
		new GenericPersisterImpl<Plz>(Plz.class).delete(entity);
	}

	@Override
	public void deletePlzById(Integer id) throws Exception {
		new GenericPersisterImpl<Plz>(Plz.class).deleteById(id);
	}

	@Override
	public Plz findPlzById(Integer id) {
		return new GenericPersisterImpl<Plz>(Plz.class).findById(id);
	}

	@Override
	public List<Plz> findAllPlz() {
		return new GenericPersisterImpl<Plz>(Plz.class).findAll();
	}

}