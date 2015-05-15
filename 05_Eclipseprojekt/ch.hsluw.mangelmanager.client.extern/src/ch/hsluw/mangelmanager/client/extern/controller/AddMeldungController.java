package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.jmx.snmp.Timestamp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class AddMeldungController implements Initializable {
		//RMI Client to interact
		ClientWS client = null;
		RootController rootController = null;
		Mangel mangel = null;
		GregorianCalendar timestamp = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}

		Login login = null;
		
		
		@FXML
		public Label lblMeldungProjekt;
		@FXML 
		private TextField txtMeldungstyp;
		@FXML
		private ChoiceBox<Mangel> cbMeldungMangel;
		@FXML
		private ChoiceBox<Meldungstyp> cbMeldungstyp;
		@FXML
		private TextArea txtMeldungBeschreibung;
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			try {
				client = new ClientWS();
				for (Mangel mangel : client.proxy.getAllMangel()) {
					cbMeldungMangel.getItems().add(mangel);
				}
				for (Meldungstyp meldungstyp : client.proxy.getAllMeldungstyp()) {
					cbMeldungstyp.getItems().add(meldungstyp);
				}	
			
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void init(Mangel mangel) {
			try {	
				this.mangel = mangel;
				lblMeldungProjekt.setText(mangel.getFkProjekt().getBezeichnung());
				cbMeldungMangel.getSelectionModel().select(mangel);
				login = client.proxy.getLoginById(Main.loginId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@FXML
		public void meldungSave() {
			timestamp = (GregorianCalendar) Calendar.getInstance();
			client.proxy.addMeldung(new Meldung(mangel, cbMeldungstyp.getSelectionModel().getSelectedItem(), txtMeldungBeschreibung.getText(),timestamp, false, login));
			
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
