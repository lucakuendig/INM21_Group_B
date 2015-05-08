
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projekt;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektRO zur Verf�gung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface ProjektRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projekt add(Projekt entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Projekt entity) throws RemoteException, Exception;

	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Projekt findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByBezeichnung(String bezeichnung)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Projektstatus.
	 * 
	 * @param projektstatus
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByProjektstatus(String projektstatus)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByOrt(String ort)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebenen Postleitzahl.
	 * 
	 * @param plz
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByPlz(String plz)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Bauherren.
	 * 
	 * @param bauherr
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByBauherr(String bauherr)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Objekttyp.
	 * 
	 * @param objekttyp
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByObjekttyp(String objekttyp)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Arbeitstyp.
	 * 
	 * @param arbeitstyp
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByArbeitstyp(String arbeitstyp)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Zeitrahmen.
	 * 
	 * @param fromDatum
	 * @param endDatum
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByDatumFromTillEnd(Date fromDatum, Date endDatum)
			throws RemoteException;

	List<Projekt> findAllSubunternehmenProjekt(Subunternehmen subunternehmen2) throws RemoteException;

}