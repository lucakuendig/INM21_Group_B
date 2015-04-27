
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.objekttyp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import ch.hsluw.mangelmanager.business.objekttyp.ObjekttypManager;
import ch.hsluw.mangelmanager.business.objekttyp.ObjekttypManagerImpl;
import ch.hsluw.mangelmanager.model.Objekttyp;

public class ObjekttypROImpl extends UnicastRemoteObject implements ObjekttypRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ObjekttypManager objekttypManager;

	public ObjekttypROImpl() throws RemoteException {
		objekttypManager = new ObjekttypManagerImpl();
	}

	@Override
	public Objekttyp add(Objekttyp entity) throws RemoteException, Exception {
		return objekttypManager.add(entity);
	}

	@Override
	public Objekttyp update(Objekttyp entity) throws RemoteException, Exception {
		return objekttypManager.update(entity);
	}

	@Override
	public void delete(Objekttyp entity) throws RemoteException, Exception {
		objekttypManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		objekttypManager.deleteById(id);	
	}

	@Override
	public Objekttyp findById(Integer id) throws RemoteException {
		return objekttypManager.findById(id);
	}

	@Override
	public List<Objekttyp> findAll() throws RemoteException {
		return objekttypManager.findAll();
	}

	@Override
	public List<Objekttyp> findByBezeichnung(String bezeichnung)
			throws RemoteException {
		return objekttypManager.findByBezeichnung(bezeichnung);
	}
	


}
