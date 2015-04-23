
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektstatus;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Projektstatus;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektstatusRO zur Verfügung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface ProjektstatusRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projektstatus add(Projektstatus entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Projektstatus update(Projektstatus entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Projektstatus entity) throws RemoteException, Exception;

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
	
	Projektstatus findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Projektstatus> findAll() throws RemoteException;
}