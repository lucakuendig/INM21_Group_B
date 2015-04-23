package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Projektstatus Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektstatusDAOImpl implements ProjektstatusDAO {
	@Override
	public void save(Projektstatus entity) throws Exception {
		new GenericPersisterImpl<Projektstatus>(Projektstatus.class).save(entity);
	}

	@Override
	public Projektstatus update(Projektstatus entity) throws Exception {
		return new GenericPersisterImpl<Projektstatus>(Projektstatus.class).update(entity);
	}

	@Override
	public void delete(Projektstatus entity) throws Exception {
		new GenericPersisterImpl<Projektstatus>(Projektstatus.class).delete(entity);
	}

	@Override
	public void deleteProjektstatusById(Integer id) throws Exception {
		new GenericPersisterImpl<Projektstatus>(Projektstatus.class).deleteById(id);
	}

	@Override
	public Projektstatus findProjektstatusById(Integer id) {
		return new GenericPersisterImpl<Projektstatus>(Projektstatus.class).findById(id);
	}

	@Override
	public List<Projektstatus> findAllProjektstatus() {
		return new GenericPersisterImpl<Projektstatus>(Projektstatus.class).findAll();
	}

}