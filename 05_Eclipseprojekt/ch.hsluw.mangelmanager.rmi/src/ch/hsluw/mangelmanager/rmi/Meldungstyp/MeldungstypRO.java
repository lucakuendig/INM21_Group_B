
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.Meldungstyp;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.hsluw.mangelmanager.model.Meldungstyp;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ObjekttypRO zur Verfügung
 * 
 * @version 1.0
 * @author cdemir
 * 
 */

public interface MeldungstypRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldungstyp add(Meldungstyp entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldungstyp update(Meldungstyp entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Meldungstyp entity) throws RemoteException, Exception;
	
	
	
}
