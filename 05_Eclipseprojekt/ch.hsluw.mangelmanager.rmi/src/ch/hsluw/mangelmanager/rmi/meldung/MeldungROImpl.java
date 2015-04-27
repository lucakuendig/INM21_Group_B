/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.meldung;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.meldung.MeldungManager;
import ch.hsluw.mangelmanager.business.meldung.MeldungManagerImpl;
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
	public List<Meldung> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
