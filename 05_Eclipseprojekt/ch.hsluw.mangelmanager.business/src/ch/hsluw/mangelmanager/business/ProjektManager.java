/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.business;

import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;

/**
 * Interface fuer Projekt Entity
 * 
 * @version 1.0
 * @author sritz
 * 
 */
public interface ProjektManager {
	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt add(Projekt entity) throws Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(Projekt entity) throws Exception;
	
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
	Projekt findById(Integer id);

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Projekt> findAll();
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebene Bezeichnung zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	List<Projekt> findByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Projektstatus zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param projektstatus
	 * @return
	 */
	List<Projekt> findByProjektstatus(String projektstatus);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Ort zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	List<Projekt> findByOrt(String ort);
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebene Plz zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param plz
	 * @return
	 */
	List<Projekt> findByPlz(String plz);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Bauherren zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param bauherr
	 * @return
	 */
	List<Projekt> findByBauherr(String bauherr);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Objekttyp zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param objekttyp
	 * @return
	 */
	List<Projekt> findByObjekttyp(String objekttyp);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Arbeitstyp zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param arbeitstyp
	 * @return
	 */
	List<Projekt> findByArbeitstyp(String arbeitstyp);
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Zeitrahmen zur�ck, falls
	 * welche gefunden, sonst eine leere Liste.
	 * 
	 * @param fromDatum
	 * @param endDatum
	 * @return
	 */
	List<Projekt> findByDatumFromTillEnd(Date fromDatum, Date endDatum);

	
}

