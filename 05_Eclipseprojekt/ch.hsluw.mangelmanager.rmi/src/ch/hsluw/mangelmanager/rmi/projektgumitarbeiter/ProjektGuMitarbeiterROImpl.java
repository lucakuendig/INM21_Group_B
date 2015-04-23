
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektgumitarbeiter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.ProjektGuMitarbeiterManager;
import ch.hsluw.mangelmanager.business.ProjektGuMitarbeiterManagerImpl;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;

public class ProjektGuMitarbeiterROImpl extends UnicastRemoteObject implements ProjektGuMitarbeiterRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ProjektGuMitarbeiterManager projektGuMitarbeiterManager;

	public ProjektGuMitarbeiterROImpl() throws RemoteException {
		projektGuMitarbeiterManager = new ProjektGuMitarbeiterManagerImpl();
	}

	@Override
	public ProjektGuMitarbeiter add(ProjektGuMitarbeiter entity) throws RemoteException, Exception {
		return projektGuMitarbeiterManager.add(entity);
	}

	@Override
	public ProjektGuMitarbeiter update(ProjektGuMitarbeiter entity) throws RemoteException, Exception {
		return projektGuMitarbeiterManager.update(entity);
	}

	@Override
	public void delete(ProjektGuMitarbeiter entity) throws RemoteException, Exception {
		projektGuMitarbeiterManager.delete(entity);
	}

}
