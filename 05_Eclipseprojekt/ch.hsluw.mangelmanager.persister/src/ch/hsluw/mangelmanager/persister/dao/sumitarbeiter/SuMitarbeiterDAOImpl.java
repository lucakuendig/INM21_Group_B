package ch.hsluw.mangelmanager.persister.dao.sumitarbeiter;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface implementation fuer Subunternehmen Mitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class SuMitarbeiterDAOImpl implements SuMitarbeiterDAO {
	@Override
	public void save(SuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).save(entity);
	}

	@Override
	public SuMitarbeiter update(SuMitarbeiter entity) throws Exception {
		return new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).update(entity);
	}

	@Override
	public void delete(SuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).delete(entity);
	}
	
	@Override
	public void deleteSuMitarbeiterById(Integer id) throws Exception {
		new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).deleteById(id);
	}

	@Override
	public SuMitarbeiter findSuMitarbeiterById(Integer id) {
		return new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).findById(id);
	}

	@Override
	public List<SuMitarbeiter> findAllSuMitarbeiter() {
		return new GenericPersisterImpl<SuMitarbeiter>(SuMitarbeiter.class).findAll();
	}
}
