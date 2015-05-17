package ch.hsluw.mangelmanager.persister.dao.bauherr;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Bauherr Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class BauherrDAOImpl implements BauherrDAO {
	@Override
	public void save(Bauherr entity) throws Exception {
		new GenericPersisterImpl<Bauherr>(Bauherr.class).save(entity);
	}

	@Override
	public Bauherr update(Bauherr entity) throws Exception {
		return new GenericPersisterImpl<Bauherr>(Bauherr.class).update(entity);
	}

	@Override
	public void delete(Bauherr entity) throws Exception {
		new GenericPersisterImpl<Bauherr>(Bauherr.class).delete(entity);
	}

	@Override
	public void deleteBauherrById(Integer id) throws Exception {
		new GenericPersisterImpl<Bauherr>(Bauherr.class).deleteById(id);
	}

	@Override
	public Bauherr findBauherrById(Integer id) {
		return new GenericPersisterImpl<Bauherr>(Bauherr.class).findById(id);
	}

	@Override
	public List<Bauherr> findAllBauherr() {
		return new GenericPersisterImpl<Bauherr>(Bauherr.class).findAll();
	}

}