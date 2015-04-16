package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektDAOImpl implements ProjektDAO {
	@Override
	public void save(Projekt entity) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).save(entity);
	}

	@Override
	public Projekt update(Projekt entity) throws Exception {
		return new GenericPersisterImpl<Projekt>(Projekt.class).update(entity);
	}

	@Override
	public void delete(Projekt entity) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).delete(entity);
	}
	
	@Override
	public void deleteProjektById(Integer id) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).deleteById(id);
	}

	@Override
	public Projekt findProjektById(Integer id) {
		return new GenericPersisterImpl<Projekt>(Projekt.class).findById(id);
	}

	@Override
	public List<Projekt> findAllProjekt() {
		return new GenericPersisterImpl<Projekt>(Projekt.class).findAll();
	}

}
