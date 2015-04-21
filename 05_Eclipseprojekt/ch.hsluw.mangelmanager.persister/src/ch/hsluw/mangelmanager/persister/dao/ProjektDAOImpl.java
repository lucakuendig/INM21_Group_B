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

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektDAOImpl implements ProjektDAO {
	@Override
	public void save(Projekt entity) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).save(entity);
	}

	@Override
	public Projekt update(Projekt entity) throws Exception {
		return new GenericPersisterImpl<Projekt>(Projekt.class).update(entity);
	}

	@Override
	public void delete(Projekt entity) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).delete(entity);
	}
	
	@Override
	public void deleteProjektById(Integer id) throws Exception {
		new GenericPersisterImpl<Projekt>(Projekt.class).deleteById(id);
	}

	@Override
	public Projekt findProjektById(Integer id) {
		return new GenericPersisterImpl<Projekt>(Projekt.class).findById(id);
	}

	@Override
	public List<Projekt> findAllProjekt() {
		return new GenericPersisterImpl<Projekt>(Projekt.class).findAll();
	}
	
	@Override
	public List<Projekt> findProjektByBezeichnung(String bezeichnung) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByBezeichnung",
				Projekt.class);

		tQuery.setParameter("bezeichnung", bezeichnung);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByProjektstatus(String projektstatus) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByProjektstatus",
				Projekt.class);

		tQuery.setParameter("projektstatus", projektstatus);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByOrt(String ort) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByOrt",
				Projekt.class);

		tQuery.setParameter("ort", ort);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByPlz(String plz) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByPlz",
				Projekt.class);

		tQuery.setParameter("plz", plz);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByBauherr(String bauherr) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByBauherr",
				Projekt.class);

		tQuery.setParameter("bauherr", bauherr);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByObjekttyp(String objekttyp) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByObjekttyp",
				Projekt.class);

		tQuery.setParameter("objekttyp", objekttyp);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
	
	@Override
	public List<Projekt> findProjektByArbeitstyp(String arbeitstyp) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByArbeitstyp",
				Projekt.class);

		tQuery.setParameter("arbeitstyp", arbeitstyp);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}

	@Override
	public List<Projekt> findProjektByDatumFromTillEnd(Date fromDatum, Date endDatum) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Projekt> tQuery = em.createNamedQuery("Projekt.findByDatumFromTillEnd",
				Projekt.class);

		tQuery.setParameter("fromDatum", fromDatum);
		tQuery.setParameter("endDatum", endDatum);

		List<Projekt> projektListe = tQuery.getResultList();

		em.close();

		return projektListe != null ? projektListe : new ArrayList<Projekt>();
	}
}
