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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Adresse entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Adresse update(Adresse entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Adresse entity) throws Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteAdresseById(Integer id) throws Exception;
	
	/**
	 * Liefert die Adresse-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Adresse findAdresseById(Integer id);

	/**
	 * Liefert alle Adresse-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Adresse> findAllAdresse();


}
