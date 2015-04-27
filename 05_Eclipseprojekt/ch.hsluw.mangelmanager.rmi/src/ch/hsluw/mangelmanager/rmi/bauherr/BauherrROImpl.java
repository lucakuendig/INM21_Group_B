
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.bauherr;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.bauherr.BauherrManager;
import ch.hsluw.mangelmanager.business.bauherr.BauherrManagerImpl;
import ch.hsluw.mangelmanager.model.Bauherr;

public class BauherrROImpl extends UnicastRemoteObject implements BauherrRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private BauherrManager bauherrManager;

	public BauherrROImpl() throws RemoteException {
		bauherrManager = new BauherrManagerImpl();
	}

	@Override
	public Bauherr add(Bauherr entity) throws RemoteException, Exception {
		return bauherrManager.add(entity);
	}

	@Override
	public Bauherr update(Bauherr entity) throws RemoteException, Exception {
		return bauherrManager.update(entity);
	}

	@Override
	public void delete(Bauherr entity) throws RemoteException, Exception {
		bauherrManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		bauherrManager.deleteById(id);	
	}

	@Override
	public Bauherr findById(Integer id) throws RemoteException {
		return bauherrManager.findById(id);
	}

	@Override
	public List<Bauherr> findAll() throws RemoteException {
		return bauherrManager.findAll();
	}

	


}
