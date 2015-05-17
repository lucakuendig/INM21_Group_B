package ch.hsluw.mangelmanager.persister.dao.objekttyp;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Objekttyp Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ObjekttypDAOImpl implements ObjekttypDAO {
	@Override
	public void save(Objekttyp entity) throws Exception {
		new GenericPersisterImpl<Objekttyp>(Objekttyp.class).save(entity);
	}

	@Override
	public Objekttyp update(Objekttyp entity) throws Exception {
		return new GenericPersisterImpl<Objekttyp>(Objekttyp.class).update(entity);
	}

	@Override
	public void delete(Objekttyp entity) throws Exception {
		new GenericPersisterImpl<Objekttyp>(Objekttyp.class).delete(entity);
	}
	
	@Override
	public void deleteObjekttypById(Integer id) throws Exception {
		new GenericPersisterImpl<Objekttyp>(Objekttyp.class).deleteById(id);
	}

	@Override
	public Objekttyp findObjekttypById(Integer id) {
		return new GenericPersisterImpl<Objekttyp>(Objekttyp.class).findById(id);
	}

	@Override
	public List<Objekttyp> findAllObjekttyp() {
		return new GenericPersisterImpl<Objekttyp>(Objekttyp.class).findAll();
	}
	
	@Override
	public List<Objekttyp> findObjekttypByBezeichnung(String bezeichnung) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Objekttyp> tQuery = em.createNamedQuery("Objekttyp.findByBezeichnung",
				Objekttyp.class);

		tQuery.setParameter("bezeichnung", bezeichnung);

		List<Objekttyp> arbeitstypListe = tQuery.getResultList();

		em.close();

		return arbeitstypListe != null ? arbeitstypListe : new ArrayList<Objekttyp>();
	}
	
}
