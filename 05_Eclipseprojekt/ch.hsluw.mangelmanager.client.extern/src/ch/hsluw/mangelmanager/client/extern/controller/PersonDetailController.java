package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;



/**
 * The ProjektDetailController handles all interaction with person * 
 * 
 * @author mmont
 * @version 1.0
 *
 */
public class PersonDetailController implements Initializable {
	//WS Client to interact
	ClientWS client = null;
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
	private Label lblPersonUnternehmen;
	@FXML
	private TextField txtPersonStrasse;
	@FXML
	private ComboBox<Plz> cbPersonPlz;
	@FXML
	private Label lblPersonOrt;
	@FXML
	private TextField txtPersonTelefon;
	@FXML
	private Label lblPersonUnternehmenanz;
	
	// Right Panel
	@FXML
	private TitledPane tpPersonLogin;
	@FXML
	private Label lblPersonBenutzername;
	@FXML
	private Label lblPersonLoginRolle;
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
	private TableColumn<Projekt, String> colPersonProjektabgeschlossen;
	
	ObservableList<Projekt> projektData;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			client = ClientWS.getInstance();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		for (Plz plz : FXCollections.observableArrayList(client.proxy.getAllPlz())) {
			cbPersonPlz.getItems().add(plz);
		}
		
		setCellValueFactoryTblProjekt();
	}

	private void setCellValueFactoryTblProjekt() {
		colPersonProjektid.setCellValueFactory(new PropertyValueFactory<Projekt, String>("id"));
		colPersonProjektbezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bezeichnung"));
		colPersonProjektbauherr.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(
					CellDataFeatures<Projekt, String> p) {
				return new SimpleStringProperty(p.getValue()
						.getFkBauherr().get(0).getNachname()
						+ " "
						+ p.getValue().getFkBauherr().get(0)
								.getVorname());
			}
		});

		colPersonProjektadresse.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(
					CellDataFeatures<Projekt, String> p) {
				return new SimpleStringProperty(p.getValue()
						.getFkAdresse().getStrasse()
						+ " "
						+ p.getValue().getFkAdresse().getPlz().getPlz()
						+ " "
						+ p.getValue().getFkAdresse().getPlz().getOrt());
			}
		});
		colPersonProjektabgeschlossen.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(
					CellDataFeatures<Projekt, String> p) {
				return new SimpleStringProperty(p.getValue()
						.getFkProjektstatus().getBezeichnung());
			}
		});
	}
	public void init(int personId) {
		try {
		person = client.proxy.getPersonById(personId);
		projektData = FXCollections.observableArrayList(client.proxy.getProjektbyPerson(person));
		lblPersonId.setText(person.getId().toString());
		lblPersonVorname.setText(person.getVorname());
		lblPersonName.setText(person.getNachname());
		
		if(person instanceof Bauherr){
			cbPersonPlz.setDisable(false);
			lblPersonOrt.setDisable(false);
			txtPersonStrasse.setDisable(false);
			cbPersonPlz.getSelectionModel().select(((Bauherr)person).getFkAdresse().getPlz().getPlz());
			cbPersonPlz.setPromptText(((Bauherr)person).getFkAdresse().getPlz().getPlz().toString());
			lblPersonOrt.setText(((Bauherr) person).getFkAdresse().getPlz().getOrt());
			txtPersonStrasse.setText(((Bauherr)person).getFkAdresse().getStrasse());			
		}
		txtPersonTelefon.setText(person.getTelefon());
		if(person instanceof GuMitarbeiter || person instanceof SuMitarbeiter){
			tpPersonLogin.setVisible(true);
			if(person instanceof SuMitarbeiter){
			lblPersonUnternehmenanz.setVisible(true);
			lblPersonUnternehmen.setVisible(true);
			lblPersonUnternehmenanz.setText(((SuMitarbeiter)person).getFkSubunternehmen().getName());
			lblPersonBenutzername.setText(((SuMitarbeiter)person).getFkLogin().getBenutzername());
			txtPersonEmail.setText(((SuMitarbeiter)person).getFkLogin().getEmail());
			lblPersonLoginRolle.setText(((SuMitarbeiter)person).getFkLogin().getFkrolle().getName());
			}
			if(person instanceof GuMitarbeiter){
				lblPersonBenutzername.setText(((GuMitarbeiter)person).getFkLogin().getBenutzername());
				txtPersonEmail.setText(((GuMitarbeiter)person).getFkLogin().getEmail());
				lblPersonLoginRolle.setText(((GuMitarbeiter)person).getFkLogin().getFkrolle().getName());
				}
		}
		tblPersonProjekt.setItems(projektData);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
	@FXML
	public void showProjektDetail(MouseEvent t) throws IOException{
		if (t.getClickCount() == 2) {
			System.out.println(tblPersonProjekt.getSelectionModel().getSelectedItem()
					.getId());

			try {
				// Load ProjektDetail View.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/projekt/InneresProjekt.fxml"));
				AnchorPane inneresProjekt = (AnchorPane) loader.load();

				ProjektDetailController detailProjektController = loader
						.<ProjektDetailController> getController();
				detailProjektController.setRootController(rootController);

				detailProjektController.init(tblPersonProjekt.getSelectionModel()
						.getSelectedItem().getId());
				rootController.rootLayout.setCenter(inneresProjekt);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	@FXML
	private void plzChange(){
		if (cbPersonPlz.getSelectionModel().getSelectedItem() != null){
			lblPersonOrt.setText(cbPersonPlz.getSelectionModel().getSelectedItem().getOrt());
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
	
	@FXML
	public void personSave(){
		if(person instanceof SuMitarbeiter){
			person.setTelefon(txtPersonTelefon.getText());
			((SuMitarbeiter) person).getFkLogin().setEmail(txtPersonEmail.getText());
		}
		else if(person instanceof GuMitarbeiter){
			person.setTelefon(txtPersonTelefon.getText());
			((GuMitarbeiter) person).getFkLogin().setEmail(txtPersonEmail.getText());
		}
		else if(person instanceof Bauherr){
			((Bauherr) person).getFkAdresse().setStrasse(txtPersonStrasse.getText());
			((Bauherr) person).getFkAdresse().setPlz(cbPersonPlz.getSelectionModel().getSelectedItem());
			person.setTelefon(txtPersonTelefon.getText());
		}
			client.proxy.updatePerson(person);
	}
}
