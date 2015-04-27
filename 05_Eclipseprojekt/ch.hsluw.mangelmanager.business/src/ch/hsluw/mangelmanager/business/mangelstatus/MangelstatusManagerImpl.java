/*
 * ZWECK: Mangelstatusmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.mangelstatus;

import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.persister.dao.MangelstatusDAO;
import ch.hsluw.mangelmanager.persister.dao.MangelstatusDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MangelstatusManager zur Verfügung.
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public class MangelstatusManagerImpl implements MangelstatusManager {

	private MangelstatusDAO mangelstatusDAO = new MangelstatusDAOImpl();

	@Override
	public Mangelstatus add(Mangelstatus entity) throws Exception {

		if (entity.getId() == null) {
			mangelstatusDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Mangelstatus update(Mangelstatus entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return mangelstatusDAO.update(entity);
		}
	}

	@Override
	public void delete(Mangelstatus entity) throws Exception {
		mangelstatusDAO.delete(entity);
	}
}