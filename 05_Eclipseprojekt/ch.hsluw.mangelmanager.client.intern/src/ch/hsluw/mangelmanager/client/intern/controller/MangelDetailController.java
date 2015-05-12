package ch.hsluw.mangelmanager.client.intern.controller;

	import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

	public class MangelDetailController implements Initializable {
	
		//RMI Client to interact
			ClientRMI client = null;
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
					client = ClientRMI.getInstance();
					mangel = client.getMangelById(MangelId);
					mangelstatusl = client.getAllMangelStatus();			
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
				client.updateMangel(mangel);
				
			}
	
}
