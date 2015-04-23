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
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * ProjektSuMitarbeiterRO zur Verfügung
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */

public interface ProjektSuMitarbeiterRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(ProjektSuMitarbeiter entity) throws RemoteException, Exception;
	
	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert die Entity für die übergebenen Werte zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	ProjektSuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<ProjektSuMitarbeiter> findAll() throws RemoteException;
}
