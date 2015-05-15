package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
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
import javafx.scene.input.MouseEvent;
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
	// WS Client to interact
	ClientWS client = null;

	RootController rootController = null;
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	
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
	private TableColumn<Mangel, String> colMangelErfassungsdatum;
	@FXML
	private TableColumn<Mangel, String> colMangelFaelligkeitsdatum;
	@FXML
	private TableColumn<Mangel, String> colMangelAbschlusszeit;
	@FXML
	private TableColumn<Mangel, String> colMangelMangelstatus;

	// Datalist for Tableview
	ObservableList<Mangel> data;

	// SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		 DateFormat formatDatum = new SimpleDateFormat("dd.MM.yyyy");
		 DateFormat formatZeit = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		 
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
		
		colMangelErfassungsdatum.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				if (p.getValue().getErfassungsZeit() == null){
					return new SimpleStringProperty(" ");
				}else{
					return new SimpleStringProperty(formatZeit.format(p.getValue().getErfassungsZeit().getTime()));
				}
			}
		});
		
		colMangelFaelligkeitsdatum.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				if (p.getValue().getFaelligkeitsDatum() == null){
					return new SimpleStringProperty(" ");
				}else{
					return new SimpleStringProperty(formatDatum.format(p.getValue().getFaelligkeitsDatum().getTime()));
				}
			}
		});
		
		colMangelAbschlusszeit.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				if (p.getValue().getAbschlussZeit() == null){
					return new SimpleStringProperty(" ");
				}else{
				return new SimpleStringProperty(formatZeit.format(p.getValue().getAbschlussZeit().getTime()));
				}
			}
		});
		
		colMangelMangelstatus.setCellValueFactory(new Callback<CellDataFeatures<Mangel, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Mangel, String> p) {
				return new SimpleStringProperty(p.getValue().getFkMangelstatus().getBezeichnung());
			}
		});

		

		// Client interaction
		try {
			client = ClientWS.getInstance();
			data = FXCollections.observableArrayList(client.proxy.getAllMangel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set data to tableview
		tblMangel.setItems(data);
	}

	
	@FXML
	public void showMangelDetail(MouseEvent t) throws IOException{
		if(t.getClickCount() == 2){
			System.out.println(tblMangel.getSelectionModel().getSelectedItem().getId());
			
			try {
				// Load MangelDetail View.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/mangel/InnererMangel.fxml"));
				AnchorPane innererMangel = (AnchorPane) loader.load();
				
				MangelDetailController detailMangelController = loader.<MangelDetailController>getController();
				detailMangelController.setRootController(rootController);
				
				detailMangelController.init(tblMangel.getSelectionModel().getSelectedItem().getId());
				rootController.rootLayout.setCenter(innererMangel);
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
}

