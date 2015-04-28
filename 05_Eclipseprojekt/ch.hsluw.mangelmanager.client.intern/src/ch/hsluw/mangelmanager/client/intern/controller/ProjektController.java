package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.ShowMethodClass;
import ch.hsluw.mangelmanager.model.Projekt;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The ProjektController handles all interaction with projects * 
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class ProjektController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	
	//Define overviewtable with columns
	@FXML
	private TableView<Projekt> tblProjekt;
	@FXML
	private TableColumn<Projekt, String> colProjektId;
	@FXML
	private TableColumn<Projekt, String> colProjektBezeichnung;
	@FXML
	private TableColumn<Projekt, String> colProjektBauherr;
	@FXML
	private TableColumn<Projekt, String> colProjektAdresse;
	@FXML
	private TableColumn<Projekt, String> colProjektOffeneMaengel;
	@FXML
	private TableColumn<Projekt, String> colProjektAbgeschlossen;
	
	//Datalist for Tableview
	ObservableList<Projekt> data;
	
	
	//SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colProjektId.setCellValueFactory(new PropertyValueFactory<Projekt, String>("id"));
		colProjektBezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bezeichnung"));

		colProjektBauherr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkBauherr().get(0).getNachname() + " " + p.getValue().getFkBauherr().get(0).getVorname());
		    }
		});
		
		colProjektAdresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkAdresse().getStrasse() + " " +p.getValue().getFkAdresse().getPlz().getPlz() + " " + p.getValue().getFkAdresse().getPlz().getOrt());
		    }
		});
		
		colProjektOffeneMaengel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Projekt, String> p) {
		    	int anzMaengel = p.getValue().getFkMaengel().size();
		    	int anzOffeneMaengel = 0;
		    	for (int i = 0; i < anzMaengel; i++) {
		    		if (p.getValue().getFkMaengel().get(i).getAbschlussZeit() == null) {
		    			anzOffeneMaengel++;
					}
					
				}
		        return new SimpleStringProperty(String.valueOf(anzOffeneMaengel));
		    }
		});
		
		colProjektAbgeschlossen.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkProjektstatus().getBezeichnung());
		    }
		});
		
		
		
		//Client interaction
		try {
			client = new ClientRMI();
			data = FXCollections.observableArrayList(client.getAllProjekt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//Set data to tableview
		tblProjekt.setItems(data);
	}
	
	

}
