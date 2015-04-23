/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.GuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.GuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * GuMitarbeiterManager zur Verf�gung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class GuMitarbeiterManagerImpl implements GuMitarbeiterManager {

	private GuMitarbeiterDAO guMitarbeiterDAO = new GuMitarbeiterDAOImpl();

	@Override
	public GuMitarbeiter add(GuMitarbeiter entity) throws Exception {

		if (entity.getId() == null) {
			guMitarbeiterDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public GuMitarbeiter update(GuMitarbeiter entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return guMitarbeiterDAO.update(entity);
		}
	}

	@Override
	public void delete(GuMitarbeiter entity) throws Exception {
		guMitarbeiterDAO.delete(entity);
	}
}
