/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.gumitarbeiter;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * GuMitarbeiterRO zur Verf�gung
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */

public interface GuMitarbeiterRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	GuMitarbeiter add(GuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	GuMitarbeiter update(GuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(GuMitarbeiter entity) throws RemoteException, Exception;
}
