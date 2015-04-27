
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektstatus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.projektstatus.ProjektstatusManager;
import ch.hsluw.mangelmanager.business.projektstatus.ProjektstatusManagerImpl;
import ch.hsluw.mangelmanager.model.Projektstatus;

public class ProjektstatusROImpl extends UnicastRemoteObject implements ProjektstatusRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ProjektstatusManager projektstatusManager;

	public ProjektstatusROImpl() throws RemoteException {
		projektstatusManager = new ProjektstatusManagerImpl();
	}

	@Override
	public Projektstatus add(Projektstatus entity) throws RemoteException, Exception {
		return projektstatusManager.add(entity);
	}

	@Override
	public Projektstatus update(Projektstatus entity) throws RemoteException, Exception {
		return projektstatusManager.update(entity);
	}

	@Override
	public void delete(Projektstatus entity) throws RemoteException, Exception {
		projektstatusManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		projektstatusManager.deleteById(id);	
	}

	@Override
	public Projektstatus findById(Integer id) throws RemoteException {
		return projektstatusManager.findById(id);
	}

	@Override
	public List<Projektstatus> findAll() throws RemoteException {
		return projektstatusManager.findAll();
	}

	


}
