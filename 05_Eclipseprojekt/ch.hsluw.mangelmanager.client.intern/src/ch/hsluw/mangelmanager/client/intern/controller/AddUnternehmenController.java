package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The AddUnternehmenController handles all interaction with unternehmen * 
 * 
 * @author lkuendig
 * @version 1.0
 *
 */

public class AddUnternehmenController implements Initializable {
	//RMI Client to interact
	ClientRMI client = null;
	RootController rootController = null;
	
	public void setRootController(RootController rootController) {
		// TODO Auto-generated method stub
		this.rootController = rootController;
	}
	Subunternehmen subunternehmen = null;
	Adresse adresse = null;
	
	@FXML
	public Label lblUnternehmenId;
	@FXML
	public TextField txtUnternehmenName;
	@FXML
	public TextField txtUnternehmenTelefon;
	@FXML
	public TextField txtUnternehmenStrasse;
	@FXML
	public ComboBox<Plz> cbUnternehmenPlz;
	@FXML
	public Label lblUnternehmenOrt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			client = new ClientRMI().getInstance();
			for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
				cbUnternehmenPlz.getItems().add(plz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@FXML
	private void plzChange(){
		if (cbUnternehmenPlz.getSelectionModel().getSelectedItem() != null){
			lblUnternehmenOrt.setText(cbUnternehmenPlz.getSelectionModel().getSelectedItem().getOrt());
		}
	}
	@FXML
	private void unternehmenSave() {
		
		adresse = new Adresse(txtUnternehmenStrasse.getText(),cbUnternehmenPlz.getSelectionModel().getSelectedItem());
		subunternehmen = new Subunternehmen(adresse, txtUnternehmenName.getText(), txtUnternehmenTelefon.getText());
		client.addSubunternehmen(subunternehmen);
		
		try {
			// Load Unternehmen overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/unternehmen/AusseresUnternehmen.fxml"));
			AnchorPane unternehmen = (AnchorPane) loader.load();
			
			SubUnternehmenController subunternehmenController = loader.<SubUnternehmenController>getController();
			subunternehmenController.setRootController(rootController);
			
			rootController.rootLayout.setCenter(unternehmen);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	

}
