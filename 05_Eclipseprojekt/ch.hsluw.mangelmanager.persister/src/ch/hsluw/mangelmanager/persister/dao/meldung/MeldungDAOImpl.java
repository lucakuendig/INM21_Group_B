/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.persister.dao.meldung;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungManager zur Verfügung.
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

	@Override
	public void deleteMeldungById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Meldung findMeldungById(Integer id) {
		// TODO Auto-generated method stub
		return new GenericPersisterImpl<Meldung>(Meldung.class).findById(id);
	}

	@Override
	public List<Meldung> findAllMeldung() {
		// TODO Auto-generated method stub
		return new GenericPersisterImpl<Meldung>(Meldung.class).findAll();
	}

	@Override
	public List<Meldung> findAllMeldungByMangel(Mangel mangel) {
EntityManager em = JpaUtil.createEntityManager();
		
		TypedQuery<Meldung> tQuery = em.createNamedQuery("Meldung.findAllMeldungByMangel",
				Meldung.class);

		tQuery.setParameter("mangelId", mangel);

		List<Meldung> meldungListe = tQuery.getResultList();

		em.close();

		return meldungListe != null ? meldungListe : new ArrayList<Meldung>();
	}
}