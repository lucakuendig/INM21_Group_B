
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.gumitarbeiter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.GuMitarbeiterManager;
import ch.hsluw.mangelmanager.business.GuMitarbeiterManagerImpl;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;

public class GuMitarbeiterROImpl extends UnicastRemoteObject implements GuMitarbeiterRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private GuMitarbeiterManager guMitarbeiterManager;

	public GuMitarbeiterROImpl() throws RemoteException {
		guMitarbeiterManager = new GuMitarbeiterManagerImpl();
	}

	@Override
	public GuMitarbeiter add(GuMitarbeiter entity) throws RemoteException, Exception {
		return guMitarbeiterManager.add(entity);
	}

	@Override
	public GuMitarbeiter update(GuMitarbeiter entity) throws RemoteException, Exception {
		return guMitarbeiterManager.update(entity);
	}

	@Override
	public void delete(GuMitarbeiter entity) throws RemoteException, Exception {
		guMitarbeiterManager.delete(entity);
	}

}
