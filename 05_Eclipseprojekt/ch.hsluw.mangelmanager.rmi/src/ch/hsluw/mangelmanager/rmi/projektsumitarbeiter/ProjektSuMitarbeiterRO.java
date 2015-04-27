/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektsumitarbeiter;


import java.rmi.Remote;
import java.rmi.RemoteException;
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
	ProjektSuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<ProjektSuMitarbeiter> findAll() throws RemoteException;
}
