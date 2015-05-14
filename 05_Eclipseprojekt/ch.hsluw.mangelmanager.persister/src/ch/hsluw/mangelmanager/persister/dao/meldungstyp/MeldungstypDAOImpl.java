/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.persister.dao.meldungstyp;

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungstypManager zur Verfügung.
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungstypDAOImpl implements MeldungstypDAO {
	@Override
	public void save(Meldungstyp entity) throws Exception {
		new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).save(entity);
	}

	@Override
	public Meldungstyp update(Meldungstyp entity) throws Exception {
		return new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).update(entity);
	}

	@Override
	public void delete(Meldungstyp entity) throws Exception {
		new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).delete(entity);
	}

	@Override
	public void deleteMeldungstypById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Meldungstyp findMeldungstypById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meldungstyp> findAllMeldungstyp() {
		// TODO Auto-generated method stub
		return new GenericPersisterImpl<Meldungstyp>(Meldungstyp.class).findAll();
	}
}