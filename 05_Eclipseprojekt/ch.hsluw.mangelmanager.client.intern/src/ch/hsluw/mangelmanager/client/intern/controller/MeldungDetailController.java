package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MeldungDetailController implements Initializable {

	//RMI Client to interact
		ClientRMI client = null;
		RootController rootController = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		Meldung meldung = null;
		
		@FXML
		public Label lblMeldungId;
		@FXML
		public TextField txtMeldungProjekt;
		@FXML
		public TextField txtMeldungMangel;
		@FXML
		public TextField txtMeldungDatum;
		@FXML
		public TextField txtMeldungArt;
		@FXML
		public TextArea txtMeldungBeschreibung;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {

			
		}


		public void init(int meldungId) {
				try {
				client = ClientRMI.getInstance();
				meldung = client.getMeldungById(meldungId);
				lblMeldungId.setText(meldung.getId().toString());
				txtMeldungProjekt.setText(meldung.getFkMangel().getFkProjekt().getBezeichnung());
				txtMeldungMangel.setText(meldung.getFkMangel().getBezeichnung());
				txtMeldungDatum.setText(meldung.getZeitpunkt().toString());
				txtMeldungArt.setText(meldung.getFkMeldungstyp().getBezeichnung());
				txtMeldungBeschreibung.appendText(meldung.getText());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@FXML
		private void saveMeldung() {
			
		}

	
}
