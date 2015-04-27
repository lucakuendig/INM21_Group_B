package ch.hsluw.mangelmanager.persister.dao.projektgumitarbeiter;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;

/**
 * Interface fuer ProjektGuMitarbeiterGuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface ProjektGuMitarbeiterDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektGuMitarbeiter entity) throws Exception;
	
	void deleteProjektGuMitarbeiterById( Integer idprojekt, Integer idguMitarbeiter) throws Exception;

	/**
	 * Liefert die ProjektGuMitarbeiter-Entity f�r die uebergebenen Werte zur�ck.
	 * 
	 * @param idprojekt
	 * @param idguMitarbeiter
	 * @return
	 */
	ProjektGuMitarbeiter findProjektGuMitarbeiterById(Integer idprojekt, Integer idguMitarbeiter);

	/**
	 * Liefert alle ProjektGuMitarbeiter-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<ProjektGuMitarbeiter> findAllProjektGuMitarbeiter();
}