package ch.hsluw.mangelmanager.client.extern.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ch.hsluw.mangelmanager.client.extern.ClientWS;
import ch.hsluw.mangelmanager.client.extern.Main;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;

public class SubUnternehmenDetailController implements Initializable {

	//WS Client to interact
		ClientWS client = null;
		RootController rootController = null;
		DateFormat formatDatum = null;
		DateTimeFormatter dateFormatter = null;
		
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
		public ComboBox<Plz> cbUnternehmenPlz;
		@FXML
		public Label lblUnternehmenOrt;
		
		//Projekte pro Subunternehmen
		@FXML
		private TableView<Projekt> tblUnternehmenProjekt;
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
		
		//Projekte pro Subunternehmen
				@FXML
				private TableView<SuMitarbeiter> tblUnternehmenMitarbeiter;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterId;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterName;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterVorname;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterStartdatum;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterEnddatum;
				@FXML
				private TableColumn<SuMitarbeiter, String> colUnternehmenMitarbeiterTelefon;
		
		
		//Datalist for Tableview
		ObservableList<Projekt> data;
		ObservableList<SuMitarbeiter>data2;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			try {
				client = ClientWS.getInstance();
				for (Plz plz : FXCollections.observableArrayList(client.proxy.getAllPlz())) {
					cbUnternehmenPlz.getItems().add(plz);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}


		


		public void init(int subunternehmenId) {
			setCellValueFactoryTblUnternehmenProjekt();
			setCellValueFactoryTblUnternehmenMiterbeiter();
				try {

				formatDatum = new SimpleDateFormat("dd.MM.yyyy");
				dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				subunternehmen = client.proxy.getSubunternehmenById(subunternehmenId);
				lblUnternehmenId.setText(subunternehmen.getId().toString());
				txtUnternehmenName.setText(subunternehmen.getName());
				txtUnternehmenTelefon.setText(subunternehmen.getTelefon());
				txtUnternehmenStrasse.setText(subunternehmen.getFkAdresse().getStrasse());
				cbUnternehmenPlz.setValue(subunternehmen.getFkAdresse().getPlz());
				lblUnternehmenOrt.setText(subunternehmen.getFkAdresse().getPlz().getOrt()));
				
				data = FXCollections.observableArrayList(client.proxy.getAllSubunternehmenProjekt(subunternehmen.getId()));
				data2 = FXCollections.observableArrayList(client.proxy.getAllSubunternehmenMitarbeiter(subunternehmen));
				//Set data to tableview
				tblUnternehmenProjekt.setItems(data);
				tblUnternehmenMitarbeiter.setItems(data2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		private void setCellValueFactoryTblUnternehmenProjekt() {
			// TODO Auto-generated method stub
			colUnternehmenProjektId.setCellValueFactory(new PropertyValueFactory<Projekt, String>("id"));
			colUnternehmenProjektBezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("bezeichnung"));

			colUnternehmenProjektBauherr.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
						CellDataFeatures<Projekt, String> p) {
					return new SimpleStringProperty(p.getValue()
							.getFkBauherr().get(0).getNachname()
							+ " "
							+ p.getValue().getFkBauherr().get(0)
									.getVorname());
				}
			});

			colUnternehmenProjektStrasse.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
						CellDataFeatures<Projekt, String> p) {return new SimpleStringProperty(p.getValue().getFkAdresse().getStrasse());}
			});
			colUnternehmenProjektPlz.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
				CellDataFeatures<Projekt, String> p) {return new SimpleStringProperty(p.getValue().getFkAdresse().getPlz().getPlz().toString());}
			});
			colUnternehmenProjektOrt.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
				CellDataFeatures<Projekt, String> p) {return new SimpleStringProperty(p.getValue().getFkAdresse().getPlz().getOrt());}
			});
	
			colUnternehmenProjektStartdatum.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
						CellDataFeatures<Projekt, String> p) {return new SimpleStringProperty(formatDatum.format(p.getValue().getStartDatum().getTime()));}
			});

			colUnternehmenProjektStatus.setCellValueFactory(new Callback<CellDataFeatures<Projekt, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(
				CellDataFeatures<Projekt, String> p) {return new SimpleStringProperty(p.getValue().getFkProjektstatus().getBezeichnung());}
			});
		}
		
		public void setCellValueFactoryTblUnternehmenMiterbeiter(){
			colUnternehmenMitarbeiterName.setCellValueFactory(new PropertyValueFactory<SuMitarbeiter, String>("nachname"));
			colUnternehmenMitarbeiterVorname.setCellValueFactory(new PropertyValueFactory<SuMitarbeiter, String>("vorname"));
			colUnternehmenMitarbeiterTelefon.setCellValueFactory(new PropertyValueFactory<SuMitarbeiter, String>("telefon"));
		}
		
		@FXML
		private void unternehmenSave() {
			
			subunternehmen.setName(txtUnternehmenName.getText());
			subunternehmen.setTelefon(txtUnternehmenTelefon.getText());
			subunternehmen.getFkAdresse().setPlz(cbUnternehmenPlz.getSelectionModel().getSelectedItem());
			subunternehmen.getFkAdresse().getPlz().setOrt(lblUnternehmenOrt.getText());
			subunternehmen.getFkAdresse().setStrasse(txtUnternehmenStrasse.getText());
			client.proxy.updateSubunternehmen(subunternehmen);
			
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
		private void unternehmenCancel(){
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
		private void plzChange(){
			if (cbUnternehmenPlz.getSelectionModel().getSelectedItem() != null){
				lblUnternehmenOrt.setText(cbUnternehmenPlz.getSelectionModel().getSelectedItem().getOrt());
			}else{	
			}
		}

		@FXML
		private void showProjektDetail(MouseEvent t) throws IOException{
			if (t.getClickCount() == 2) {
				System.out.println(tblUnternehmenProjekt.getSelectionModel().getSelectedItem()
						.getId());

				try {
					// Load ProjektDetail View.
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class
							.getResource("view/projekt/InneresProjekt.fxml"));
					AnchorPane inneresProjekt = (AnchorPane) loader.load();

					ProjektDetailController detailProjektController = loader
							.<ProjektDetailController> getController();
					detailProjektController.setRootController(rootController);

					detailProjektController.init(tblUnternehmenProjekt.getSelectionModel()
							.getSelectedItem().getId());
					rootController.rootLayout.setCenter(inneresProjekt);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		@FXML
		public void showMitarbeiterDetail(MouseEvent t){
			if (t.getClickCount() == 2) {
				System.out.println(tblUnternehmenMitarbeiter.getSelectionModel().getSelectedItem()
						.getId());

				try {
					// Load ProjektDetail View.
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class
							.getResource("view/person/InnerePerson.fxml"));
					AnchorPane inneresPerson = (AnchorPane) loader.load();

					PersonDetailController detailPersonController = loader
							.<PersonDetailController> getController();
					detailPersonController.setRootController(rootController);

					detailPersonController.init(tblUnternehmenMitarbeiter.getSelectionModel().getSelectedItem()
							.getId());
					rootController.rootLayout.setCenter(inneresPerson);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
}
