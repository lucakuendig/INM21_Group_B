package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Projekt;

public class PersonController implements Initializable {
	RootController rootController = null;
	// RMI Client to interact
	ClientRMI client = null;

	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub

		this.rootController = rootController;
	}

	// Define overviewtable with columns
	@FXML
	private TableView<Person> tblPerson;
	@FXML
	private TableColumn<Person, String> colPersonId;
	@FXML
	private TableColumn<Person, String> colPersonVorname;
	@FXML
	private TableColumn<Person, String> colPersonName;
	@FXML
	private TableColumn<Person, String> colPersonAdresse;
	@FXML
	private TableColumn<Person, String> colPersonUnternehmen;
	@FXML
	private TableColumn<Person, String> colPersonTelefon;

	

	// Datalist for Tableview
	ObservableList<Person> data;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//SetCellValueFactory from overviewtable
//		colPersonId.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
//		colPersonVorname.setCellValueFactory(new PropertyValueFactory<Person, String>("vorname"));
//		colPersonName.setCellValueFactory(new PropertyValueFactory<Person, String>("nachname"));
//		colPersonAdresse.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
//		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
//		        return new SimpleStringProperty(((Bauherr) p).get);
//		    }
//		});
//		
		colPersonTelefon.setCellValueFactory(new PropertyValueFactory<Person, String>("telefon"));
		
	}
}
