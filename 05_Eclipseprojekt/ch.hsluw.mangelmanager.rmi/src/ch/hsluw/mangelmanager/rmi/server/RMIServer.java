package ch.hsluw.mangelmanager.rmi.server;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import ch.hsluw.mangelmanager.rmi.adresse.AdresseRO;
import ch.hsluw.mangelmanager.rmi.adresse.AdresseROImpl;
import ch.hsluw.mangelmanager.rmi.arbeitstyp.ArbeitstypRO;
import ch.hsluw.mangelmanager.rmi.arbeitstyp.ArbeitstypROImpl;
import ch.hsluw.mangelmanager.rmi.mangel.MangelRO;
import ch.hsluw.mangelmanager.rmi.mangel.MangelROImpl;
import ch.hsluw.mangelmanager.rmi.mangelstatus.MangelstatusRO;
import ch.hsluw.mangelmanager.rmi.mangelstatus.MangelstatusROImpl;
import ch.hsluw.mangelmanager.rmi.meldung.MeldungRO;
import ch.hsluw.mangelmanager.rmi.meldung.MeldungROImpl;
import ch.hsluw.mangelmanager.rmi.meldungstyp.MeldungstypRO;
import ch.hsluw.mangelmanager.rmi.meldungstyp.MeldungstypROImpl;
import ch.hsluw.mangelmanager.rmi.objekttyp.ObjekttypRO;
import ch.hsluw.mangelmanager.rmi.objekttyp.ObjekttypROImpl;
import ch.hsluw.mangelmanager.rmi.person.PersonRO;
import ch.hsluw.mangelmanager.rmi.person.PersonROImpl;
import ch.hsluw.mangelmanager.rmi.plz.PlzRO;
import ch.hsluw.mangelmanager.rmi.plz.PlzROImpl;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektRO;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektROImpl;
import ch.hsluw.mangelmanager.rmi.subunternehmen.SubunternehmenRO;
import ch.hsluw.mangelmanager.rmi.subunternehmen.SubunternehmenROImpl;


public class RMIServer {

	public static void main(String[] args) {

		/*
		 * Port und Host-IP (an sich sollten diese Angaben aus einer
		 * Property-Datei eingelesen werden)
		 */
		int port = 1099;
		String hostIp = "localhost";

		Registry registry = null;

		try {

			InetAddress.getLocalHost();

			/*
			 * Die NIC-IP nach 'aussen' kommunizieren (falls die Namensauflösung
			 * probleme bereiten sollte)
			 */
			System.setProperty("java.rmi.server.hostname", hostIp);
			
			// Registry starten
			registry = LocateRegistry.createRegistry(port);

			if (registry != null) {

				// Entfernte Objekte erstellen
				PersonRO personRO = new PersonROImpl();
				ProjektRO projektRO = new ProjektROImpl();
				SubunternehmenRO subunternehmenRO = new SubunternehmenROImpl();
				MangelRO mangelRO = new MangelROImpl();
				MeldungRO meldungRO = new MeldungROImpl();
				PlzRO plzRO = new PlzROImpl();
				AdresseRO adresseRO = new AdresseROImpl();
				ObjekttypRO objekttypRO = new ObjekttypROImpl();
				ArbeitstypRO arbeitstypRO = new ArbeitstypROImpl();
				MangelstatusRO mangelstatusRO = new MangelstatusROImpl();
				MeldungstypRO meldungstypRO = new MeldungstypROImpl();
				

				registry.rebind("personRO", personRO);
				registry.rebind("projektRO", projektRO);
				registry.rebind("subunternehmenRO", subunternehmenRO);
				registry.rebind("mangelRO", mangelRO);
				registry.rebind("meldungRO", meldungRO);
				registry.rebind("plzRO", plzRO);
				registry.rebind("adresseRO", adresseRO);
				registry.rebind("objekttypRO", objekttypRO);
				registry.rebind("arbeitstypRO", arbeitstypRO);
				registry.rebind("mangelstatusRO", mangelstatusRO);
				registry.rebind("meldungstypRO", meldungstypRO);
				
				String msg = "RMI-Server ist bereit für Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIp + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind("personRO");
				registry.unbind("projektRO");
				registry.unbind("subunternehmenRO");
				registry.unbind("mangelRO");
				registry.unbind("meldungRO");
				registry.unbind("plzRO");
				registry.unbind("adresseRO");
				registry.unbind("objekttypRO");
				registry.unbind("arbeitsttypRO");
				registry.unbind("mangelstatusRO");
				registry.unbind("meldungstypRO");

				System.out.println("RMI Server wird heruntergefahren!\n");

				System.exit(0);
			} else {
				System.out
						.println("Entferntes Objekt konnte nicht exportiert werden!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
