package de.mikosninebites.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

/**
 * This is the EndWindow class which is responsible for displaying a "thank you"
 * message on a new screen after the user has completed their order.
 * 
 * @author mikolaj
 *
 */
public class EndWindow {

	/* A border pane to display a "thank you" message */
	private BorderPane lastScreenBorderPane = new BorderPane();

	/*
	 * A Label for the countdown timer that displays the time remaining until the
	 * user's order is ready for pickup.
	 */
	private Label clock = new Label();

	/* The main window to which the end window belongs. */
	private MainWindow mainWindow;

	/**
	 * Constructor for EndWindow class.
	 * 
	 * @param mainWindow - The main window to which the end window belongs.
	 */
	public EndWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * Creates and sets up the "thank you" message screen, including the logo,
	 * message, and timer. The timer is created using a Timer object, and the screen
	 * is displayed in the main window's primary stage.
	 */
	public void showEndWindow() {

		createTopPanelWithLogoBox();
		createCentralPanelWithMessage();
		createBottomPanelWithTimer();

		Timer timer = new Timer(mainWindow, clock);
		timer.createTimer();

		// Creates a new Scene to display the "thank you" message.
		Scene lastScreenScene = new Scene(lastScreenBorderPane, 600, 900);

		// Adds a stylesheet for styling the "thank you" message.
		lastScreenScene.getStylesheets().add("file:resources/style.css");
		// Adds a font stylesheet for the "thank you" message.
		lastScreenScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");
		// Sets the last screen as the primary stage scene.
		mainWindow.getPrimaryStage().setScene(lastScreenScene);
	}

	/*
	 * Loads and displays the company logo at the top of the "thank you" message
	 * screen.
	 */
	private void createTopPanelWithLogoBox() {

		// Loads an image for the company logo.
		Image companyLogoForLastScreen = new Image("file:resources/icons/company_logo_small.png");
		ImageView showCompanyLogoForLastScreen = new ImageView(companyLogoForLastScreen);

		// Creates three HBox objects to arrange the company logo and "thank you"
		// message.
		HBox firstRow = new HBox();

		// Sets the alignment and padding for the first row.
		firstRow.setAlignment(Pos.TOP_CENTER);
		firstRow.setPadding(new Insets(10, 0, 0, 0));
		// Adds the company logo to the first row.
		firstRow.getChildren().addAll(showCompanyLogoForLastScreen);
		// Sets the first row as the top of the BorderPane.
		lastScreenBorderPane.setTop(firstRow);
	}

	/* Creates and displays a "thank you" message with instructions for the user. */
	private void createCentralPanelWithMessage() {
		// Creates three HBox objects to arrange the company logo and "thank you"
		// message.
		HBox secondRow = new HBox();

		// Creates a Label to display a "thank you" message.
		Label thankYouLabel = new Label("Thank you for your order.\nThe order confirmation is printed."
				+ "\nPlease collect your receipt and go to the checkout to pay for your order.\n\n☺ Enjoy your meal! ☺");
		thankYouLabel.setTextAlignment(TextAlignment.CENTER);
		thankYouLabel.setWrapText(true);
		thankYouLabel.setId("thankyou");
		// Sets the padding and preferred width for the second row.
		secondRow.setPadding(new Insets(0, 20, 0, 20));
		secondRow.setPrefWidth(280);
		// Adds the "thank you" message to the second row.
		secondRow.getChildren().addAll(thankYouLabel);
		secondRow.setAlignment(Pos.TOP_CENTER);
		// Sets the second row as the center of the BorderPane.
		lastScreenBorderPane.setCenter(secondRow);
	}

	/*
	 * Creates and displays a countdown timer at the bottom of the "thank you"
	 * message screen.
	 */
	private void createBottomPanelWithTimer() {
		HBox thirdRow = new HBox();

		thirdRow.setPadding(new Insets(0, 20, 0, 20));
		thirdRow.setPrefWidth(280);
		thirdRow.getChildren().addAll(clock);
		thirdRow.setAlignment(Pos.CENTER);
		lastScreenBorderPane.setBottom(thirdRow);
	}
}