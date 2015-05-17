package ch.hsluw.mangelmanager.persister.dao.rolle;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface fuer Rolle Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public class RolleDAOImpl implements RolleDAO {
	@Override
	public void save(Rolle entity) throws Exception {
		new GenericPersisterImpl<Rolle>(Rolle.class).save(entity);
	}

	@Override
	public Rolle update(Rolle entity) throws Exception {
		return new GenericPersisterImpl<Rolle>(Rolle.class).update(entity);
	}

	@Override
	public void delete(Rolle entity) throws Exception {
		new GenericPersisterImpl<Rolle>(Rolle.class).delete(entity);
	}

	@Override
	public void deleteRolleById(Integer id) throws Exception {
		new GenericPersisterImpl<Rolle>(Rolle.class).deleteById(id);
	}

	@Override
	public Rolle findRolleById(Integer id) {
		return new GenericPersisterImpl<Rolle>(Rolle.class).findById(id);
	}

	@Override
	public List<Rolle> findAllRolle() {
		return new GenericPersisterImpl<Rolle>(Rolle.class).findAll();
	}
}
