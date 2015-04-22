
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.rolle;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Rolle;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * RolleRO zur Verfügung
 * 
 * @version 1.0
 * @author miten
 * 
 */

public interface RolleRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Rolle add(Rolle entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Rolle update(Rolle entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Rolle entity) throws RemoteException, Exception;

}