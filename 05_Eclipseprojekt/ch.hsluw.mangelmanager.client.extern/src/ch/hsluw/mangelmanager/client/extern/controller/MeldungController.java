package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import ch.hsluw.mangelmanager.client.intern.ClientRMI;
import ch.hsluw.mangelmanager.client.intern.Main;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Projekt;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * The MeldungController handles all interaction with meldungen * 
 * 
 * @author lkuendig
 * @version 1.0
 *
 */

public class MeldungController implements Initializable {

	//RMI Client to interact
		ClientRMI client = null;
		
		RootController rootController = null;
		
		public void setRootController(RootController rootController) {
			// TODO Auto-generated method stub
			this.rootController = rootController;
		}
		
		//Define overviewtable with columns
		@FXML
		private TableView<Meldung> tblMeldung;
		@FXML
		private TableColumn<Meldung, String> colMeldungId;
		@FXML
		private TableColumn<Meldung, String> colMeldungProjekt;
		@FXML
		private TableColumn<Meldung, String> colMeldungMangel;
		@FXML
		private TableColumn<Meldung, String> colMeldungTyp;
		@FXML
		private TableColumn<Meldung, String> colMeldungErfasst;
		@FXML
		private TableColumn<Meldung, String> colMeldungQuittiert;
		
		//Datalist for Tableview
		ObservableList<Meldung> data;
	
		//SetCellValueFactory from overviewtable
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			DateFormat formatDatum = new SimpleDateFormat("dd.MM.yyyy");
			
			colMeldungId.setCellValueFactory(new PropertyValueFactory<Meldung, String>("id"));
			colMeldungProjekt.setCellValueFactory(new Callback<CellDataFeatures<Meldung, String>, ObservableValue<String>>() {
			    public ObservableValue<String> call(CellDataFeatures<Meldung, String> p) {
			        return new SimpleStringProperty(p.getValue().getFkMangel().getFkProjekt().getBezeichnung());
			    }
			});
			colMeldungMangel.setCellValueFactory(new Callback<CellDataFeatures<Meldung, String>, ObservableValue<String>>() {
			    public ObservableValue<String> call(CellDataFeatures<Meldung, String> p) {
			        return new SimpleStringProperty(String.valueOf(p.getValue().getFkMangel().getId()));
			    }
			});
			colMeldungTyp.setCellValueFactory(new Callback<CellDataFeatures<Meldung, String>, ObservableValue<String>>() {
			    public ObservableValue<String> call(CellDataFeatures<Meldung, String> p) {
			        return new SimpleStringProperty(p.getValue().getFkMeldungstyp().getBezeichnung());
			    }
			});
			colMeldungErfasst.setCellValueFactory(new Callback<CellDataFeatures<Meldung, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(CellDataFeatures<Meldung, String> p) {
					if (p.getValue().getZeitpunkt() == null){
						return new SimpleStringProperty(" ");
					}else{
						return new SimpleStringProperty(formatDatum.format(p.getValue().getZeitpunkt().getTime()));
					}
				}
			});
			colMeldungQuittiert.setCellValueFactory(new PropertyValueFactory<Meldung, String>("quittiert"));
		
			//Client interaction
			try {
				client = new ClientRMI();
				data = FXCollections.observableArrayList(client.getAllMeldung());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			//Set data to tableview
			tblMeldung.setItems(data);
		
		}
		
		@FXML
		public void showMeldungDetail(MouseEvent t) throws IOException{
			if(t.getClickCount() == 2){
				System.out.println(tblMeldung.getSelectionModel().getSelectedItem().getId());
				
				try {
					// Load MeldungDetail View.
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class
							.getResource("view/meldung/InnereMeldung.fxml"));
					AnchorPane inneresMeldung = (AnchorPane) loader.load();
					
					MeldungDetailController detailMeldungController = loader.<MeldungDetailController>getController();
					detailMeldungController.setRootController(rootController);
					
					detailMeldungController.init(tblMeldung.getSelectionModel().getSelectedItem().getId());
					rootController.rootLayout.setCenter(inneresMeldung);
					

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
}
