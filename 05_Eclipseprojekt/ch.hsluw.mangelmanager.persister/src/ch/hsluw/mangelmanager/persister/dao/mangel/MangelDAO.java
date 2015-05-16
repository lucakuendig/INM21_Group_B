package ch.hsluw.mangelmanager.persister.dao.mangel;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

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
public interface MangelDAO {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void save(Mangel entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangel update(Mangel entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Mangel entity) throws Exception;

	void deleteMangelById(Integer id) throws Exception;

	/**
	 * Liefert die Mangel-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Mangel findMangelById(Integer id);

	/**
	 * Liefert alle Mangel-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Mangel> findAllMangel();

	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene Bezeichnung zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Mangel> findMangelByBezeichnung(String bezeichnung);

	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Namen zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mangel> findMangelByName(String name);

	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene Erfassungszeit zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param erfassungszeit
	 * @return
	 */
	public List<Mangel> findMangelByErfassungszeit(Date erfassungsZeit);

	/**
	 * Liefert die Liste mit M�ngeln f�r das �bergebene Faelligkeitsdatum
	 * zur�ck, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 */
	public List<Mangel> findMangelByFaelligkeitsDatum(Date faelligkeitsDatum);

	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Mangelstatus zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param mangelstatus
	 * @return
	 */
	public List<Mangel> findMangelByMangelstatus(String mangelstatus);

	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene AbschlussZeit zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param abschlussZeit
	 * @return
	 */
	public List<Mangel> findMangelByAbschlussZeit(Date abschlussZeit);
	
	/**
	 * Liefert alle M�ngel vom Projekt
	 * @param projekt
	 * @return
	 */
	public List<Mangel> findAllMangelProjekt(Integer projekt);


}
