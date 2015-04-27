/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.arbeitstyp;
import java.util.List;

import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAO;
import ch.hsluw.mangelmanager.persister.dao.arbeitstyp.ArbeitstypDAOImpl;




/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ArbeitstypManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ArbeitstypManagerImpl implements ArbeitstypManager {

	private ArbeitstypDAO arbeitstypDAO = new ArbeitstypDAOImpl();

	@Override
	public Arbeitstyp add(Arbeitstyp entity) throws Exception {

		if (entity.getId() == null) {
			arbeitstypDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Arbeitstyp update(Arbeitstyp entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return arbeitstypDAO.update(entity);
		}
	}

	@Override
	public void delete(Arbeitstyp entity) throws Exception {
		arbeitstypDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		arbeitstypDAO.deleteArbeitstypById(id);
	}
	
	@Override
	public Arbeitstyp findById(Integer id) {
		return arbeitstypDAO.findArbeitstypById(id);
	}

	@Override
	public List<Arbeitstyp> findAll() {
		return arbeitstypDAO.findAllArbeitstyp();
	}
	
	@Override
	public List<Arbeitstyp> findByBezeichnung(String bezeichnung) {
		return arbeitstypDAO.findArbeitstypByBezeichnung(bezeichnung);
	}

	
}
