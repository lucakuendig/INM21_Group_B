package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;



/**
 * Interface fuer Meldung Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungDAOImpl implements MeldungDAO {
	@Override
	public void save(Meldung entity) throws Exception {
		new GenericPersisterImpl<Meldung>(Meldung.class).save(entity);
	}

	@Override
	public Meldung update(Meldung entity) throws Exception {
		return new GenericPersisterImpl<Meldung>(Meldung.class).update(entity);
	}

	@Override
	public void delete(Meldung entity) throws Exception {
		new GenericPersisterImpl<Meldung>(Meldung.class).delete(entity);
	}
}