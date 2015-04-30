/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projektgumitarbeiter;
import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.projektgumitarbeiter.ProjektGuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.projektgumitarbeiter.ProjektGuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektGuMitarbeiterManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektGuMitarbeiterManagerImpl implements ProjektGuMitarbeiterManager {

	private ProjektGuMitarbeiterDAO projektGuMitarbeiterDAO = new ProjektGuMitarbeiterDAOImpl();

	@Override
	public ProjektGuMitarbeiter add(ProjektGuMitarbeiter entity) throws Exception {

		if (entity.getFkMitarbeiter() == null && entity.getFkProjekt() == null) {
			projektGuMitarbeiterDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (GuMitarbeiter = "
							+ entity.getFkMitarbeiter().getNachname()+" Projekt= " + entity.getFkProjekt().getBezeichnung() + ")");
		}
	}

	@Override
	public ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws Exception {

		if (entity.getFkMitarbeiter() == null && entity.getFkProjekt() == null) {
			return add(entity);
		} else {
			return projektGuMitarbeiterDAO.update(entity);
		}
	}

	@Override
	public void delete(ProjektGuMitarbeiter entity) throws Exception {
		projektGuMitarbeiterDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception {
		projektGuMitarbeiterDAO.deleteProjektGuMitarbeiterById(idProjekt, idMitarbeiter);
		
	}
	
	@Override
	public ProjektGuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) {
		return projektGuMitarbeiterDAO.findProjektGuMitarbeiterById(idProjekt, idMitarbeiter);
	}

	@Override
	public List<ProjektGuMitarbeiter> findAll() {
		return projektGuMitarbeiterDAO.findAllProjektGuMitarbeiter();
	}
}
