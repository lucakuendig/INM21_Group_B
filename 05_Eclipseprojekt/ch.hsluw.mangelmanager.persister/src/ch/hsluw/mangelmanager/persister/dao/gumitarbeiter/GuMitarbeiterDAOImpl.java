package ch.hsluw.mangelmanager.persister.dao.gumitarbeiter;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;

/**
 * Interface implementation fuer GuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class GuMitarbeiterDAOImpl implements GuMitarbeiterDAO {
	@Override
	public void save(GuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).save(entity);
	}

	@Override
	public GuMitarbeiter update(GuMitarbeiter entity) throws Exception {
		return new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).update(entity);
	}

	@Override
	public void delete(GuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).delete(entity);
	}
	
	@Override
	public void deleteGuMitarbeiterById(Integer id) throws Exception {
		new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).deleteById(id);
	}

	@Override
	public GuMitarbeiter findGuMitarbeiterById(Integer id) {
		return new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).findById(id);
	}

	@Override
	public List<GuMitarbeiter> findAllGuMitarbeiter() {
		return new GenericPersisterImpl<GuMitarbeiter>(GuMitarbeiter.class).findAll();
	}
}
