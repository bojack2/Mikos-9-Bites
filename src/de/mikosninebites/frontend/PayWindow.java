package de.mikosninebites.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * PayWindow class is responsible for creating and displaying the pay window on
 * the main window. This class creates the top panel with the company logo, the
 * central panel with the order details and the bottom panel with the navigation
 * buttons. It also adds events to the navigation buttons for navigation to
 * other screens.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class PayWindow {

	/* The main window to which the pay window belongs. */
	private MainWindow mainWindow;

	/* A border pane to hold the pay screen */
	private BorderPane payScreenBorderPane = new BorderPane();

	/* An array of buttons representing the navigation options */
	private Button[] navigationButtons = { new Button("CANCEL"), new Button("BACK"), new Button("ORDER") };

	/**
	 * Constructor for PayWindow class.
	 * 
	 * @param mainWindow - The main window to which the pay window belongs.
	 */
	public PayWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * The method showPayWindow() creates the top panel with the company logo, the
	 * central panel with the order details and the bottom panel with the navigation
	 * buttons. It also adds events to the navigation buttons for navigation to
	 * other screens.
	 */
	public void showPayWindow() {

		createTopPanelWithLogoBox();
		createCentralPanelWithOrderText();
		createBottomPanelWithNavigationsButtons();

		BackCancelPayButtonEvents backCancelPayButtonEvents = new BackCancelPayButtonEvents(mainWindow,
				navigationButtons);
		backCancelPayButtonEvents.addEventsToButtons();

		// Create a new Scene with the payScreenBorderPane as its root node and set its
		// dimensions to 600 x 900
		Scene payScene = new Scene(payScreenBorderPane, 600, 900);

		// Add the CSS stylesheet for the pay scene
		payScene.getStylesheets().add("file:resources/style.css");

		// Add the Google Fonts stylesheet for the pay scene
		payScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");
		mainWindow.getPrimaryStage().setScene(payScene);
	}

	/**
	 * This method creates the top panel of the pay window that contains the company
	 * logo.
	 */
	public void createTopPanelWithLogoBox() {
		// Set up the company logo image and HBox to contain it
		Image companyLogo = new Image("file:resources/icons/company_logo_small.png");
		ImageView showCompanyLogo = new ImageView(companyLogo);
		HBox logoHbox = new HBox();

		// Set the alignment and padding for the logoHBox
		logoHbox.setAlignment(Pos.TOP_CENTER);
		logoHbox.setPadding(new Insets(10, 0, 0, 0));
		logoHbox.getChildren().addAll(showCompanyLogo);
		payScreenBorderPane.setTop(logoHbox);
	}

	/**
	 * This method creates a central panel in a JavaFX application that displays the
	 * user's order details and the total amount to be paid.
	 */
	public void createCentralPanelWithOrderText() {
		// Set up the label and HBox to contain it
		Label order = new Label("Your order: ");
		HBox orderBox = new HBox();

		// Populate the order label with the details of the selected products
		for (int i = 0; i < mainWindow.getAmountOfSelectedProductList().size(); i++) {
			order.setText(order.getText() + "\n" + mainWindow.getAmountOfSelectedProductList().get(i) + " x ("
					+ mainWindow.getPriceOfSelectedProductList().get(i) + "€) "
					+ mainWindow.getNameOfSelectedProductList().get(i) + "\n\t\t\t\t\t\t\t\t"
					+ mainWindow.getEntirePriceOfSelectedProductList().get(i) + "€");
		}

		// Add the total price to the order label
		order.setText(order.getText() + "\n-------------------------------------\nTo be paid: "
				+ (double) Math.round(mainWindow.getEndPriceOfOrder() * 100) / 100 + "€");

		// Set the alignment and padding for the orderBox
		orderBox.setAlignment(Pos.CENTER);
		orderBox.setPadding(new Insets(0, 20, 0, 20));

		// Set the preferred width for the order label
		order.setPrefWidth(280);

		// Set up a scroll pane to contain the order label
		ScrollPane scrollBar = new ScrollPane();
		scrollBar.setContent(order);
		scrollBar.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollBar.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		// Add the scroll pane to the orderBox
		orderBox.getChildren().addAll(scrollBar);
		orderBox.setAlignment(Pos.CENTER);
		payScreenBorderPane.setCenter(orderBox);
	}

	/*
	 * Creates the bottom panel of the pay screen containing the navigation buttons.
	 */
	public void createBottomPanelWithNavigationsButtons() {

		HBox buttonBox = new HBox(20);

		// Set up the navigation buttons
		for (Button navigationButton : navigationButtons) {
			navigationButton.setPrefSize(120, 50);
			navigationButton.setMaxSize(120, 50);
			navigationButton.setMinSize(120, 50);
		}
		navigationButtons[0].setId("redButton");
		navigationButtons[1].setId("redButton");
		navigationButtons[2].setId("greenButton");

		// Set the alignment and padding of the HBox
		// that contains the navigation buttons to be aligned to the bottom center and
		// have some padding
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonBox.setPadding(new Insets(10, 0, 91, 0));

		// Add the navigation buttons to the buttonBox
		buttonBox.getChildren().addAll(navigationButtons);

		// Set the bottom of the BorderPane to be the buttonBox
		payScreenBorderPane.setBottom(buttonBox);
	}
}