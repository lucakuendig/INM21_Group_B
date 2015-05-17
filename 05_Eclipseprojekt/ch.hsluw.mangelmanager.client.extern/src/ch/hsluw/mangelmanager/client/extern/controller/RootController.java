package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ch.hsluw.mangelmanager.client.extern.Main;

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

	@FXML 
	private void logout() {
		// Load Login and close current Stage
		Main.initRootLayout();
		Stage stageToClose = (Stage) rootLayout.getScene().getWindow();
		stageToClose.close();
	}
	@FXML
	private void showPersonen() {
		try {
			// Load Person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/person/AusserePerson.fxml"));
			AnchorPane personen = (AnchorPane) loader.load();
			
			PersonController personController = loader.<PersonController>getController();
			personController.setRootController(this);
			
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
			
			SubUnternehmenController subunternehmenController = loader.<SubUnternehmenController>getController();
			subunternehmenController.setRootController(this);
			
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
			loader.setLocation(Main.class
					.getResource("view/projekt/AusseresProjekt.fxml"));
			AnchorPane projekte = (AnchorPane) loader.load();
			
			ProjektController projektController = loader.<ProjektController>getController();
			projektController.setRootController(this);
			
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
			loader.setLocation(Main.class
					.getResource("view/mangel/AussererMangel.fxml"));
			AnchorPane maengel = (AnchorPane) loader.load();
			
			MangelController mangelController = loader.<MangelController>getController();
			mangelController.setRootController(this);
			
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
			loader.setLocation(Main.class
					.getResource("view/meldung/AussereMeldung.fxml"));
			AnchorPane meldungen = (AnchorPane) loader.load();
			
			MeldungController meldungController = loader.<MeldungController>getController();
			meldungController.setRootController(this);
			
			rootLayout.setCenter(meldungen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		showPersonen();
	}

}
