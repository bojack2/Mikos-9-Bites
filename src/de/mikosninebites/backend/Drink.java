package de.mikosninebites.backend;

/**
 * This is a class named "Drink" that defines a drink's attributes such as name and price. 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class Drink {
	
	/* variable that stores the name of the drink */
	private String name;

	/* variable that stores the price of the drink */
	private double price;

	/**
	 * @param name  - each drink's name
	 * @param price - each drink's price
	 */
	public Drink(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Returns drink's name
	 * 
	 * @return drink's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets drink's name
	 * 
	 * @param name - drink's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns drink's price
	 * 
	 * @return drink's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets drink's price
	 * 
	 * @param price - drink's price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", price=" + price + "]";
	}
	
}