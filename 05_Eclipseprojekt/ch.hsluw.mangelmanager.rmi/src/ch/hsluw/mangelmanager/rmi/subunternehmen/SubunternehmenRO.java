/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.subunternehmen;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javafx.beans.value.ObservableValue;
import ch.hsluw.mangelmanager.model.Subunternehmen;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * SubunternehmenRO zur Verfügung
 * 
 * @version 1.0
 * @author lkuendig
 * 
 */

public interface SubunternehmenRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Subunternehmen add(Subunternehmen entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Subunternehmen update(Subunternehmen entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Subunternehmen entity) throws RemoteException, Exception;
	
	/**
	 * Löscht die Entity mit der übergebenen Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Subunternehmen findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Subunternehmen> findAll() throws RemoteException;

	String findAllProjekte(int subunternehmen);
}
