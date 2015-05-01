<<<<<<< HEAD
=======

>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
<<<<<<< HEAD
import java.text.DateFormat;
import java.text.SimpleDateFormat;
=======
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Projekt;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The MangelController handles all interaction with Mangel *
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class MangelController implements Initializable {
	// RMI Client to interact
	ClientRMI client = null;

	// Define overviewtable with columns
	@FXML
	private TableView<Mangel> tblMangel;
	@FXML
	private TableColumn<Mangel, String> colMangelId;
	@FXML
	private TableColumn<Mangel, String> colMangelBezeichnung;
	@FXML
	private TableColumn<Mangel, String> colMangelProjekt;
	@FXML
<<<<<<< HEAD
	private TableColumn<Mangel, String> colMangelFaelligkeitsdatum;
=======
	private TableColumn<Mangel, String> colMangelFaehlligkeitsdatum;
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
	@FXML
	private TableColumn<Mangel, String> colMangelAbschlusszeit;
	@FXML
	private TableColumn<Mangel, String> colMangelMangelstatus;

	// Datalist for Tableview
	ObservableList<Mangel> data;

<<<<<<< HEAD
	
=======
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
	// SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

<<<<<<< HEAD
		 DateFormat formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		 DateFormat formatZeit = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		 
=======
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
		colMangelId.setCellValueFactory(new PropertyValueFactory<Mangel, String>("id"));
		colMangelBezeichnung.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
						return new SimpleStringProperty(p.getValue().getBezeichnung());
					}
				});
		colMangelProjekt.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
						return new SimpleStringProperty(p.getValue().getFkProjekt().getBezeichnung());
					}
				});
<<<<<<< HEAD
		
		colMangelFaelligkeitsdatum.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(formatDatum.format(p.getValue().getFaelligkeitsDatum().getTime()));
			}
		});
		
		colMangelAbschlusszeit.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(formatZeit.format(p.getValue().getAbschlussZeit().getTime()));
			}
		});
		
=======
		colMangelFaehlligkeitsdatum.setCellValueFactory(new PropertyValueFactory<Mangel, String>("faelligkeitsDatum"));
		colMangelAbschlusszeit.setCellValueFactory(new PropertyValueFactory<Mangel, String>("abschlussZeit"));
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
		colMangelMangelstatus.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(p.getValue().getFkMangelstatus().getBezeichnung());
			}
		});

		

		// Client interaction
		try {
			client = ClientRMI.getInstance();
<<<<<<< HEAD
			data = FXCollections.observableArrayList(client.getAllMaengel());
=======
			data = FXCollections.observableArrayList(client.getAllMangel());
>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set data to tableview
		tblMangel.setItems(data);
	}

}
<<<<<<< HEAD
=======

>>>>>>> 8e796e074643e2136c6747c0a56e4ed19c958b18
