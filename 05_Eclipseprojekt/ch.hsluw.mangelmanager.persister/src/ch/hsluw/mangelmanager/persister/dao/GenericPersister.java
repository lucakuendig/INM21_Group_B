/*
 * ZWECK: Referenzprojekt
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Jordan Sucur - Februar 2015
 */
package ch.hsluw.mangelmanager.persister.dao;

import java.util.List;

/**
 * Interface für CRUD-Basisoperationen.
 * 
 * @author jsucur
 * @version 1.0
 *
 * @param <T>
 * 
 */
public interface GenericPersister<T> {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void save(T entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	T update(T entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(T entity) throws Exception;

	/**
	 * Löscht die Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	T findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<T> findAll();

}
