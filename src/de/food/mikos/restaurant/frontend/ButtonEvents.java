package de.food.mikos.restaurant.frontend;

import java.util.List;

import de.food.mikos.restaurant.backend.BurgerEnum;
import de.food.mikos.restaurant.backend.DrinkEnum;
import de.food.mikos.restaurant.backend.FoodEnum;
import de.food.mikos.restaurant.backend.HotdogEnum;
import de.food.mikos.restaurant.backend.PizzaEnum;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonEvents {
	public void addEventToProductButtonsForFavourites(Button[] productButtons,
			List<Integer> drawnNumbersForFavourites) {

		FoodEnum[] food = FoodEnum.values();

		for (int i = 0; i < drawnNumbersForFavourites.size(); i++) {
			int drawnNumber = drawnNumbersForFavourites.get(i);
			String foodName = food[drawnNumber].getName();
			double foodPrice = food[drawnNumber].getPrice();
			String foodContent = food[drawnNumber].getContent();
			String foodImagePath = food[drawnNumber].getImagePath();
			productButtons[i].setOnAction(clickOnProduct -> {
				ProductWindow productWindow = new ProductWindow();
				productWindow.showWindow(foodName, foodPrice, foodContent, foodImagePath);
			});
		}

	}

	public void addEventToMenuBarButtons(Button[] menuButtons, BorderPane mainWindow, Button[] productButtons,
			HBox[] productRows, List<Integer> drawnNumbersForFavourites) {
		CentralPanel centralPanel = new CentralPanel();

		menuButtons[0].setOnAction(click -> {
			mainWindow.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			VBox favouritesBox = centralPanel.createPanelWithFavourites(productButtons, productRows,
					drawnNumbersForFavourites);
			mainWindow.setCenter(favouritesBox);

			addEventToProductButtonsForFavourites(productButtons, drawnNumbersForFavourites);
		});

		menuButtons[1].setOnAction(click -> {
			mainWindow.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			VBox burgerBox = centralPanel.createPanelWithBurgers(productButtons, productRows);
			mainWindow.setCenter(burgerBox);

			BurgerEnum[] burgers = BurgerEnum.values();
			for (int i = 0; i < productButtons.length; i++) {
				String burgerName = burgers[i].getName();
				double burgerPrice = burgers[i].getPrice();
				String burgerContent = burgers[i].getContent();
				String burgerImagePath = burgers[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {
					ProductWindow productWindow = new ProductWindow();
					productWindow.showWindow(burgerName, burgerPrice, burgerContent, burgerImagePath);
				});
			}
		});

		menuButtons[2].setOnAction(click -> {
			mainWindow.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			VBox pizzaBox = centralPanel.createPanelWithPizzas(productButtons, productRows);
			mainWindow.setCenter(pizzaBox);
			PizzaEnum[] pizzas = PizzaEnum.values();
			for (int i = 0; i < productButtons.length; i++) {
				String pizzaName = pizzas[i].getName();
				double pizzaPrice = pizzas[i].getPrice();
				String pizzaContent = pizzas[i].getContent();
				String pizzaImagePath = pizzas[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {
					ProductWindow productWindow = new ProductWindow();
					productWindow.showWindow(pizzaName, pizzaPrice, pizzaContent, pizzaImagePath);
				});
			}

		});

		menuButtons[3].setOnAction(click -> {
			mainWindow.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			VBox hotdogBox = centralPanel.createPanelWithHotdogs(productButtons, productRows);
			mainWindow.setCenter(hotdogBox);
			HotdogEnum[] hotdogs = HotdogEnum.values();
			for (int i = 0; i < productButtons.length; i++) {
				String hotdogName = hotdogs[i].getName();
				double hotdogPrice = hotdogs[i].getPrice();
				String hotdogContent = hotdogs[i].getContent();
				String hotdogImagePath = hotdogs[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {
					ProductWindow productWindow = new ProductWindow();
					productWindow.showWindow(hotdogName, hotdogPrice, hotdogContent, hotdogImagePath);
				});
			}
		});

		menuButtons[4].setOnAction(click -> {
			mainWindow.setCenter(null);
			for (HBox productRow : productRows)
				productRow.getChildren().clear();

			VBox drinkBox = centralPanel.createPanelWithDrinks(productButtons, productRows);
			mainWindow.setCenter(drinkBox);
			DrinkEnum[] drinks = DrinkEnum.values();
			for (int i = 0; i < productButtons.length; i++) {
				String drinkName = drinks[i].getName();
				double drinkPrice = drinks[i].getPrice();
				String drinkImagePath = drinks[i].getImagePath();
				productButtons[i].setOnAction(clickOnProduct -> {
					ProductWindow productWindow = new ProductWindow();
					productWindow.showWindow(drinkName, drinkPrice, "", drinkImagePath);
				});
			}
		});
	}
}
