package de.mikosninebites.frontend;

import de.mikosninebites.backend.BurgerEnum;
import de.mikosninebites.backend.DrinkEnum;
import de.mikosninebites.backend.FoodEnum;
import de.mikosninebites.backend.HotdogEnum;
import de.mikosninebites.backend.PizzaEnum;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents the event handlers for the buttons in the main menu of
 * the application. It contains methods to handle the actions of each button,
 * including displaying panels with different product categories and opening
 * windows with detailed information about each product.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class MenuButtonEvents {

	/* The main window to which the pay window belongs. */
	private MainWindow mainWindow;

	/**
	 * Constructor for MenuButtonEvents class.
	 * 
	 * @param mainWindow - The main window to which the pay window belongs.
	 */
	public MenuButtonEvents(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * This method adds an event handler to an array of product buttons for the
	 * "favourites" panel The method takes the product buttons
	 */
	public void addEventToProductButtonsForFavourites(Button[] productButtons) {

		// Get the values of the FoodEnum enumeration
		FoodEnum[] food = FoodEnum.values();

		// Iterate over the drawnNumbersForFavourites list
		for (int i = 0; i < mainWindow.getDrawnNumbersForFavourites().size(); i++) {
			int drawnNumber = mainWindow.getDrawnNumbersForFavourites().get(i);

			// Get the food name, price, content, and image path for the current drawn
			// number
			String foodName = food[drawnNumber].getName();
			double foodPrice = food[drawnNumber].getPrice();
			String foodContent = food[drawnNumber].getContent();
			String foodImagePath = food[drawnNumber].getImagePath();

			// Add an event handler to the current product button
			productButtons[i].setOnAction(clickOnProduct -> {
				ProductWindow productWindow = new ProductWindow(mainWindow);
				productWindow.showProductWindow(foodName, foodPrice, foodContent, foodImagePath);
			});
		}
	}

	/*
	 * This method adds event handlers to menu buttons for changing the central
	 * panel in the main window The method takes an array of menu buttons, the main
	 * window, an array of product buttons, an array of product rows, and a list of
	 * integers representing the selected favourite products
	 */
	public void addEventToMenuBarButtons(Button[] menuButtons, BorderPane borderPane, Button[] productButtons,
			HBox[] productRows) {

		// Create a CentralPanel object
		CentralPanel centralPanel = new CentralPanel(productButtons, productRows, mainWindow.getDrawnNumbersForFavourites());
		// Create a new ProductWindow object
		ProductWindow productWindow = new ProductWindow(mainWindow);

		// Add an event handler to the "Favourites" menu button
		menuButtons[0].setOnAction(click -> {
			borderPane.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			// Create a VBox for the favourites panel using the createPanelWithFavourites
			// method of the central panel object
			VBox favouritesBox = centralPanel.createPanelWithFavourites();
			borderPane.setCenter(favouritesBox);

			// Add event handlers to the product buttons in the favourites panel using the
			// addEventToProductButtonsForFavourites method
			addEventToProductButtonsForFavourites(productButtons);
		});

		// Add an event handler to the "Burgers" menu button
		menuButtons[1].setOnAction(click -> {
			borderPane.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			// Create a VBox for the burgers panel using the createPanelWithBurgers method
			// of the central panel object
			VBox burgerBox = centralPanel.createPanelWithBurgers();
			borderPane.setCenter(burgerBox);

			// Get the values of the BurgerEnum enumeration
			BurgerEnum[] burgers = BurgerEnum.values();

			// Add event handlers to the product buttons in the burgers panel
			for (int i = 0; i < productButtons.length; i++) {
				String burgerName = burgers[i].getName();
				double burgerPrice = burgers[i].getPrice();
				String burgerContent = burgers[i].getContent();
				String burgerImagePath = burgers[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {

					// Show the product window
					productWindow.showProductWindow(burgerName, burgerPrice, burgerContent, burgerImagePath);
				});
			}
		});

		// Add an event handler to the "Pizzas" menu button
		menuButtons[2].setOnAction(click -> {
			borderPane.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			// Create a VBox for the pizzas panel using the createPanelWithPizzas method of
			// the central panel object
			VBox pizzaBox = centralPanel.createPanelWithPizzas();
			borderPane.setCenter(pizzaBox);

			// Get the values of the PizzaEnum enumeration
			PizzaEnum[] pizzas = PizzaEnum.values();

			// Add event handlers to the product buttons in the pizzas panel
			for (int i = 0; i < productButtons.length; i++) {
				String pizzaName = pizzas[i].getName();
				double pizzaPrice = pizzas[i].getPrice();
				String pizzaContent = pizzas[i].getContent();
				String pizzaImagePath = pizzas[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {

					// Show the product window
					productWindow.showProductWindow(pizzaName, pizzaPrice, pizzaContent, pizzaImagePath);
				});
			}

		});

		// Add an event handler to the "Hot Dogs" menu button
		menuButtons[3].setOnAction(click -> {
			borderPane.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			// Create a VBox for the hotdogs panel using the createPanelWithHotdogs method
			// of the central panel object
			VBox hotdogBox = centralPanel.createPanelWithHotdogs();
			borderPane.setCenter(hotdogBox);

			// Get the values of the HotdogEnum enumeration
			HotdogEnum[] hotdogs = HotdogEnum.values();

			// Add event handlers to the product buttons in the hotdogs panel
			for (int i = 0; i < productButtons.length; i++) {
				String hotdogName = hotdogs[i].getName();
				double hotdogPrice = hotdogs[i].getPrice();
				String hotdogContent = hotdogs[i].getContent();
				String hotdogImagePath = hotdogs[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {

					// Show the product window
					productWindow.showProductWindow(hotdogName, hotdogPrice, hotdogContent, hotdogImagePath);
				});
			}
		});

		// Add an event handler to the "Drinks" menu button
		menuButtons[4].setOnAction(click -> {
			borderPane.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			// Create a VBox for the drinks panel using the createPanelWithDrinks method of
			// the central panel object
			VBox drinkBox = centralPanel.createPanelWithDrinks();
			borderPane.setCenter(drinkBox);

			// Get the values of the DrinkEnum enumeration
			DrinkEnum[] drinks = DrinkEnum.values();

			// Add event handlers to the product buttons in the drinks panel
			for (int i = 0; i < productButtons.length; i++) {
				String drinkName = drinks[i].getName();
				double drinkPrice = drinks[i].getPrice();
				String drinkImagePath = drinks[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {

					// Show the product window
					productWindow.showProductWindow(drinkName, drinkPrice, "", drinkImagePath);
				});
			}
		});
	}
}