/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.plz;
import java.util.List;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.persister.dao.AdresseDAO;
import ch.hsluw.mangelmanager.persister.dao.AdresseDAOImpl;
import ch.hsluw.mangelmanager.persister.dao.PlzDAO;
import ch.hsluw.mangelmanager.persister.dao.PlzDAOImpl;





/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * PlzManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class PlzManagerImpl implements PlzManager {

	private PlzDAO plzDAO = new PlzDAOImpl();

	@Override
	public Plz add(Plz entity) throws Exception {

		if (entity.getPlz() == null) {
			plzDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getPlz() + ")");
		}
	}

	@Override
	public Plz update(Plz entity) throws Exception {

		if (entity.getPlz() == null) {
			return add(entity);
		} else {
			return plzDAO.update(entity);
		}
	}

	@Override
	public void delete(Plz entity) throws Exception {
		plzDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		plzDAO.deletePlzById(id);
	}
	
	@Override
	public Plz findById(Integer id) {
		return plzDAO.findPlzById(id);
	}

	@Override
	public List<Plz> findAll() {
		return plzDAO.findAllPlz();
	}
	

	
}
