/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.gumitarbeiter;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.gumitarbeiter.GuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.gumitarbeiter.GuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * GuMitarbeiterManager zur Verfügung.
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
	
	@Override
	public void deleteById(Integer id) throws Exception {
		guMitarbeiterDAO.deleteGuMitarbeiterById(id);
		
	}
	
	@Override
	public GuMitarbeiter findById(Integer id) {
		return guMitarbeiterDAO.findGuMitarbeiterById(id);
	}

	@Override
	public List<GuMitarbeiter> findAll() {
		return guMitarbeiterDAO.findAllGuMitarbeiter();
	}
}
