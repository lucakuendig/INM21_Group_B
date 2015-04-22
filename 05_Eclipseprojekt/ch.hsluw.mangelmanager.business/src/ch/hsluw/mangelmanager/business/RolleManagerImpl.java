/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.persister.dao.RolleDAO;
import ch.hsluw.mangelmanager.persister.dao.RolleDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * RolleManager zur Verfügung.
 * 
 * @version 1.0
 * @author miten
 * 
 */
public class RolleManagerImpl implements RolleManager {

	private RolleDAO rolleDAO = new RolleDAOImpl();

	@Override
	public Rolle add(Rolle entity) throws Exception {

		if (entity.getId() == null) {
			rolleDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Rolle update(Rolle entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return rolleDAO.update(entity);
		}
	}

	@Override
	public void delete(Rolle entity) throws Exception {
		rolleDAO.delete(entity);
	}
	
}
