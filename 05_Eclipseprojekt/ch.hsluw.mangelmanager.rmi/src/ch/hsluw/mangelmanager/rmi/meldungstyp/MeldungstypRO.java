/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.meldungstyp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MeldungstypRO zur Verf�gung
 * 
 * @version 1.0
 * @author cdemir
 * 
 */

public interface MeldungstypRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldungstyp add(Meldungstyp entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Meldungstyp update(Meldungstyp entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Meldungstyp entity) throws RemoteException, Exception;
	
	/**
	 * L�scht die Entity mit der �bergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Meldung findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Meldungen zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Meldungstyp> findAll() throws RemoteException;
	
}
