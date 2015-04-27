/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektgumitarbeiter;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektGuMitarbeiterRO zur Verf�gung
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */

public interface ProjektGuMitarbeiterRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektGuMitarbeiter add(ProjektGuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(ProjektGuMitarbeiter entity) throws RemoteException, Exception;
	
	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert die Entity f�r die �bergebenen Werte zur�ck.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	ProjektGuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<ProjektGuMitarbeiter> findAll() throws RemoteException;
}
