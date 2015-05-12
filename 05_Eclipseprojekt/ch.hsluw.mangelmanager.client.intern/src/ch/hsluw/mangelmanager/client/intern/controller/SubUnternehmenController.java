package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.client.intern.ShowMethodClass;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The SubunternehmenController handles all interaction with subunternehmen * 
 * 
 * @author lkuendig
 * @version 1.0
 *
 */

public class SubUnternehmenController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	RootController rootController = null;
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	
	//Define overviewtable with columns
	@FXML
	private TableView<Subunternehmen> tblSubunternehmen;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenId;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenName;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenAdresse;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenTelefon;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenOffeneProjekte;
	@FXML
	private TableColumn<Subunternehmen, String> colSubunternehmenAnzMitarbeiter;
	
	//Datalist for Tableview
	ObservableList<Subunternehmen> data;
	
	
	//SetCellValueFactory from overviewtable
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colSubunternehmenId.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("id"));
		colSubunternehmenName.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("name"));

		colSubunternehmenAdresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		        return new SimpleStringProperty(p.getValue().getFkAdresse().getStrasse() + " " +p.getValue().getFkAdresse().getPlz().getPlz() + " " + p.getValue().getFkAdresse().getPlz().getOrt());
		    }
		});
		colSubunternehmenTelefon.setCellValueFactory(new PropertyValueFactory<Subunternehmen, String>("telefon"));	
		
		colSubunternehmenOffeneProjekte.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		    	return new SimpleStringProperty(client.getProjektproSubunternehmen(p.getValue().getId()));
		    }
		});
		
		
		colSubunternehmenAnzMitarbeiter.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subunternehmen, String>, ObservableValue<String>>() {
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Subunternehmen, String> p) {
		        return new SimpleStringProperty(String.valueOf(p.getValue().getFkSuMitarbeiter().size()));
		    	}
		});	
		
		//Client interaction
		try {
			client = new ClientRMI();
			data = FXCollections.observableArrayList(client.getAllSubunternehmen());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//Set data to tableview
		tblSubunternehmen.setItems(data);
	}
	
	@FXML
	public void showSubunternehmenDetail(MouseEvent t) throws IOException{
		if(t.getClickCount() == 2){
			System.out.println(tblSubunternehmen.getSelectionModel().getSelectedItem().getId());
			
			try {
				// Load SubunternehmenDetail View.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/unternehmen/InneresUnternehmen.fxml"));
				AnchorPane inneresUnternehmen = (AnchorPane) loader.load();
				
				SubUnternehmenDetailController detailSubunternehmenController = loader.<SubUnternehmenDetailController>getController();
				detailSubunternehmenController.setRootController(rootController);
				
				detailSubunternehmenController.init(tblSubunternehmen.getSelectionModel().getSelectedItem().getId());
				rootController.rootLayout.setCenter(inneresUnternehmen);
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	@FXML
	private void addUnternehmen(){
		try {
			// Load ProjektDetail View.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/unternehmen/AddUnternehmen.fxml"));
			AnchorPane addUnternehmen = (AnchorPane) loader.load();
			
			AddUnternehmenController addUnternehmenController = loader.<AddUnternehmenController>getController();
			addUnternehmenController.setRootController(rootController);
			rootController.rootLayout.setCenter(addUnternehmen);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


