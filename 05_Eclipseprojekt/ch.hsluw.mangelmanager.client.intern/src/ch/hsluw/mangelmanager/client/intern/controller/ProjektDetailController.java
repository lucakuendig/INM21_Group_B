package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
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
	private ChoiceBox<Objekttyp> cbProjektObjekttyp;
	@FXML 
	private ChoiceBox<Arbeitstyp> cbProjektArbeitstyp;
	@FXML
	private Label lblProjektStartdatum;
	@FXML
	private DatePicker dateProjektEnddatum;	
	@FXML
	private Label lblProjektFaellig;
	
	//Right Panel Mangel
	@FXML
	private TableView<Mangel> tblProjektMangel;
	@FXML
	private TableColumn<Mangel, String> colProjektMangelId;
	@FXML
	private TableColumn<Mangel, String> colProjektMangelBezeichnung;
	ObservableList<Mangel> mangelData;
	
	//Right Panel Meldung
	@FXML
	private TableView<Meldung> tblProjektMeldung;
	@FXML
	private TableColumn<Meldung, String> colProjektMeldungId;
	@FXML
	private TableColumn<Meldung, String> colProjektMeldungBezeichnung;

	ObservableList<Meldung> meldungData;
	
	//Right Panel SubUnternehmen
	@FXML
	private TableView<Subunternehmen> tblProjektUnternehmen;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenId;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenName;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenStrasse;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenPlz;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenOrt;
	@FXML
	private TableColumn<Subunternehmen, String> colProjektUnternehmenTelefon;

	ObservableList<Subunternehmen> subunternehmenData;
	
	@FXML
	private ComboBox<Subunternehmen> cbSubunternehmen;
	@FXML
	private ComboBox<SuMitarbeiter> cbAnsprechperson;
	
	

	//Right Panel Bauleiter
	@FXML
	private TableView<ProjektGuMitarbeiter> tblProjektBauleiter;
	@FXML
	private TableColumn<ProjektGuMitarbeiter, String> colProjektBauleiterId;
	@FXML
	private TableColumn<ProjektGuMitarbeiter, String> colProjektBauleiterName;
	@FXML
	private TableColumn<ProjektGuMitarbeiter, String> colProjektBauleiterVorname;
	@FXML
	private TableColumn<ProjektGuMitarbeiter, String> colProjektBauleiterStartdatum;
	@FXML
	private TableColumn<ProjektGuMitarbeiter, String> colProjektBauleiterEnddatum;


	ObservableList<ProjektGuMitarbeiter> bauleiterData;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		client = ClientRMI.getInstance();
		formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		
		for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
			cbProjektPlz.getItems().add(plz.getPlz());
		}
		for (Objekttyp objekttyp : FXCollections.observableArrayList(client.getAllObjekttyp())) {
			cbProjektObjekttyp.getItems().add(objekttyp);
		}
		for (Arbeitstyp arbeitstyp : FXCollections.observableArrayList(client.getAllArbeitstyp())) {
			cbProjektArbeitstyp.getItems().add(arbeitstyp);
		}
		for (Subunternehmen subunternehmen : FXCollections.observableArrayList(client.getAllSubunternehmen())) {
			cbSubunternehmen.getItems().add(subunternehmen);
		}
		
		
		
		// Client interaction
		try {
			client = ClientRMI.getInstance();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		setCellValueFactoryTblMangel();
		setCellValueFactoryTblMeldung();
		setCellValueFactoryTblUnternehmen();
		setCellValueFactoryTblBauleiter();
	
		
	}
	
	
	private void setCellValueFactoryTblBauleiter() {
		// TODO Auto-generated method stub
		colProjektBauleiterId.setCellValueFactory(new PropertyValueFactory<ProjektGuMitarbeiter, String>("idProjekt"));

		colProjektBauleiterName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProjektGuMitarbeiter, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<ProjektGuMitarbeiter, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkMitarbeiter().getNachname());
		    }
		});
		colProjektBauleiterName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProjektGuMitarbeiter, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<ProjektGuMitarbeiter, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkMitarbeiter().getVorname());
		    }
		});
		
		colProjektBauleiterStartdatum.setCellValueFactory(new Callback<CellDataFeatures<ProjektGuMitarbeiter, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ProjektGuMitarbeiter, String> p) {
				if (p.getValue().getStartDatum() == null){
					return new SimpleStringProperty(" ");
				}else{
					return new SimpleStringProperty(formatDatum.format(p.getValue().getStartDatum().getTime()));
				}
			}
		});
		colProjektBauleiterEnddatum.setCellValueFactory(new Callback<CellDataFeatures<ProjektGuMitarbeiter, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ProjektGuMitarbeiter, String> p) {
				if (p.getValue().getEndDatum() == null){
					return new SimpleStringProperty(" ");
				}else{
					return new SimpleStringProperty(formatDatum.format(p.getValue().getEndDatum().getTime()));
				}
			}
		});
	}


	private void setCellValueFactoryTblMeldung() {
		colProjektMeldungId.setCellValueFactory(new PropertyValueFactory<Meldung, String>("id"));
		colProjektMeldungBezeichnung.setCellValueFactory(new PropertyValueFactory<Meldung, String>("text"));
	}


	private void setCellValueFactoryTblMangel() {
		colProjektMangelId.setCellValueFactory(new PropertyValueFactory<Mangel, String>("id"));
		colProjektMangelBezeichnung.setCellValueFactory(new PropertyValueFactory<Mangel, String>("bezeichnung"));
	}
	
	private void setCellValueFactoryTblUnternehmen() {
		colProjektUnternehmenId.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("id"));
		colProjektUnternehmenName.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("name"));
		colProjektUnternehmenStrasse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkAdresse().getStrasse());
		    }
		});
		colProjektUnternehmenPlz.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkAdresse().getPlz().getPlz().toString());
		    }
		});
		colProjektUnternehmenOrt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		        return new SimpleStringProperty( p.getValue().getFkAdresse().getPlz().getOrt());
		    }
		});
		colProjektUnternehmenTelefon.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("telefon"));	
	}


	public void init(int projektId) {
			try {
			projekt = client.getProjektById(projektId);
			lblPersonId.setText(projekt.getId().toString());
			lblProjektBauherr.setText(projekt.getFkBauherr().get(0).getNachname() + " " +projekt.getFkBauherr().get(0).getVorname());
			txtProjektStrasse.setText(projekt.getFkAdresse().getStrasse());
			cbProjektPlz.getSelectionModel().select(projekt.getFkAdresse().getPlz().getPlz());
			lblProjektOrt.setText(client.getPlzById((Integer) cbProjektPlz.getSelectionModel().getSelectedItem()).getOrt());
			cbProjektObjekttyp.getSelectionModel().select(projekt.getFkObjekttyp());
			cbProjektArbeitstyp.getSelectionModel().select(projekt.getFkArbeitstyp());
			lblProjektStartdatum.setText(formatDatum.format(projekt.getStartDatum().getTime()));
			dateProjektEnddatum.setValue(LocalDate.parse(formatDatum.format(projekt.getEndDatum().getTime()), dateFormatter));
			lblProjektFaellig.setText(formatDatum.format(projekt.getFaelligkeitsDatum().getTime()));
			
			mangelData = FXCollections.observableArrayList(client.getAllMangelProjekt(projekt));
			subunternehmenData = FXCollections.observableArrayList(client.getUnternehmenByProjekt(projekt));
			bauleiterData = FXCollections.observableArrayList(client.getBauleiterByProjekt(projekt));
//			
			tblProjektMangel.setItems(mangelData);
			tblProjektUnternehmen.setItems(subunternehmenData);
			tblProjektBauleiter.setItems(bauleiterData);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void showMeldungByMangel(){
		meldungData = FXCollections.observableArrayList(client.getAllMeldungByMangel(tblProjektMangel.getSelectionModel().getSelectedItem()));
		tblProjektMeldung.setItems(meldungData);
	}
	
	@FXML
	public void projektCancel(){
		
	}
	@FXML
	public void fillCbAnsprechperson(){
		for (SuMitarbeiter sumitarbeiter : client.getAllSubunternehmenMitarbeiter(cbSubunternehmen.getSelectionModel().getSelectedItem())) {
			cbAnsprechperson.getItems().add(sumitarbeiter);
		}	
	}
	
	@FXML
	public void projektSave(){
	
		projekt.getFkAdresse().setStrasse(txtProjektStrasse.getText());
		projekt.getFkAdresse().getPlz().setPlz((Integer) cbProjektPlz.getSelectionModel().getSelectedItem());
		projekt.getFkAdresse().getPlz().setOrt(lblProjektOrt.getText());
		
		projekt.setFkObjekttyp(cbProjektObjekttyp.getSelectionModel().getSelectedItem());
		projekt.setFkArbeitstyp(cbProjektArbeitstyp.getSelectionModel().getSelectedItem());
		projekt.setEndDatum(new GregorianCalendar(dateProjektEnddatum.getValue().getYear(), dateProjektEnddatum.getValue().getMonthValue() -1, dateProjektEnddatum.getValue().getDayOfMonth()));

		client.updateProjekt(projekt);		
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
		GregorianCalendar c1 = (GregorianCalendar) Calendar.getInstance();
		client.addSuMitarbeiterByProjekt(new ProjektSuMitarbeiter(projekt, cbAnsprechperson.getSelectionModel().getSelectedItem(),c1, null));
		subunternehmenData = FXCollections.observableArrayList(client.getUnternehmenByProjekt(projekt));
		tblProjektUnternehmen.setItems(subunternehmenData);
	}
	
	@FXML
	public void projektAddBauleiter(){
		
	}
	
	@FXML
	private void plzChange(){
		if (cbProjektPlz.getSelectionModel().getSelectedItem() != null){
			lblProjektOrt.setText(client.getPlzById((Integer) cbProjektPlz.getSelectionModel().getSelectedItem()).getOrt());
		}else{	
		}
	}

}
