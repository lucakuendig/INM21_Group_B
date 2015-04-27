
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.arbeitstyp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.arbeitstyp.ArbeitstypManager;
import ch.hsluw.mangelmanager.business.arbeitstyp.ArbeitstypManagerImpl;
import ch.hsluw.mangelmanager.model.Arbeitstyp;

public class ArbeitstypROImpl extends UnicastRemoteObject implements ArbeitstypRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ArbeitstypManager arbeitstypManager;

	public ArbeitstypROImpl() throws RemoteException {
		arbeitstypManager = new ArbeitstypManagerImpl();
	}

	@Override
	public Arbeitstyp add(Arbeitstyp entity) throws RemoteException, Exception {
		return arbeitstypManager.add(entity);
	}

	@Override
	public Arbeitstyp update(Arbeitstyp entity) throws RemoteException, Exception {
		return arbeitstypManager.update(entity);
	}

	@Override
	public void delete(Arbeitstyp entity) throws RemoteException, Exception {
		arbeitstypManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		arbeitstypManager.deleteById(id);	
	}

	@Override
	public Arbeitstyp findById(Integer id) throws RemoteException {
		return arbeitstypManager.findById(id);
	}

	@Override
	public List<Arbeitstyp> findAll() throws RemoteException {
		return arbeitstypManager.findAll();
	}

	@Override
	public List<Arbeitstyp> findByBezeichnung(String bezeichnung)
			throws RemoteException {
		return arbeitstypManager.findByBezeichnung(bezeichnung);
	}
	


}
