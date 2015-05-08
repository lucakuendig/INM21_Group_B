
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.projekt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.projekt.ProjektManager;
import ch.hsluw.mangelmanager.business.projekt.ProjektManagerImpl;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class ProjektROImpl extends UnicastRemoteObject implements ProjektRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private ProjektManager projektManager;

	public ProjektROImpl() throws RemoteException {
		projektManager = new ProjektManagerImpl();
	}

	@Override
	public Projekt add(Projekt entity) throws RemoteException, Exception {
		return projektManager.add(entity);
	}

	@Override
	public Projekt update(Projekt entity) throws RemoteException, Exception {
		return projektManager.update(entity);
	}

	@Override
	public void delete(Projekt entity) throws RemoteException, Exception {
		projektManager.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		projektManager.deleteById(id);	
	}
	
	@Override
	public Projekt findById(Integer id) throws RemoteException {
		return projektManager.findById(id);
	}

	@Override
	public List<Projekt> findAll() throws RemoteException {
		return projektManager.findAll();
	}

	@Override
	public List<Projekt> findByBezeichnung(String bezeichnung)
			throws RemoteException {
		return projektManager.findByBezeichnung(bezeichnung);
	}
	
	@Override
	public List<Projekt> findByProjektstatus(String projektstatus)
			throws RemoteException {
		return projektManager.findByProjektstatus(projektstatus);
	}
	
	@Override
	public List<Projekt> findByOrt(String ort)
			throws RemoteException {
		return projektManager.findByOrt(ort);
	}
	
	@Override
	public List<Projekt> findByPlz(String plz)
			throws RemoteException {
		return projektManager.findByPlz(plz);
	}
	
	@Override
	public List<Projekt> findByBauherr(String bauherr)
			throws RemoteException {
		return projektManager.findByBauherr(bauherr);
	}
	
	@Override
	public List<Projekt> findByObjekttyp(String objekttyp)
			throws RemoteException {
		return projektManager.findByObjekttyp(objekttyp);
	}
	
	@Override
	public List<Projekt> findByArbeitstyp(String arbeitstyp)
			throws RemoteException {
		return projektManager.findByArbeitstyp(arbeitstyp);
	}
	
	@Override
	public List<Projekt> findByDatumFromTillEnd(Date fromDatum, Date endDatum)
			throws RemoteException {
		return projektManager.findByDatumFromTillEnd(fromDatum,endDatum);
	}

	@Override
	public List<Projekt> findAllSubunternehmenProjekt(Subunternehmen subunternehmen2) throws RemoteException {
		return projektManager.findAllSubunternehmenProjekt(subunternehmen2);
	}

	

}
