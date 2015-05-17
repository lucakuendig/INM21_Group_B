package ch.hsluw.mangelmanager.client.extern.controller;

	import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;

	public class MangelDetailController implements Initializable {
	
		//WS Client to interact
			ClientWS client = null;
			RootController rootController = null;
			DateFormat formatDatum = null;
			DateTimeFormatter dateFormatter = null;
			
			public void setRootController(RootController rootController) {
				// TODO Auto-generated method stub
				this.rootController = rootController;
			}
			
			Mangel mangel = null;
			List<Mangelstatus> mangelstatusl = null;
			Mangelstatus mangelstatus = null;
			
			@FXML
			public Label lblMangelId;
			@FXML
			public TextArea txtMangelBeschreibung;
			@FXML
			public TextField txtMangelDatumanfang;
			@FXML
			public Label lblMangelFaellig;
			@FXML
			public DatePicker dateMangelDatumende;
			@FXML
			public Label lblMangelStatus;
			@FXML
			public Label lblMangelBezeichung;
			
			
			public void initialize(URL location, ResourceBundle resources) {		
						
			}
			
			public void init(Integer MangelId) {
					try {
					client = ClientWS.getInstance();
					mangel = client.proxy.getMangelById(MangelId);
					mangelstatusl = client.proxy.getAllMangelStatus();			
					for (Mangelstatus mangelstatus : mangelstatusl) {
						;
						if(mangelstatus.getBezeichnung().equals("Abgeschlossen")){
							this.mangelstatus = mangelstatus;
						}
					}
					
					formatDatum = new SimpleDateFormat("dd.MM.yyyy");
					dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
					
					lblMangelId.setText(mangel.getId().toString());
					lblMangelBezeichung.setText(mangel.getBezeichnung());
					lblMangelFaellig.setText((formatDatum.format(mangel.getFaelligkeitsDatum().getTime())));
					txtMangelBeschreibung.setText(mangel.getBeschreibung());
					txtMangelDatumanfang.setText((formatDatum.format(mangel.getErfassungsZeit().getTime())));
					
					if(mangel.getAbschlussZeit() == null){
						dateMangelDatumende.setValue(null);
					}else{
						dateMangelDatumende.setValue(LocalDate.parse(formatDatum.format(mangel.getAbschlussZeit().getTime()), dateFormatter));
					}
					lblMangelStatus.setText(mangel.getFkMangelstatus().getBezeichnung());
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			
			@FXML
			private void mangelClose() {
				mangel.setFkMangelstatus(mangelstatus);
				if(dateMangelDatumende.getValue() != null){
					mangel.setAbschlussZeit(new GregorianCalendar(dateMangelDatumende.getValue().getDayOfMonth(), dateMangelDatumende.getValue().getMonthValue(), dateMangelDatumende.getValue().getYear()));
				}
				lblMangelStatus.setText("Abgeschlossen");
				client.proxy.updateMangel(mangel);
				
			}
			@FXML
			public void mangelCancel(){
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
