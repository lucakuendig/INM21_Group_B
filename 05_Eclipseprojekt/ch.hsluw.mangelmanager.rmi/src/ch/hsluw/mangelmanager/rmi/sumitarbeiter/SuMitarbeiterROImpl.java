
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.sumitarbeiter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.SuMitarbeiterManager;
import ch.hsluw.mangelmanager.business.SuMitarbeiterManagerImpl;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;

public class SuMitarbeiterROImpl extends UnicastRemoteObject implements SuMitarbeiterRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private SuMitarbeiterManager suMitarbeiterManager;

	public SuMitarbeiterROImpl() throws RemoteException {
		suMitarbeiterManager = new SuMitarbeiterManagerImpl();
	}

	@Override
	public SuMitarbeiter add(SuMitarbeiter entity) throws RemoteException, Exception {
		return suMitarbeiterManager.add(entity);
	}

	@Override
	public SuMitarbeiter update(SuMitarbeiter entity) throws RemoteException, Exception {
		return suMitarbeiterManager.update(entity);
	}

	@Override
	public void delete(SuMitarbeiter entity) throws RemoteException, Exception {
		suMitarbeiterManager.delete(entity);
	}

	
	@Override
	public void deleteById(Integer id) throws Exception {
		suMitarbeiterManager.deleteById(id);	
	}
	
	@Override
	public SuMitarbeiter findById(Integer id) throws RemoteException {
		return suMitarbeiterManager.findById(id);
	}

	@Override
	public List<SuMitarbeiter> findAll() throws RemoteException {
		return suMitarbeiterManager.findAll();
	}
}
