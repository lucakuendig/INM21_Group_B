
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.adresse;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Adresse;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * AdresseRO zur Verfügung
 * 
 * @version 1.0
 * @author sritz
 * 
 */

public interface AdresseRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Adresse add(Adresse entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Adresse update(Adresse entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Adresse entity) throws RemoteException, Exception;

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
	
	Adresse findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Adresse> findAll() throws RemoteException;
}