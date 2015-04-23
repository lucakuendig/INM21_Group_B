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

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

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
}
