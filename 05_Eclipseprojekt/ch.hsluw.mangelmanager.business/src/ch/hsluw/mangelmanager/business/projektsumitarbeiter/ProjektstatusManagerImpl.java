/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projektsumitarbeiter;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projektstatus;
import ch.hsluw.mangelmanager.persister.dao.ProjektstatusDAO;
import ch.hsluw.mangelmanager.persister.dao.ProjektstatusDAOImpl;





/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektstatusManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektstatusManagerImpl implements ProjektstatusManager {

	private ProjektstatusDAO projektstatusDAO = new ProjektstatusDAOImpl();

	@Override
	public Projektstatus add(Projektstatus entity) throws Exception {

		if (entity.getId() == null) {
			projektstatusDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Projektstatus update(Projektstatus entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return projektstatusDAO.update(entity);
		}
	}

	@Override
	public void delete(Projektstatus entity) throws Exception {
		projektstatusDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		projektstatusDAO.deleteProjektstatusById(id);
	}
	
	@Override
	public Projektstatus findById(Integer id) {
		return projektstatusDAO.findProjektstatusById(id);
	}

	@Override
	public List<Projektstatus> findAll() {
		return projektstatusDAO.findAllProjektstatus();
	}
	

	
}
