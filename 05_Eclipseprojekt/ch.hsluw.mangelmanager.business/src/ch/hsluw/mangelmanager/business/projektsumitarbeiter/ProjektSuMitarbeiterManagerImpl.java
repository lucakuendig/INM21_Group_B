/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.projektsumitarbeiter;
import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.projektsumitarbeiter.ProjektSuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.projektsumitarbeiter.ProjektSuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektSuMitarbeiterManager zur Verfüsung.
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public class ProjektSuMitarbeiterManagerImpl implements ProjektSuMitarbeiterManager {

	private ProjektSuMitarbeiterDAO projektSuMitarbeiterDAO = new ProjektSuMitarbeiterDAOImpl();

	@Override
	public ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws Exception {

		if (entity.getFkMitarbeiter() == null && entity.getFkProjekt() == null) {
			projektSuMitarbeiterDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (SuMitarbeiter = "
							+ entity.getFkMitarbeiter().getNachname()+" Projekt= " + entity.getFkProjekt().getBezeichnung() + ")");
		}
	}

	@Override
	public ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception {

		if (entity.getFkMitarbeiter() == null && entity.getFkProjekt() == null) {
			return add(entity);
		} else {
			return projektSuMitarbeiterDAO.update(entity);
		}
	}

	@Override
	public void delete(ProjektSuMitarbeiter entity) throws Exception {
		projektSuMitarbeiterDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception {
		projektSuMitarbeiterDAO.deleteProjektSuMitarbeiterById(idProjekt, idMitarbeiter);
		
	}
	
	@Override
	public ProjektSuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) {
		return projektSuMitarbeiterDAO.findProjektSuMitarbeiterById(idProjekt, idMitarbeiter);
	}

	@Override
	public List<ProjektSuMitarbeiter> findAll() {
		return projektSuMitarbeiterDAO.findAllProjektSuMitarbeiter();
	}
}
