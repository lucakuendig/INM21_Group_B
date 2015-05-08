package ch.hsluw.mangelmanager.persister.dao.mangel;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Mangel Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public class MangelDAOImpl implements MangelDAO {
	@Override
	public void save(Mangel entity) throws Exception {
		new GenericPersisterImpl<Mangel>(Mangel.class).save(entity);
	}

	@Override
	public Mangel update(Mangel entity) throws Exception {
		return new GenericPersisterImpl<Mangel>(Mangel.class).update(entity);
	}

	@Override
	public void delete(Mangel entity) throws Exception {
		new GenericPersisterImpl<Mangel>(Mangel.class).delete(entity);
	}

	@Override
	public void deleteMangelById(Integer id) throws Exception {
		new GenericPersisterImpl<Mangel>(Mangel.class).deleteById(id);
	}

	@Override
	public Mangel findMangelById(Integer id) {
		return new GenericPersisterImpl<Mangel>(Mangel.class).findById(id);
	}

	@Override
	public List<Mangel> findAllMangel() {
		return new GenericPersisterImpl<Mangel>(Mangel.class).findAll();
	}

	@Override
	public List<Mangel> findMangelByBezeichnung(String bezeichnung) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery(
				"Mangel.findByBezeichnung", Mangel.class);

		tQuery.setParameter("bezeichnung", bezeichnung);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}

	@Override
	public List<Mangel> findMangelByMangelstatus(String Mangelstatus) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery(
				"Mangel.findByMangelstatus", Mangel.class);

		tQuery.setParameter("Mangelstatus", Mangelstatus);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}

	@Override
	public List<Mangel> findMangelByName(String name) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery("Mangel.findByName",
				Mangel.class);

		tQuery.setParameter("ort", name);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}

	@Override
	public List<Mangel> findMangelByErfassungszeit(Date erfassungsZeit) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery(
				"Mangel.findByErfassungszeit", Mangel.class);

		tQuery.setParameter("erfassungsZeit", erfassungsZeit);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}

	@Override
	public List<Mangel> findMangelByFaelligkeitsDatum(Date faelligkeitsDatum) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery(
				"Mangel.findByFaelligkeitsDatum", Mangel.class);

		tQuery.setParameter("faelligkeitsDatum", faelligkeitsDatum);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}

	@Override
	public List<Mangel> findMangelByAbschlussZeit(Date abschlussZeit) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mangel> tQuery = em.createNamedQuery(
				"Mangel.findByabschlussZeit", Mangel.class);

		tQuery.setParameter("abschlussZeit", abschlussZeit);

		List<Mangel> MangelListe = tQuery.getResultList();

		em.close();

		return MangelListe != null ? MangelListe : new ArrayList<Mangel>();
	}
	
	@Override
	public List<Mangel> findAllMangelProjekt(Projekt projekt) {
		EntityManager em = JpaUtil.createEntityManager();
		
		TypedQuery<Mangel> tQuery = em.createNamedQuery("Mangel.findByMangelProjekt",
				Mangel.class);

		tQuery.setParameter("projektId", projekt);

		List<Mangel> mangelListe = tQuery.getResultList();

		em.close();

		return mangelListe != null ? mangelListe : new ArrayList<Mangel>();
	}

}
