package ch.hsluw.mangelmanager.client.intern.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.jmx.snmp.Timestamp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class AddMangelController implements Initializable {
		//RMI Client to interact
		ClientRMI client = null;
		RootController rootController = null;
		Projekt projekt = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}

		Meldung meldung = null;
		Mangel mangel = null;
		Mangelstatus mangelstatus = null;
		Login login = null;
		List<Mangelstatus> mangelstatusl = null;
		List<Meldungstyp> meldungstypl = null;
		Meldungstyp meldungstyp = null;
		
		
		@FXML
		public TextField txtMangelBezeichung;
		@FXML
		public TextArea txtMangelBeschreibung;
		@FXML
		public DatePicker dateMangelFaellig;
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

		public void init(Projekt projekt) {
			try {
				client = new ClientRMI();
			
				this.projekt = projekt;
				mangelstatusl = client.getAllMangelStatus();			
				for (Mangelstatus mangelstatus : mangelstatusl) {
					if(mangelstatus.getBezeichnung().equals("Offen")){
						this.mangelstatus = mangelstatus;
					}
				}
				meldungstypl = client.getAllMeldungstyp();
				for (Meldungstyp meldungstyp : meldungstypl) {
					if(meldungstyp.getBezeichnung().equals("Reklamation")){
						this.meldungstyp = meldungstyp;
					}
				}
				login = client.getLoginById(Main.loginId);
				System.out.println(login.getBenutzername()+ " " + login.getEmail());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@FXML
		private void mangelSave() {
			Calendar cl = Calendar.getInstance();
			
			mangel = new Mangel(projekt, txtMangelBezeichung.getText(),(GregorianCalendar) cl, new GregorianCalendar(dateMangelFaellig.getValue().getYear(), dateMangelFaellig.getValue().getMonthValue()-1, dateMangelFaellig.getValue().getDayOfMonth()),mangelstatus ,login , txtMangelBeschreibung.getText());
			
			client.addMangel(mangel);
			
			try {
				// Load Unternehmen overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/mangel/AussererMangel.fxml"));
				AnchorPane mangel = (AnchorPane) loader.load();
				
				MangelController mangelController = loader.<MangelController>getController();
				mangelController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(mangel);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		@FXML
		public void addMangelCancel(){
			try {
				// Load Unternehmen overview.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/mangel/AussererMangel.fxml"));
				AnchorPane mangel = (AnchorPane) loader.load();
				
				MangelController mangelController = loader.<MangelController>getController();
				mangelController.setRootController(rootController);
				
				rootController.rootLayout.setCenter(mangel);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
