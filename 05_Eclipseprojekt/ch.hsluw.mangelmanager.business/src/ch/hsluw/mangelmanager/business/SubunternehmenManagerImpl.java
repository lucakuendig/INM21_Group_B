/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.persister.dao.SubunternehmenDAO;
import ch.hsluw.mangelmanager.persister.dao.SubunternehmenDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * SubunternehmenManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class SubunternehmenManagerImpl implements SubunternehmenManager {

	private SubunternehmenDAO subunternehmenDAO = new SubunternehmenDAOImpl();

	@Override
	public Subunternehmen add(Subunternehmen entity) throws Exception {

		if (entity.getId() == null) {
			subunternehmenDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Subunternehmen update(Subunternehmen entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return subunternehmenDAO.update(entity);
		}
	}

	@Override
	public void delete(Subunternehmen entity) throws Exception {
		subunternehmenDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		subunternehmenDAO.deleteSubunternehmenById(id);
		
	}
	
	@Override
	public Subunternehmen findById(Integer id) {
		return subunternehmenDAO.findSubunternehmenById(id);
	}

	@Override
	public List<Subunternehmen> findAll() {
		return subunternehmenDAO.findAllSubunternehmen();
	}
}
