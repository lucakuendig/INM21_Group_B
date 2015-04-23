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

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface implementation fuer ProjektSuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class ProjektSuMitarbeiterDAOImpl implements ProjektSuMitarbeiterDAO {
	@Override
	public void save(ProjektSuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<ProjektSuMitarbeiter>(ProjektSuMitarbeiter.class).save(entity);
	}

	@Override
	public ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception {
		return new GenericPersisterImpl<ProjektSuMitarbeiter>(ProjektSuMitarbeiter.class).update(entity);
	}

	@Override
	public void delete(ProjektSuMitarbeiter entity) throws Exception {
		new GenericPersisterImpl<ProjektSuMitarbeiter>(ProjektSuMitarbeiter.class).delete(entity);
	}
}
