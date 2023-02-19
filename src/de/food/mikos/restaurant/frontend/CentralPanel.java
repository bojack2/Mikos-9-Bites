package de.food.mikos.restaurant.frontend;

import de.food.mikos.restaurant.backend.HotdogEnum;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import de.food.mikos.restaurant.backend.PizzaEnum;
import java.util.List;
import de.food.mikos.restaurant.backend.BurgerEnum;
import de.food.mikos.restaurant.backend.DrinkEnum;
import de.food.mikos.restaurant.backend.FoodEnum;

public class CentralPanel {
	
	final int numProductsInRow = 3;
	final int numOfFavourites = 9;

	public VBox createPanelWithFavourites(Button[] productButtons, HBox[] productRows, List<Integer> drawnNumbers) {

		FoodEnum[] favouriteFood = FoodEnum.values();
		Label[] favouriteFoodNames = new Label[numOfFavourites];
		Label[] favouriteFoodPrices = new Label[numOfFavourites];
		for (int i = 0; i < numOfFavourites; i++) {
			int drawnNumber = drawnNumbers.get(i);
			favouriteFoodNames[i] = new Label(favouriteFood[drawnNumber].getName());
			favouriteFoodPrices[i] = new Label(favouriteFood[drawnNumber].getPrice() + "€");
			productButtons[i].setTooltip(new Tooltip(favouriteFood[drawnNumber].getContent()));

			Image img = new Image(favouriteFood[drawnNumber].getImagePath());

			if (favouriteFood[drawnNumber].getName().contains("Burger")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 118, 83, false, false);

			} else if (favouriteFood[drawnNumber].getName().contains("Pizza")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 62, 83, false, false);

			} else if (favouriteFood[drawnNumber].getName().contains("Hot Dog")) {
				img = new Image(favouriteFood[drawnNumber].getImagePath(), 130, 58, false, false);
			}
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);

		}
		return createVboxWithProductRows(productRows, productButtons, favouriteFoodNames, favouriteFoodPrices);
	}

	public VBox createPanelWithBurgers(Button[] productButtons, HBox[] productRows) {

		BurgerEnum[] burgers = BurgerEnum.values();

		Label[] burgersNames = new Label[burgers.length];
		Label[] burgerPrices = new Label[burgers.length];
		for (int i = 0; i < burgers.length; i++) {
			burgersNames[i] = new Label(burgers[i].getName());
			burgerPrices[i] = new Label(burgers[i].getPrice() + "€");
			productButtons[i].setTooltip(new Tooltip(burgers[i].getContent()));
			Image img = new Image(burgers[i].getImagePath(), 118, 83, false, false);
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);

		}

		return createVboxWithProductRows(productRows, productButtons, burgersNames, burgerPrices);
	}

	public VBox createPanelWithPizzas(Button[] productButtons, HBox[] productRows) {

		PizzaEnum[] pizzas = PizzaEnum.values();

		Label[] pizzasNames = new Label[pizzas.length];
		Label[] pizzasPrices = new Label[pizzas.length];
		for (int i = 0; i < pizzas.length; i++) {
			pizzasNames[i] = new Label(pizzas[i].getName());
			pizzasPrices[i] = new Label(pizzas[i].getPrice() + "€");
			productButtons[i].setTooltip(new Tooltip(pizzas[i].getContent()));
			Image img = new Image(pizzas[i].getImagePath(), 62, 83, false, false);
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(productRows, productButtons, pizzasNames, pizzasPrices);
	}

	public VBox createPanelWithHotdogs(Button[] productButtons, HBox[] productRows) {

		HotdogEnum[] hotdogs = HotdogEnum.values();

		Label[] hotdogsNames = new Label[hotdogs.length];
		Label[] hotdogsPrices = new Label[hotdogs.length];
		for (int i = 0; i < hotdogs.length; i++) {
			hotdogsNames[i] = new Label(hotdogs[i].getName());
			hotdogsPrices[i] = new Label(hotdogs[i].getPrice() + "€");
			productButtons[i].setTooltip(new Tooltip(hotdogs[i].getContent()));
			Image img = new Image(hotdogs[i].getImagePath(), 130, 58, false, false);
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(productRows, productButtons, hotdogsNames, hotdogsPrices);
	}

	public VBox createPanelWithDrinks(Button[] productButtons, HBox[] productRows) {

		DrinkEnum[] drinks = DrinkEnum.values();

		Label[] drinksNames = new Label[drinks.length];
		Label[] drinksPrices = new Label[drinks.length];
		for (int i = 0; i < drinks.length; i++) {
			drinksNames[i] = new Label(drinks[i].getName());
			drinksPrices[i] = new Label(drinks[i].getPrice() + "€");
			productButtons[i].setTooltip(null);
			Image img = new Image(drinks[i].getImagePath());
			if (drinks[i].getName().equals("Tea") || drinks[i].getName().contains("Coffee")) {
				img = new Image(drinks[i].getImagePath(), 100, 65, false, false);
			} else {
				img = new Image(drinks[i].getImagePath(), 51, 86, false, false);
			}
			ImageView imgView = new ImageView(img);
			productButtons[i].setGraphic(imgView);
		}
		return createVboxWithProductRows(productRows, productButtons, drinksNames, drinksPrices);
	}
	
	public VBox createVboxWithProductRows(HBox productRows[], Button[] productButtons, Label[] productNames, Label[] productPrices) {
		
		int num = 0;
		for (int i = 0; i < productRows.length; i++) {
			productRows[i].getChildren().addAll(
					createProductWithLabels(productButtons[num], productNames[num], productPrices[num]),
					createProductWithLabels(productButtons[num + 1], productNames[num + 1],
							productPrices[num + 1]),
					createProductWithLabels(productButtons[num + 2], productNames[num + 2],
							productPrices[num + 2]));

			num += numProductsInRow;
		}

		VBox row = new VBox(50, productRows[0], productRows[1], productRows[2]);
		return row;
	}
	
	private VBox createProductWithLabels(Button product, Label name, Label price) {
		VBox cell = new VBox(5, name, product, price);
		cell.setAlignment(Pos.CENTER);
		return cell;
	}
}