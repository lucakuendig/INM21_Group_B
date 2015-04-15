/*
 * ZWECK: Referenzprojekt
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Jordan Sucur - Februar 2015
 */
package ch.hsluw.mangelmanager.persister.dao;

import java.util.List;

/**
 * Interface f�r CRUD-Basisoperationen.
 * 
 * @author jsucur
 * @version 1.0
 *
 * @param <T>
 * 
 */
public interface GenericPersister<T> {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void save(T entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	T update(T entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(T entity) throws Exception;

	/**
	 * L�scht die Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;

	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	T findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<T> findAll();

}
