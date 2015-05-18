package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Rolle;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * The AddPersonController handles all interaction with person * 
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class AddPersonController implements Initializable {
	//WS Client to interact
	ClientWS client = null;
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
				if(txtPersonPasswort.getText().equals(txtPersonPasswortWiederholen.getText())){
					login = new Login(txtPersonBenutzername.getText(), txtPersonPasswort.getText(), txtPersonEmail.getText(), cbPersonRolle.getSelectionModel().getSelectedItem());
					guMitarbeiter = new GuMitarbeiter(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), login);
					client.proxy.addGuMitarbeiter(guMitarbeiter);
				}else{
					lblPersonError.setText("Passwort wiederholen!");
					return;
				}
			}else if(cbPersonFunktion.getValue().equals("SuMitarbeiter")){
				if(txtPersonPasswort.getText().equals(txtPersonPasswortWiederholen.getText())){
					login = new Login(txtPersonBenutzername.getText(), txtPersonPasswort.getText(), txtPersonEmail.getText(), cbPersonRolle.getSelectionModel().getSelectedItem());
					suMitarbeiter = new SuMitarbeiter(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), cbPersonUnternehmen.getSelectionModel().getSelectedItem(), login);
					client.proxy.addSuMitarbeiter(suMitarbeiter);
				}else{
					lblPersonError.setText("Passwort wiederholen!");
					return;
				}
			}else{
				adresse = new Adresse(txtPersonStrasse.getText(), cbPersonPlz.getSelectionModel().getSelectedItem());
				bauherr = new Bauherr(txtPersonName.getText(), txtPersonVorname.getText(), txtPersonTelefon.getText(), adresse);
				client.proxy.addBauherr(bauherr);
			}
		}else{
			lblPersonError.setText("Funktion Auswählen");
			return;
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
		client = ClientWS.getInstance();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		for (Plz plz : FXCollections.observableArrayList(client.proxy.getAllPlz())) {
			cbPersonPlz.getItems().add(plz);
		}
		for (Subunternehmen subunternehmen : FXCollections.observableArrayList(client.proxy.getAllSubunternehmen())) {
			cbPersonUnternehmen.getItems().add(subunternehmen);
		}
		for (Rolle rolle : FXCollections.observableArrayList(client.proxy.getAllRolle())) {
			cbPersonRolle.getItems().add(rolle);
		}
		cbPersonFunktion.setItems(FXCollections.observableArrayList("Bauherr","SuMitarbeiter","GuMitarbeiter"));
	}

	
}
