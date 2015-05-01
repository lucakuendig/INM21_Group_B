<<<<<<< HEAD
package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
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
	private TableColumn<Mangel, String> colMangelFaehlligkeitsdatum;
	@FXML
	private TableColumn<Mangel, String> colMangelAbschlusszeit;
	@FXML
	private TableColumn<Mangel, String> colMangelMangelstatus;

	// Datalist for Tableview
	ObservableList<Mangel> data;

	// SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
		colMangelFaehlligkeitsdatum.setCellValueFactory(new PropertyValueFactory<Mangel, String>("faelligkeitsDatum"));
		colMangelAbschlusszeit.setCellValueFactory(new PropertyValueFactory<Mangel, String>("abschlussZeit"));
		colMangelMangelstatus.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(p.getValue().getFkMangelstatus().getBezeichnung());
			}
		});

		

		// Client interaction
		try {
			client = ClientRMI.getInstance();
			data = FXCollections.observableArrayList(client.getAllMangel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set data to tableview
		tblMangel.setItems(data);
	}

}
=======
package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
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
	private TableColumn<Mangel, String> colMangelFaehlligkeitsdatum;
	@FXML
	private TableColumn<Mangel, String> colMangelAbschlusszeit;
	@FXML
	private TableColumn<Mangel, String> colMangelMangelstatus;

	// Datalist for Tableview
	ObservableList<Mangel> data;

	// SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
		colMangelFaehlligkeitsdatum.setCellValueFactory(new PropertyValueFactory<Mangel, String>("faelligkeitsDatum"));
		colMangelAbschlusszeit.setCellValueFactory(new PropertyValueFactory<Mangel, String>("abschlussZeit"));
		colMangelMangelstatus.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(p.getValue().getFkMangelstatus().getBezeichnung());
			}
		});

		

		// Client interaction
		try {
			client = ClientRMI.getInstance();
			data = FXCollections.observableArrayList(client.getAllMaengel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set data to tableview
		tblMangel.setItems(data);
	}

}
>>>>>>> 38cdd69a243d109f0980e251103e0e4f932d1f12
