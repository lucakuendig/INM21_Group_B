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

import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

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

}
