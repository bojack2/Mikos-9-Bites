package de.mikosninebites.frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class represents the main window of the application. It contains the
 * layout and controls for the user interface of the application, including a
 * menu bar, product panels, and a shopping cart panel. The MainWindow class
 * extends the BorderPane class, which provides a layout pane for arranging
 * child nodes in the top, left, right, bottom, and center positions. The center
 * position is used to display the product panels and the shopping cart panel.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class MainWindow extends Application {

	/* An array of buttons representing the main menu options */
	private Button[] menuButtons = { new Button("FAVS ♥"), new Button("BURGERS"), new Button("PIZZAS"),
			new Button("HOT DOGS"), new Button("DRINKS") };
	/* An array of buttons representing the individual products in the menu */
	private Button[] productButtons = { new Button(""), new Button(""), new Button(""), new Button(""), new Button(""),
			new Button(""), new Button(""), new Button(""), new Button("") };
	/* A button used to cancel an order */
	private Button cancelButton = new Button("CANCEL");

	/* A button used to proceed to the order summary */
	private Button toOrderButton = new Button("TO ORDER");

	/* An array of HBoxes, each representing a row of products */
	private HBox[] productRows = { new HBox(20), new HBox(20), new HBox(20) };

	/* An HBox containing the buttons used for payment */
	private HBox payBox = new HBox(20);

	/* A label displaying the total cost of the order */
	private Label bill = new Label("");

	/* A BorderPane used as the main layout for the restaurant window */
	private BorderPane borderPaneForMainWindow = new BorderPane();

	/* A list of integers representing the indices of the user's favourite products */
	private List<Integer> drawnNumbersForFavourites = new ArrayList<>();

	/* An instance of MenuButtonEvents, a custom class used to handle button events */
	private MenuButtonEvents menuButtonEvents;

	/* A list of integers representing the quantity of each selected product */
	private List<Integer> amountOfSelectedProductList = new ArrayList<>();

	/* A list of doubles representing the total price of each selected product */
	private List<Double> entirePriceOfSelectedProductList = new ArrayList<>();

	/* A double representing the total cost of the order */
	private double endPriceOfOrder;

	/* A list of doubles representing the price of each selected product */
	private List<Double> priceOfSelectedProductList = new ArrayList<>();

	/* A list of strings representing the name of each selected product */
	private List<String> nameOfSelectedProductList = new ArrayList<>();

	/* The primary stage of the application */
	private Stage primaryStage;

	/* The main scene of the restaurant window */
	private Scene restaurantMainScene = new Scene(borderPaneForMainWindow, 600, 900);

	/**
	 * Overrides the start method of the Application class and creates the main
	 * window of the restaurant application
	 * 
	 * @param primaryStage the primary stage of the application
	 * @throws Exception if an exception occurs during the execution of the method
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		// Initialize the primary stage and button events
		this.primaryStage = primaryStage;
		this.menuButtonEvents = new MenuButtonEvents(this);

		// Create the list of drawn numbers for favourites, the menu bar, middle panel,
		// and bottom panel
		RandomFavouriteNumbers randomFavouriteNumbers = new RandomFavouriteNumbers();
		drawnNumbersForFavourites = randomFavouriteNumbers.createFavouritesNumberList();
		createMenuBar();
		createMiddlePanel();
		createBottomPanel();

		// Set the properties of the primary stage
		primaryStage.setTitle("Miko's 9 Bites");
		primaryStage.setResizable(false);

		// Add the stylesheets to the restaurant main scene
		restaurantMainScene.getStylesheets().add("file:resources/style.css");
		restaurantMainScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");

		// Set the scene of the primary stage and show it
		primaryStage.setScene(restaurantMainScene);
		primaryStage.show();
	}

	/**
	 * Creates the menu bar and sets its properties, such as button size and
	 * padding. Also adds event listeners to the menu bar buttons.
	 */
	public void createMenuBar() {

		HBox menuBar = new HBox(10);
		for (Button menuButton : menuButtons) {
			menuButton.setPrefSize(120, 50);
		}
		for (Button product : productButtons) {
			product.setPrefSize(180, 120);
			product.setMaxSize(180, 120);
			product.setMinSize(180, 120);
		}
		menuBar.setPadding(new Insets(10, 10, 20, 10));
		menuBar.getChildren().addAll(menuButtons);
		menuBar.getStyleClass().add("menubuttons");

		borderPaneForMainWindow.setTop(menuBar);

		for (HBox allProductRows : productRows) {
			allProductRows.setAlignment(Pos.CENTER);

			menuButtonEvents.addEventToMenuBarButtons(menuButtons, borderPaneForMainWindow, productButtons, productRows);
		}
	}

	/**
	 * Creates the central panel of the application, which displays the products
	 * available for ordering. Also adds event listeners to the product buttons for
	 * selecting favourites.
	 */
	public void createMiddlePanel() {

		CentralPanel centralPanel = new CentralPanel(productButtons, productRows,
				drawnNumbersForFavourites);
		VBox centralPanelVbox = centralPanel.createPanelWithFavourites();

		menuButtonEvents.addEventToProductButtonsForFavourites(productButtons);

		borderPaneForMainWindow.setCenter(centralPanelVbox);
	}

	/**
	 * Creates the bottom panel of the main window. The panel contains the company
	 * logo, a bill, and two buttons for cancelling or submitting the order.
	 */
	public void createBottomPanel() {

		// Create HBox and VBox for holding the logo and the rest of the elements,
		// respectively
		HBox logoBox = new HBox();
		VBox bottomBox = new VBox();

		// Align the logo box to the bottom right corner and set some padding for it
		logoBox.setAlignment(Pos.BOTTOM_RIGHT);
		logoBox.setPadding(new Insets(20, 0, 0, 0));

		// Align the pay box (which contains the bill and buttons) to the center and set
		// some padding for it
		payBox.setAlignment(Pos.CENTER);
		payBox.setPadding(new Insets(10, 10, 0, 10));

		// Create an image view for the company logo and set its size
		Image companyLogo = new Image("file:resources/icons/company_logo_small.png", 139, 71, false, false);
		ImageView showCompanyLogo = new ImageView(companyLogo);

		// Set the preferred size and IDs of the cancel and submit buttons
		cancelButton.setPrefSize(120, 50);
		toOrderButton.setPrefSize(120, 50);
		cancelButton.setId("redButton");
		toOrderButton.setId("greenButton");

		// Add event handlers to the buttons
		CancelPayButtonEvents cancelPayButtonEvents = new CancelPayButtonEvents(this);
		cancelPayButtonEvents.addEventToButtons();

		// Add the bill and buttons to the pay box
		payBox.getChildren().addAll(bill, cancelButton, toOrderButton);

		// Add the company logo to the logo box
		logoBox.getChildren().addAll(showCompanyLogo);

		// Add the pay box and logo box to the bottom box, and set some style for the
		// pay box
		bottomBox.getChildren().addAll(payBox, logoBox);
		payBox.getStyleClass().add("menubuttons");

		// Hide the pay box by default
		payBox.setVisible(false);

		// Set the bottom box as the bottom of the main window
		borderPaneForMainWindow.setBottom(bottomBox);
	}

	/** Returns the pay box containing the bill and cancel button. */
	public HBox getPayBox() {
		return payBox;
	}

	/** Returns the label displaying the bill. */
	public Label getBill() {
		return bill;
	}

	/** Returns the list of names of the selected products. */
	public List<String> getNameOfSelectedProductList() {
		return nameOfSelectedProductList;
	}

	/** Returns the list of prices of the selected products. */
	public List<Double> getPriceOfSelectedProductList() {
		return priceOfSelectedProductList;
	}

	/** Returns the list of amounts of the selected products. */
	public List<Integer> getAmountOfSelectedProductList() {
		return amountOfSelectedProductList;
	}

	/** Returns the list of entire prices of the selected products. */
	public List<Double> getEntirePriceOfSelectedProductList() {
		return entirePriceOfSelectedProductList;
	}

	/** Returns the final price of the order. */
	public double getEndPriceOfOrder() {
		return endPriceOfOrder;
	}

	/** Sets the final price of the order. */
	public void setEndPriceOfOrder(double endPriceOfOrder) {
		this.endPriceOfOrder = endPriceOfOrder;
	}

	/** Returns the cancel button. */
	public Button getCancelButton() {
		return cancelButton;
	}

	/** Returns the "to order" button. */
	public Button getToOrderButton() {
		return toOrderButton;
	}

	/** Returns the primary stage. */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/** Returns the main scene for restaurant. */
	public Scene getRestaurantMainScene() {
		return restaurantMainScene;
	}

	/** Returns the list of drawn numbers for favourite foods. */
	public List<Integer> getDrawnNumbersForFavourites() {
		return drawnNumbersForFavourites;
	}
}