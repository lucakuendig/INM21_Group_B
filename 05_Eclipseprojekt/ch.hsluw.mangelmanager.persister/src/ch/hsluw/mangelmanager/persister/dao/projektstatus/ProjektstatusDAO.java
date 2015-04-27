package ch.hsluw.mangelmanager.persister.dao.projektstatus;

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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Projektstatus entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projektstatus update(Projektstatus entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projektstatus entity) throws Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteProjektstatusById(Integer id) throws Exception;
	
	/**
	 * Liefert die Projektstatus-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Projektstatus findProjektstatusById(Integer id);

	/**
	 * Liefert alle Projektstatus-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Projektstatus> findAllProjektstatus();


}
