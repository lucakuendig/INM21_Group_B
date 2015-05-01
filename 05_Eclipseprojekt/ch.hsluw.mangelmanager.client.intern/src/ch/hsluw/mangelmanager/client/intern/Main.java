package ch.hsluw.mangelmanager.client.intern;


import java.io.IOException;

import javafx.application.Application;
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

	private Stage loginStage;
	private AnchorPane loginLayout;
	
	@FXML
	private Label lblLoginError;
	@FXML
	private TextField txtBenutzer;
	@FXML
	private PasswordField pwPasswort;

	@Override
	public void start(Stage primaryStage) {
		this.loginStage = primaryStage;
		this.loginStage.setTitle("Mängelmanager");

		initRootLayout();

	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void login() throws IOException {

		if ((txtBenutzer.getText().equals("demo"))
				&& (pwPasswort.getText().equals("demo"))) {
			lblLoginError.setText("Login erfolgreich!");
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource(
					"view/root/Root.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Mängelmanager");
			stage.show();

			Stage stageToClose = (Stage) txtBenutzer.getScene().getWindow();
			stageToClose.close();
		} else {
			lblLoginError.setText("Fehler beim Einloggen!");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}