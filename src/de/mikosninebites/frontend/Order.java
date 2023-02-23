package de.mikosninebites.frontend;

import java.util.List;

/**
 * Class representing an order made by the customer, consisting of a key,
 * quantity, meal and price.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class Order {

	/* A reference to the main window of the application */
	private MainWindow mainWindowAttribute;

	/* The unique key assigned to this order */
	private int key;

	/* A list of integers representing the quantity of each meal ordered */
	private List<Integer> quantity;

	/* A list of strings representing the name of each meal ordered */
	private List<String> meal;

	/* The total price of this order */
	private double price;

	/**
	 * Constructor for creating an Order object with the given quantity, meal, and
	 * price.
	 * 
	 * @param quantity - A list of integers representing the quantity of each meal
	 *                 ordered
	 * @param meal     - A list of strings representing the name of each meal
	 *                 ordered
	 * @param price    - The total price of this order
	 */
	public Order(List<Integer> quantity, List<String> meal, double price) {
		this.quantity = quantity;
		this.meal = meal;
		this.price = price;
	}

	/** Returns the key of the order. */
	public int getKey() {
		return key;
	}

	/** Sets the key of the order. */
	public void setKey(int key) {
		this.key = key;
	}

	/** Returns the names of the meals in the order. */
	public List<String> getMeal() {
		return meal;
	}

	/** Returns the total price of the order. */
	public double getPrice() {
		return price;
	}

	/** Returns the MainWindow object attribute of the order. */
	public MainWindow getMainWindowAttribute() {
		return mainWindowAttribute;
	}

	/** Sets the quantity of the meals in the order. */
	public List<Integer> getQuantity() {
		return quantity;
	}

}
