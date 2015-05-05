package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.scene.control.TextField;

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
		public TextField txtSubunternehmenId;
		@FXML
		public TextField txtSubunternehmenName;
		@FXML
		public TextField txtSubunternehmenTelefon;
		@FXML
		public TextField txtSubunternehmenAdresse;
		@FXML
		public TextField txtSubunternehmenPlz;
		@FXML
		public TextField txtSubunternehmenOrt;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {

			
		}


		public void init(int subunternehmenId) {
				try {
				client = ClientRMI.getInstance();
				subunternehmen = client.getSubunternehmenById(subunternehmenId);
				txtSubunternehmenId.setText(subunternehmen.getId().toString());
				txtSubunternehmenName.setText(subunternehmen.getName());
				txtSubunternehmenTelefon.setText(subunternehmen.getTelefon());
				txtSubunternehmenAdresse.setText(subunternehmen.getFkAdresse().getStrasse());
				txtSubunternehmenPlz.setText(subunternehmen.getFkAdresse().getPlz().getPlz().toString());
				txtSubunternehmenOrt.setText(subunternehmen.getFkAdresse().getPlz().getOrt());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	
}
