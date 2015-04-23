package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.List;

import ch.hsluw.mangelmanager.model.Projektstatus;

/**
 * Interface fuer Projektstatus Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ProjektstatusDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Projektstatus entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projektstatus update(Projektstatus entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projektstatus entity) throws Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteProjektstatusById(Integer id) throws Exception;
	
	/**
	 * Liefert die Projektstatus-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Projektstatus findProjektstatusById(Integer id);

	/**
	 * Liefert alle Projektstatus-Objekte zurück.
	 * 
	 * @return
	 */
	List<Projektstatus> findAllProjektstatus();


}
