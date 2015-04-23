
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.plz;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.PlzManager;
import ch.hsluw.mangelmanager.business.PlzManagerImpl;
import ch.hsluw.mangelmanager.model.Plz;

public class PlzROImpl extends UnicastRemoteObject implements PlzRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private PlzManager adresseManager;

	public PlzROImpl() throws RemoteException {
		adresseManager = new PlzManagerImpl();
	}

	@Override
	public Plz add(Plz entity) throws RemoteException, Exception {
		return adresseManager.add(entity);
	}

	@Override
	public Plz update(Plz entity) throws RemoteException, Exception {
		return adresseManager.update(entity);
	}

	@Override
	public void delete(Plz entity) throws RemoteException, Exception {
		adresseManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		adresseManager.deleteById(id);	
	}

	@Override
	public Plz findById(Integer id) throws RemoteException {
		return adresseManager.findById(id);
	}

	@Override
	public List<Plz> findAll() throws RemoteException {
		return adresseManager.findAll();
	}

	


}
