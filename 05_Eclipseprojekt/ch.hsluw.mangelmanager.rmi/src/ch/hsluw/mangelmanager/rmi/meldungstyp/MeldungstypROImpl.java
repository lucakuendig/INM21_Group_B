/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.meldungstyp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.meldungstyp.MeldungstypManager;
import ch.hsluw.mangelmanager.business.meldungstyp.MeldungstypManagerImpl;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;



public class MeldungstypROImpl extends UnicastRemoteObject implements MeldungstypRO {


	private static final long serialVersionUID = -8523214358712447146L;
	
	private MeldungstypManager meldungstypManager;

	public MeldungstypROImpl() throws RemoteException {
		meldungstypManager = new MeldungstypManagerImpl();
	}

	@Override
	public Meldungstyp add(Meldungstyp entity) throws RemoteException, Exception {
		return meldungstypManager.add(entity);
	}

	@Override
	public Meldungstyp update(Meldungstyp entity) throws RemoteException, Exception {
		return meldungstypManager.update(entity);
	}

	@Override
	public void delete(Meldungstyp entity) throws RemoteException, Exception {
		meldungstypManager.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Meldung findById(Integer id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meldungstyp> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
