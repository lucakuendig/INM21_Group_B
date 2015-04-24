/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.persister.dao.MangelDAO;
import ch.hsluw.mangelmanager.persister.dao.MangelDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MangelManager zur Verfügung.
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public class MangelManagerImpl implements MangelManager {

	private MangelDAO mangelDAO = new MangelDAOImpl();

	@Override
	public Mangel add(Mangel entity) throws Exception {

		if (entity.getId() == null) {
			mangelDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Mangel update(Mangel entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return mangelDAO.update(entity);
		}
	}

	@Override
	public void delete(Mangel entity) throws Exception {
		mangelDAO.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		mangelDAO.deleteMangelById(id);
		
	}

	@Override
	public Mangel findById(Integer id) {
		return mangelDAO.findMangelById(id);
	}

	@Override
	public List<Mangel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangel> findByBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangel> findByMangelstatus(String mangelstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangel> findByErfassungsZeit(Date erfassungsZeit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangel> findByAbschlussZeit(Date abschlussZeit) {
		// TODO Auto-generated method stub
		return null;
	}
}