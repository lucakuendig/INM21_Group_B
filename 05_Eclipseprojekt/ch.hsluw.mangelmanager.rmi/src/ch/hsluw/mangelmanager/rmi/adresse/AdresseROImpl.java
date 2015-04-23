
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.adresse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.AdresseManager;
import ch.hsluw.mangelmanager.business.AdresseManagerImpl;
import ch.hsluw.mangelmanager.model.Adresse;

public class AdresseROImpl extends UnicastRemoteObject implements AdresseRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private AdresseManager adresseManager;

	public AdresseROImpl() throws RemoteException {
		adresseManager = new AdresseManagerImpl();
	}

	@Override
	public Adresse add(Adresse entity) throws RemoteException, Exception {
		return adresseManager.add(entity);
	}

	@Override
	public Adresse update(Adresse entity) throws RemoteException, Exception {
		return adresseManager.update(entity);
	}

	@Override
	public void delete(Adresse entity) throws RemoteException, Exception {
		adresseManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		adresseManager.deleteById(id);	
	}

	@Override
	public Adresse findById(Integer id) throws RemoteException {
		return adresseManager.findById(id);
	}

	@Override
	public List<Adresse> findAll() throws RemoteException {
		return adresseManager.findAll();
	}

	


}
