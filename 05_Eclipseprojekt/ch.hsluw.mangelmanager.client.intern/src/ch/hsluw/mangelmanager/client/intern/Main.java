import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Mängelmanager");

		initRootLayout();
		test();

	}
	public void test() {
		//showInnerPerson();
		// showInnerMeldung();
		 showPerson();
		// showUnternehmen();
	}
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/root/Root.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showPerson() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/person/outer/AusserePerson.fxml"));
			AnchorPane Personen = (AnchorPane) loader.load();
			rootLayout.setCenter(Personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showUnternehmen() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/unternehmen/outer/AusseresUnternehmen.fxml"));
			AnchorPane Personen = (AnchorPane) loader.load();
			rootLayout.setCenter(Personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerPerson() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/person/inner/InnerePerson.fxml"));
			AnchorPane Personen = (AnchorPane) loader.load();
			rootLayout.setCenter(Personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerMeldung() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/meldung/inner/InnereMeldung.fxml"));
			AnchorPane Personen = (AnchorPane) loader.load();
			rootLayout.setCenter(Personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showInnerMangel() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("issuemanager/gui/meldung/inner/InnereMangel.fxml"));
			AnchorPane Personen = (AnchorPane) loader.load();
			rootLayout.setCenter(Personen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	/*
	 * public Stage getPrimaryStage() { return primaryStage; }
	 */

	public static void main(String[] args) {
		launch(args);
	}
}