package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Projekt;

/**
 * The ProjektController handles all interaction with projects *
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class ProjektController implements Initializable {
	// WS Client to interact
	ClientWS client = null;
	RootController rootController = null;

	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}

	// Define overviewtable with columns
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
	private TableColumn<Projekt, String> colProjektOffeneMeldungen;
	@FXML
	private TableColumn<Projekt, String> colProjektAbgeschlossen;

	// Datalist for Tableview
	ObservableList<Projekt> data;

	// Suche
	@FXML
	private ChoiceBox<String> cbProjektSearch;
	@FXML
	private TextField txtProjektSearch;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setCellValueFactoryTblProjekt();

		// Client interaction
		try {
			client = ClientWS.getInstance();
			data = FXCollections.observableArrayList(client.proxy.getAllProjekt());
		} catch (Exception e) {
			e.printStackTrace();
		}

		cbProjektSearch.getItems().addAll(
				FXCollections.observableArrayList("Bezeichnung", "Bauherr",
						"Plz", "Ort",
						"Projektstatus"));
		cbProjektSearch.getSelectionModel().selectFirst();
		
		//If selected Item is changed clean txtProjektSearch
		cbProjektSearch.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {                
            	txtProjektSearch.setText("");          
            }    
        });
		// Handle TextField text changes.
		txtProjektSearch.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
		    	if(newValue.length() <1){
		    		updateTblProjekt(FXCollections.observableArrayList(client.proxy.getAllProjekt()));
		    	}
		    	else{
		    	switch (cbProjektSearch.getSelectionModel().getSelectedItem()) {
					case "Bezeichnung":
						updateTblProjekt(FXCollections.observableArrayList(client.proxy.getProjektByBezeichnung(txtProjektSearch.getText())));
						break;
					case "Bauherr":
						updateTblProjekt(FXCollections.observableArrayList(client.proxy.getProjektByBauherr(txtProjektSearch.getText())));
						break;
					case "Plz":
						updateTblProjekt(FXCollections.observableArrayList(client.proxy.getProjektByPlz(txtProjektSearch.getText())));
						break;
					case "Ort":
						updateTblProjekt(FXCollections.observableArrayList(client.proxy.getProjektByOrt(txtProjektSearch.getText())));
						break;
					case "Projektstatus":
						updateTblProjekt(FXCollections.observableArrayList(client.proxy.getProjektByProjektstatus(txtProjektSearch.getText())));
						break;
					default:
						updateTblProjekt(data);
						break;
					}
		    	}
		    }
		    
		});

		// Set data to tableview
		updateTblProjekt(data);
	}

	private void updateTblProjekt(ObservableList<Projekt> data) {
		// TODO Auto-generated method stub
			tblProjekt.setItems(data);
	}

	private void setCellValueFactoryTblProjekt() {
		// SetCellValueFactory from overviewtable
		colProjektId
				.setCellValueFactory(new PropertyValueFactory<Projekt, String>(
						"id"));
		colProjektBezeichnung
				.setCellValueFactory(new PropertyValueFactory<Projekt, String>(
						"bezeichnung"));

		colProjektBauherr
				.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(
							CellDataFeatures<Projekt, String> p) {
						return new SimpleStringProperty(p.getValue()
								.getFkBauherr().get(0).getNachname()
								+ " "
								+ p.getValue().getFkBauherr().get(0)
										.getVorname());
					}
				});

		colProjektAdresse
				.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
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


		colProjektAbgeschlossen
				.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(
							CellDataFeatures<Projekt, String> p) {
						return new SimpleStringProperty(p.getValue()
								.getFkProjektstatus().getBezeichnung());
					}
				});
	}

	@FXML
	public void showProjektDetail(MouseEvent t) throws IOException {
		if (t.getClickCount() == 2) {
			System.out.println(tblProjekt.getSelectionModel().getSelectedItem()
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

				detailProjektController.init(tblProjekt.getSelectionModel()
						.getSelectedItem().getId());
				rootController.rootLayout.setCenter(inneresProjekt);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	@FXML
	private void addProjekt(){
		try {
			// Load ProjektAdd View.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/projekt/AddProjekt.fxml"));
			AnchorPane addProjekt = (AnchorPane) loader.load();

			AddProjektController addProjektController = loader
					.<AddProjektController> getController();
			addProjektController.setRootController(rootController);

			rootController.rootLayout.setCenter(addProjekt);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
