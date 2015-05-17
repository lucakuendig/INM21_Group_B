package ch.hsluw.mangelmanager.persister.dao.adresse;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Adresse Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class AdresseDAOImpl implements AdresseDAO {
	@Override
	public void save(Adresse entity) throws Exception {
		new GenericPersisterImpl<Adresse>(Adresse.class).save(entity);
	}

	@Override
	public Adresse update(Adresse entity) throws Exception {
		return new GenericPersisterImpl<Adresse>(Adresse.class).update(entity);
	}

	@Override
	public void delete(Adresse entity) throws Exception {
		new GenericPersisterImpl<Adresse>(Adresse.class).delete(entity);
	}

	@Override
	public void deleteAdresseById(Integer id) throws Exception {
		new GenericPersisterImpl<Adresse>(Adresse.class).deleteById(id);
	}

	@Override
	public Adresse findAdresseById(Integer id) {
		return new GenericPersisterImpl<Adresse>(Adresse.class).findById(id);
	}

	@Override
	public List<Adresse> findAllAdresse() {
		return new GenericPersisterImpl<Adresse>(Adresse.class).findAll();
	}

}