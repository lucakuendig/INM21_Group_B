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

import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface implementation fuer ProjektGuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class ProjektGuMitarbeiterDAOImpl implements ProjektGuMitarbeiterDAO {
	@Override
	public void save(ProjektGuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<ProjektGuMitarbeiter>(ProjektGuMitarbeiter.class).save(entity);
	}

	@Override
	public ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws Exception {
		return new GenericPersisterImpl<ProjektGuMitarbeiter>(ProjektGuMitarbeiter.class).update(entity);
	}

	@Override
	public void delete(ProjektGuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<ProjektGuMitarbeiter>(ProjektGuMitarbeiter.class).delete(entity);
	}
}
