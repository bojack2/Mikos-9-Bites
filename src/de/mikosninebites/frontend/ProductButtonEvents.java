package de.mikosninebites.frontend;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * This class handles the event listeners for the buttons and text fields in the
 * product window.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class ProductButtonEvents {

	/** An instance variable that holds the reference to the main window. */
	private MainWindow mainWindow;

	/** An instance variable that holds the reference to the product window. */
	private ProductWindow productWindow;

	/**
	 * Constructor for ProductButtonEvents class.
	 * 
	 * @param payInfo - The main window, ... to which the product buttons belongs.
	 */
	public ProductButtonEvents(ProductWindow productWindow, MainWindow mainWindow) {
		this.productWindow = productWindow;
		this.mainWindow = mainWindow;
	}

	/**
	 * Adds event listeners to the buttons and text fields in the product window.
	 * 
	 * @param productName  - The name of the selected product.
	 * @param productPrice - The price of the selected product.
	 */
	public void addEventsToObjects(String productName, double productPrice) {

		// Listener for the amountOfProducts text field to restrict input to numeric
		// characters and limit length to 2 digits
		// Mix of two methods from authors:
		// -Nicolas Filotto, Oct 14, 2017 at 8:52, Stackoverflow
		// -Abra, Feb 17, 2021 at 12:05, Stackoverflow
		productWindow.getAmountOfProducts().textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					productWindow.getAmountOfProducts().setText(newValue.replaceAll("[^\\d]", ""));
				}
				if (productWindow.getAmountOfProducts().getText().length() > 2) {
					String s = productWindow.getAmountOfProducts().getText().substring(0, 2);
					productWindow.getAmountOfProducts().setText(s);
				}
			}
		});

		// Listener for the plus button to increment the amount of products in the text
		// field
		productWindow.getPlusButton().setOnAction(click -> {
			String textInField = productWindow.getAmountOfProducts().getText();
			int numberInField = Integer.parseInt(textInField);
			numberInField++;
			if (numberInField >= 99) {
				numberInField = 99;
			}
			Integer objectFromNumberInField = Integer.valueOf(numberInField);
			productWindow.getAmountOfProducts().setText(objectFromNumberInField.toString());
		});

		// Listener for the minus button to decrement the amount of products in the text
		// field
		productWindow.getMinusButton().setOnAction(click -> {
			String textInField = productWindow.getAmountOfProducts().getText();
			int numberInField = Integer.parseInt(textInField);
			numberInField--;
			if (numberInField <= 0) {
				numberInField = 1;
			}
			Integer objectFromNumberInField = Integer.valueOf(numberInField);

			productWindow.getAmountOfProducts().setText(objectFromNumberInField.toString());
		});

		// Listener for the addToBasketButton to add the selected product to the basket
		productWindow.getAddToBasketButton().setOnAction(click -> {
			String textInField = productWindow.getAmountOfProducts().getText();
			int numberInField = Integer.parseInt(textInField);
			double priceOfproductInWindow = productPrice * numberInField;

			mainWindow.getNameOfSelectedProductList().add(productName);
			mainWindow.getPriceOfSelectedProductList().add(productPrice);
			mainWindow.getAmountOfSelectedProductList().add(numberInField);
			mainWindow.getEntirePriceOfSelectedProductList().add(priceOfproductInWindow);
			int quantity = 0;
			mainWindow.setEndPriceOfOrder(0);

			// Update the quantity and total price of the order in the payInfo object
			for (int i = 0; i < mainWindow.getAmountOfSelectedProductList().size(); i++) {
				quantity += mainWindow.getAmountOfSelectedProductList().get(i);
				mainWindow.setEndPriceOfOrder(
						mainWindow.getEndPriceOfOrder() + mainWindow.getEntirePriceOfSelectedProductList().get(i));
			}

			// Update the displayed bill with the new quantity and total price, and display
			// the payBox
			mainWindow.getBill()
					.setText("To be paid: " + (double) Math.round(mainWindow.getEndPriceOfOrder() * 100) / 100 + "€"
							+ "\nNumber of ordered articles: " + quantity);
			mainWindow.getPayBox().setVisible(true);

			productWindow.getProductStage().close();

		});
	}
}