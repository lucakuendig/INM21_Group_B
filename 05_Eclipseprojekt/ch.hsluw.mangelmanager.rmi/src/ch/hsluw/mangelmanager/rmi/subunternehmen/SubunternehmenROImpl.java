
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.subunternehmen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.SubunternehmenManager;
import ch.hsluw.mangelmanager.business.SubunternehmenManagerImpl;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class SubunternehmenROImpl extends UnicastRemoteObject implements SubunternehmenRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private SubunternehmenManager subunternehmenManager;

	public SubunternehmenROImpl() throws RemoteException {
		subunternehmenManager = new SubunternehmenManagerImpl();
	}

	@Override
	public Subunternehmen add(Subunternehmen entity) throws RemoteException, Exception {
		return subunternehmenManager.add(entity);
	}

	@Override
	public Subunternehmen update(Subunternehmen entity) throws RemoteException, Exception {
		return subunternehmenManager.update(entity);
	}

	@Override
	public void delete(Subunternehmen entity) throws RemoteException, Exception {
		subunternehmenManager.delete(entity);
	}

}
