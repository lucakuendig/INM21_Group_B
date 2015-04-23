
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.Meldung;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.hsluw.mangelmanager.business.MeldungManager;
import ch.hsluw.mangelmanager.business.MeldungManagerImpl;
import ch.hsluw.mangelmanager.model.Meldung;



public class MeldungROImpl extends UnicastRemoteObject implements MeldungRO {

	
	private static final long serialVersionUID = -4240817211813159411L;
	
	private MeldungManager meldungManager;

	public MeldungROImpl() throws RemoteException {
		meldungManager = new MeldungManagerImpl();
	}

	@Override
	public Meldung add(Meldung entity) throws RemoteException, Exception {
		return meldungManager.add(entity);
	}

	@Override
	public Meldung update(Meldung entity) throws RemoteException, Exception {
		return meldungManager.update(entity);
	}

	@Override
	public void delete(Meldung entity) throws RemoteException, Exception {
		meldungManager.delete(entity);
	}
	
}
