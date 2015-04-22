
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.arbeitstyp;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Arbeitstyp;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ArbeitstypRO zur Verfügung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface ArbeitstypRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Arbeitstyp add(Arbeitstyp entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Arbeitstyp update(Arbeitstyp entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Arbeitstyp entity) throws RemoteException, Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	
	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	Arbeitstyp findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Arbeitstyp> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit Arbeitstypen für die übergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Arbeitstyp> findByBezeichnung(String bezeichnung)
			throws RemoteException;
}