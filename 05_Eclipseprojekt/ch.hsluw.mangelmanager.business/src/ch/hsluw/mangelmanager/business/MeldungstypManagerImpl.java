/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

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

	private MeldungstypDAO MeldungstypDAO = new MeldungstypDAOImpl();

	@Override
	public Meldungstyp add(Meldungstyp entity) throws Exception {

		if (entity.getId() == null) {
			MeldungstypDAO.save(entity);
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
			return MeldungstypDAO.update(entity);
		}
	}

	@Override
	public void delete(Meldungstyp entity) throws Exception {
		MeldungstypDAO.delete(entity);
	}
}