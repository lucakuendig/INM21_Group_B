
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.objekttyp;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Objekttyp;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ObjekttypRO zur Verfügung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface ObjekttypRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Objekttyp add(Objekttyp entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Objekttyp update(Objekttyp entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Objekttyp entity) throws RemoteException, Exception;

	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Objekttyp findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Objekttyp> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit Objekttypen für die übergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Objekttyp> findByBezeichnung(String bezeichnung)
			throws RemoteException;
}