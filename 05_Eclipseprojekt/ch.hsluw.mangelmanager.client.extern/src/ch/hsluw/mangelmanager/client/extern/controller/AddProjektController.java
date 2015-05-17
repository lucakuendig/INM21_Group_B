package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Projektstatus;

public class AddProjektController implements Initializable {
		//WS Client to interact
		ClientWS client = null;
		RootController rootController = null;
		Projekt projekt = null;
		DateFormat formatDatum = null;
		DateTimeFormatter dateFormatter = null;
		List<Bauherr> b = null;
		Adresse a = null;
		Projektstatus ps = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		@FXML
		private TextField txtProjektBezeichnung;
		@FXML
		private ChoiceBox<Bauherr> cbProjektBauherr;
		@FXML
		private TextField txtProjektStrasse;
		@FXML 
		private ComboBox<Plz> cbProjektPlz;
		@FXML
		private Label lblProjektOrt;
		@FXML 
		private ChoiceBox<Objekttyp> cbProjektObjekttyp;
		@FXML 
		private ChoiceBox<Arbeitstyp> cbProjektArbeitstyp;
		@FXML
		private DatePicker dateProjektStartdatum;
		@FXML
		private DatePicker dateProjektFaellig;
		
		@FXML
		private void addProjekt(){
			b = new ArrayList<Bauherr>();
			b.add(cbProjektBauherr.getSelectionModel().getSelectedItem());
			
			a = new Adresse(txtProjektStrasse.getText(), cbProjektPlz.getSelectionModel().getSelectedItem());
			projekt = new Projekt(a,txtProjektBezeichnung.getText(),b, new GregorianCalendar(dateProjektStartdatum.getValue().getYear(), dateProjektStartdatum.getValue().getMonthValue() -1, dateProjektStartdatum.getValue().getDayOfMonth()),null,cbProjektObjekttyp.getSelectionModel().getSelectedItem(),cbProjektArbeitstyp.getSelectionModel().getSelectedItem(), new GregorianCalendar(dateProjektFaellig.getValue().getYear(), dateProjektFaellig.getValue().getMonthValue() -1, dateProjektFaellig.getValue().getDayOfMonth()),ps);
			//client.addAdresse(a);
			client.proxy.addProjekt(projekt);		
			
			try {
				// Load Projekt overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/projekt/AusseresProjekt.fxml"));
				AnchorPane projekte = (AnchorPane) loader.load();
				
				ProjektController projektController = loader.<ProjektController>getController();
				projektController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(projekte);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		@FXML
		private void cancelProjekt(){
			try {
				// Load Projekt overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/projekt/AusseresProjekt.fxml"));
				AnchorPane projekte = (AnchorPane) loader.load();
				
				ProjektController projektController = loader.<ProjektController>getController();
				projektController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(projekte);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@FXML
		private void plzChange(){
			if (cbProjektPlz.getSelectionModel().getSelectedItem() != null){
				lblProjektOrt.setText(cbProjektPlz.getSelectionModel().getSelectedItem().getOrt());
			}
		}

	
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			client = ClientWS.getInstance();
			formatDatum = new SimpleDateFormat("dd.MM.yyyy");
			dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			for (Bauherr bauherr : FXCollections.observableArrayList(client.proxy.getAllBauherr())) {
				cbProjektBauherr.getItems().add(bauherr);
			}
			for (Plz plz : FXCollections.observableArrayList(client.proxy.getAllPlz())) {
				cbProjektPlz.getItems().add(plz);
			}
			for (Objekttyp objekttyp : FXCollections.observableArrayList(client.proxy.getAllObjekttyp())) {
				cbProjektObjekttyp.getItems().add(objekttyp);
			}
			for (Arbeitstyp arbeitstyp : FXCollections.observableArrayList(client.proxy.getAllArbeitstyp())) {
				cbProjektArbeitstyp.getItems().add(arbeitstyp);
			}
			for (Projektstatus projektstatus : FXCollections.observableArrayList(client.proxy.getAllProjektstatus())) {
				if(projektstatus.getBezeichnung().equals("Offen")){
					ps = projektstatus;
				}
			}
			
			// Client interaction
			try {
				client = ClientWS.getInstance();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
