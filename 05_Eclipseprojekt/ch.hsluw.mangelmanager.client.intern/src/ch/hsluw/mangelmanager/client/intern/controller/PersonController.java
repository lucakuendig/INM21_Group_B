package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;

/**
 * The PersonController handle all interactions with Persons
 * 
 * @author Sandro
 * @version 1.0
 */
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
	private TableColumn<Person, String> colPersonName;
	@FXML
	private TableColumn<Person, String> colPersonVorname;
	@FXML
	private TableColumn<Person, String> colPersonTyp;
	@FXML
	private TableColumn<Person, String> colPersonUnternehmen;
	@FXML
	private TableColumn<Person, String> colPersonTelefon;
	@FXML
	private TableColumn<Person, String> colPersonBenutzername;
	@FXML
	private TableColumn<Person, String> colPersonEmail;
	@FXML
	private TableColumn<Person, String> colPersonRolle;


	

	

	// Datalist for Tableview
	ObservableList<Person> data;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCellValueFactoryTblPerson();
		
		//Client interaction
				try {
					client = ClientRMI.getInstance();
					data = FXCollections.observableArrayList(client.getAllPerson());
				} catch (Exception e) {
					e.printStackTrace();
				}
				

				//Set data to tableview
				tblPerson.setItems(data);
	}

	
	
	private void setCellValueFactoryTblPerson() {
		colPersonId.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
		colPersonName.setCellValueFactory(new PropertyValueFactory<Person, String>("nachname"));
		colPersonVorname.setCellValueFactory(new PropertyValueFactory<Person, String>("vorname"));
		colPersonTyp.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		    	if (p.getValue() instanceof Bauherr) {
		    		 return new SimpleStringProperty("Bauherr");
				}
		    	else if (p.getValue() instanceof GuMitarbeiter) {
		    		 return new SimpleStringProperty("General-Mitarbeiter");
				}
		    	else if (p.getValue() instanceof SuMitarbeiter) {
		    		 return new SimpleStringProperty("Subunternehmen-Mitarbeiter");
				}	    	
		    	else{
		    		return new SimpleStringProperty("unbekannt");
		    	}
		       
		    }
		});
		
		colPersonUnternehmen.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		    	if (p.getValue() instanceof Bauherr) {
		    		 return new SimpleStringProperty("Kein Unternehmen");
				}
		    	else if (p.getValue() instanceof GuMitarbeiter) {
		    		 return new SimpleStringProperty("W & W");
				}
		    	else if (p.getValue() instanceof SuMitarbeiter) {
		    		 return new SimpleStringProperty(((SuMitarbeiter) p.getValue()).getFkSubunternehmen().getName());
				}	    	
		    	else{
		    		return new SimpleStringProperty("unbekannt");
		    	}
		       
		    }
		});
		
		colPersonTelefon.setCellValueFactory(new PropertyValueFactory<Person, String>("telefon"));
		colPersonBenutzername.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		    	if (p.getValue() instanceof Bauherr) {
		    		 return new SimpleStringProperty("-");
				}
		    	else if (p.getValue() instanceof GuMitarbeiter) {
		    		 return new SimpleStringProperty(((GuMitarbeiter) p.getValue()).getFkLogin().getBenutzername());
				}
		    	else if (p.getValue() instanceof SuMitarbeiter) {
		    		 return new SimpleStringProperty(((SuMitarbeiter) p.getValue()).getFkLogin().getBenutzername());
				}	    	
		    	else{
		    		return new SimpleStringProperty("unbekannt");
		    	}
		    }
		});
		colPersonEmail.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		    	if (p.getValue() instanceof Bauherr) {
		    		 return new SimpleStringProperty("-");
				}
		    	else if (p.getValue() instanceof GuMitarbeiter) {
		    		 return new SimpleStringProperty(((GuMitarbeiter) p.getValue()).getFkLogin().getEmail());
				}
		    	else if (p.getValue() instanceof SuMitarbeiter) {
		    		 return new SimpleStringProperty(((SuMitarbeiter) p.getValue()).getFkLogin().getEmail());
				}	    	
		    	else{
		    		return new SimpleStringProperty("unbekannt");
		    	}
		       
		    }
		});
		colPersonRolle.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		    	if (p.getValue() instanceof Bauherr) {
		    		 return new SimpleStringProperty("-");
				}
		    	else if (p.getValue() instanceof GuMitarbeiter) {
		    		 return new SimpleStringProperty(((GuMitarbeiter) p.getValue()).getFkLogin().getFkrolle().getName());
				}
		    	else if (p.getValue() instanceof SuMitarbeiter) {
		    		 return new SimpleStringProperty(((SuMitarbeiter) p.getValue()).getFkLogin().getFkrolle().getName());
				}	    	
		    	else{
		    		return new SimpleStringProperty("unbekannt");
		    	}
		       
		    }
		});
	}
	
	@FXML
	private void addPerson(){
		try {
			// Load ProjektDetail View.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/person/AddPerson.fxml"));
			AnchorPane addPerson = (AnchorPane) loader.load();
			
			AddPersonController addPersonController = loader.<AddPersonController>getController();
			addPersonController.setRootController(rootController);
			
			rootController.rootLayout.setCenter(addPerson);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void deletePerson(){
		
	}
}
