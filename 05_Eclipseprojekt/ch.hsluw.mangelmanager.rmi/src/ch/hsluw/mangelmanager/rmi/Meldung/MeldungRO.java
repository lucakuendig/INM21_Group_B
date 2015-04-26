/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.meldung;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Meldung;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungRO zur Verfügung
 * 
 * @version 1.0
 * @author cdemir
 * 
 */

public interface MeldungRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldung add(Meldung entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldung update(Meldung entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Meldung entity) throws RemoteException, Exception;
	
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
	Meldung findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Meldungen zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Meldung> findAll() throws RemoteException;
	
}
