package ch.hsluw.mangelmanager.persister.dao.arbeitstyp;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Arbeitstyp Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ArbeitstypDAOImpl implements ArbeitstypDAO {
	@Override
	public void save(Arbeitstyp entity) throws Exception {
		new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).save(entity);
	}

	@Override
	public Arbeitstyp update(Arbeitstyp entity) throws Exception {
		return new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).update(entity);
	}

	@Override
	public void delete(Arbeitstyp entity) throws Exception {
		new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).delete(entity);
	}
	
	@Override
	public void deleteArbeitstypById(Integer id) throws Exception {
		new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).deleteById(id);
	}

	@Override
	public Arbeitstyp findArbeitstypById(Integer id) {
		return new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).findById(id);
	}

	@Override
	public List<Arbeitstyp> findAllArbeitstyp() {
		return new GenericPersisterImpl<Arbeitstyp>(Arbeitstyp.class).findAll();
	}
	
	@Override
	public List<Arbeitstyp> findArbeitstypByBezeichnung(String bezeichnung) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Arbeitstyp> tQuery = em.createNamedQuery("Arbeitstyp.findByBezeichnung",
				Arbeitstyp.class);

		tQuery.setParameter("bezeichnung", bezeichnung);

		List<Arbeitstyp> arbeitstypListe = tQuery.getResultList();

		em.close();

		return arbeitstypListe != null ? arbeitstypListe : new ArrayList<Arbeitstyp>();
	}
	
}
