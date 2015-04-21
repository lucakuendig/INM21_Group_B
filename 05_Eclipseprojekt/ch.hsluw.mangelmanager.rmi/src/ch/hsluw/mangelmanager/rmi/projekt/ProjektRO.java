
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



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektRO zur Verfügung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface ProjektRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projekt add(Projekt entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projekt update(Projekt entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Projekt entity) throws RemoteException, Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Projekt findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für die übergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByBezeichnung(String bezeichnung)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Projektstatus.
	 * 
	 * @param projektstatus
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByProjektstatus(String projektstatus)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Projekten für den übergebenen Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByOrt(String ort)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für die übergebenen Postleitzahl.
	 * 
	 * @param plz
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByPlz(String plz)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Bauherren.
	 * 
	 * @param bauherr
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByBauherr(String bauherr)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Objekttyp.
	 * 
	 * @param objekttyp
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByObjekttyp(String objekttyp)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Arbeitstyp.
	 * 
	 * @param arbeitstyp
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByArbeitstyp(String arbeitstyp)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Zeitrahmen.
	 * 
	 * @param fromDatum
	 * @param endDatum
	 * @return
	 * @throws RemoteException
	 */
	List<Projekt> findByDatumFromTillEnd(Date fromDatum, Date endDatum)
			throws RemoteException;

}