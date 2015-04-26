/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.List;

import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.persister.dao.MeldungstypDAO;
import ch.hsluw.mangelmanager.persister.dao.MeldungstypDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungstypManager zur Verfügung.
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungstypManagerImpl implements MeldungstypManager {

	private MeldungstypDAO meldungstypDAO = new MeldungstypDAOImpl();

	@Override
	public Meldungstyp add(Meldungstyp entity) throws Exception {

		if (entity.getId() == null) {
			meldungstypDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Meldungstyp update(Meldungstyp entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return meldungstypDAO.update(entity);
		}
	}

	@Override
	public void delete(Meldungstyp entity) throws Exception {
		meldungstypDAO.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Meldungstyp findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meldungstyp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}