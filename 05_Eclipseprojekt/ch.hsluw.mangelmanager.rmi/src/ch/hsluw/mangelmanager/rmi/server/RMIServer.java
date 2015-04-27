package ch.hsluw.mangelmanager.rmi.server;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import ch.hsluw.mangelmanager.rmi.projekt.ProjektRO;
import ch.hsluw.mangelmanager.rmi.projekt.ProjektROImpl;


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
				ProjektRO projektRO = new ProjektROImpl();

				registry.rebind("projektRO", projektRO);

				String msg = "RMI-Server ist bereit für Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIp + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind("projektRO");
		

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
