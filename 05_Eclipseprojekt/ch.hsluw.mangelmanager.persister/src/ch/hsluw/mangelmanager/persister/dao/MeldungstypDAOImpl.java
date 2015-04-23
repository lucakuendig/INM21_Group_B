package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;



/**
 * Interface fuer Meldungstyp Entity
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungstypDAOImpl implements MeldungstypDAO {
	@Override
	public void save(Meldungstyp entity) throws Exception {
		new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).save(entity);
	}

	@Override
	public Meldungstyp update(Meldungstyp entity) throws Exception {
		return new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).update(entity);
	}

	@Override
	public void delete(Meldungstyp entity) throws Exception {
		new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).delete(entity);
	}
}