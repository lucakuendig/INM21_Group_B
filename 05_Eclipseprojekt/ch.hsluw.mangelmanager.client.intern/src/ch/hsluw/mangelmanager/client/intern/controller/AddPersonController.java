package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The AddPersonController handles all interaction with person * 
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class AddPersonController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	RootController rootController = null;
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	
	Bauherr bauherr;
	GuMitarbeiter guMitarbeiter;
	SuMitarbeiter suMitarbeiter;
	Login login;
	Adresse adresse;
	
	//Declare FXML objects
	@FXML
	private TextField txtPersonName;
	@FXML
	private TextField txtPersonVorname;
	@FXML
	private TextField txtPersonStrasse;
	@FXML
	private TextField txtPersonTelefon;
	@FXML
	private Label lblPersonOrt;
	@FXML 
	private ComboBox<Plz> cbPersonPlz;
	@FXML
	private ComboBox cbPersonFunktion;
	@FXML 
	private ChoiceBox<Subunternehmen> cbPersonUnternehmen;
	@FXML
	private Label lblPersonError;
	@FXML 
	private TitledPane tpPersonLogin;
	@FXML
	private TextField txtPersonBenutzername;
	@FXML
	private TextField txtPersonPasswort;
	@FXML
	private TextField txtPersonPasswortWiederholen;
	@FXML
	private TextField txtPersonEmail;
	@FXML
	private ComboBox<Rolle> cbPersonRolle;
	
	//Saves a new Person objekt
	@FXML
	public void personSave(){
		// TODO
		if(cbPersonFunktion.getValue() != null){
			if(cbPersonFunktion.getValue().equals("GuMitarbeiter")){
				login = new Login(txtPersonBenutzername.getText(), txtPersonPasswort.getText(), txtPersonEmail.getText(), cbPersonRolle.getSelectionModel().getSelectedItem());
				guMitarbeiter = new GuMitarbeiter(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), login);
				client.addGuMitarbeiter(guMitarbeiter);
			}else if(cbPersonFunktion.getValue().equals("SuMitarbeiter")){
				login = new Login(txtPersonBenutzername.getText(), txtPersonPasswort.getText(), txtPersonEmail.getText(), cbPersonRolle.getSelectionModel().getSelectedItem());
				suMitarbeiter = new SuMitarbeiter(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), cbPersonUnternehmen.getSelectionModel().getSelectedItem(), login);
				client.addSuMitarbeiter(suMitarbeiter);
			}else{
				adresse = new Adresse(txtPersonStrasse.getText(), cbPersonPlz.getSelectionModel().getSelectedItem());
				bauherr = new Bauherr(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), adresse);
				client.addBauherr(bauherr);
			}
		}else{
			lblPersonError.setText("Funktion Ausw�hlen");
		}
		try {
			// Load Unternehmen overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/person/AusserePerson.fxml"));
			AnchorPane person = (AnchorPane) loader.load();
			
			PersonController personController = loader.<PersonController>getController();
			personController.setRootController(rootController);
			
			rootController.rootLayout.setCenter(person);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void personCancel(){
		try {
			// Load Unternehmen overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/person/AusserePerson.fxml"));
			AnchorPane person = (AnchorPane) loader.load();
			
			PersonController personController = loader.<PersonController>getController();
			personController.setRootController(rootController);
			
			rootController.rootLayout.setCenter(person);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//enabled or disabled fields if not needed
	@FXML
	public void enableFields(){
		if(cbPersonFunktion.getValue() != null){
			if(cbPersonFunktion.getValue().equals("GuMitarbeiter")){
				tpPersonLogin.setDisable(false);
				cbPersonUnternehmen.setDisable(true);
				cbPersonPlz.setDisable(true);
				txtPersonStrasse.setDisable(true);

			}
			else if(cbPersonFunktion.getValue().equals("SuMitarbeiter")){
				tpPersonLogin.setDisable(false);
				cbPersonUnternehmen.setDisable(false);
				cbPersonPlz.setDisable(true);
				txtPersonStrasse.setDisable(true);
			}
			else if(cbPersonFunktion.getValue().equals("Bauherr")){
				tpPersonLogin.setDisable(true);
				cbPersonUnternehmen.setDisable(true);
				cbPersonPlz.setDisable(false);
				txtPersonStrasse.setDisable(false);
			}
		}
	}
	
	
	
	@FXML
	private void plzChange(){
		if (cbPersonPlz.getSelectionModel().getSelectedItem() != null){
			lblPersonOrt.setText(cbPersonPlz.getSelectionModel().getSelectedItem().getOrt());
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {			try {
		client = ClientRMI.getInstance();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
			cbPersonPlz.getItems().add(plz);
		}
		for (Subunternehmen subunternehmen : FXCollections.observableArrayList(client.getAllSubunternehmen())) {
			cbPersonUnternehmen.getItems().add(subunternehmen);
		}
		for (Rolle rolle : FXCollections.observableArrayList(client.getAllRolle())) {
			cbPersonRolle.getItems().add(rolle);
		}
		cbPersonFunktion.setItems(FXCollections.observableArrayList("Bauherr","SuMitarbeiter","GuMitarbeiter"));
	}

	
}
