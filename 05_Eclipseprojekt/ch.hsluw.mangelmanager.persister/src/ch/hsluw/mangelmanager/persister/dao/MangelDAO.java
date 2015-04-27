package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;

/**
 * Interface fuer Mangel Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public interface MangelDAO {
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Mangel entity) throws Exception;

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

	void deleteMangelById(Integer id) throws Exception;

	/**
	 * Liefert die Mangel-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	Mangel findMangelById(Integer id);

	/**
	 * Liefert alle Mangel-Objekte zurück.
	 * 
	 * @return
	 */
	List<Mangel> findAllMangel();

	/**
	 * Liefert die Liste mit Mängeln für die übergebene Bezeichnung zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Mangel> findMangelByBezeichnung(String bezeichnung);

	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Namen zurück, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mangel> findMangelByName(String name);

	/**
	 * Liefert die Liste mit Mängeln für die übergebene Erfassungszeit zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param erfassungszeit
	 * @return
	 */
	public List<Mangel> findMangelByErfassungszeit(Date erfassungsZeit);

	/**
	 * Liefert die Liste mit Mängeln für das übergebene Faelligkeitsdatum
	 * zurück, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 */
	public List<Mangel> findMangelByFaelligkeitsDatum(Date faelligkeitsDatum);

	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Mangelstatus zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param mangelstatus
	 * @return
	 */
	public List<Mangel> findMangelByMangelstatus(String mangelstatus);

	/**
	 * Liefert die Liste mit Mängeln für die übergebene AbschlussZeit zurück,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param abschlussZeit
	 * @return
	 */
	public List<Mangel> findMangelByAbschlussZeit(Date abschlussZeit);


}
