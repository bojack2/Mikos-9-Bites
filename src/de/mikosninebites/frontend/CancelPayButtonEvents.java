package de.mikosninebites.frontend;

/**
 * This is a class that defines the event handlers for the cancel and pay
 * buttons in the point of sale system. It contains methods to add actions to
 * the buttons, such as clearing selected product information and hiding the
 * payment interface when the cancel button is clicked, and creating a new pay
 * window when the pay button is clicked. The class takes a MainWindow object as
 * a parameter to interact with the main UI.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class CancelPayButtonEvents {

	/*
	 * An instance variable of type MainWindow, which is a reference to the main
	 * window of the application.
	 */
	private MainWindow mainWindow;

	/**
	 * Constructor for CancelPayButtonEvents class.
	 * 
	 * @param mainWindow - The main window to which the cancel and pay buttons
	 *                   belongs.
	 */
	public CancelPayButtonEvents(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/**
	 * Adds event listeners to the "cancel" button and "to order" button using
	 * lambda expressions.
	 */
	public void addEventToButtons() {

		// Sets the event handler for the cancel button. When the cancel button is
		// clicked, the method clears the amount,
		// price and name lists of the selected products, and hides the payment box.
		mainWindow.getCancelButton().setOnAction(click -> {
			mainWindow.getAmountOfSelectedProductList().clear();
			mainWindow.getEntirePriceOfSelectedProductList().clear();
			mainWindow.getPriceOfSelectedProductList().clear();
			mainWindow.getNameOfSelectedProductList().clear();
			mainWindow.getPayBox().setVisible(false);
		});

		// sets the event handler for the "to order" button. When the button is clicked,
		// the method creates an instance of "PayWindow" and calls its "showPayWindow()"
		// method to display the payment window.
		mainWindow.getToOrderButton().setOnAction(click -> {
			PayWindow payWindow = new PayWindow(mainWindow);
			payWindow.showPayWindow();
		});
	}
}