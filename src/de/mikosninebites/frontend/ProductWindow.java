package de.mikosninebites.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The ProductWindow class is responsible for creating a new window that shows
 * the product's details when a user clicks on the product in the main window.
 * The class contains methods for creating and adding products to the VBox
 * object, adding content to the product and adding events to the buttons.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class ProductWindow {

	/** An instance variable that holds the reference to the main window. */
	private MainWindow mainWindow;

	/** An instance variable that holds the "minus" button. */
	private Button minusButton = new Button("-");

	/** An instance variable that holds the "plus" button. */
	private Button plusButton = new Button("+");

	/** An instance variable that holds the "Add To Order" button. */
	private Button addToBasketButton = new Button("Add To Order");

	/**
	 * An instance variable that holds the text field that shows the number of
	 * products.
	 */
	private TextField amountOfProducts = new TextField();

	/** An instance variable that holds the stage for the product window. */
	private Stage productStage = new Stage();

	/**
	 * Constructor for ProductWindow class.
	 * 
	 * @param mainWindow - The main window to which the product window belongs.
	 */
	public ProductWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/**
	 * Displays a product window for a given product with its name, price, content
	 * and image path.
	 * 
	 * @param productName      - The name of the product to be displayed.
	 * @param productPrice     - The price of the product to be displayed.
	 * @param productContent   - The content of the product to be displayed.
	 * @param productImagePath - The path to the image of the product to be
	 *                         displayed.
	 */
	public void showProductWindow(String productName, double productPrice, String productContent,
			String productImagePath) {

		// VBox that contains the product's image, name and price,
		VBox productsVbox = addProductNamePhotoAndPrice(productImagePath, productName, productPrice, productContent);
		// HBox that contains the product and information.
		HBox productAndInfo = addProductContent(productName, productContent, productsVbox);

		// Set the sizes of buttons in the window.
		setButtonSizes();

		// Set the initial value of text field as 1.
		amountOfProducts.setText("1");

		// Add events to the buttons and textfield.
		ProductButtonEvents productButtonEvents = new ProductButtonEvents(this, mainWindow);
		productButtonEvents.addEventsToObjects(productName, productPrice);

		// VBox that contains the overall layout of the window
		VBox forAll = createWindow(productAndInfo);

		// A border pane used as a main layout
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(forAll);

		// The Scene is created with the BorderPane as its root node and a size of 700
		// by 450 pixels
		Scene productScene = new Scene(borderPane, 700, 450);
		productScene.getStylesheets().add("file:resources/style.css");
		// Add stylesheet to the scene
		productScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");

		// Stage represents the window where the product details are shown.
		productStage.setTitle("Miko's 9 Bites");
		productStage.setResizable(false);
		productStage.setScene(productScene);
		productStage.setAlwaysOnTop(true);
		productStage.show();
	}

	/**
	 * Method returns a VBox that contains the product name, photo, and price of a
	 * product.
	 * 
	 * @param productImagePath - The path to the image of the product to be
	 *                         displayed.
	 * @param productName      - The name of the product to be displayed.
	 * @param productPrice     - The price of the product to be displayed.
	 * @param productContent   - The content of the product to be displayed.
	 * @return The VBox that contains the product name, photo and price.
	 */
	public VBox addProductNamePhotoAndPrice(String productImagePath, String productName, double productPrice,
			String productContent) {

		// Load the product image using the given product image path.
		Image img = new Image(productImagePath);

		// Resize the image based on the product name.
		if (productName.contains("Burger")) {
			img = new Image(productImagePath, 188, 132, false, false);
		}
		if (productName.contains("Pizza")) {
			img = new Image(productImagePath, 98, 132, false, false);
		}
		if (productName.contains("Hot Dog")) {
			img = new Image(productImagePath, 208, 92, false, false);
		}
		if (productContent.isEmpty()) {
			img = new Image(productImagePath, 78, 132, false, false);
		}
		if (productName.equals("Tea") || productName.equals("Coffee")) {
			img = new Image(productImagePath, 203, 132, false, false);
		}

		// Create an ImageView object with the resized image.
		ImageView imgView = new ImageView(img);

		// Create a Label object with the product name and price.
		Label productNameLabel = new Label(productName);
		Label productPriceLabel = new Label(productPrice + " €");

		// Create a VBox object to hold the product name, image and price.
		VBox productsVbox = new VBox();

		// Set the VBox's children to the product name, image and price.
		productsVbox = new VBox(5, productNameLabel, imgView, productPriceLabel);

		// Center the VBox's contents.
		productsVbox.setAlignment(Pos.CENTER);

		// Set the VBox's padding to 0.
		productsVbox.setPadding(new Insets(0, 0, 0, 0));

		return productsVbox;
	}

	/**
	 * This method adds the product content (i.e. ingredients) to a VBox containing
	 * the product name, photo, and price, and returns an HBox containing both
	 * VBoxes.
	 * 
	 * @param productName    - a String containing the name of the product
	 * @param productContent - a String containing the product's ingredients
	 * @param productsVbox   - a VBox containing the product name, photo and price
	 * @return An HBox containing both the productsVbox and the productsInfoVbox (if
	 *         it exists)
	 */
	public HBox addProductContent(String productName, String productContent, VBox productsVbox) {

		// Create a label to display the product content (ingredients)
		Label productContentLabel = new Label("Ingredients:\n" + productContent);

		// Create a VBox to hold the product content label
		VBox productsInfoVbox = new VBox();

		// Set the maximum size and wrap text for the product content label
		productContentLabel.setMaxSize(200, 200);
		productContentLabel.setWrapText(true);

		// If the product has content (ingredients), add the label to the VBox and set
		// the padding of the productsVbox
		if (!productContent.isEmpty()) {
			productsInfoVbox.getChildren().addAll(productContentLabel);
			productsVbox.setPadding(new Insets(0, 70, 0, 0));
		}
		// Set the alignment of the productsInfoVbox to center
		productsInfoVbox.setAlignment(Pos.CENTER);
		// Create an HBox to hold both the productsVbox and the productsInfoVbox
		HBox productAndInfo = new HBox();
		productAndInfo.getChildren().addAll(productsVbox, productsInfoVbox);
		productAndInfo.setAlignment(Pos.CENTER);

		// If the product is a hot dog, set the bottom padding of the HBox to 40
		if (productName.contains("Hot Dog")) {
			productAndInfo.setPadding(new Insets(0, 0, 40, 0));
		}
		// Return the HBox containing both VBoxes
		return productAndInfo;
	}

	/**
	 * Sets the preferred sizes and alignments of the buttons and text fields in the
	 * window.
	 */
	public void setButtonSizes() {
		minusButton.setPrefSize(50, 50);
		plusButton.setPrefSize(50, 50);

		amountOfProducts.setMaxSize(120, 40);
		amountOfProducts.setMinSize(120, 40);

		addToBasketButton.setPrefSize(120, 50);
		addToBasketButton.setId("greenButton");
		amountOfProducts.setAlignment(Pos.CENTER);
	}

	/**
	 * Creates a window containing a product and its information, along with
	 * controls for the quantity of the product and a button to add it to the
	 * basket.
	 * 
	 * @return final vertical box containing all the elements of the window
	 */
	public VBox createWindow(HBox productAndInfo) {

		// Create a horizontal box for the first row, containing a label for the
		// quantity of the product
		HBox firstRow = new HBox();

		// Create a label with text: "Quantity"
		Label quantityLabel = new Label("Quantity");

		// Load the company logo as an image and create an image view to display it
		Image companyLogo = new Image("file:resources/icons/company_logo_small.png", 139, 71, false, false);
		ImageView showCompanyLogo = new ImageView(companyLogo);

		// Add the quantity label to the first row and set padding and alignment
		firstRow.getChildren().addAll(quantityLabel);
		firstRow.setPadding(new Insets(40, 0, 0, 0));
		firstRow.setAlignment(Pos.CENTER);

		// Create a horizontal box for the second row, containing buttons to adjust the
		// quantity of the product and textfield
		HBox secondRow = new HBox(10);
		secondRow.getChildren().addAll(minusButton, amountOfProducts, plusButton);
		secondRow.setAlignment(Pos.CENTER);

		// Create a horizontal box for the third row, containing a button to add the
		// product to the basket
		HBox thirdRow = new HBox();
		thirdRow.getChildren().addAll(addToBasketButton);
		thirdRow.setPadding(new Insets(20, 0, 0, 0));
		thirdRow.setAlignment(Pos.CENTER);

		// Add style classes to the rows for CSS styling
		firstRow.getStyleClass().add("WindowButtons");
		secondRow.getStyleClass().add("WindowButtons2");
		thirdRow.getStyleClass().add("WindowButtons");

		// Create a vertical box to contain all the rows, centered on the screen
		VBox centralPanel = new VBox();
		centralPanel.getChildren().addAll(firstRow, secondRow, thirdRow);
		centralPanel.setAlignment(Pos.CENTER);

		// Create a horizontal box to contain the company logo at the bottom right of
		// the screen
		HBox logoVbox = new HBox();
		logoVbox.getChildren().addAll(showCompanyLogo);
		logoVbox.setAlignment(Pos.BOTTOM_RIGHT);

		// Create a vertical box to contain all the elements of the window, with padding
		// at the top
		VBox forAll = new VBox();
		forAll.getChildren().addAll(productAndInfo, centralPanel, logoVbox);
		forAll.setPadding(new Insets(20, 0, 0, 0));

		// Return the final vertical box containing all the elements of the window
		return forAll;
	}

	/**
	 * @return the minusButton
	 */
	public Button getMinusButton() {
		return minusButton;
	}

	/**
	 * @return the plusButton
	 */
	public Button getPlusButton() {
		return plusButton;
	}

	/**
	 * @return the addToBasketButton
	 */
	public Button getAddToBasketButton() {
		return addToBasketButton;
	}

	/**
	 * @return the amountOfProducts
	 */
	public TextField getAmountOfProducts() {
		return amountOfProducts;
	}

	/**
	 * @return the productStage
	 */
	public Stage getProductStage() {
		return productStage;
	}
}