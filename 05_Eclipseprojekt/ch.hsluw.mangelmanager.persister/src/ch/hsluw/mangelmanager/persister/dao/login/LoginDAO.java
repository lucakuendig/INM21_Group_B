package ch.hsluw.mangelmanager.persister.dao.login;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import ch.hsluw.mangelmanager.model.Login;

/**
 * Interface fuer Login Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public interface LoginDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Login entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Login update(Login entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Login entity) throws Exception;
	
	void deleteLoginById(Integer id) throws Exception;

	/**
	 * Liefert die Login-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Login findLoginById(Integer id);

	/**
	 * Liefert alle Login-Objekte zurück.
	 * 
	 * @return
	 */
	List<Login> findAllLogin();

	Login findByName(String name);

}
