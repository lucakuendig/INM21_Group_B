
/*
 * ZWECK: mangelManager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.mangelstatus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.hsluw.mangelmanager.business.mangelstatus.MangelstatusManager;
import ch.hsluw.mangelmanager.business.mangelstatus.MangelstatusManagerImpl;
import ch.hsluw.mangelmanager.model.Mangelstatus;


public class MangelstatusROImpl extends UnicastRemoteObject implements MangelstatusRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private MangelstatusManager mangelstatusManager;

	public MangelstatusROImpl() throws RemoteException {
		mangelstatusManager = new MangelstatusManagerImpl();
	}

	@Override
	public Mangelstatus add(Mangelstatus entity) throws RemoteException, Exception {
		return mangelstatusManager.add(entity);
	}

	@Override
	public Mangelstatus update(Mangelstatus entity) throws RemoteException, Exception {
		return mangelstatusManager.update(entity);
	}

	@Override
	public void delete(Mangelstatus entity) throws RemoteException, Exception {
		mangelstatusManager.delete(entity);
	}

}