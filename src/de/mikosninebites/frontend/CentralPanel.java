package de.mikosninebites.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

import de.mikosninebites.backend.BurgerEnum;
import de.mikosninebites.backend.DrinkEnum;
import de.mikosninebites.backend.FoodEnum;
import de.mikosninebites.backend.HotdogEnum;
import de.mikosninebites.backend.PizzaEnum;

/**
 * The CentralPanel class represents the central panel of the ordering
 * application. It contains the UI elements for displaying a list of available
 * products, their prices and images, as well as buttons for adding them to the
 * order. The panel is organized into rows of 3 products per row and each
 * product is displayed with its name, price and image.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class CentralPanel {

	/* Constants for number of products in a row. */
	final int numProductsInRow = 3;

	/* Constants for number of favourite foods. */
	final int numOfFavourites = 9;

	/* An array of buttons representing the individual products in the menu */
	private Button[] productButtons;

	/* An array of HBoxes, each representing a row of products */
	private HBox[] productRows;

	/*
	 * A list of integers representing the indices of the user's favourite products
	 */
	private List<Integer> drawnNumbers;

	/**
	 * Constructor for CentralPanel class.
	 * 
	 * @param productButtons - An array of buttons representing the individual
	 *                       products in the menu
	 * @param productRows    - An array of HBoxes, each representing a row of
	 *                       products
	 * @param drawnNumbers   - A list of integers representing the indices of the
	 *                       user's favourite products
	 */
	public CentralPanel(Button[] productButtons, HBox[] productRows, List<Integer> drawnNumbers) {
		this.productButtons = productButtons;
		this.productRows = productRows;
		this.drawnNumbers = drawnNumbers;
	}

	/**
	 * Method returns a VBox with favourite foods
	 * 
	 * @return VBox containing favourite food names with prices
	 */
	public VBox createPanelWithFavourites() {

		// Get all favourite foods.
		FoodEnum[] favouriteFood = FoodEnum.values();

		// Create arrays to store favourite food names and prices.
		Label[] favouriteFoodNames = new Label[numOfFavourites];
		Label[] favouriteFoodPrices = new Label[numOfFavourites];

		// Loop through each favourite food and set its name, price and image.
		for (int i = 0; i < numOfFavourites; i++) {
			int drawnNumber = drawnNumbers.get(i);

			// Set the name and price of the favourite food.
			favouriteFoodNames[i] = new Label(favouriteFood[drawnNumber].getName());
			favouriteFoodPrices[i] = new Label(favouriteFood[drawnNumber].getPrice() + "€");

			// Set the tooltip of the product button to show the content of the favourite
			// food.
			productButtons[i].setTooltip(new Tooltip(favouriteFood[drawnNumber].getContent()));

			// Set the image of the product button based on the type of food.
			Image img = new Image(favouriteFood[drawnNumber].getImagePath());

			if (favouriteFood[drawnNumber].getName().contains("Burger")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 118, 83, false, false);

			} else if (favouriteFood[drawnNumber].getName().contains("Pizza")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 62, 83, false, false);

			} else if (favouriteFood[drawnNumber].getName().contains("Hot Dog")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 130, 58, false, false);
			}

			// Set the image view of the product button.
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);

		}
		return createVboxWithProductRows(favouriteFoodNames, favouriteFoodPrices);
	}

	/**
	 * Method returns a VBox with burgers
	 * 
	 * @return VBox containing burgers names with prices
	 */
	public VBox createPanelWithBurgers() {

		// Get all burgers.
		BurgerEnum[] burgers = BurgerEnum.values();

		// Create arrays to store burgers names and prices.
		Label[] burgersNames = new Label[burgers.length];
		Label[] burgerPrices = new Label[burgers.length];

		// Loop through each burger and set its name, price and image.
		for (int i = 0; i < burgers.length; i++) {

			// Set the name and price of the burgers.
			burgersNames[i] = new Label(burgers[i].getName());
			burgerPrices[i] = new Label(burgers[i].getPrice() + "€");

			// Set the tooltip of the product button to show the content of the burgers.
			productButtons[i].setTooltip(new Tooltip(burgers[i].getContent()));

			Image img = new Image(burgers[i].getImagePath(), 118, 83, false, false);

			// Set the image view of the product button.
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);

		}
		return createVboxWithProductRows(burgersNames, burgerPrices);
	}

	/**
	 * Method returns a VBox with pizzas
	 * 
	 * @return VBox containing pizzas names with prices
	 */
	public VBox createPanelWithPizzas() {

		// Get all pizzas.
		PizzaEnum[] pizzas = PizzaEnum.values();

		// Create arrays to store pizzas names and prices.
		Label[] pizzasNames = new Label[pizzas.length];
		Label[] pizzasPrices = new Label[pizzas.length];

		// Loop through each pizza and set its name, price and image.
		for (int i = 0; i < pizzas.length; i++) {

			// Set the name and price of the pizzas.
			pizzasNames[i] = new Label(pizzas[i].getName());
			pizzasPrices[i] = new Label(pizzas[i].getPrice() + "€");

			// Set the tooltip of the product button to show the content of the pizzas.
			productButtons[i].setTooltip(new Tooltip(pizzas[i].getContent()));

			Image img = new Image(pizzas[i].getImagePath(), 62, 83, false, false);

			// Set the image view of the product button.
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(pizzasNames, pizzasPrices);
	}

	/**
	 * Method returns a VBox with hotdogs
	 * 
	 * @return VBox containing hotdogs names with prices
	 */
	public VBox createPanelWithHotdogs() {

		// Get all hotdogs.
		HotdogEnum[] hotdogs = HotdogEnum.values();

		// Create arrays to store hotdogs names and prices.
		Label[] hotdogsNames = new Label[hotdogs.length];
		Label[] hotdogsPrices = new Label[hotdogs.length];

		// Loop through each hotdog and set its name, price, and image.
		for (int i = 0; i < hotdogs.length; i++) {

			// Set the name and price of the hotdogs.
			hotdogsNames[i] = new Label(hotdogs[i].getName());
			hotdogsPrices[i] = new Label(hotdogs[i].getPrice() + "€");

			// Set the tooltip of the product button to show the content of the hotdogs.
			productButtons[i].setTooltip(new Tooltip(hotdogs[i].getContent()));

			Image img = new Image(hotdogs[i].getImagePath(), 130, 58, false, false);

			// Set the image view of the product button.
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(hotdogsNames, hotdogsPrices);
	}

	/**
	 * Method returns a VBox with drinks
	 * 
	 * @return VBox containing drinks names with prices
	 */
	public VBox createPanelWithDrinks() {

		// Get all drinks.
		DrinkEnum[] drinks = DrinkEnum.values();

		// Create arrays to store drinks names and prices.
		Label[] drinksNames = new Label[drinks.length];
		Label[] drinksPrices = new Label[drinks.length];

		// Loop through each drink and set its name, price, and image.
		for (int i = 0; i < drinks.length; i++) {

			// Set the name and price of the drinks.
			drinksNames[i] = new Label(drinks[i].getName());
			drinksPrices[i] = new Label(drinks[i].getPrice() + "€");

			// Set the tooltip as "null". Drinks have no content.
			productButtons[i].setTooltip(null);

			Image img = new Image(drinks[i].getImagePath());
			if (drinks[i].getName().equals("Tea") || drinks[i].getName().contains("Coffee")) {
				img = new Image(drinks[i].getImagePath(), 100, 65, false, false);
			} else {
				img = new Image(drinks[i].getImagePath(), 51, 86, false, false);
			}

			// Set the image view of the product button.
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(drinksNames, drinksPrices);
	}

	/**
	 * Creates a VBox containing multiple HBoxes, each representing a row of
	 * products. Each HBox contains three products with their respective name and
	 * price labels and a button.
	 * 
	 * @param productNames  an array of Label objects representing the name of each
	 *                      product
	 * @param productPrices an array of Label objects representing the price of each
	 *                      product
	 * @return a VBox containing the HBoxes with the products and their respective
	 *         labels
	 */
	public VBox createVboxWithProductRows(Label[] productNames, Label[] productPrices) {
		// Variable to keep track of the index of the current product.
		int num = 0;

		// Loop through each product row HBox and add three products with their
		// respective labels and button.
		for (int i = 0; i < productRows.length; i++) {
			productRows[i].getChildren().addAll(
					createProductWithLabels(productButtons[num], productNames[num], productPrices[num]),
					createProductWithLabels(productButtons[num + 1], productNames[num + 1], productPrices[num + 1]),
					createProductWithLabels(productButtons[num + 2], productNames[num + 2], productPrices[num + 2]));

			// Increment num by the number of products in a row
			num += numProductsInRow;
		}
		// Create a VBox with a spacing of 50 pixels between each row and add the rows
		// of products to it.
		VBox row = new VBox(50, productRows[0], productRows[1], productRows[2]);
		return row;
	}

	/**
	 * Method returns a VBox containing a product button with labels of name and
	 * price.
	 * 
	 * @param product the product button to be included in the VBox
	 * @param name    the product label to be included in the VBox
	 * @param price   the product price label to be included in the VBox
	 * @return VBox containing the product label, button and price label.
	 */
	private VBox createProductWithLabels(Button product, Label name, Label price) {
		VBox cell = new VBox(5, name, product, price);
		cell.setAlignment(Pos.CENTER);
		return cell;
	}
}