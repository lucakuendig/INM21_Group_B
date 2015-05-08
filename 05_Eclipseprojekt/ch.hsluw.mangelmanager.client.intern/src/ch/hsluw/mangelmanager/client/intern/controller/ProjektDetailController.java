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
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	
	Projekt projekt = null;
	
	
	@FXML
	public Label lblPersonId;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}


	public void init(int projektId) {
			try {
			client = ClientRMI.getInstance();
			projekt = client.getProjektById(projektId);
			lblPersonId.setText(projekt.getId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@FXML
	public void projektCancel(){
		
	}
	@FXML
	public void projektSave(){
		
	}
	@FXML
	public void projektAddMangel(){
		
	}
	@FXML
	public void projektAddMeldung(){
		
	}
	@FXML
	public void projektAddUnternehmen(){
		
	}
	@FXML
	public void projektAddBauleiter(){
		
	}

}
