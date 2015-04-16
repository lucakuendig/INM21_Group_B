package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ProjektDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Projekt entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projekt entity) throws Exception;
	
	void deleteProjektById(Integer id) throws Exception;

	/**
	 * Liefert die Projekt-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Projekt findProjektById(Integer id);

	/**
	 * Liefert alle Projekt-Objekte zurück.
	 * 
	 * @return
	 */
	List<Projekt> findAllProjekt();
}
