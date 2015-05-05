/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.persister.dao.meldung;

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;



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
}