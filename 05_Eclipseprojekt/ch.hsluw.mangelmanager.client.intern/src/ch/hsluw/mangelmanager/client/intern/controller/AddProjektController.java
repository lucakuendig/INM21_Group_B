package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.jmx.snmp.Timestamp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.client.intern.ShowMethodClass;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class AddProjektController implements Initializable {
		//RMI Client to interact
		ClientRMI client = null;
		RootController rootController = null;
		Projekt projekt = null;
		DateFormat formatDatum = null;
		DateTimeFormatter dateFormatter = null;
		List<Bauherr> b = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		@FXML
		private ChoiceBox<Bauherr> cbProjektBauherr;
		@FXML
		private TextField txtProjektStrasse;
		@FXML 
		private ComboBox<Integer> cbProjektPlz;
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
			projekt.setFkBauherr(b);
			projekt.setFkAdresse(new Adresse(txtProjektStrasse.getText(), new Plz(cbProjektPlz.getSelectionModel().getSelectedItem(), lblProjektOrt.getText())));
			projekt.getFkAdresse().setStrasse(txtProjektStrasse.getText());		
			projekt.setFkObjekttyp(cbProjektObjekttyp.getSelectionModel().getSelectedItem());
			projekt.setFkArbeitstyp(cbProjektArbeitstyp.getSelectionModel().getSelectedItem());
			projekt.setStartDatum(new GregorianCalendar(dateProjektStartdatum.getValue().getYear(), dateProjektStartdatum.getValue().getMonthValue() -1, dateProjektStartdatum.getValue().getDayOfMonth()));
			projekt.setFaelligkeitsDatum(new GregorianCalendar(dateProjektFaellig.getValue().getYear(), dateProjektFaellig.getValue().getMonthValue() -1, dateProjektFaellig.getValue().getDayOfMonth()));
			client.addProjekt(projekt);		
			
			try {
				// Load Projekt overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(ShowMethodClass.class
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
			
		}
		
		@FXML
		private void plzChange(){
			if (cbProjektPlz.getSelectionModel().getSelectedItem() != null){
				lblProjektOrt.setText(client.getPlzById((Integer) cbProjektPlz.getSelectionModel().getSelectedItem()).getOrt());
			}else{	
			}
		}

	
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			client = ClientRMI.getInstance();
			formatDatum = new SimpleDateFormat("dd.MM.yyyy");
			dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			for (Bauherr bauherr : FXCollections.observableArrayList(client.getAllBauherr())) {
				cbProjektBauherr.getItems().add(bauherr);
			}
			for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
				cbProjektPlz.getItems().add(plz.getPlz());
			}
			for (Objekttyp objekttyp : FXCollections.observableArrayList(client.getAllObjekttyp())) {
				cbProjektObjekttyp.getItems().add(objekttyp);
			}
			for (Arbeitstyp arbeitstyp : FXCollections.observableArrayList(client.getAllArbeitstyp())) {
				cbProjektArbeitstyp.getItems().add(arbeitstyp);
			}
			
			// Client interaction
			try {
				client = ClientRMI.getInstance();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
