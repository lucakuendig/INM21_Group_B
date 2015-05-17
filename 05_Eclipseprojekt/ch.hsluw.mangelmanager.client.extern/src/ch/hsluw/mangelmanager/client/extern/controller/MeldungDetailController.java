package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Meldung;

public class MeldungDetailController implements Initializable {

	//WS Client to interact
		ClientWS client = null;
		RootController rootController = null;
		DateFormat formatZeit;
	
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		Meldung meldung = null;
		
		@FXML
		public Label lblMeldungId;
		@FXML
		public Label lblMeldungProjekt;
		@FXML
		public Label lblMeldungMangel;
		@FXML
		public Label lblMeldungDatum;
		@FXML
		public Label lblMeldungArt;
		@FXML
		public TextArea txtMeldungBeschreibung;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			formatZeit = new SimpleDateFormat("dd.MM.yyyy hh:mm");
			
		}


		public void init(int meldungId) {
				try {
				client = ClientWS.getInstance();
				meldung = client.proxy.getMeldungById(meldungId);
				lblMeldungId.setText(meldung.getId().toString());
				lblMeldungProjekt.setText(meldung.getFkMangel().getFkProjekt().getBezeichnung());
				lblMeldungMangel.setText(meldung.getFkMangel().getBezeichnung());
				lblMeldungDatum.setText(formatZeit.format(meldung.getZeitpunkt().getTime()));
				lblMeldungArt.setText(meldung.getFkMeldungstyp().getBezeichnung());
				txtMeldungBeschreibung.appendText(meldung.getText());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@FXML
		private void meldungCancel() {
			try {
				// Load Unternehmen overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/meldung/AussereMeldung.fxml"));
				AnchorPane meldung = (AnchorPane) loader.load();
				
				MeldungController meldungController = loader.<MeldungController>getController();
				meldungController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(meldung);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@FXML
		public void meldungRead(){
			meldung.setQuittiert(true);
			client.proxy.updateMeldung(meldung);
			
			try {
				// Load Unternehmen overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/meldung/AussereMeldung.fxml"));
				AnchorPane meldung = (AnchorPane) loader.load();
				
				MeldungController meldungController = loader.<MeldungController>getController();
				meldungController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(meldung);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
