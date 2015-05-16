
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.mangel;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MangelRO zur Verfügung
 * 
 * @version 1.0
 * @author mmont
 * 
 */

public interface MangelRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangel add(Mangel entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangel update(Mangel entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Mangel entity) throws RemoteException, Exception;

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
	Mangel findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit Mängeln für die übergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByBezeichnung(String bezeichnung)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Mängeln für den übergebenen Projektstatus.
	 * 
	 * @param mangelstatus
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByMangelstatus(String mangelstatus)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Projekten für den übergebenen Ort.
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByName(String name)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für die übergebenen Postleitzahl.
	 * 
	 * @param erfassungsZeit
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByErfassungsZeit(Date erfassungsZeit)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Bauherren.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten für den übergebenen Objekttyp.
	 * 
	 * @param abschlussZeit
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByAbschlussZeit(Date abschlussZeit)
			throws RemoteException;
	
	/**
	 * Liefert alle Mängel von einem Projekt
	 * 
	 * @param projekt
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findAllMangelProjekt(Integer projekt) throws RemoteException;

}