/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.bauherr;
import java.util.List;

import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAO;
import ch.hsluw.mangelmanager.persister.dao.bauherr.BauherrDAOImpl;





/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * BauherrManager zur Verfügung.
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public class BauherrManagerImpl implements BauherrManager {

	private BauherrDAO adresseDAO = new BauherrDAOImpl();

	@Override
	public Bauherr add(Bauherr entity) throws Exception {

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
	public Bauherr update(Bauherr entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return adresseDAO.update(entity);
		}
	}

	@Override
	public void delete(Bauherr entity) throws Exception {
		adresseDAO.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		adresseDAO.deleteBauherrById(id);
	}
	
	@Override
	public Bauherr findById(Integer id) {
		return adresseDAO.findBauherrById(id);
	}

	@Override
	public List<Bauherr> findAll() {
		return adresseDAO.findAllBauherr();
	}
	

	
}
