/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.adresse;
import java.util.List;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.persister.dao.AdresseDAO;
import ch.hsluw.mangelmanager.persister.dao.AdresseDAOImpl;





/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * AdresseManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class AdresseManagerImpl implements AdresseManager {

	private AdresseDAO adresseDAO = new AdresseDAOImpl();

	@Override
	public Adresse add(Adresse entity) throws Exception {

		if (entity.getId() == null) {
			adresseDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Adresse update(Adresse entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return adresseDAO.update(entity);
		}
	}

	@Override
	public void delete(Adresse entity) throws Exception {
		adresseDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		adresseDAO.deleteAdresseById(id);
	}
	
	@Override
	public Adresse findById(Integer id) {
		return adresseDAO.findAdresseById(id);
	}

	@Override
	public List<Adresse> findAll() {
		return adresseDAO.findAllAdresse();
	}
	

	
}
