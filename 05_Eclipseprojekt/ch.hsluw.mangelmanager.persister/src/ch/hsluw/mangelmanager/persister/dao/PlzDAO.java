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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Plz entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Plz update(Plz entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Plz entity) throws Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deletePlzById(Integer id) throws Exception;
	
	/**
	 * Liefert die Plz-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Plz findPlzById(Integer id);

	/**
	 * Liefert alle Plz-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Plz> findAllPlz();


}
