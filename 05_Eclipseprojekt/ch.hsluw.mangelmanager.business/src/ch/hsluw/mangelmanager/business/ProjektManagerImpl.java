/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.persister.dao.ProjektDAO;
import ch.hsluw.mangelmanager.persister.dao.ProjektDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektManager zur Verf�gung.
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
	
	@Override
	public List<Projekt> findByBezeichnung(String bezeichnung) {
		return projektDAO.findProjektByBezeichnung(bezeichnung);
	}
	
	@Override
	public List<Projekt> findByProjektstatus(String projektstatus) {
		return projektDAO.findProjektByProjektstatus(projektstatus);
	}
	
	@Override
	public List<Projekt> findByOrt(String ort) {
		return projektDAO.findProjektByOrt(ort);
	}
	
	@Override
	public List<Projekt> findByPlz(String plz) {
		return projektDAO.findProjektByPlz(plz);
	}
	
	@Override
	public List<Projekt> findByBauherr(String bauherr) {
		return projektDAO.findProjektByBauherr(bauherr);
	}
	
	@Override
	public List<Projekt> findByObjekttyp(String objekttyp) {
		return projektDAO.findProjektByObjekttyp(objekttyp);
	}
	
	@Override
	public List<Projekt> findByArbeitstyp(String arbeitstyp) {
		return projektDAO.findProjektByObjekttyp(arbeitstyp);
	}
	
	@Override
	public List<Projekt> findByDatumFromTillEnd(Date fromDatum, Date endDatum) {
		return projektDAO.findProjektByDatumFromTillEnd(fromDatum, endDatum);
	}




}
