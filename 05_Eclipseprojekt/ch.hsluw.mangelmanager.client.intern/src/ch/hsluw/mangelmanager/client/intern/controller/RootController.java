package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.client.intern.ShowMethodClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The RootController is used to load different content 
 * in center of the BorderPane
 * 
 * 
 * @author sritz, mmonti
 * @version 1.0
 *
 */
public class RootController implements Initializable {

	@FXML
	public BorderPane rootLayout;

	@FXML private void logout() {
		Main.initRootLayout();
		Stage stageToClose = (Stage) rootLayout.getScene().getWindow();
		stageToClose.close();
	}
	@FXML
	private void showPersonen() {
		try {
			// Load Person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/person/AusserePerson.fxml"));
			AnchorPane personen = (AnchorPane) loader.load();
			rootLayout.setCenter(personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void showUnternehmen() {
		try {
			// Load Unternehmen overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/unternehmen/AusseresUnternehmen.fxml"));
			AnchorPane unternehmen = (AnchorPane) loader.load();
			rootLayout.setCenter(unternehmen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void showProjekte() {
		try {
			// Load Projekt overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/projekt/AusseresProjekt.fxml"));
			AnchorPane projekte = (AnchorPane) loader.load();
			rootLayout.setCenter(projekte);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void showMaengel() {
		try {
			// Load Maengel overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/mangel/AussererMangel.fxml"));
			AnchorPane maengel = (AnchorPane) loader.load();
			rootLayout.setCenter(maengel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void showMeldungen() {
		try {
			// Load Meldung overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/meldung/AussereMeldung.fxml"));
			AnchorPane meldungen = (AnchorPane) loader.load();
			rootLayout.setCenter(meldungen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
