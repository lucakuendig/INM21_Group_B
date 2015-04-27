package ch.hsluw.mangelmanager.persister.dao.adresse;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Adresse;

/**
 * Interface fuer Adresse Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface AdresseDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Adresse entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Adresse update(Adresse entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Adresse entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteAdresseById(Integer id) throws Exception;
	
	/**
	 * Liefert die Adresse-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Adresse findAdresseById(Integer id);

	/**
	 * Liefert alle Adresse-Objekte zurück.
	 * 
	 * @return
	 */
	List<Adresse> findAllAdresse();


}
