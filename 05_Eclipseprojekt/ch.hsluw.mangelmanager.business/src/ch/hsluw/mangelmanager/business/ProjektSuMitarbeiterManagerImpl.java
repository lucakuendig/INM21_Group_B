/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.persister.dao.ProjektSuMitarbeiterDAO;
import ch.hsluw.mangelmanager.persister.dao.ProjektSuMitarbeiterDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektSuMitarbeiterManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ProjektSuMitarbeiterManagerImpl implements ProjektSuMitarbeiterManager {

	private ProjektSuMitarbeiterDAO projektSuMitarbeiterDAO = new ProjektSuMitarbeiterDAOImpl();

	@Override
	public ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws Exception {

		if (entity.getFkSuMitarbeiter() == null && entity.getFkProjekt() == null) {
			projektSuMitarbeiterDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (SuMitarbeiter = "
							+ entity.getFkSuMitarbeiter().getNachname()+" Projekt= " + entity.getFkProjekt().getBezeichnung() + ")");
		}
	}

	@Override
	public ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception {

		if (entity.getFkSuMitarbeiter() == null && entity.getFkProjekt() == null) {
			return add(entity);
		} else {
			return projektSuMitarbeiterDAO.update(entity);
		}
	}

	@Override
	public void delete(ProjektSuMitarbeiter entity) throws Exception {
		projektSuMitarbeiterDAO.delete(entity);
	}
}
