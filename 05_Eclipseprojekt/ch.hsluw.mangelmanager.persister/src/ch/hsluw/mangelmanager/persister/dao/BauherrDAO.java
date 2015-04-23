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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Bauherr entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Bauherr update(Bauherr entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Bauherr entity) throws Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteBauherrById(Integer id) throws Exception;
	
	/**
	 * Liefert die Bauherr-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Bauherr findBauherrById(Integer id);

	/**
	 * Liefert alle Bauherr-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Bauherr> findAllBauherr();


}
