package ch.hsluw.mangelmanager.persister.dao;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;

/**
 * Interface fuer ProjektSuMitarbeiter Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface ProjektSuMitarbeiterDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektSuMitarbeiter entity) throws Exception;
	
	void deleteProjektSuMitarbeiterById( Integer idprojekt, Integer idguMitarbeiter) throws Exception;

	/**
	 * Liefert die ProjektSuMitarbeiter-Entity für die uebergebenen Werte zurück.
	 * 
	 * @param idprojekt
	 * @param idguMitarbeiter
	 * @return
	 */
	ProjektSuMitarbeiter findProjektSuMitarbeiterById(Integer idprojekt, Integer idguMitarbeiter);

	/**
	 * Liefert alle ProjektSuMitarbeiter-Objekte zurück.
	 * 
	 * @return
	 */
	List<ProjektSuMitarbeiter> findAllProjektSuMitarbeiter();
}