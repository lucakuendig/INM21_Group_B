/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektsumitarbeiter;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektSuMitarbeiterRO zur Verf�gung
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */

public interface ProjektSuMitarbeiterRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(ProjektSuMitarbeiter entity) throws RemoteException, Exception;
}
