/*
 * ZWECK: mangelManager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.mangel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.MangelManager;
import ch.hsluw.mangelmanager.business.MangelManagerImpl;
import ch.hsluw.mangelmanager.model.Mangel;

public class MangelROImpl extends UnicastRemoteObject implements MangelRO {

	private static final long serialVersionUID = -4116064628937156721L;

	private MangelManager mangelManager;

	public MangelROImpl() throws RemoteException {
		mangelManager = new MangelManagerImpl();
	}

	@Override
	public Mangel add(Mangel entity) throws RemoteException, Exception {
		return mangelManager.add(entity);
	}

	@Override
	public Mangel update(Mangel entity) throws RemoteException, Exception {
		return mangelManager.update(entity);
	}

	@Override
	public void delete(Mangel entity) throws RemoteException, Exception {
		mangelManager.delete(entity);
	}

	@Override
	public List<Mangel> findByErfassungsZeit(Date erfassungsZeit)
			throws RemoteException {
		return mangelManager.findByErfassungsZeit(erfassungsZeit);
	}

	@Override
	public List<Mangel> findByFaelligkeitsDatum(Date faelligkeitsDatum)
			throws RemoteException {
		return mangelManager.findByFaelligkeitsDatum(faelligkeitsDatum);

	}

	@Override
	public List<Mangel> findByAbschlussZeit(Date abschlussZeit)
			throws RemoteException {
		return mangelManager.findByAbschlussZeit(abschlussZeit);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		mangelManager.deleteById(id);	

	}

	@Override
	public Mangel findById(Integer id) throws RemoteException {
		return mangelManager.findById(id);
	}

	@Override
	public List<Mangel> findAll() throws RemoteException {
		return mangelManager.findAll();
	}

	@Override
	public List<Mangel> findByBezeichnung(String bezeichnung)
			throws RemoteException {
		return mangelManager.findByBezeichnung(bezeichnung);
	}

	@Override
	public List<Mangel> findByMangelstatus(String mangelstatus)
			throws RemoteException {
		return mangelManager.findByMangelstatus(mangelstatus);
	}

	@Override
	public List<Mangel> findByName(String name) throws RemoteException {
		return mangelManager.findByName(name);
	}

}
