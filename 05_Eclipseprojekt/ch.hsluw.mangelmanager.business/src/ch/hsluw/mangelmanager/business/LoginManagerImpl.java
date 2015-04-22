/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.persister.dao.LoginDAO;
import ch.hsluw.mangelmanager.persister.dao.LoginDAOImpl;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * LoginManager zur Verfügung.
 * 
 * @version 1.0
 * @author miten
 * 
 */
public class LoginManagerImpl implements LoginManager {

	private LoginDAO loginDAO = new LoginDAOImpl();

	@Override
	public Login add(Login entity) throws Exception {

		if (entity.getId() == null) {
			loginDAO.save(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId() + ")");
		}
	}

	@Override
	public Login update(Login entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return loginDAO.update(entity);
		}
	}

	@Override
	public void delete(Login entity) throws Exception {
		loginDAO.delete(entity);
	}

}
