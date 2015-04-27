package ch.hsluw.mangelmanager.client.intern;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ShowMethodClass extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Mängelmanager");

		initRootLayout();
		test();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void test() {
		// showLogin();
		// showMangel();
		 showInnerMangel();
		// showMeldung();
		// showInnerMeldung();
		//showPerson();
		// showInnerPerson();
		// showProjekt();
		// showInnerProjekt();
		// showUnternehmen();
		// showInnerUnternehmen();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class.getResource("view/root/Root.fxml"));
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
	public void showLogin() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class.getResource("view/login/Login.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			rootLayout.setCenter(Login);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMangel() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/mangel/outer/AussererMangel.fxml"));
			AnchorPane Mangel = (AnchorPane) loader.load();
			rootLayout.setCenter(Mangel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerMangel() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/mangel/inner/InnererMangel.fxml"));
			AnchorPane InnerMangel = (AnchorPane) loader.load();
			rootLayout.setCenter(InnerMangel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMeldung() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/meldung/outer/AussereMeldung.fxml"));
			AnchorPane Meldung = (AnchorPane) loader.load();
			rootLayout.setCenter(Meldung);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerMeldung() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/meldung/inner/InnereMeldung.fxml"));
			AnchorPane InnerMeldung = (AnchorPane) loader.load();
			rootLayout.setCenter(InnerMeldung);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPerson() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/person/outer/AusserePerson.fxml"));
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
			loader.setLocation(ShowMethodClass.class
					.getResource("view/person/inner/InnerePerson.fxml"));
			AnchorPane InnerPerson = (AnchorPane) loader.load();
			rootLayout.setCenter(InnerPerson);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showProjekt() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/projekt/outer/AusseresProjekt.fxml"));
			AnchorPane Projekt = (AnchorPane) loader.load();
			rootLayout.setCenter(Projekt);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerProjekt() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/projekt/inner/InneresProjekt.fxml"));
			AnchorPane InnerProjekt = (AnchorPane) loader.load();
			rootLayout.setCenter(InnerProjekt);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showUnternehmen() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/unternehmen/outer/AusseresUnternehmen.fxml"));
			AnchorPane Unternehmen = (AnchorPane) loader.load();
			rootLayout.setCenter(Unternehmen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showInnerUnternehmen() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ShowMethodClass.class
					.getResource("view/unternehmen/inner/InneresUnternehmen.fxml"));
			AnchorPane InnerUnternehmen = (AnchorPane) loader.load();
			rootLayout.setCenter(InnerUnternehmen);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}