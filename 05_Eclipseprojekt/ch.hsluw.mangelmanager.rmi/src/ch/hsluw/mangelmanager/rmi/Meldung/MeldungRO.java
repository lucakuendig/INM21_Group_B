
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.Meldung;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.hsluw.mangelmanager.model.Meldung;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ObjekttypRO zur Verf�gung
 * 
 * @version 1.0
 * @author cdemir
 * 
 */

public interface MeldungRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldung add(Meldung entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldung update(Meldung entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Meldung entity) throws RemoteException, Exception;
	
	
	
}
