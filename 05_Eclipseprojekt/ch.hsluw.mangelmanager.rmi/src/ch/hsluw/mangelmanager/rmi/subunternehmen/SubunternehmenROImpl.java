
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.subunternehmen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javafx.beans.value.ObservableValue;
import ch.hsluw.mangelmanager.business.subunternehmen.SubunternehmenManager;
import ch.hsluw.mangelmanager.business.subunternehmen.SubunternehmenManagerImpl;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class SubunternehmenROImpl extends UnicastRemoteObject implements SubunternehmenRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private SubunternehmenManager subunternehmenManager;

	public SubunternehmenROImpl() throws RemoteException {
		subunternehmenManager = new SubunternehmenManagerImpl();
	}

	@Override
	public Subunternehmen add(Subunternehmen entity) throws RemoteException, Exception {
		return subunternehmenManager.add(entity);
	}

	@Override
	public Subunternehmen update(Subunternehmen entity) throws RemoteException, Exception {
		return subunternehmenManager.update(entity);
	}

	@Override
	public void delete(Subunternehmen entity) throws RemoteException, Exception {
		subunternehmenManager.delete(entity);
	}
	
	@Override
	public void deleteById(Integer id) throws Exception {
		subunternehmenManager.deleteById(id);	
	}
	
	@Override
	public Subunternehmen findById(Integer id) throws RemoteException {
		return subunternehmenManager.findById(id);
	}

	@Override
	public List<Subunternehmen> findAll() throws RemoteException {
		return subunternehmenManager.findAll();
	}

	@Override
	public String findAllProjekte(int subunternehmen) {
		return subunternehmenManager.findAllProjekte(subunternehmen);
	}	

}
