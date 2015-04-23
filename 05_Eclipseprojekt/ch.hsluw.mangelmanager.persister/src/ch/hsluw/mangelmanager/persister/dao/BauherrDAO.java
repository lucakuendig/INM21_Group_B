package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Bauherr;

/**
 * Interface fuer Bauherr Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface BauherrDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Bauherr entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Bauherr update(Bauherr entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Bauherr entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteBauherrById(Integer id) throws Exception;
	
	/**
	 * Liefert die Bauherr-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Bauherr findBauherrById(Integer id);

	/**
	 * Liefert alle Bauherr-Objekte zurück.
	 * 
	 * @return
	 */
	List<Bauherr> findAllBauherr();


}
