package ch.hsluw.mangelmanager.client.intern.controller;

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
	
	Projekt projekt = null;
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
	private TextField txtPersonOrt;
	@FXML
	private TextField txtPersonTelefon;
	@FXML
	private ChoiceBox<String> cbPersonUnternehmen;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
