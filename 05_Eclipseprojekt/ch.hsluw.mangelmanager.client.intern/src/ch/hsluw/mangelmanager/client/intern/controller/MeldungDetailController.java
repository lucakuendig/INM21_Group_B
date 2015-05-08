package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
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
				client = ClientRMI.getInstance();
				meldung = client.getMeldungById(meldungId);
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
		private void saveMeldung() {
			
		}

	
}
