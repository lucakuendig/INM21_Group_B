/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.persister.dao.MeldungDAO;
import ch.hsluw.mangelmanager.persister.dao.MeldungDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungManager zur Verfügung.
 * 
 * @version 1.0
 * @author cdemir
 * 
 */
public class MeldungManagerImpl implements MeldungManager {

	private MeldungDAO MeldungDAO = new MeldungDAOImpl();

	@Override
	public Meldung add(Meldung entity) throws Exception {

		if (entity.getId() == null) {
			MeldungDAO.save(entity);
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
			return MeldungDAO.update(entity);
		}
	}

	@Override
	public void delete(Meldung entity) throws Exception {
		MeldungDAO.delete(entity);
	}
}