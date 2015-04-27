/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business.mangel;

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
public interface MangelManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Mangel add(Mangel entity) throws Exception;

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

	/**
	 * L�scht die Entity mit �bergebener Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;

	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	Mangel findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Mangel> findAll();

	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene Bezeichnung zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	List<Mangel> findByBezeichnung(String bezeichnung);

	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Mangelstatus zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param mangelstatus
	 * @return
	 */
	List<Mangel> findByMangelstatus(String mangelstatus);

	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Erfassungszeit zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param erfassungsZeit
	 * @return
	 */
	List<Mangel> findByErfassungsZeit(Date erfassungsZeit);

	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene Faelligkeitsdatum zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 */
	List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum);

	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Abschlusszeit zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param AbschlussZeit
	 * @return
	 */
	List<Mangel> findByAbschlussZeit(Date abschlussZeit);

	/** Liefer die Liste mit M�ngeln f�r den �bergebenen Namen zur�ck,
	 * falls welche gefunden, sonst eine leere Liste.
	 * @param name
	 * @return
	 */
	List<Mangel> findByName(String name);

}
