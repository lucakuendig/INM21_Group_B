package ch.hsluw.mangelmanager.client.intern.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class SubUnternehmenDetailController implements Initializable {

	//RMI Client to interact
		ClientRMI client = null;
		RootController rootController = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		Subunternehmen subunternehmen = null;
		
		
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {

			
		}


		public void init(int subunternehmenId) {
				try {
				client = ClientRMI.getInstance();
				subunternehmen = client.getSubunternehmenById(subunternehmenId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	
}
