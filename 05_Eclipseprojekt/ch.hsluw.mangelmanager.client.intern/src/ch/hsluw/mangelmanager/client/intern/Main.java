package ch.hsluw.mangelmanager.client.intern;


import java.io.IOException;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Projekt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

	// RMI Client to interact
		ClientRMI client = null;
	
	private static Stage loginStage;
	private static AnchorPane loginLayout;
	public static Integer loginId;
	public static String port;
	public static String ip;
	
	@FXML
	private Label lblLoginError;
	@FXML
	private TextField txtBenutzer;
	@FXML
	private PasswordField pwPasswort;
	@FXML
	private TextField txtIp;
	@FXML
	private TextField txtPort;

	@Override
	public void start(Stage primaryStage) {
		this.loginStage = primaryStage;
		this.loginStage.setTitle("Mängelmanager");
		initRootLayout();

	}

	/**
	 * Initializes the demo	 layout.
	 */
	public static void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/login/Login.fxml"));
			loginLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(loginLayout);
			loginStage.setScene(scene);
			loginStage.show();
			loginStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void login() throws IOException {
		
		ip = txtIp.getText();
		port = txtPort.getText();
		
		client = ClientRMI.getInstance();
		Login data = client.getLoginByName(txtBenutzer.getText());
		

		if (data != null){
			if ((txtBenutzer.getText().equals(data.getBenutzername()))
					&& (pwPasswort.getText().equals(data.getPasswort()))) {
				lblLoginError.setText("Login erfolgreich!");
				loginId = data.getId();
				Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource(
						"view/root/Root.fxml"));
	
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Mängelmanager");
				stage.setMaximized(true);
				stage.show();
				Stage stageToClose = (Stage) txtBenutzer.getScene().getWindow();
				stageToClose.close();
			} else {
				lblLoginError.setText("Fehler beim Einloggen!");
			}
		} else {
			lblLoginError.setText("Fehler beim Einloggen!");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}