/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.objekttyp;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAO;
import ch.hsluw.mangelmanager.persister.dao.objekttyp.ObjekttypDAOImpl;




/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ObjekttypManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class ObjekttypManagerImpl implements ObjekttypManager {

	private ObjekttypDAO objekttypDAO = new ObjekttypDAOImpl();

	@Override
	public Objekttyp add(Objekttyp entity) throws Exception {

		if (entity.getId() == null) {
			objekttypDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Objekttyp update(Objekttyp entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return objekttypDAO.update(entity);
		}
	}

	@Override
	public void delete(Objekttyp entity) throws Exception {
		objekttypDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		objekttypDAO.deleteObjekttypById(id);
	}
	
	@Override
	public Objekttyp findById(Integer id) {
		return objekttypDAO.findObjekttypById(id);
	}

	@Override
	public List<Objekttyp> findAll() {
		return objekttypDAO.findAllObjekttyp();
	}
	
	@Override
	public List<Objekttyp> findByBezeichnung(String bezeichnung) {
		return objekttypDAO.findObjekttypByBezeichnung(bezeichnung);
	}

	
}
