/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.SuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.SuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * SuMitarbeiterManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class SuMitarbeiterManagerImpl implements SuMitarbeiterManager {

	private SuMitarbeiterDAO suMitarbeiterDAO = new SuMitarbeiterDAOImpl();

	@Override
	public SuMitarbeiter add(SuMitarbeiter entity) throws Exception {

		if (entity.getId() == null) {
			suMitarbeiterDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public SuMitarbeiter update(SuMitarbeiter entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return suMitarbeiterDAO.update(entity);
		}
	}

	@Override
	public void delete(SuMitarbeiter entity) throws Exception {
		suMitarbeiterDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		suMitarbeiterDAO.deleteSuMitarbeiterById(id);
		
	}
	
	@Override
	public SuMitarbeiter findById(Integer id) {
		return suMitarbeiterDAO.findSuMitarbeiterById(id);
	}

	@Override
	public List<SuMitarbeiter> findAll() {
		return suMitarbeiterDAO.findAllSuMitarbeiter();
	}
}
