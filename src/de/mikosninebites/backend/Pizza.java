package de.mikosninebites.backend;

/**
 * This is a class named "Pizza" that defines a pizza's attributes such as name,
 * price and content.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class Pizza implements FoodInterface {

	/* Variable that stores the name of the pizza */
	private String name;

	/* Variable that stores the price of the pizza */
	private double price;

	/* Variable that stores the content of the pizza */
	private String content;

	/**
	 * @param name  - each pizza's name
	 * @param price - each pizza's price
	 */
	public Pizza(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Returns pizza's name
	 * 
	 * @return pizza's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets pizza's name
	 * 
	 * @param name - pizza's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns pizza's price
	 * 
	 * @return pizza's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets pizza's price
	 * 
	 * @param price - pizza's price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns pizza's content
	 * 
	 * @return pizza's content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets pizza's content
	 * 
	 * @param content - pizza's content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 
	 * Checks if the pizza is gluten-free by examining its name. If the name
	 * contains "Vegan" or "Veggie", the pizza is considered gluten-free.
	 * 
	 * @return true if the pizza is gluten-free, false otherwise.
	 */
	@Override
	public boolean isGlutenfree() {
		if (getName().contains("Vegan") || getName().contains("Veggie")) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", price=" + price + ", content=" + content + "]";
	}

}