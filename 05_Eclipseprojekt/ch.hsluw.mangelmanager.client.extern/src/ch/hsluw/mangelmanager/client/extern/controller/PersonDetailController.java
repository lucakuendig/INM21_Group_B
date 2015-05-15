package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;



/**
 * The ProjektDetailController handles all interaction with person * 
 * 
 * @author mmont
 * @version 1.0
 *
 */
public class PersonDetailController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	RootController rootController = null;
	DateFormat formatDatum = null;
	DateTimeFormatter dateFormatter = null;
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	
	Person person = null;
	
	//Left Panel
	@FXML
	private Label lblPersonId;
	@FXML
	private Label lblPersonName;
	@FXML
	private Label lblPersonVorname;
	@FXML
	private TextField txtPersonStrasse;
	@FXML
	private ComboBox<Integer> cbPersonPlz;
	@FXML
	private Label lblPersonOrt;
	@FXML
	private TextField txtPersonTelefon;
	@FXML
	private ChoiceBox<String> cbPersonUnternehmen;
	
	// Right Panel
	@FXML
	private TextField txtPersonBenutzername;
	@FXML
	private TextField txtPersonEmail;
	@FXML
	private TableView<Projekt> tblPersonProjekt;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektid;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektbezeichnung;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektbauherr;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektadresse;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektmaengel;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektmeldungen;
	@FXML
	private TableColumn<Projekt, String> colPersonProjektabgeschlossen;
	
	ObservableList<Projekt> projektData;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		client = ClientRMI.getInstance();
		formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
			cbPersonPlz.getItems().add(plz.getPlz());
		}
		try {
			client = ClientRMI.getInstance();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		setCellValueFactoryTblProjekt();
	}

	private void setCellValueFactoryTblProjekt() {
		colPersonProjektid.setCellValueFactory(new PropertyValueFactory<Projekt, String>("id"));
		colPersonProjektbezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bezeichnung"));
		colPersonProjektbauherr.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bauherr"));
		colPersonProjektadresse.setCellValueFactory(new PropertyValueFactory<Projekt, String>("adresse"));
		colPersonProjektmaengel.setCellValueFactory(new PropertyValueFactory<Projekt, String>("maengel"));
		colPersonProjektmeldungen.setCellValueFactory(new PropertyValueFactory<Projekt, String>("meldungen"));
		colPersonProjektabgeschlossen.setCellValueFactory(new PropertyValueFactory<Projekt, String>("abgeschlossen"));
	}
	public void init(int personId) {
		try {
		//<person = client.getPersonById(personId);
		lblPersonId.setText(person.getId().toString());
		lblPersonVorname.setText(person.getVorname());
		//<txtPersonStrasse.setText(person.getFkAdresse().getStrasse());
		//<cbPersonPlz.getSelectionModel().select(person.getFkAdresse().getPlz().getPlz());
		lblPersonOrt.setText(client.getPlzById((Integer) cbPersonPlz.getSelectionModel().getSelectedItem()).getOrt());
		txtPersonTelefon.setText(person.getTelefon());
//		cbPersonUnternehmen.getSelectionModel().select(person.getFkUnternehmen.getName());
//		txtPersonBenutzername.setText(person.getFkLogin().getBenutezrname);
//		txtPersonEmail.setText(person.getFkLogin().getEmail);
		
//		projektData = FXCollections.observableArrayList(client.getAllProjektPerson(person));
		tblPersonProjekt.setItems(projektData);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	
	@FXML
	public void personCancel(){
		
	}
	@FXML
	public void personSave(){
		
	}
}
