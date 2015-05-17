package ch.hsluw.mangelmanager.persister.dao.projektsumitarbeiter;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

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
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(ProjektSuMitarbeiter entity) throws Exception;
	
	void deleteProjektSuMitarbeiterById( Integer idprojekt, Integer idguMitarbeiter) throws Exception;

	/**
	 * Liefert die ProjektSuMitarbeiter-Entity f�r die uebergebenen Werte zur�ck.
	 * 
	 * @param idprojekt
	 * @param idguMitarbeiter
	 * @return
	 */
	ProjektSuMitarbeiter findProjektSuMitarbeiterById(Integer idprojekt, Integer idguMitarbeiter);

	/**
	 * Liefert alle ProjektSuMitarbeiter-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<ProjektSuMitarbeiter> findAllProjektSuMitarbeiter();
}