package ch.hsluw.mangelmanager.persister.dao.subunternehmen;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.Date;
import java.util.List;

import javafx.beans.value.ObservableValue;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * Interface fuer Subunternehmen Entity
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */
public interface SubunternehmenDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Subunternehmen entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void update(Subunternehmen entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Subunternehmen entity) throws Exception;
	
	void deleteSubunternehmenById(Integer id) throws Exception;

	/**
	 * Liefert die Subunternehmen-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Subunternehmen findSubunternehmenById(Integer id);

	/**
	 * Liefert alle Subunternehmen-Objekte zurück.
	 * 
	 * @return
	 */
	List<Subunternehmen> findAllSubunternehmen();


	String findAllProjekte(int subunternehmen);

	List<SuMitarbeiter> findAllSubunternehmenMitarbeiter(Subunternehmen subunternehmen);

	List<Subunternehmen> findAllSubunternehmenByProjekt(Integer projekt2);
}