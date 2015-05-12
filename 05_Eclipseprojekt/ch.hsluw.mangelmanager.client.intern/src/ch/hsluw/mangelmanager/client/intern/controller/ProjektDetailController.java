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
 * The ProjektDetailController handles all interaction with projects * 
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class ProjektDetailController implements Initializable {
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
	
	//Left Panel
	@FXML
	private Label lblPersonId;
	@FXML
	private Label lblProjektBauherr;
	@FXML
	private TextField txtProjektStrasse;
	@FXML 
	private ComboBox<Integer> cbProjektPlz;
	@FXML
	private Label lblProjektOrt;
	@FXML 
	private ChoiceBox<String> cbProjektObjekttyp;
	@FXML 
	private ChoiceBox<String> cbProjektArbeitstyp;
	@FXML
	private Label lblProjektStartdatum;
	@FXML
	private DatePicker dateProjektEnddatum;	
	@FXML
	private Label lblProjektFaellig;
	
	//Right Panel
	@FXML
	private TableView<Mangel> tblProjektMangel;
	@FXML
	private TableColumn<Mangel, String> colProjektMangelId;
	@FXML
	private TableColumn<Mangel, String> colProjektMangelBezeichnung;
	
	ObservableList<Mangel> mangelData;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		client = ClientRMI.getInstance();
		formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
			cbProjektPlz.getItems().add(plz.getPlz());
		}
		for (Objekttyp objekttyp : FXCollections.observableArrayList(client.getAllObjekttyp())) {
			cbProjektObjekttyp.getItems().add(objekttyp.getBezeichnung());
		}
		for (Arbeitstyp arbeitstyp : FXCollections.observableArrayList(client.getAllArbeitstyp())) {
			cbProjektArbeitstyp.getItems().add(arbeitstyp.getBezeichnung());
		}
		
		// Client interaction
		try {
			client = ClientRMI.getInstance();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		setCellValueFactoryTblMangel();
		
	}


	private void setCellValueFactoryTblMangel() {
		colProjektMangelId.setCellValueFactory(new PropertyValueFactory<Mangel, String>("id"));
		colProjektMangelBezeichnung.setCellValueFactory(new PropertyValueFactory<Mangel, String>("bezeichnung"));
	}


	public void init(int projektId) {
			try {
			projekt = client.getProjektById(projektId);
			lblPersonId.setText(projekt.getId().toString());
			lblProjektBauherr.setText(projekt.getFkBauherr().get(0).getNachname() + " " +projekt.getFkBauherr().get(0).getVorname());
			txtProjektStrasse.setText(projekt.getFkAdresse().getStrasse());
			cbProjektPlz.getSelectionModel().select(projekt.getFkAdresse().getPlz().getPlz());
			lblProjektOrt.setText(client.getPlzById((Integer) cbProjektPlz.getSelectionModel().getSelectedItem()).getOrt());
			cbProjektObjekttyp.getSelectionModel().select(projekt.getFkObjekttyp().getBezeichnung());
			cbProjektArbeitstyp.getSelectionModel().select(projekt.getFkArbeitstyp().getBezeichnung());
			lblProjektStartdatum.setText(formatDatum.format(projekt.getStartDatum().getTime()));
			dateProjektEnddatum.setValue(LocalDate.parse(formatDatum.format(projekt.getEndDatum().getTime()), dateFormatter));
			lblProjektFaellig.setText(formatDatum.format(projekt.getFaelligkeitsDatum().getTime()));
			
			mangelData = FXCollections.observableArrayList(client.getAllMangelProjekt(projekt));
			tblProjektMangel.setItems(mangelData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@FXML
	public void projektCancel(){
		
	}
	@FXML
	public void projektSave(){
		
	}
	@FXML
	public void projektAddMangel(){
		try {
			// Load ProjektDetail View.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/mangel/AddMangel.fxml"));
			AnchorPane addMangel = (AnchorPane) loader.load();
			
			AddMangelController addMangelController = loader.<AddMangelController>getController();
			addMangelController.setRootController(rootController);
			
			addMangelController.init(projekt);
			rootController.rootLayout.setCenter(addMangel);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void projektAddMeldung(){
		
	}
	@FXML
	public void projektAddUnternehmen(){
		
	}
	@FXML
	public void projektAddBauleiter(){
		
	}

}
