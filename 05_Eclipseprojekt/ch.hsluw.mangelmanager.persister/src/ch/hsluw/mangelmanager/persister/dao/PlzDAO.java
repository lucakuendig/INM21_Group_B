package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Plz;

/**
 * Interface fuer Plz Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface PlzDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Plz entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Plz update(Plz entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Plz entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deletePlzById(Integer id) throws Exception;
	
	/**
	 * Liefert die Plz-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Plz findPlzById(Integer id);

	/**
	 * Liefert alle Plz-Objekte zurück.
	 * 
	 * @return
	 */
	List<Plz> findAllPlz();


}
