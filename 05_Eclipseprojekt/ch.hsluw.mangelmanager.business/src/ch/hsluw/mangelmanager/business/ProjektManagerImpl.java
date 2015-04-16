/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.dao.ProjektDAO;
import ch.hsluw.mangelmanager.persister.dao.ProjektDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektManagerImpl implements ProjektManager {

	private ProjektDAO projektDAO = new ProjektDAOImpl();

	@Override
	public Projekt add(Projekt entity) throws Exception {

		if (entity.getId() == null) {
			projektDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Projekt update(Projekt entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return projektDAO.update(entity);
		}
	}

	@Override
	public void delete(Projekt entity) throws Exception {
		projektDAO.delete(entity);
	}
	
	@Override
	public Projekt findById(Integer id) {
		return projektDAO.findProjektById(id);
	}

	@Override
	public List<Projekt> findAll() {
		return projektDAO.findAllProjekt();
	}




}
