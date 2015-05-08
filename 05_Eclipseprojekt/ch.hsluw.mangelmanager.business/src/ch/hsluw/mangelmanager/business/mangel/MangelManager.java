/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.mangel;

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * Interface fuer Mangel Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public interface MangelManager {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangel add(Mangel entity) throws Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangel update(Mangel entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Mangel entity) throws Exception;

	/**
	 * Löscht die Entity mit übergebener Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Mangel findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 */
	List<Mangel> findAll();

	/**
	 * Liefert die Liste mit Mängeln für die übergebene Bezeichnung zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	List<Mangel> findByBezeichnung(String bezeichnung);

	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Mangelstatus zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param mangelstatus
	 * @return
	 */
	List<Mangel> findByMangelstatus(String mangelstatus);

	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Erfassungszeit zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param erfassungsZeit
	 * @return
	 */
	List<Mangel> findByErfassungsZeit(Date erfassungsZeit);

	/**
	 * Liefert die Liste mit Mängeln für die übergebene Faelligkeitsdatum zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 */
	List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum);

	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Abschlusszeit zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param AbschlussZeit
	 * @return
	 */
	List<Mangel> findByAbschlussZeit(Date abschlussZeit);

	/** Liefer die Liste mit Mängeln für den übergebenen Namen zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * @param name
	 * @return
	 */
	List<Mangel> findByName(String name);
	
	/**
	 * Liefert alle Mängel vom Projekt
	 * @param projekt
	 * @return
	 */
	List<Mangel> findAllMangelProjekt(Projekt projekt);

}
