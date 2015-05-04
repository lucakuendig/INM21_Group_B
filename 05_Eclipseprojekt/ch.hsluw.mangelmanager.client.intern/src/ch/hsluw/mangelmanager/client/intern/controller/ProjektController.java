package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
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
 * The ProjektController handles all interaction with projects * 
 * 
 * @author sritz
 * @version 1.0
 *
 */

public class ProjektController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	
	@FXML
	public BorderPane rootLayout;
	
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
	private TableColumn<Projekt, String> colProjektOffeneMeldungen;
	@FXML
	private TableColumn<Projekt, String> colProjektAbgeschlossen;
	
	//Datalist for Tableview
	ObservableList<Projekt> data;
	
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//SetCellValueFactory from overviewtable
		colProjektId.setCellValueFactory(new PropertyValueFactory<Projekt, String>("id"));
		colProjektBezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bezeichnung"));

		colProjektBauherr.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkBauherr().get(0).getNachname() + " " + p.getValue().getFkBauherr().get(0).getVorname());
		    }
		});
		
		colProjektAdresse.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkAdresse().getStrasse() + " " +p.getValue().getFkAdresse().getPlz().getPlz() + " " + p.getValue().getFkAdresse().getPlz().getOrt());
		    }
		});
		
		colProjektOffeneMaengel.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Projekt, String> p) {
		    	int anzMaengel = p.getValue().getFkMaengel().size();
		    	int anzOffeneMaengel = 0;
		    	for (int i = 0; i < anzMaengel; i++) {
		    		if (p.getValue().getFkMaengel().get(i).getFkMangelstatus().getBezeichnung() == "offen") {
		    			anzOffeneMaengel++;
					}
					
				}
		        return new SimpleStringProperty(String.valueOf(anzOffeneMaengel));
		    }
		});
		
		colProjektOffeneMeldungen.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Projekt, String> p) {
		    	int anzMaengel = p.getValue().getFkMaengel().size();
		    	int anzMeldungen = 0;
		    	int anzOffeneMeldungen = 0;
		    	for (int i = 0; i < anzMaengel; i++) {
		    		anzMeldungen = p.getValue().getFkMaengel().get(i).getFkMeldung().size();
		    		for (int j = 0; j < anzMeldungen; j++) {
		    			if(p.getValue().getFkMaengel().get(i).getFkMeldung().get(j).getQuittiert()){
		    				anzOffeneMeldungen++;
		    			}
					}
				}
		        return new SimpleStringProperty(String.valueOf(anzOffeneMeldungen));     	
		    }
		});
		
		colProjektAbgeschlossen.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(CellDataFeatures<Projekt, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkProjektstatus().getBezeichnung());
		    }
		});
		
		
		
		//Client interaction
		try {
			client = ClientRMI.getInstance();
			data = FXCollections.observableArrayList(client.getAllProjekt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//Set data to tableview
		tblProjekt.setItems(data);
		
    	
	
	}
	
	@FXML
	public void showProjektDetail(MouseEvent t) throws IOException{
		if(t.getClickCount() == 2){
			System.out.println(tblProjekt.getSelectionModel().getSelectedItem().getId());
			
			try {
				// Load Unternehmen overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/projekt/InneresProjekt.fxml"));
				AnchorPane inneresProjekt = (AnchorPane) loader.load();
				ProjektDetailController detailProjekt = new ProjektDetailController();
				detailProjekt.loadDetailData(tblProjekt.getSelectionModel().getSelectedItem().getId());
				rootLayout.setCenter(inneresProjekt);
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
	}
	

	
	

}
