/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.meldung;

import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.persister.dao.meldung.MeldungDAO;
import ch.hsluw.mangelmanager.persister.dao.meldung.MeldungDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungManager zur Verfügung.
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungManagerImpl implements MeldungManager {

	private MeldungDAO meldungDAO = new MeldungDAOImpl();

	@Override
	public Meldung add(Meldung entity) throws Exception {

		if (entity.getId() == null) {
			meldungDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Meldung update(Meldung entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return meldungDAO.update(entity);
		}
	}

	@Override
	public void delete(Meldung entity) throws Exception {
		meldungDAO.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Meldung findById(Integer id) {
		// TODO Auto-generated method stub
		return meldungDAO.findMeldungById(id);
	}

	@Override
	public List<Meldung> findAll() {
		// TODO Auto-generated method stub
		return meldungDAO.findAllMeldung();
	}

	@Override
	public List<Meldung> findAllMeldungByMangel(Mangel mangel) {
		// TODO Auto-generated method stub
		return meldungDAO.findAllMeldungByMangel(mangel);
	}
}