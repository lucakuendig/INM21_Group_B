package ch.hsluw.mangelmanager.persister.dao.subunternehmen;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.beans.value.ObservableValue;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
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
	public void update(Subunternehmen entity) throws Exception {
		 new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).update(entity);
	}

	@Override
	public void delete(Subunternehmen entity) throws Exception {
		new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).delete(entity);
	}
	@Override
	public void deleteSubunternehmenById(Integer id) throws Exception {
		new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).deleteById(id);
	}

	@Override
	public Subunternehmen findSubunternehmenById(Integer id) {
		return new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).findById(id);
	}

	@Override
	public List<Subunternehmen> findAllSubunternehmen() {
		return new GenericPersisterImpl<Subunternehmen>(Subunternehmen.class).findAll();
	}

	@Override
	public String findAllProjekte(int subunternehmen) {
		EntityManager em = JpaUtil.createEntityManager();
		String anzProjekte = "";
		

		Query tQuery = em.createNativeQuery("select count(distinct ps.fkprojekt_id) from projektsumitarbeiter as ps "
				+ "join sumitarbeiter as s on s.id = ps.fkmitarbeiter_id "
				+ "join projekt as p on p.id = ps.fkprojekt_id "
				+ "join projektstatus pst on pst.id = p.fkprojektstatus_id "
				+ "where s.fksubunternehmen_id = "+ subunternehmen +" and pst.bezeichnung != 'abgeschlossen'");

		Object resProjekte = tQuery.getSingleResult();

		em.close();
		anzProjekte = resProjekte.toString();

		return anzProjekte;
		
	}

	@Override
	public List<SuMitarbeiter> findAllSubunternehmenMitarbeiter(Subunternehmen subunternehmen) {
EntityManager em = JpaUtil.createEntityManager();
		
		TypedQuery<SuMitarbeiter> tQuery = em.createNamedQuery("Subunternehmen.findBySubunternehmenMitarbeiter",
				SuMitarbeiter.class);

		tQuery.setParameter("subunternehmenId", subunternehmen);

		List<SuMitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<SuMitarbeiter>();
	}

	@Override
	public List<Subunternehmen> findAllSubunternehmenByProjekt(Integer projekt2) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.createEntityManager();
				
		
		Query tQuery = em.createNativeQuery("select s.* from subunternehmen as s, "
				+ "sumitarbeiter as sm, projektsumitarbeiter as ps "
				+ "where ps.fkmitarbeiter_id = sm.id "
				+ "and sm.fksubunternehmen_id = s.id and ps.fkprojekt_id = "+ projekt2,
				Subunternehmen.class);

		List<Subunternehmen> subunternehmenListe = tQuery.getResultList();

		em.close();

		return subunternehmenListe != null ? subunternehmenListe : new ArrayList<Subunternehmen>();
	}
	
}
