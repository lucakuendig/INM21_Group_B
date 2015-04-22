
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.rolle;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.RolleManager;
import ch.hsluw.mangelmanager.business.RolleManagerImpl;
import ch.hsluw.mangelmanager.model.Rolle;

public class RolleROImpl extends UnicastRemoteObject implements RolleRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private RolleManager rolleManager;

	public RolleROImpl() throws RemoteException {
		rolleManager = new RolleManagerImpl();
	}

	@Override
	public Rolle add(Rolle entity) throws RemoteException, Exception {
		return rolleManager.add(entity);
	}

	@Override
	public Rolle update(Rolle entity) throws RemoteException, Exception {
		return rolleManager.update(entity);
	}

	@Override
	public void delete(Rolle entity) throws RemoteException, Exception {
		rolleManager.delete(entity);
	}

}
