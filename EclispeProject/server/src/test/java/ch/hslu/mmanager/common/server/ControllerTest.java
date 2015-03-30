package ch.hslu.mmanager.common.server;

import java.util.List;

import org.junit.Test;

import ch.hslu.mmanager.common.model.GUMitarbeiter;
import ch.hslu.mmanager.common.model.Rolle;
import ch.hslu.mmanager.common.model.User;

public class ControllerTest {

	@Test
	public void test(){
		Controller<User, Integer> uC = new Controller<User, Integer>(User.class);
		Controller<GUMitarbeiter, Integer> gumC = new Controller<GUMitarbeiter, Integer>(GUMitarbeiter.class);
		
		User u = new User("sandro", "1234", "sandroritz@ewcom.ch", new Rolle("Administrator"));
		GUMitarbeiter gum = new GUMitarbeiter("Schmid", "Hans","0279714024", u);
		
		uC.persist(u);
		gumC.persist(gum);
		
		List<User> personen = uC.getAll();
		
		for (User user : personen) {
			System.out.println("Benutzer: " + user.getBenutzername() +" Passwort: " +user.getPasswort() + 
					" EMail: " + user.getEmail() + " Rolle: " + user.getRolle().getBezeichnung());
		}
		
	}
}
