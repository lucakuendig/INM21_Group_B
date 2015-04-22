
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.rmi.login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import ch.hsluw.mangelmanager.business.LoginManager;
import ch.hsluw.mangelmanager.business.LoginManagerImpl;
import ch.hsluw.mangelmanager.model.Login;

public class LoginROImpl extends UnicastRemoteObject implements LoginRO {


	private static final long serialVersionUID = -4116064628937156721L;
	
	private LoginManager loginManager;

	public LoginROImpl() throws RemoteException {
		loginManager = new LoginManagerImpl();
	}

	@Override
	public Login add(Login entity) throws RemoteException, Exception {
		return loginManager.add(entity);
	}

	@Override
	public Login update(Login entity) throws RemoteException, Exception {
		return loginManager.update(entity);
	}

	@Override
	public void delete(Login entity) throws RemoteException, Exception {
		loginManager.delete(entity);
	}

}
