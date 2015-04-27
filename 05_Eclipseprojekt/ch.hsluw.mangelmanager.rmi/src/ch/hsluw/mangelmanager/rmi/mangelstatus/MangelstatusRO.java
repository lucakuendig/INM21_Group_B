
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.mangelstatus;


import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.hsluw.mangelmanager.model.Mangelstatus;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MangelRO zur Verf�gung
 * 
 * @version 1.0
 * @author mmont
 * 
 */

public interface MangelstatusRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangelstatus add(Mangelstatus entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangelstatus update(Mangelstatus entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Mangelstatus entity) throws RemoteException, Exception;

	

}