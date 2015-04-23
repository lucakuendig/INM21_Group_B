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

import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface implementation fuer Subunternehmen Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class SubunternehmenDAOImpl implements SubunternehmenDAO {
	@Override
	public void save(Subunternehmen entity) throws Exception {
		new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).save(entity);
	}

	@Override
	public Subunternehmen update(Subunternehmen entity) throws Exception {
		return new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).update(entity);
	}

	@Override
	public void delete(Subunternehmen entity) throws Exception {
		new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).delete(entity);
	}
}
