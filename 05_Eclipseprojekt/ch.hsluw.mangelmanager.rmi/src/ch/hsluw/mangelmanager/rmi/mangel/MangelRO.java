
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



/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MangelRO zur Verf�gung
 * 
 * @version 1.0
 * @author mmont
 * 
 */

public interface MangelRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangel add(Mangel entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Mangel update(Mangel entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Mangel entity) throws RemoteException, Exception;

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
	Mangel findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findAll() throws RemoteException;
	
	/**
	 * Liefert die Liste mit M�ngeln f�r die �bergebene Bezeichnung.
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByBezeichnung(String bezeichnung)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit M�ngeln f�r den �bergebenen Projektstatus.
	 * 
	 * @param mangelstatus
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByMangelstatus(String mangelstatus)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Ort.
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByName(String name)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r die �bergebenen Postleitzahl.
	 * 
	 * @param erfassungsZeit
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByErfassungsZeit(Date erfassungsZeit)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Bauherren.
	 * 
	 * @param faelligkeitsDatum
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum)
			throws RemoteException;
	
	/**
	 * Liefert die Liste mit Projekten f�r den �bergebenen Objekttyp.
	 * 
	 * @param abschlussZeit
	 * @return
	 * @throws RemoteException
	 */
	List<Mangel> findByAbschlussZeit(String abschlussZeit)
			throws RemoteException;

}