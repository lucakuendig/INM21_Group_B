/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.login;
import java.util.List;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.persister.dao.login.LoginDAO;
import ch.hsluw.mangelmanager.persister.dao.login.LoginDAOImpl;



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

	@Override
	public void deleteById(Integer id) throws Exception {
		loginDAO.deleteLoginById(id);
		
	}
	
	@Override
	public Login findById(Integer id) {
		return loginDAO.findLoginById(id);
	}

	@Override
	public List<Login> findAll() {
		return loginDAO.findAllLogin();
	}
}
