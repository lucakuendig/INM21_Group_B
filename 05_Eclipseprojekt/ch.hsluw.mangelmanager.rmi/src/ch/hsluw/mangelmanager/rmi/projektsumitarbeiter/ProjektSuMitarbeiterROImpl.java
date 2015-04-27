
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projektsumitarbeiter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.projektsumitarbeiter.ProjektSuMitarbeiterManager;
import ch.hsluw.mangelmanager.business.projektsumitarbeiter.ProjektSuMitarbeiterManagerImpl;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;

public class ProjektSuMitarbeiterROImpl extends UnicastRemoteObject implements ProjektSuMitarbeiterRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ProjektSuMitarbeiterManager projektSuMitarbeiterManager;

	public ProjektSuMitarbeiterROImpl() throws RemoteException {
		projektSuMitarbeiterManager = new ProjektSuMitarbeiterManagerImpl();
	}

	@Override
	public ProjektSuMitarbeiter add(ProjektSuMitarbeiter entity) throws RemoteException, Exception {
		return projektSuMitarbeiterManager.add(entity);
	}

	@Override
	public ProjektSuMitarbeiter update(ProjektSuMitarbeiter entity) throws RemoteException, Exception {
		return projektSuMitarbeiterManager.update(entity);
	}

	@Override
	public void delete(ProjektSuMitarbeiter entity) throws RemoteException, Exception {
		projektSuMitarbeiterManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer idProjekt, Integer idMitarbeiter) throws Exception {
		projektSuMitarbeiterManager.deleteById(idProjekt, idMitarbeiter);	
	}
	
	@Override
	public ProjektSuMitarbeiter findById(Integer idProjekt, Integer idMitarbeiter) throws RemoteException {
		return projektSuMitarbeiterManager.findById(idProjekt, idMitarbeiter);
	}

	@Override
	public List<ProjektSuMitarbeiter> findAll() throws RemoteException {
		return projektSuMitarbeiterManager.findAll();
	}

}
