package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Subunternehmen;

/**
 * The AddUnternehmenController handles all interaction with unternehmen * 
 * 
 * @author lkuendig
 * @version 1.0
 *
 */

public class AddUnternehmenController implements Initializable {
	//WS Client to interact
	ClientWS client = null;
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
			client = new ClientWS().getInstance();
			for (Plz plz : FXCollections.observableArrayList(client.proxy.getAllPlz())) {
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
		client.proxy.addSubunternehmen(subunternehmen);
		
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
	@FXML
	public void unternehmenCancel(){
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
