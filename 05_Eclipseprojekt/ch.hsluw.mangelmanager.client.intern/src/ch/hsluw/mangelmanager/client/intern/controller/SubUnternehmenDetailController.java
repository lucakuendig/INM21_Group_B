package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SubUnternehmenDetailController implements Initializable {

	//RMI Client to interact
		ClientRMI client = null;
		RootController rootController = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		Subunternehmen subunternehmen = null;
		
		@FXML
		public Label lblUnternehmenId;
		@FXML
		public TextField txtUnternehmenName;
		@FXML
		public TextField txtUnternehmenTelefon;
		@FXML
		public TextField txtUnternehmenStrasse;
		@FXML
		public ComboBox cbUnternehmenPlz;
		@FXML
		public Label lblUnternehmenOrt;
		
		//Projekte pro Subunternehmen
		@FXML
		private TableView<Projekt> tblUnterehmenProjekt;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektId;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektBezeichnung;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektBauherr;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektStrasse;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektPlz;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektOrt;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektStartdatum;
		@FXML
		private TableColumn<Projekt, String> colUnternehmenProjektStatus;
		
		//Datalist for Tableview
		ObservableList<Projekt> data;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			setCellValueFactoryTblProjekt();
			
			try {
				client = new ClientRMI();
				for (Plz plz : FXCollections.observableArrayList(client.getAllPlz())) {
					cbUnternehmenPlz.getItems().add(plz.getPlz());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}


		private void setCellValueFactoryTblProjekt() {
			// TODO Auto-generated method stub
			
		}


		public void init(int subunternehmenId) {
				try {
				client = ClientRMI.getInstance();
				subunternehmen = client.getSubunternehmenById(subunternehmenId);
				lblUnternehmenId.setText(subunternehmen.getId().toString());
				txtUnternehmenName.setText(subunternehmen.getName());
				txtUnternehmenTelefon.setText(subunternehmen.getTelefon());
				txtUnternehmenStrasse.setText(subunternehmen.getFkAdresse().getStrasse());
				cbUnternehmenPlz.setValue(subunternehmen.getFkAdresse().getPlz().getPlz());
				lblUnternehmenOrt.setText(client.getPlzById((Integer) cbUnternehmenPlz.getSelectionModel().getSelectedItem()).getOrt());
				
				data = FXCollections.observableArrayList(client.getAllSubunternehmenProjekt(subunternehmen));
				
				System.out.println(data.get(1).getId());
				//Set data to tableview
				//tblUnterehmenProjekt.setItems(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@FXML
		private void unternehmenSave() {
			
			subunternehmen.setName(txtUnternehmenName.getText());
			subunternehmen.setTelefon(txtUnternehmenTelefon.getText());
			subunternehmen.getFkAdresse().getPlz().setPlz((Integer) cbUnternehmenPlz.getSelectionModel().getSelectedItem());
			subunternehmen.getFkAdresse().getPlz().setOrt(lblUnternehmenOrt.getText());
			subunternehmen.getFkAdresse().setStrasse(txtUnternehmenStrasse.getText());
			client.updateSubunternehmen(subunternehmen);
			
		}
		
		@FXML
		private void unternehmenCancel(){
			
		}
		@FXML
		private void plzChange(){
			if (cbUnternehmenPlz.getSelectionModel().getSelectedItem() != null){
				lblUnternehmenOrt.setText(client.getPlzById((Integer) cbUnternehmenPlz.getSelectionModel().getSelectedItem()).getOrt());
			}else{	
			}
		}

	
}
