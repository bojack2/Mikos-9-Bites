package de.mikosninebites.frontend;

import javafx.scene.control.Button;

/**
 * This class provides event handlers for the back, cancel and pay buttons in
 * the main window of a restaurant ordering system. It is responsible for
 * clearing the selected product list, displaying the payment window and
 * navigating back to the previous screen.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class BackCancelPayButtonEvents {

	/*
	 * An instance variable of type MainWindow, which is a reference to the main
	 * window of the application.
	 */
	private MainWindow mainWindow;

	/* An array of buttons representing the navigation options */
	private Button[] navigationButtons;

	/**
	 * Constructor for BackCancelPayButtonEvents class.
	 * 
	 * @param mainWindow        - The main window to which the back, cancel, pay
	 *                          (buttons) events belongs.
	 * @param navigationButtons - An array of buttons representing the navigation
	 *                          options
	 */
	public BackCancelPayButtonEvents(MainWindow mainWindow, Button[] navigationButtons) {
		this.mainWindow = mainWindow;
		this.navigationButtons = navigationButtons;
	}

	/* This method adds event listeners to the navigation buttons. */
	public void addEventsToButtons() {

		// Set up the actions for the navigation buttons.

		// Cancel button - clears the selected product list and navigates back to the
		// restaurant main scene.
		navigationButtons[0].setOnAction(event -> {
			mainWindow.getAmountOfSelectedProductList().clear();
			mainWindow.getEntirePriceOfSelectedProductList().clear();
			mainWindow.getPriceOfSelectedProductList().clear();
			mainWindow.getNameOfSelectedProductList().clear();
			mainWindow.getPayBox().setVisible(false);
			mainWindow.getPrimaryStage().setScene(mainWindow.getRestaurantMainScene());

		});

		// Back button - navigates back to the restaurant main scene and shows the pay
		// box.
		navigationButtons[1].setOnAction(event -> {
			mainWindow.getPrimaryStage().setScene(mainWindow.getRestaurantMainScene());
			mainWindow.getPayBox().setVisible(true);
		});

		// Order button - sends the order to the database and displays the end window.
		navigationButtons[2].setOnAction(event -> {

			sendOrderToDatabase();

			EndWindow endWindow = new EndWindow(mainWindow);
			endWindow.showEndWindow();
		});

	}

	/**
	 * This method creates an Order object with the selected products and their
	 * quantities and sends it to the database.
	 */
	public void sendOrderToDatabase() {
		// Creates an Order object with the selected products and their quantities.
		Order order = new Order(mainWindow.getAmountOfSelectedProductList(), mainWindow.getNameOfSelectedProductList(),
				mainWindow.getEndPriceOfOrder());

		// Creates a Database object to send the order.
		Database yourOrder = new Database();
		yourOrder.sendOrder(order);
	}

}
